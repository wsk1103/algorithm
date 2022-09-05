import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/5
 * @desc say
 **/
public class L260 {

    /*
     * //给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     * //
     * // 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,2,1,3,2,5]
     * //输出：[3,5]
     * //解释：[5, 3] 也是有效的答案。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [-1,0]
     * //输出：[-1,0]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [0,1]
     * //输出：[1,0]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= nums.length <= 3 * 10⁴
     * // -2³¹ <= nums[i] <= 2³¹ - 1
     * // 除两个只出现一次的整数外，nums 中的其他数字都出现两次
     * //
     * //
     * // Related Topics 位运算 数组 👍 647 👎 0
     */

    /**
     * 执行耗时:3 ms,击败了30.73% 的Java用户
     * 内存消耗:41.8 MB,击败了43.17% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int[] handle(int[] nums) {

        if (nums.length == 2) {
            return nums;
        }
        int len = nums.length;
        int[] to = new int[2];
        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[0] != nums[1]) {
                    to[j++] = nums[i];
                }
            } else if (i == len - 1) {
                if (nums[len - 1] != nums[len - 2]) {
                    to[j++] = nums[i];
                }
            } else if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                to[j++] = nums[i];
            }
        }
        return to;
    }

    /**
     * 执行耗时:1 ms,击败了96.38% 的Java用户
     * 内存消耗:41.3 MB,击败了90.88% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int[] handle2(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return nums;
        }
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int m = 0;
        while (((sum >> m) & 1) != 1) {
            m++;
        }
        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            if ((num >> m & 1) == 1) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[]{x1, x2};
    }

}
