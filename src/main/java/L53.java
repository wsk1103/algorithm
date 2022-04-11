/**
 * @author sk
 * @time 2022/4/11
 **/
public class L53 {

    /**
     * //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * //
     * // 子数组 是数组中的一个连续部分。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * //输出：6
     * //解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1]
     * //输出：1
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [5,4,-1,7,8]
     * //输出：23
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10⁵
     * // -10⁴ <= nums[i] <= 10⁴
     * //
     * //
     * //
     * //
     * // 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     * // Related Topics 数组 分治 动态规划 👍 4726 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:49.7 MB,击败了82.18% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int pre = max;
        for (int i = 1; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.err.println(handle(nums));
        nums = new int[]{5, 4, -1, 7, 8};
        System.err.println(handle(nums));
    }

}
