/**
 * @author sk
 * @time 2021/12/2
 * @desc say
 **/
public class L322 {

	/*
	 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
	 *
	 * 你可以认为每种硬币的数量是无限的。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：coins = [1, 2, 5], amount = 11
	 * 输出：3
	 * 解释：11 = 5 + 5 + 1
	 * 示例 2：
	 *
	 * 输入：coins = [2], amount = 3
	 * 输出：-1
	 * 示例 3：
	 *
	 * 输入：coins = [1], amount = 0
	 * 输出：0
	 * 示例 4：
	 *
	 * 输入：coins = [1], amount = 1
	 * 输出：1
	 * 示例 5：
	 *
	 * 输入：coins = [1], amount = 2
	 * 输出：2
	 *
	 *
	 * 提示：
	 *
	 * 1 <= coins.length <= 12
	 * 1 <= coins[i] <= 231 - 1
	 * 0 <= amount <= 104
	 */

	/**
	 * 1 2 5 = 11
	 *   1 2 3 4 5 6 7 8 9 10 11
	 * 1 1 2 3 4 5 6 7 8 9 10 11
	 * 2 1 1 2 2 3 3 3 4 5 5  6
	 * 5 1 1 2 2 1 2 2 3 3 2  3
	 * dp[i]:到i元最小个数
	 * db[i]=min{db[i-coin]+1,db[i]}
	 * 1. 0元时需要0个硬币，所以db[0]=0;
	 * 2. 当i<0时：设为正无穷,通过初始化实现 ；也可采用将db中所有元素赋值为amount+1
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int handle(int[] coins, int amount) {
//		Arrays.sort(coins);
		if (amount == 0) {
			return 0;
		}
		int len = coins.length;
//		int pgSize = amount / len + 1;
		int[] dp = new int[amount + 1];
		for (int i = 1; i < amount + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		int[] nums;
		int target;
		nums = new int[]{1,2,3};
		target = 7;
		System.err.println(handle(nums, target));
	}


}
