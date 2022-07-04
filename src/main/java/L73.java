import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/7/4
 **/
public class L73 {

    /*
     * //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * //
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：matrix = [[1,1,1},{1,0,1},{1,1,1]]
     * //输出：[[1,0,1},{0,0,0},{1,0,1]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：matrix = [[0,1,2,0},{3,4,5,2},{1,3,1,5]]
     * //输出：[[0,0,0,0},{0,4,5,0},{0,3,1,0]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // m == matrix.length
     * // n == matrix[0].length
     * // 1 <= m, n <= 200
     * // -2³¹ <= matrix[i][j] <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：
     * //
     * //
     * // 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
     * // 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * // 你能想出一个仅使用常量空间的解决方案吗？
     * //
     * // Related Topics 数组 哈希表 矩阵 👍 738 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了37.01% 的Java用户
     * 内存消耗:43 MB,击败了40.90% 的Java用户
     *
     * @param matrix
     */
    public static void handle(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        List<int[]> set = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 0) {
                    int[] t = new int[2];
                    t[0] = i;
                    t[1] = j;
                    set.add(t);
                }
            }
        }
        for (int[] integer : set) {
            int m = integer[0];
            int n = integer[1];
            for (int i = 0; i < a; i++) {
                if (matrix[i][n] != 0) {
                    matrix[i][n] = 0;
                }
            }
            for (int i = 0; i < b; i++) {
                if (matrix[m][i] != 0) {
                    matrix[m][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nn;
        nn = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        handle(nn);
        System.err.println(JSONUtil.toJsonStr(nn));
        nn = new int[][]{{0, 9, 3, 3, 8, 2, 1, 4, 1, 7, 1, 2, 7}, {6, 0, 2, 3, 3, 8, 5, 1, 9, 3, 2, 0, 7}, {8, 4, 6, 0, 2, 6, 1, 5, 1, 0, 7, 2, 6}, {1, 1, 9, 3, 9, 6, 5, 1, 1, 1, 1, 7, 2}, {0, 0, 6, 3, 9, 4, 7, 5, 6, 0, 3, 7, 7}, {5, 9, 7, 9, 6, 8, 1, 5, 3, 0, 3, 8, 3}, {5, 1, 7, 4, 3, 9, 4, 9, 2, 6, 5, 0, 3}};
        handle(nn);
        System.err.println(JSONUtil.toJsonStr(nn));
    }

}
