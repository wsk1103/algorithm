/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L162 {

    /*
     * //峰值元素是指其值严格大于左右相邻值的元素。
     * //
     * // 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * //
     * // 你可以假设 nums[-1] = nums[n] = -∞ 。
     * //
     * // 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,2,3,1]
     * //输出：2
     * //解释：3 是峰值元素，你的函数应该返回其索引 2。
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,2,1,3,5,6,4]
     * //输出：1 或 5
     * //解释：你的函数可以返回索引 1，其峰值元素为 2；
     * //     或者返回索引 5， 其峰值元素为 6。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 1000
     * // -2³¹ <= nums[i] <= 2³¹ - 1
     * // 对于所有有效的 i 都有 nums[i] != nums[i + 1]
     * //
     * //
     * // Related Topics 数组 二分查找 👍 900 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了79.93% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == len - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了72.14% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int last = len - 1;
        int start = 0;
        int end = last;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == last) {
                if (nums[last] > nums[last - 1]) {
                    return last;
                } else {
                    return last - 1;
                }
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2};
        System.err.println(handle(nums));
    }

}
