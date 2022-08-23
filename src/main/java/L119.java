import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/23
 * @desc say
 **/
public class L119 {

    /*
     * //给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
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
     * //输入: rowIndex = 3
     * //输出: [1,3,3,1]
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: rowIndex = 0
     * //输出: [1]
     * //
     * //
     * // 示例 3:
     * //
     * //
     * //输入: rowIndex = 1
     * //输出: [1,1]
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 0 <= rowIndex <= 33
     * //
     * //
     * //
     * //
     * // 进阶：
     * //
     * // 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
     * //
     * // Related Topics 数组 动态规划 👍 421 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了77.24% 的Java用户
     * 内存消耗:39.2 MB,击败了49.26% 的Java用户
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> handle(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> last = new ArrayList<>();
            last.add(1);
            for (int j = 1; j < i + 1; j++) {
                int add = temp.get(j - 1);
                if (j < temp.size()) {
                    add += temp.get(j);
                }
                last.add(add);
            }
            temp = last;
        }
        return temp;
    }

    public static void main(String[] args) {
//        System.err.println(JSONUtil.toJsonStr(handle(5)));
        System.err.println(JSONUtil.toJsonStr(handle(3)));
        System.err.println(JSONUtil.toJsonStr(L118.handle(3)));
//        System.err.println(JSONUtil.toJsonStr(handle(33)));
    }

}
