import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * @author sk
 * @time 2022/6/28
 **/
public class L324 {

    /*
     * //给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     * //
     * // 你可以假设所有输入数组都可以得到满足题目要求的结果。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,5,1,1,6,4]
     * //输出：[1,6,1,5,1,4]
     * //解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,3,2,2,3,1]
     * //输出：[2,3,1,3,1,2]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 5 * 10⁴
     * // 0 <= nums[i] <= 5000
     * // 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
     * //
     * //
     * //
     * //
     * // 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
     * // Related Topics 数组 分治 快速选择 排序 👍 425 👎 0
     */

    /**
     * 执行耗时:3 ms,击败了72.42% 的Java用户
     * 内存消耗:45.1 MB,击败了45.22% 的Java用户
     *
     * @param nums
     */
    public static void handle(int[] nums) {

        if (nums.length == 1) {
            return;
        }
        Arrays.sort(nums);
        int[] re = new int[nums.length];
        int start = re.length >> 1;
        if ((nums.length & 1) == 0) {
            start = start - 1;
        }
        int end = nums.length - 1;
        int i = 0;
        while (start >= 0) {
            re[i] = nums[start--];
            i += 2;
        }
        i = 1;
        while (i < nums.length) {
            re[i] = nums[end--];
            i += 2;
        }
        System.arraycopy(re, 0, nums, 0, nums.length);
        System.err.println(JSONUtil.toJsonStr(nums));
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{1, 5, 1, 1, 6, 4};
        handle(n);
        n = new int[]{1, 3, 2, 2, 3, 1};
        handle(n);
        n = new int[]{1, 3, 2, 2, 3};
        handle(n);
        n = new int[]{3, 1};
        handle(n);
        n = new int[]{3, 1, 1};
        handle(n);
    }

}
