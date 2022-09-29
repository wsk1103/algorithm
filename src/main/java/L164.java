import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L164 {

    /*
     * //给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
     * //
     * // 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: nums = [3,6,9,1]
     * //输出: 3
     * //解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * //
     * // 示例 2:
     * //
     * //
     * //输入: nums = [10]
     * //输出: 0
     * //解释: 数组元素个数小于 2，因此返回 0。
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= nums.length <= 10⁵
     * // 0 <= nums[i] <= 10⁹
     * //
     * //
     * // Related Topics 数组 桶排序 基数排序 排序 👍 518 👎 0
     */

    /**
     * 执行耗时:48 ms,击败了21.73% 的Java用户
     * 内存消耗:56.8 MB,击败了10.72% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int len = nums.length;
//        if (len == 1) {
//            return 0;
//        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < len; i++) {
            int tmp = nums[i] - nums[i - 1];
            max = Math.max(max, tmp);
        }
        return max;
    }

}
