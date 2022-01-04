import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/28
 * @desc say
 **/
public class L31_146 {

	/*
	 * 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。
	 *
	 * 实现 LRUCache 类：
	 *
	 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
	 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
	 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
	 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
	 *
	 *
	 * 示例：
	 *
	 * 输入
	 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
	 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
	 * 输出
	 * [null, null, null, 1, null, -1, null, -1, 3, 4]
	 *
	 * 解释
	 * LRUCache lRUCache = new LRUCache(2);
	 * lRUCache.put(1, 1); // 缓存是 {1=1}
	 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
	 * lRUCache.get(1);    // 返回 1
	 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
	 * lRUCache.get(2);    // 返回 -1 (未找到)
	 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
	 * lRUCache.get(1);    // 返回 -1 (未找到)
	 * lRUCache.get(3);    // 返回 3
	 * lRUCache.get(4);    // 返回 4
	 *
	 *
	 * 提示：
	 *
	 * 1 <= capacity <= 3000
	 * 0 <= key <= 10000
	 * 0 <= value <= 105
	 * 最多调用 2 * 105 次 get 和 put
	 *
	 *
	 * 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
	 * map + 链表
	 */

	private static class LRUCache {

		private class Node {
			private int key;
			private int value;
			private Node pre;
			private Node next;

			@Override
			public String toString() {
				return "Node{" +
						"key=" + key +
						", value=" + value +
						'}';
			}
		}

		private Map<Integer, Node> map = new HashMap<>();
		private int capacity;
		private Node tail;
		private Node head;

		public LRUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			Node node = map.get(key);

			if (node == head) {
				return node.value;
			} else if (node == tail) {
				node.next = head;
				head.pre = node;
				head = node;

				tail = tail.pre;
				tail.next = null;

				node.pre = null;
			} else {
				node.pre.next = node.next;
				node.next.pre = node.pre;

				head.pre = node;
				node.next = head;
				node.pre = null;
				head = node;
			}

			return node.value;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				node.value = value;
				get(key);
			} else {
				Node node = new Node();
				node.key = key;
				node.value = value;
				if (map.size() == 0) {
					head = node;
					tail = node;
					map.put(key, node);
				} else {
					node.next = head;
					head.pre = node;
					head = node;
					map.put(key, node);
					if (map.size() > capacity) {
						map.remove(tail.key);
						tail.pre.next = null;
						tail = tail.pre;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);

		cache.put(1, 1);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.err.println(cache.get(4));
		System.err.println(cache.get(2));
		System.err.println(cache.get(3));
		System.err.println(cache.get(2));
		System.err.println();
	}

}
