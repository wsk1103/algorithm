import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class L148 {

	/*
	 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：head = [4,2,1,3]
	 * 输出：[1,2,3,4]
	 * 示例 2：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：head = [-1,5,3,4,0]
	 * 输出：[-1,0,3,4,5]
	 * 示例 3：
	 * <p>
	 * 输入：head = []
	 * 输出：[]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 链表中节点的数目在范围 [0, 5 * 104] 内
	 * -105 <= Node.val <= 105
	 * <p>
	 * <p>
	 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
	 */

	public static ListNode handle(ListNode head) {
		if (head == null) {
			return null;
		}
		List<Integer> treeSet = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			treeSet.add(temp.val);
			temp = temp.next;
		}
		Collections.sort(treeSet);
		ListNode first = null;
		ListNode loop = null;
		for (Integer integer : treeSet) {
			ListNode to = new ListNode();
			to.val = integer;
			if (loop == null) {
				first = to;
				loop = to;
			} else {
				loop.next = to;
				loop = to;
			}
		}
		return first;
	}

	/**
	 * 归并排序
	 * 快慢指针 切割 链表，循环切割链表，直至快慢列表成单个或者空，递归快慢链表合并
	 * @param head
	 * @return
	 */
	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = slow;
		slow = slow.next;
		fast.next = null;

		fast = mergeSort(head);
		slow = mergeSort(slow);
		return merge(fast, slow);
	}

	public static ListNode merge(ListNode fast, ListNode slow) {
		if (fast == null) {
			return slow;
		}
		if (slow == null) {
			return fast;
		}
		ListNode re = null;
		ListNode temp = null;
		while (fast != null && slow != null) {
			if (fast.val > slow.val) {
				if (re == null) {
					re = slow;
					temp = re;
				} else {
					temp.next = slow;
					temp = temp.next;
				}
				slow = slow.next;
			} else {
				if (re == null) {
					re = fast;
					temp = re;
				} else {
					temp.next = fast;
					temp = temp.next;
				}
				fast = fast.next;
			}
		}
		if (fast != null) {
			temp.next = fast;
		}
		if (slow != null) {
			temp.next = slow;
		}

		return re;
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{5,3,4,8,2,4,1,7,8,6,2};
		ListNode node = NodeSer.ser(nums);
		ListNode to = handle(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));

		nums = new int[]{5,3,4,8,2,4,1,7,8,6,2};
		node = NodeSer.ser(nums);
		to = mergeSort(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));

		nums = new int[]{1};
		node = NodeSer.ser(nums);
		to = mergeSort(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));

		nums = new int[]{};
		node = NodeSer.ser(nums);
		to = mergeSort(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));

		nums = new int[]{2,1};
		node = NodeSer.ser(nums);
		to = mergeSort(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));

		nums = new int[]{3,2,1};
		node = NodeSer.ser(nums);
		to = mergeSort(node);
		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));
	}

}
