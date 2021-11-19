import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class L215 {

	/**
	 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
	 * <p>
	 * 请注
	 * 意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: [3,2,1,5,6,4] 和 k = 2
	 * 输出: 5
	 * 示例 2:
	 * <p>
	 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	 * 输出: 4
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= k <= nums.length <= 104
	 * -104 <= nums[i] <= 104
	 */

	public static int handle(int[] nums, int k) {
		if (nums == null) {
			return -1;
		} else if (nums.length <= 1) {
			return nums[0];
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			if (queue.size() < k) {
				queue.offer(num);
			} else {
				if (queue.peek() < num) {
					queue.poll();
					queue.offer(num);
				}
			}
		}
		return queue.peek();
	}

	public static int handle2(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		int[] nums;
		int k;
		nums = new int[]{9,8,5,2,4,6,7,5,1};
		k = 3;
		System.err.println(handle2(nums, k));
	}
}
