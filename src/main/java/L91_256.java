/**
 * @author sk
 * @time 2021/11/25
 * @desc say
 **/
public class L91_256 {

	/*
	 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
	 *
	 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
	 *
	 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
	 *
	 * 请计算出粉刷完所有房子最少的花费成本。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
	 * 输出: 10
	 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
	 *      最少花费: 2 + 5 + 3 = 10。
	 * 示例 2：
	 *
	 * 输入: costs = [[7,6,2]]
	 * 输出: 2
	 *
	 *
	 * 提示:
	 *
	 * costs.length == n
	 * costs[i].length == 3
	 * 1 <= n <= 100
	 * 1 <= costs[i][j] <= 20
	 */
	public static int handle(int[][] costs) {
		/*
		 * f(00) = min(c[00])
		 * f(01) = min(c[01])
		 * f(02) = min(c[02])
		 * f(n) = min(f(n0),f(n1),f(n2))
		 * f(10) = min(f(01) + c[10], f(02) + c[10])
		 * f(11) = min(f(00) + c[11], f(02) + c[11])
		 * f(12) = min(f(00) + c[12], f(01) + c[12])
		 */
		int[][] dp = new int[costs.length][3];
		dp[0] = costs[0];
//		dp[0][0] = costs[0][0];
//		dp[0][1] = costs[0][1];
//		dp[0][2] = costs[0][2];
		for (int i = 1; i < costs.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1] + costs[i][0], dp[i - 1][2] + costs[i][0]);
			dp[i][1] = Math.min(dp[i - 1][0] + costs[i][1], dp[i - 1][2] + costs[i][1]);
			dp[i][2] = Math.min(dp[i - 1][0] + costs[i][2], dp[i - 1][1] + costs[i][2]);
		}
		int max = Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
		max = Math.min(dp[dp.length - 1][2], max);
		return max;
	}


	public static void main(String[] args) {
		int[][] co;
		co = new int[][]{{1, 2, 3}, {3, 2, 1}, {4, 5, 6}};
		System.err.println(handle(co));
		co = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
		System.err.println(handle(co));

	}
}
