import java.util.Arrays;

/**
 * @author sk
 * @time 2021/12/2
 * @desc say
 **/
public class L104_377 {

	/*
	 * 给定一个由 不同 正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。
	 * 数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
	 *
	 * 题目数据保证答案符合 32 位整数范围。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [1,2,3], target = 4
	 * 输出：7
	 * 解释：
	 * 所有可能的组合为：
	 * (1, 1, 1, 1)
	 * (1, 1, 2)
	 * (1, 2, 1)
	 * (1, 3)
	 * (2, 1, 1)
	 * (2, 2)
	 * (3, 1)
	 * 请注意，顺序不同的序列被视作不同的组合。
	 * 示例 2：
	 *
	 * 输入：nums = [9], target = 3
	 * 输出：0
	 *
	 *
	 * 提示：
	 *
	 * 1 <= nums.length <= 200
	 * 1 <= nums[i] <= 1000
	 * nums 中的所有元素 互不相同
	 * 1 <= target <= 1000
	 *
	 *
	 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
	 */

	/**
	 * 1 2 3 = 4
	 *   1 2 3 4
	 * 1 1 1 1 1
	 * 2 1 2 3 5
	 * 3 1 2 4 7
	 * dp[i]:和为i的数量
	 * dp[i] += dp[i - nums(j)]
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int handle(int[] nums, int target) {
		Arrays.sort(nums);
//		int len = nums.length;
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < target + 1; i++) {
			for (int num : nums) {
				if (i >= num) {
					dp[i] += dp[i - num];
				} else {
					break;
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int[] nums;
		int target;
		nums = new int[]{1,2,3};
		target = 5;
		System.err.println(handle(nums, target));
		nums = new int[]{1, 2, 3};
		target = 4;
		System.err.println(handle(nums, target));
	}
}
