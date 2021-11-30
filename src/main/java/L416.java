

/**
 * @author sk
 * @time 2021/11/30
 * @desc say
 **/
public class L416 {

	/*
	 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [1,5,11,5]
	 * 输出：true
	 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
	 * 示例 2：
	 *
	 * 输入：nums = [1,2,3,5]
	 * 输出：false
	 * 解释：nums 不可以分为和相等的两部分
	 *
	 *
	 * 提示：
	 *
	 * 1 <= nums.length <= 200
	 * 1 <= nums[i] <= 100
	 */

	/**
	 * 思路: 题意转化为 是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半设为 target
	 *
	 * 状态数组: dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j
	 * 状态转移:
	 * a. 不选 nums[i], dp[i][j]= dp[i-1][j]
	 * b. 选 nums[i]
	 * 当 j>=nums[i], dp[i][j] = dp[i-1][j-nums[i]]
	 * 初始化: 和为0,都为 true, dp[i][0]=true, 同时填充第0行, dp[0][nums[0]]=true
	 * 输出结果: dp[len-1][target], 即数组选一些数的和可以为整个数据元素和的一半
	 * 情况特判: 先求数组总和, 若不为偶数, 则直接返回false
	 * @param nums
	 * @return
	 */
	public static boolean handle(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return false;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1) {
			return false;
		}
		int target = sum / 2;
		boolean[][] dp = new boolean[len][target + 1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = true;
		}
		if (nums[0] <= target) {
			dp[0][nums[0]] = true;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= target; j++) {
				if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[len - 1][target];
	}

	public static boolean handle2(int[] nums) {
		int sum = 0;
		int len = nums.length;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1) {
			return false;
		}
		int target = sum / 2;
		boolean[][] dp = new boolean[len][target + 1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = true;
		}
		if (nums[0] <= target) {
			dp[0][nums[0]] = true;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[len - 1][target];
	}

	public static void main(String[] args) {
		int[] nu;
		nu = new int[]{1,5,11,5};
		System.err.println(handle(nu));
		System.err.println(handle2(nu));
		nu = new int[]{1,2,3,5};
		System.err.println(handle2(nu));
		nu = new int[]{5, 1, 2, 3, 2, 6, 4, 5};
		System.err.println(handle2(nu));
	}

}
