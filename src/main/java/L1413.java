import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2022/8/9
 **/
public class L1413 {

    /*
     * //给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
     * //
     * // 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
     * //
     * // 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [-3,2,-3,4,2]
     * //输出：5
     * //解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
     * //                累加求和
     * //                startValue = 4 | startValue = 5 | nums
     * //                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     * //                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     * //                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     * //                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     * //                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,2]
     * //输出：1
     * //解释：最小的 startValue 需要是正数。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1,-2,-3]
     * //输出：5
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 100
     * // -100 <= nums[i] <= 100
     * //
     * // Related Topics 数组 前缀和 👍 56 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了45.15% 的Java用户
     * 寻找前缀和最小值
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        int[] sum = new int[nums.length];
        int add = 0;
        for (int i = 0; i < nums.length; i++) {
            add += nums[i];
            sum[i] = add;
        }
        int res = Integer.MAX_VALUE;
        for (int i : sum) {
            res = Math.min(i, res);
        }

        return res >= 0 ? 1 : -res + 1;
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了36.99% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
//        int[] sum = new int[nums.length];
        int add = 0;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            add += num;
            res = Math.min(add, res);
        }

        return res >= 0 ? 1 : -res + 1;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{-3, 2, -3, 4, 2};
        System.err.println(handle(nums));
        nums = new int[]{1, 2};
        System.err.println(handle(nums));
        nums = new int[]{1, -2, -3};
        System.err.println(handle(nums));
        nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
            if (random.nextInt(2) == 0) {
                nums[i] = -nums[i];
            }
        }
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
    }

}
