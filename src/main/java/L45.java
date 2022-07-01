import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2022/7/1
 **/
public class L45 {

    /*
     * //给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * //
     * // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * //
     * // 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * //
     * // 假设你总是可以到达数组的最后一个位置。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: nums = [2,3,1,1,4]
     * //输出: 2
     * //解释: 跳到最后一个位置的最小跳跃数是 2。
     * //     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: nums = [2,3,0,1,4]
     * //输出: 2
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= nums.length <= 10⁴
     * // 0 <= nums[i] <= 1000
     * //
     * // Related Topics 贪心 数组 动态规划 👍 1674 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了99.02% 的Java用户
     * 内存消耗:41.7 MB,击败了75.53% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        int size = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nu;
        nu = new int[]{8, 4, 13, 7, 3, 2, 8, 10, 12, 1, 1, 14, 6, 10, 0, 9, 14, 12, 0, 6, 14, 1, 1, 0, 9, 4, 8, 3, 9, 1, 0, 14, 13, 13, 1, 3, 5, 10, 12, 10, 9, 10, 6, 2, 10, 2, 5, 12, 11, 12};
        System.err.println(handle(nu));
        nu = new int[]{2, 3, 0, 1, 4};
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
