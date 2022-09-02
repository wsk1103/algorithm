/**
 * @author sk
 * @time 2022/9/2
 * @desc say
 **/
public class L240 {

    /*
     * //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * //
     * //
     * // 每行的元素从左到右升序排列。
     * // 每列的元素从上到下升序排列。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
     * //,23,26,30]], target = 5
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
     * //,23,26,30]], target = 20
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
     * // 1 <= n, m <= 300
     * // -10⁹ <= matrix[i][j] <= 10⁹
     * // 每行的所有元素从左到右升序排列
     * // 每列的所有元素从上到下升序排列
     * // -10⁹ <= target <= 10⁹
     * //
     * //
     * // Related Topics 数组 二分查找 分治 矩阵 👍 1111 👎 0
     */

    /**
     * 执行耗时:5 ms,击败了93.97% 的Java用户
     * 内存消耗:47.5 MB,击败了26.77% 的Java用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean handle(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ns = n - 1;
        int ms = 0;
        for (int i = ns; i >= 0;) {
            if (matrix[ms][i] == target) {
                return true;
            }
            if (matrix[ms][i] < target) {
                ms++;
                if (ms >= m) {
                    return false;
                }
                continue;
            }
            i--;
        }
        return false;
    }

}
