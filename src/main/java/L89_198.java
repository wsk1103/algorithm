/**
 * @author sk
 * @time 2021/11/25
 * @desc say
 **/
public class L89_198 {

	/*
	 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
	 * 影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 *
	 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [1,2,3,1]
	 * 输出：4
	 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	 *      偷窃到的最高金额 = 1 + 3 = 4 。
	 * 示例 2：
	 *
	 * 输入：nums = [2,7,9,3,1]
	 * 输出：12
	 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	 *
	 *
	 * 提示：
	 *
	 * 1 <= nums.length <= 100
	 * 0 <= nums[i] <= 400
	 */

	public static int handle(int[] nums) {
		//f(0) = num[0]
		//f(1) = max(num[0],num[1])
		//f(n) = max(f(n-1), f(n-2) + num[n])
		if (nums.length == 1) {
			return nums[0];
		}
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		sum[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			sum[i] = Math.max(sum[i - 2] + nums[i], sum[i - 1]);
		}
		return sum[sum.length - 1];
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1,3,5,6,7,8};
		System.err.println(handle(nums));
		nums = new int[]{2,7,9,3,1};
		System.err.println(handle(nums));
		nums = new int[]{2, 7};
		System.err.println(handle(nums));
		nums = new int[]{2, 7,49,42,34,1,3,0,53,9,4};
		System.err.println(handle(nums));

	}

}
