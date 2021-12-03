/**
 * @author sk
 * @time 2021/12/3
 * @desc say
 **/
public class L695 {

	/*
	 * 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
	 *
	 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
	 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
	 *
	 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
	 *
	 *
	 *
	 * 示例 1:
	 *
	 *
	 *
	 * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
	 * 输出: 6
	 * 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
	 * 示例 2:
	 *
	 * 输入: grid = [[0,0,0,0,0,0,0,0]]
	 * 输出: 0
	 *
	 *
	 * 提示：
	 *
	 * m == grid.length
	 * n == grid[i].length
	 * 1 <= m, n <= 50
	 * grid[i][j] is either 0 or 1
	 */

	@Deprecated
	public static int handle(int[][] grid) {
		int max = 0;
		int len = grid.length;
//		int[][] dp = new int[len][grid[0].length];

		for (int i = 0; i < len; i++) {
			int[] tt = grid[i];
			int l2 = tt.length;
			for (int j = 0; j < l2; j++) {
				if (tt[j] == 1) {
//					tt[j] += 1;
					if (i > 0 && grid[i - 1][j] > 0) {
						tt[j] += grid[i - 1][j];
					}
					if (j > 0 && tt[j - 1] > 0) {
						tt[j] += tt[j - 1];
					}
					if (i > 0 && grid[i - 1][j] > 0 && j > 0 && tt[j - 1] > 0) {
						tt[j] -= grid[i - 1][j - 1];
					}
					max = Math.max(max, tt[j]);
				}
			}
		}
		return max;
	}

	public static int handle2(int[][] grid) {
		int l1 = grid.length;
		int l2 = grid[0].length;
		int max = 0;
		int[][] dp = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				int cur = dfs(grid, dp, i, j, 0, l1, l2);
				max = Math.max(max, cur);
			}
		}
		return max;
	}

	private static int dfs(int[][] grid, int[][] dp, int i, int j, int m, int l1, int l2) {
		if (i < 0 || i >= l1) {
			return m;
		}
		if (j < 0 || j >= l2) {
			return m;
		}
		if (dp[i][j] == 1) {
			return m;
		}
		dp[i][j] = 1;
		if (grid[i][j] == 0) {
			return m;
		}
		m += 1;
		m = dfs(grid, dp, i - 1, j, m, l1, l2);
		m = dfs(grid, dp, i, j - 1, m, l1, l2);
		m = dfs(grid, dp, i, j + 1, m, l1, l2);
		m = dfs(grid, dp, i + 1, j, m, l1, l2);
		return m;
	}

	public static int handle3(int[][] grid) {
		int l1 = grid.length;
		int l2 = grid[0].length;
		int max = 0;
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				int cur = dfs(grid, i, j, 0, l1, l2);
				max = Math.max(max, cur);
			}
		}
		return max;
	}

	private static int dfs(int[][] grid, int i, int j, int m, int l1, int l2) {
		if (i < 0 || i >= l1) {
			return m;
		}
		if (j < 0 || j >= l2) {
			return m;
		}
		if (grid[i][j] == -1) {
			return m;
		}
		if (grid[i][j] == 0) {
			return m;
		}
		if (grid[i][j] == 1) {
			grid[i][j] = -1;
			m += 1;
			m = dfs(grid, i - 1, j, m, l1, l2);
			m = dfs(grid, i, j - 1, m, l1, l2);
			m = dfs(grid, i, j + 1, m, l1, l2);
			m = dfs(grid, i + 1, j, m, l1, l2);
		}
		return m;
	}


	public static void main(String[] args) {
		//[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
		int[][] nn;
		nn = new int[][]{
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
		};
		System.err.println(handle3(nn));
	}
}
