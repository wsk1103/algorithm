/**
 * @author sk
 * @time 2021/11/30
 * @desc say
 **/
public class L102_494 {

	/*
	 * 给定一个正整数数组 nums 和一个整数 target 。
	 *
	 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
	 *
	 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
	 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [1,1,1,1,1], target = 3
	 * 输出：5
	 * 解释：一共有 5 种方法让最终目标和为 3 。
	 * -1 + 1 + 1 + 1 + 1 = 3
	 * +1 - 1 + 1 + 1 + 1 = 3
	 * +1 + 1 - 1 + 1 + 1 = 3
	 * +1 + 1 + 1 - 1 + 1 = 3
	 * +1 + 1 + 1 + 1 - 1 = 3
	 * 示例 2：
	 *
	 * 输入：nums = [1], target = 1
	 * 输出：1
	 *
	 *
	 * 提示：
	 *
	 * 1 <= nums.length <= 20
	 * 0 <= nums[i] <= 1000
	 * 0 <= sum(nums[i]) <= 1000
	 * -1000 <= target <= 1000
	 * dp or 01 背包
	 */
	public static int handle(int[] nums, int target) {
		int to = add(nums, 0, 0, 0, target, 0, 0);
		return to;
	}

	public static int add(int[] nums, int index, int cur, int sum, int target, int size, int zero) {
		if (index >= nums.length) {
			if (sum == target && size == nums.length) {
				if (zero > 0) {
					return cur + (int) Math.pow(2, zero);
				}
				return cur + 1;
			} else {
				return cur;
			}
		}
//		for (int i = index; i < nums.length; i++) {
		if (nums[index] == 0) {
			cur = add(nums, index + 1, cur, sum, target, size + 1, zero + 1);
		} else {
			int temp;
			temp = sum + nums[index];
			size++;
			cur = add(nums, index + 1, cur, temp, target, size, zero);
			size--;
			temp = sum - nums[index];
			size++;
			cur = add(nums, index + 1, cur, temp, target, size, zero);
			size--;
		}
//		}
		return cur;
	}

//	public static int handle2(int[] nums, int target) {
//		int len = nums.length;
//		int sum = 0;
//		for (int num : nums) {
//			sum += num;
//		}
//		//70 > 60
//		if (target > sum && target > 0) {
//			return 0;
//		} else if (target < 0 || target < -sum) {
//			//-70 < -60
//			return 0;
//		}
//		int[][] dp = new int[len][2 * (sum + 1)];
//		int la1 = 0;
//		int la2 = 0;
//		for (int i = 0; i < len; i++) {
//			la1 = target - nums[i];
//			la2 = target + nums[i];
//		}
//	}

	public static int handle3(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (target > sum || (target + sum) % 2 == 1) {
			return 0;
		}
		//背包容量target；
		int t = Math.abs((target + sum)) / 2;
		int[] dp = new int[t + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = t; j >= num; j--) {
				dp[j] = dp[j] + dp[j - num];
			}
		}
		return dp[t];
	}

	public static void main(String[] args) {
		int[] nums;
		int target;
		nums = new int[]{1, 1, 1, 1, 1};
		target = 3;
		System.err.println(handle(nums, target));
		nums = new int[]{1};
		target = 1;
		System.err.println(handle(nums, target));
		nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		target = 1;
		System.err.println(handle(nums, target));
		System.err.println(handle3(nums, target));
		nums = new int[]{1, 0};
		target = 1;
		System.err.println(handle(nums, target));
		nums = new int[]{42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47};
		target = 38;
		System.err.println(handle(nums, target));
		System.err.println(handle3(nums, target));

	}

}
