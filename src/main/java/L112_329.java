/**
 * @author sk
 * @time 2021/12/13
 * @desc say
 **/
public class L112_329 {

    /*
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
     *
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
     * 输出：4
     * 解释：最长递增路径为 [1, 2, 6, 9]。
     * 示例 2：
     *
     *
     *
     * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
     * 输出：4
     * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     * 示例 3：
     *
     * 输入：matrix = [[1]]
     * 输出：1
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 200
     * 0 <= matrix[i][j] <= 231 - 1
     */

    public static int handle(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, vis, i, j, 0));
            }
        }
        return max;
    }

    private static int dfs(int[][] dp, int[][] vis, int m, int n, int max) {
        if (m < 0 || m >= dp.length) {
            return max;
        }
        if (n < 0 || n >= dp[0].length) {
            return max;
        }
        if (vis[m][n] > max) {
            return max;
        }
        max += 1;
        vis[m][n] = max;
        int mm = max;
        if (m + 1 < dp.length) {
            if (dp[m][n] < dp[m + 1][n]) {
                mm = dfs(dp, vis, m + 1, n, max);
            }
        }
        if (m - 1 >= 0) {
            if (dp[m][n] < dp[m - 1][n]) {
                mm = Math.max(dfs(dp, vis, m - 1, n, max), mm);
            }
        }
        if (n + 1 < dp[0].length) {
            if (dp[m][n] < dp[m][n + 1]) {
                mm = Math.max(dfs(dp, vis, m, n + 1, max), mm);
            }
        }
        if (n - 1 >= 0) {
            if (dp[m][n] < dp[m][n - 1]) {
                mm = Math.max(dfs(dp, vis, m, n - 1, max), mm);
            }
        }
        return mm;
    }


    public static void main(String[] args) {
        int[][] m;
//        [[9,9,4],[6,6,8],[2,1,1]]
        m = new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.err.println(handle(m));
//        [[3,4,5],[3,2,6],[2,2,1]]
        m = new int[][]{
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        System.err.println(handle(m));
        //[[7,8,9],[9,7,6],[7,2,3]]
        m = new int[][]{
                {7, 8, 9},
                {9, 7, 6},
                {7, 2, 3}
        };
        System.err.println(handle(m));
        //[[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]
        m = new int[][]{
                {0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {0,0,0,0,0,0,0,0,0,0}
        };
        System.err.println(handle(m));
    }

}
