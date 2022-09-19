import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sk
 * @time 2022/9/19
 * @desc say
 **/
public class L1636 {

    /*
     * //给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     * //
     * // 请你返回排序后的数组。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：nums = [1,1,2,2,2,3]
     * //输出：[3,1,1,2,2,2]
     * //解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：nums = [2,3,1,3,2]
     * //输出：[1,3,3,2,2]
     * //解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
     * //输出：[5,-1,4,4,-6,-6,1,1,1]
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 100
     * // -100 <= nums[i] <= 100
     * //
     * //
     * // Related Topics 数组 哈希表 排序 👍 74 👎 0
     */

    /**
     * 执行耗时:6 ms,击败了45.66% 的Java用户
     * 内存消耗:41.5 MB,击败了85.55% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int[] handle(int[] nums) {
        Map<Integer, KV> map = new HashMap<>();
        for (int num : nums) {
            KV in = map.getOrDefault(num, new KV(num, 0));
            ++in.v;
            map.put(num, in);
        }

        List<KV> list = map.values().stream().sorted((a, b) -> {
            int cp = Integer.compare(a.v, b.v);
            if (cp == 0) {
                cp = Integer.compare(b.k, a.k);
            }
            return cp;
        }).collect(Collectors.toList());

        int[] ans = new int[nums.length];
        int add = 0;
        for (KV kv : list) {
            for (int j = 0; j < kv.v; j++) {
                ans[add++] = kv.k;
            }
        }
        return ans;
    }

    public static class KV {
        private int k;
        private int v;

        KV(int k, int v) {
            this.k = k;
            this.v = v;

        }
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{1, 1, 2, 2, 2, 3};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
        n = new int[]{2, 3, 1, 3, 2};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
    }

}
