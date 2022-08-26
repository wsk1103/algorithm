import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/8/26
 * @desc say
 **/
public class L1464 {

    /*
     * //给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
     * //
     * // 请你计算并返回该式的最大值。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：nums = [3,4,5,2]
     * //输出：12
     * //解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
     * // 3*4 = 12 。
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：nums = [1,5,4,5]
     * //输出：16
     * //解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：nums = [3,7]
     * //输出：12
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= nums.length <= 500
     * // 1 <= nums[i] <= 10^3
     * //
     * //
     * // Related Topics 数组 排序 堆（优先队列） 👍 56 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了59.15% 的Java用户
     * 内存消耗:40.7 MB,击败了86.60% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        Arrays.sort(nums);
        int len = nums.length;
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了66.81% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[1];
        if (max1 > max2) {
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            int n = nums[i];
            if (n < max1) {
                continue;
            } else if (n > max1 && n < max2) {
                max1 = n;
            } else if (n >= max2) {
                max1 = max2;
                max2 = n;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{3, 4, 5, 2};
        System.err.println(handle(n));
        System.err.println(handle2(n));
        n = new int[]{1, 5, 4, 5};
        System.err.println(handle(n));
        System.err.println(handle2(n));
        Random random = new Random();
        n = new int[100];
        for (int i = 0; i < 100; i++) {
            n[i] = random.nextInt(100) + 1;
        }
        System.err.println(handle2(n));
        System.err.println(handle(n));
    }

}
