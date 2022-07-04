/**
 * @author sk
 * @time 2022/7/4
 **/
public class L74 {

    /*
     * //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * //
     * //
     * // 每行中的整数从左到右按升序排列。
     * // 每行的第一个整数大于前一行的最后一个整数。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // m == matrix.length
     * // n == matrix[i].length
     * // 1 <= m, n <= 100
     * // -10⁴ <= matrix[i][j], target <= 10⁴
     * //
     * // Related Topics 数组 二分查找 矩阵 👍 674 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了68.37% 的Java用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean handle(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1;
        int loop = 0;

        while (loop < m) {
            if (target == matrix[loop][n]) {
                return true;
            }
            if (target < matrix[loop][n]) {
                int start = 0;
                int end = n;
                while (start <= end) {
                    int mid = (start + end) >> 1;
                    if (target == matrix[loop][mid]) {
                        return true;
                    } else if (target > matrix[loop][mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                return false;
            } else {
                loop++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m;
        int target;
        m = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        target = 3;
        System.err.println(handle(m, target));
        target = 1;
        System.err.println(handle(m, target));
        target = 60;
        System.err.println(handle(m, target));
        target = 23;
        System.err.println(handle(m, target));
        target = 24;
        System.err.println(handle(m, target));
        target = 63;
        System.err.println(handle(m, target));
    }

}
