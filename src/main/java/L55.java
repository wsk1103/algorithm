import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2022/7/1
 **/
public class L55 {

    /*
     * //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * //
     * // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * //
     * // 判断你是否能够到达最后一个下标。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [2,3,1,1,4]
     * //输出：true
     * //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [3,2,1,0,4]
     * //输出：false
     * //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 3 * 10⁴
     * // 0 <= nums[i] <= 10⁵
     * //
     * // Related Topics 贪心 数组 动态规划 👍 1897 👎 0
     */

    /**
     * 执行耗时:3 ms,击败了25.19% 的Java用户
     * 内存消耗:41.8 MB,击败了66.43% 的Java用户
     *
     * @param nums
     * @return
     */
    public static boolean handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
            }
        }
        return end >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nu;
        nu = new int[]{8, 4, 13, 7, 3, 2, 8, 10, 12, 1, 1, 14, 6, 10, 0, 9, 14, 12, 0, 6, 14, 1, 1, 0, 9, 4, 8, 3, 9, 1, 0, 14, 13, 13, 1, 3, 5, 10, 12, 10, 9, 10, 6, 2, 10, 2, 5, 12, 11, 12};
        //System.err.println(handle(nu));
        nu = new int[]{3, 2, 1, 0, 4};
        System.err.println(handle(nu));
        nu = new int[]{3, 2, 1, 1, 4};
        System.err.println(handle(nu));
        Random random = new Random();
        nu = new int[50];
        nu[0] = random.nextInt(10) + 1;
        for (int i = 1; i < nu.length; i++) {
            nu[i] = random.nextInt(15);
        }
        System.err.println(handle(nu));
    }

}
