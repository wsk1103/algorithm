/**
 * @author sk
 * @time 2021/12/22
 * @desc say
 **/
public class L304 {

    /*
     * 给定一个二维矩阵 matrix，以下类型的多个请求：
     *
     * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
     * 实现 NumMatrix 类：
     *
     * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
     * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入:
     * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
     * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
     * 输出:
     * [null, 8, 11, 12]
     *
     * 解释:
     * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
     * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
     * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
     * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 200
     * -105 <= matrix[i][j] <= 105
     * 0 <= row1 <= row2 < m
     * 0 <= col1 <= col2 < n
     * 最多调用 104 次 sumRegion 方法
     * 前缀和
     */

    private static class NumMatrix {

        int[][] nums;

        //每列前缀和
        public NumMatrix(int[][] matrix) {
            this.nums = matrix;
            int m = nums.length;
            int n = nums[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    nums[i][j] = nums[i][j] + nums[i][j - 1];
                }
            }
        }

        //合计前缀和
        public NumMatrix(int[][] matrix, int to) {
            this.nums = matrix;
            int m = nums.length;
            int n = nums[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        if (j == 0) {
                            nums[i][j] = nums[i][j];
                        } else {
                            nums[i][j] = nums[i][j] + nums[i][j - 1];
                        }
                    } else {
                        if (j == 0) {
                            nums[i][j] = nums[i][j] + nums[i - 1][j];
                        } else {
                            nums[i][j] = nums[i][j] + nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
                        }
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                if (col1 == 0) {
                    sum += this.nums[i][col2];
                } else {
                    sum += (this.nums[i][col2] - this.nums[i][col1 - 1]);
                }
            }
            return sum;
        }

        public int sumRegion2(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return nums[row2][col2];
            }
            if (row1 == 0) {
                return nums[row2][col2] - nums[row2][col1 - 1];
            }
            if (col1 == 0) {
                return nums[row2][col2] - nums[row1 - 1][col2];
            }
            return nums[row2][col2] + nums[row1 - 1][col1 - 1] - nums[row1 - 1][col2] - nums[row2][col1 - 1];
        }

    }

    public static void main(String[] args) {
        int[][] n = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix;
//        NumMatrix numMatrix = new NumMatrix(n);
//        System.err.println(numMatrix.sumRegion(2, 1, 4, 3));
//        System.err.println(numMatrix.sumRegion(1, 1, 2, 2));
//        System.err.println(numMatrix.sumRegion(1, 2, 2, 4));

        numMatrix = new NumMatrix(n, 2);
        System.err.println(numMatrix.sumRegion2(2, 1, 4, 3));
        System.err.println(numMatrix.sumRegion2(1, 1, 2, 2));
        System.err.println(numMatrix.sumRegion2(1, 2, 2, 4));
    }

}
