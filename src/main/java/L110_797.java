import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2021/12/10
 * @desc say
 **/
public class L110_797 {

    /*
     * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
     *
     * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），
     * 若为空，就是没有下一个节点了。
     *
     *
     *
     * 示例 1：
     * 0 - 1
     * |   |
     * 2 - 3
     *
     *
     * 输入：graph = [[1,2],[3],[3],[]]
     * 输出：[[0,1,3],[0,2,3]]
     * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
     * 示例 2：
     *  -------
     * |       |
     * |   0 - 1
     * |  / \ / \
     *  -4 - 3 - 2
     *
     *
     * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
     * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
     * 示例 3：
     *
     * 输入：graph = [[1],[]]
     * 输出：[[0,1]]
     * 示例 4：
     *
     * 输入：graph = [[1,2,3],[2],[3],[]]
     * 输出：[[0,1,2,3],[0,2,3],[0,3]]
     * 示例 5：
     *
     * 输入：graph = [[1,3],[2],[3],[]]
     * 输出：[[0,1,2,3],[0,3]]
     *
     *
     * 提示：
     *
     * n == graph.length
     * 2 <= n <= 15
     * 0 <= graph[i][j] < n
     * graph[i][j] != i
     * 保证输入为有向无环图 (GAD)
     */

    public static List<List<Integer>> handle(int[][] graph) {
        List<List<Integer>> to = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        int n = graph.length - 1;

        hh(0, n, graph, to, path);
        return to;
    }

    public static void hh(int cur, int n, int[][] graph, List<List<Integer>> to, LinkedList<Integer> path) {
        for (int i = 0; i < graph[cur].length; i++) {
            path.offer(graph[cur][i]);
            int temp = graph[cur][i];
            if (temp == n) {
                List<Integer> list = new ArrayList<>(path);
                to.add(list);
            } else {
                hh(temp, n, graph, to, path);
            }
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        int[][] g;
        g = new int[][]{
                {4,3,1},{3,2,4},{3},{4},{}
        };
        System.err.println(JSON.toJSONString(handle(g)));
    }
}
