import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/30
 * @desc say
 **/
public class L01_08_ {

    /*
     * //编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：
     * //[
     * //  [1,1,1],
     * //  [1,0,1],
     * //  [1,1,1]
     * //]
     * //输出：
     * //[
     * //  [1,0,1],
     * //  [0,0,0],
     * //  [1,0,1]
     * //]
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：
     * //[
     * //  [0,1,2,0],
     * //  [3,4,5,2],
     * //  [1,3,1,5]
     * //]
     * //输出：
     * //[
     * //  [0,0,0,0],
     * //  [0,4,5,0],
     * //  [0,3,1,0]
     * //]
     * //
     * //
     * // Related Topics 数组 哈希表 矩阵 👍 97 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了43.70% 的Java用户
     * 内存消耗:42.7 MB,击败了92.12% 的Java用户
     *
     * @param matrix
     */
    public static void handle(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] b = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j]) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    if (!b[i][j]) {
                        b[i][j] = true;
                        for (int k = 0; k < m; k++) {
                            if (matrix[k][j] != 0) {
                                matrix[k][j] = 0;
                                b[k][j] = true;
                            }
                        }
                        for (int k = 0; k < n; k++) {
                            if (matrix[i][k] != 0) {
                                matrix[i][k] = 0;
                                b[i][k] = true;
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * 执行耗时:15 ms,击败了5.68% 的Java用户
     * 内存消耗:43 MB,击败了50.02% 的Java用户
     *
     * @param matrix
     */
    public static void handle2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String cur = i + "," + j;
                boolean b = map.getOrDefault(cur, false);
                if (b) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    map.put(cur, true);
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            String tmp = k + "," + j;
                            map.put(tmp, true);
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0;
                            String tmp = i + "," + k;
                            map.put(tmp, true);
                        }
                    }
                }
            }
        }

    }

}
