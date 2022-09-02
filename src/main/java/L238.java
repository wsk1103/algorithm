/**
 * @author sk
 * @time 2022/9/2
 * @desc say
 **/
public class L238 {

    /*
     * //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * //
     * // 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
     * //
     * // 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: nums = [1,2,3,4]
     * //输出: [24,12,8,6]
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: nums = [-1,1,0,-3,3]
     * //输出: [0,0,9,0,0]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= nums.length <= 10⁵
     * // -30 <= nums[i] <= 30
     * // 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
     * //
     * //
     * //
     * //
     * // 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     * //
     * // Related Topics 数组 前缀和 👍 1249 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:49.1 MB,击败了94.16% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int[] handle(int[] nums) {
        int len = nums.length;
        int[] to = new int[len];
        int mul = 1;
        int index = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == 0) {
                if (index != -1) {
                    return to;
                }
                index = i;
                continue;
            }
            mul *= num;
        }
        if (index != -1) {
            to[index] = mul;
            return to;
        } else {
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                to[i] = mul / num;
            }
        }
        return to;
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:49.4 MB,击败了67.64% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int[] handle2(int[] nums) {
        int len = nums.length;
        int[] to = new int[len];
        to[0] = 1;
        for (int i = 1; i < len; i++) {
            int num = nums[i - 1];
            to[i] = to[i - 1] * num;
        }
        int mul = 1;
        for (int i = len - 1; i >= 0; i--) {
            to[i] = to[i] * mul;
            mul *= nums[i];
        }
        return to;
    }

}
