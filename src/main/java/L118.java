import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/23
 * @desc say
 **/
public class L118 {

    /*
     * //给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * //
     * // 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * //
     * //
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: numRows = 5
     * //输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: numRows = 1
     * //输出: [[1]]
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= numRows <= 30
     * //
     * //
     * // Related Topics 数组 动态规划 👍 822 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了47.17% 的Java用户
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> handle(int numRows) {
        List<List<Integer>> to = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        to.add(temp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = to.get(i - 1);
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i + 1; j++) {
                int add = last.get(j - 1);
                if (j < last.size()) {
                    add += last.get(j);
                }
                temp.add(add);
            }
            to.add(temp);
        }
        return to;
    }

    public static void main(String[] args) {
        System.err.println(JSONUtil.toJsonStr(handle(5)));
        System.err.println(JSONUtil.toJsonStr(handle(20)));
    }

}
