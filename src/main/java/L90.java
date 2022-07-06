import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * @author sk
 * @time 2022/7/6
 **/
public class L90 {

    /*
     * //给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * //
     * // 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,2,2]
     * //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [0]
     * //输出：[[],[0]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10
     * // -10 <= nums[i] <= 10
     * //
     * //
     * //
     * // Related Topics 位运算 数组 回溯 👍 872 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了12.85% 的Java用户
     * 内存消耗:41.4 MB,击败了76.93% 的Java用户
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        LinkedList<Integer> ad = new LinkedList<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        add(0, nums, ad, res, set, sb);
        return res;
    }

    private static void add(int now, int[] nums, LinkedList<Integer> ad, List<List<Integer>> res, Set<String> set, StringBuilder sb) {
        if (now > nums.length) {
            return;
        }
        for (int i = now; i < nums.length; i++) {
            ad.addLast(nums[i]);
            String v = String.valueOf(nums[i]);
            sb.append(v).append(",");
            String temp = sb.toString();
            if (!set.contains(temp)) {
                List<Integer> to = new ArrayList<>(ad);
                res.add(to);
                set.add(temp);
            }
            add(i + 1, nums, ad, res, set, sb);
            ad.removeLast();
            sb.delete(sb.length() - (v.length() + 1), sb.length());
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 2};
        System.err.println(JSONUtil.toJsonStr(handle(nums)));
        nums = new int[]{5, 3, 2, 3};
        System.err.println(JSONUtil.toJsonStr(handle(nums)));
        nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(10);
        }
        System.err.println(JSONUtil.toJsonStr(handle(nums)));
    }
}
