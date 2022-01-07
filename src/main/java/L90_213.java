import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sk
 * @time 2021/11/25
 * @desc say
 **/
public class L90_213 {

	/*
	 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
	 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
	 *
	 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [2,3,2]
	 * 输出：3
	 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
	 * 示例 2：
	 *
	 * 输入：nums = [1,2,3,1]
	 * 输出：4
	 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	 *      偷窃到的最高金额 = 1 + 3 = 4 。
	 * 示例 3：
	 *
	 * 输入：nums = [0]
	 * 输出：0
	 *
	 *
	 * 提示：
	 *
	 * 1 <= nums.length <= 100
	 * 0 <= nums[i] <= 1000
	 */

	public static int handle(int[] nums) {
		//f(0) = num[0]
		//f(1) = max(num[0],num[1])
		//f(n) = max(f(n-1), f(n-2) + num[n])
		if (nums.length == 1) {
			return nums[0];
		}
		int[] sum1 = new int[nums.length];
		int[] sum2 = new int[nums.length];
		sum1[0] = nums[0];
		sum2[0] = 0;
		sum1[1] = Math.max(nums[0], nums[1]);
		sum2[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			if (i == nums.length - 1) {
				sum1[i] = Math.max(sum1[i - 2], sum1[i - 1]);
			} else {
				sum1[i] = Math.max(sum1[i - 2] + nums[i], sum1[i - 1]);
			}
			sum2[i] = Math.max(sum2[i - 2] + nums[i], sum2[i - 1]);
		}
		return Math.max(sum1[sum1.length - 1], sum2[sum2.length - 1]);
	}

	public static int handle2(int[] nums) {
		int a1 = 0; //f(n-2) + num[n]
		int b1 = nums[0]; //f(n-1)
		int a2 = 0;
		int b2 = 0;
		for (int i = 1; i < nums.length; i++) {
			if (i == nums.length - 1) {
				int temp = b1;
				b1 = Math.max(a1, b1);
				a1 = temp;
			} else {
				a1 = a1 + nums[i];
				int temp = b1;
				b1 = Math.max(a1, b1);
				a1 = temp;
			}
			a2 = a2 + nums[i];
			int temp = b2;
			b2 = Math.max(a2, b2);
			a2 = temp;
		}
		return Math.max(b1, b2);
	}

	public static void main(String[] args) {
		int[] nums;
//		nums = new int[]{1,2,3,1};
//		System.err.println(handle(nums));
//		System.err.println(handle2(nums));
//		nums = new int[]{1, 2, 3, 1,6};
//		System.err.println(handle(nums));
//		System.err.println(handle2(nums));
//		nums = new int[]{1, 2};
//		System.err.println(handle(nums));
//		System.err.println(handle2(nums));
		nums = new int[]{2,1};
		System.err.println(handle(nums));
		System.err.println(handle2(nums));
		nums = new int[]{1, 2,4,5,645,345,2,35,62,26};
		System.err.println(handle(nums));
		System.err.println(handle2(nums));
		List<Integer> te = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			te.add(r.nextInt(1000) + 1);
		}
		nums = new int[te.size()];
		for (int i = 0; i < te.size(); i++) {
			nums[i] = te.get(i);
		}
		System.err.println(handle(nums));
		System.err.println(handle2(nums));
	}
}
