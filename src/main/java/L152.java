/**
 * @author sk
 * @time 2022/9/27
 * @desc say
 **/
public class L152 {

    /*
     * //给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * //
     * // 测试用例的答案是一个 32-位 整数。
     * //
     * // 子数组 是数组的连续子序列。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: nums = [2,3,-2,4]
     * //输出: 6
     * //解释: 子数组 [2,3] 有最大乘积 6。
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: nums = [-2,0,-1]
     * //输出: 0
     * //解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= nums.length <= 2 * 10⁴
     * // -10 <= nums[i] <= 10
     * // nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     * //
     * //
     * // Related Topics 数组 动态规划 👍 1808 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了66.99% 的Java用户
     * 内存消耗:41.4 MB,击败了82.01% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = max;
        for (int i = 1; i < len; i++) {
            int tmp = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            min = Math.min(max * nums[i], Math.min(nums[i], min * nums[i]));
            max = tmp;
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
