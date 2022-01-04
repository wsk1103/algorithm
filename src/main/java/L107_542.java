import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/12/6
 * @desc say
 **/
public class L107_542 {

    /*
     * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     *
     *
     *
     * 示例 1：
     * 0 0 0
     * 0 1 0
     * 0 0 0
     *
     *
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     * 示例 2：
     * 0 0 0
     * 0 1 0
     * 1 1 1
     *
     * 0 0 0
     * 0 1 0
     * 1 2 1
     *
     *
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     *
     *
     * 提示：
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 104
     * 1 <= m * n <= 104
     * mat[i][j] is either 0 or 1.
     * mat 中至少有一个 0
     */

    private static int min = Integer.MAX_VALUE;

    public static int[][] handle(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] to = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    min = Integer.MAX_VALUE;
                    dfs(new HashMap<>(), mat, i, j, 0);
                    to[i][j] = min;
                }
            }
        }
        return to;
    }

    private static void dfs(Map<String, Integer> map, int[][] mat, int i, int j, int size) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return;
        }
        if (min < size) {
            return;
        }
        String key = i + "" + j;
        if (map.containsKey(key)) {
            int v = map.get(key);
            if (v <= size) {
                return;
            }
        }
        map.put(key, size);
        if (mat[i][j] == 0) {
            min = Math.min(min, size);
            return;
        }
        dfs(map, mat, i, j - 1, size + 1);
        dfs(map, mat, i, j + 1, size + 1);
        dfs(map, mat, i - 1, j, size + 1);
        dfs(map, mat, i + 1, j, size + 1);
//		return size;
    }

    public static int[][] handle2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] to = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(to[i], 10001);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    to[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dd = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] out = queue.poll();
            int x = out[0];
            int y = out[1];
            int num = to[x][y];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dd[i][0];
                int nextY = y + dd[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                    continue;
                }
                if (to[nextX][nextY] < 10001) {
                    continue;
                }
                to[nextX][nextY] = num + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return to;
    }

    public static void main(String[] args) {
        int[][] mat;
        mat = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };
        System.err.println(JSON.toJSONString(handle2(mat)));
    }

}
