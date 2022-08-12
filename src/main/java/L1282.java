import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/12
 **/
public class L1282 {

    /*
     * //有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
     * //
     * // 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3
     * //，则第 1 个人必须位于大小为 3 的组中。
     * //
     * // 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
     * //
     * // 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：groupSizes = [3,3,3,3,3,1,3]
     * //输出：[[5],[0,1,2],[3,4,6]]
     * //解释：
     * //第一组是 [5]，大小为 1，groupSizes[5] = 1。
     * //第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
     * //第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
     * //其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：groupSizes = [2,1,3,3,3,2]
     * //输出：[[1],[0,5],[2,3,4]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // groupSizes.length == n
     * // 1 <= n <= 500
     * // 1 <= groupSizes[i] <= n
     * //
     */

    /**
     * 解答成功:
     * 执行耗时:5 ms,击败了83.84% 的Java用户
     * 内存消耗:42 MB,击败了67.99% 的Java用户
     *
     * @param groupSizes
     * @return
     */
    public static List<List<Integer>> handle(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int s = groupSizes[i];
            List<Integer> temp = map.get(s);
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(i);
                map.put(s, temp);
            } else {
                temp.add(i);
            }
            if (temp.size() == s) {
                res.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ii;
        ii = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.err.println(JSONUtil.toJsonStr(handle(ii)));
        ii = new int[]{2, 1, 3, 3, 3, 2};
        System.err.println(JSONUtil.toJsonStr(handle(ii)));
    }

}
