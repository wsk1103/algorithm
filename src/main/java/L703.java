/**
 * @author sk
 * @time 2021/11/11
 * @desc say
 **/
public class L703 {

	/*
	 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
	 * <p>
	 * 请实现 KthLargest 类：
	 * <p>
	 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
	 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：
	 * ["KthLargest", "add", "add", "add", "add", "add"]
	 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
	 * 输出：
	 * [null, 4, 5, 5, 8, 8]
	 * <p>
	 * 解释：
	 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
	 * kthLargest.add(3);   // return 4
	 * kthLargest.add(5);   // return 5
	 * kthLargest.add(10);  // return 5
	 * kthLargest.add(9);   // return 8
	 * kthLargest.add(4);   // return 8
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= k <= 104
	 * 0 <= nums.length <= 104
	 * -104 <= nums[i] <= 104
	 * -104 <= val <= 104
	 * 最多调用 add 方法 104 次
	 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
	 *
	 * 小根堆
	 */


	static class KthLargest {

		int[] v;
		int size;

		KthLargest(int k, int[] nums) {
			v = new int[k];
			for (int num : nums) {
				add(num);
			}
		}

		public Integer add(int val) {
			if (size < v.length) {
				v[size] = val;
				insert(size++);
			} else {
				if (val <= v[0]) {
					return v[0];
				}
				insert(val, v.length - 1);
			}
			return v[0];
		}

		public void insert(int val, int end) {
			if (end < 0) {
				return;
			}
			int temp = v[end];
			if (val < temp) {
				insert(val, end - 1);
			} else {
				v[end] = val;
				insert(temp, end - 1);
			}
		}

		public void insert(int index) {
			int par = (index - 1) / 2;
			while (par >= 0) {
				if (v[index] >= v[par]) {
					break;
				} else {
					swap(index, par);
					index = par;
					par = (index - 1) / 2;
				}
			}
		}

		private void swap(int i, int j) {
			int temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}

	}


//	static class KthLargest {
//		int size;
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//		KthLargest(int k, int[] nums) {
//			size = k;
//			if (nums != null && nums.length > 0) {
//				for (int num : nums) {
//					queue.offer(num);
//					if (queue.size() > k) {
//						queue.poll();
//					}
//				}
//			}
//		}
//
//		public Integer add(int val) {
//			queue.offer(val);
//			if (queue.size() > size) {
//				queue.poll();
//			}
//			return queue.peek();
//		}
//	}

	public static void main(String[] args) {
		int[] nums = new int[]{-1,-5,7,6};
		KthLargest k = new KthLargest(5, nums);
		System.err.println(k.add(3));
		System.err.println(k.add(5));
		System.err.println(k.add(10));
		System.err.println(k.add(9));
		System.err.println(k.add(4));
		System.err.println(k.add(11));
		System.err.println(k.add(0));
		System.err.println(k.add(10));
		System.err.println(k.add(10));
		System.err.println(k.add(10));
		System.err.println(k.add(10));
	}

}
