import java.util.List;

/**
 * @author sk
 * @time 2021/11/30
 * @desc say
 **/
public class L100_120 {

	/*
	 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
	 *
	 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
	 * 输出：11
	 * 解释：如下面简图所示：
	 *    2
	 *   3 4
	 *  6 5 7
	 * 4 1 8 3
	 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
	 * 示例 2：
	 *
	 * 输入：triangle = [[-10]]
	 * 输出：-10
	 *
	 *
	 * 提示：
	 *
	 * 1 <= triangle.length <= 200
	 * triangle[0].length == 1
	 * triangle[i].length == triangle[i - 1].length + 1
	 * -104 <= triangle[i][j] <= 104
	 *
	 *
	 * 进阶：
	 *
	 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
	 */

	public static int handle(List<List<Integer>> triangle) {
		int min = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> tt = triangle.get(i);
			List<Integer> tl = triangle.get(i - 1);
			for (int j = 0; j < tt.size(); j++) {
				int vv;
				if (j - 1 < 0) {
					vv = tt.get(j) + tl.get(j);
					tt.set(j, vv);
				} else if (j >= tl.size()) {
					vv = tt.get(j) + tl.get(j - 1);
					tt.set(j, vv);
				} else {
					int v = tt.get(j);
					int t1 = v + tl.get(j);
					int t2 = v + tl.get(j - 1);
					vv = Math.min(t1, t2);
					tt.set(j, vv);
				}
				if (j == 0) {
					min = vv;
				} else {
					min = Math.min(min, vv);
				}
			}
		}
		return min;
	}

	public static int handle2(int[][] triangle) {
		int min = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j - 1 < 0) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
				} else if (j >= triangle[i - 1].length) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
				} else {
					int temp = triangle[i][j];
					int t1 = temp + triangle[i - 1][j];
					int t2 = temp + triangle[i - 1][j - 1];
					triangle[i][j] = Math.min(t1, t2);
				}
				if (j == 0) {
					min = triangle[i][j];
				} else {
					min = Math.min(min, triangle[i][j]);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] n;
		n = new int[][]{
				{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}
		};
		System.err.println(handle2(n));
		n = new int[][]{
				{2}
		};
		System.err.println(handle2(n));
		n = new int[][]{
				{-2}
		};
		System.err.println(handle2(n));
	}

}
