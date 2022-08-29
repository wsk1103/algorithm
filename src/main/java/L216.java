import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L216 {

    /*
     * //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * //
     * //
     * // 只使用数字1到9
     * // 每个数字 最多使用一次
     * //
     * //
     * // 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: k = 3, n = 7
     * //输出: [[1,2,4]]
     * //解释:
     * //1 + 2 + 4 = 7
     * //没有其他符合的组合了。
     * //
     * // 示例 2:
     * //
     * //
     * //输入: k = 3, n = 9
     * //输出: [[1,2,6], [1,3,5], [2,3,4]]
     * //解释:
     * //1 + 2 + 6 = 9
     * //1 + 3 + 5 = 9
     * //2 + 3 + 4 = 9
     * //没有其他符合的组合了。
     * //
     * // 示例 3:
     * //
     * //
     * //输入: k = 4, n = 1
     * //输出: []
     * //解释: 不存在有效的组合。
     * //在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 2 <= k <= 9
     * // 1 <= n <= 60
     * //
     * //
     * // Related Topics 数组 回溯 👍 531 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了47.89% 的Java用户
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> handle(int k, int n) {
        List<List<Integer>> to = new ArrayList<>();
        LinkedList<Integer> addList = new LinkedList<>();

        loop(k, n, 1, 0, to, addList);
        return to;
    }

    public static void loop(int k, int n, int now, int sum, List<List<Integer>> to, LinkedList<Integer> addList) {
        if (now > n || sum > n || addList.size() > k) {
            return;
        }
        for (int i = now; i <= 9; i++) {
            sum += i;
            addList.addLast(i);
            if (sum == n && addList.size() == k) {
                List<Integer> list = new ArrayList<>(addList);
                to.add(list);
                sum -= i;
                addList.removeLast();
                break;
            } else {
                loop(k, n, i + 1, sum, to, addList);
                sum -= i;
                addList.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int k, n;
        k = 3;
        n = 9;
        System.err.println(JSONUtil.toJsonStr(handle(k, n)));
        k = 4;
        n = 1;
        System.err.println(JSONUtil.toJsonStr(handle(k, n)));
        k = 3;
        n = 7;
        System.err.println(JSONUtil.toJsonStr(handle(k, n)));
    }


}
