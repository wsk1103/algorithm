import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L154 {

    /*
     * //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变
     * //化后可能得到：
     * //
     * //
     * // 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * // 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * //
     * //
     * // 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
     * //..., a[n-2]] 。
     * //
     * // 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * //
     * // 你必须尽可能减少整个过程的操作步骤。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,3,5]
     * //输出：1
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [2,2,2,0,1]
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // n == nums.length
     * // 1 <= n <= 5000
     * // -5000 <= nums[i] <= 5000
     * // nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     * //
     * //
     * //
     * //
     * // 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
     * //
     * // Related Topics 数组 二分查找 👍 549 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了37.75% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了98.85% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (nums[0] < nums[len - 1]) {
            return nums[0];
        }
        int start = 0;
        int end = len - 1;
        while (start <= end && nums[start] == nums[end]) {
            end--;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0) {
                return Math.min(nums[0], nums[1]);
            } else if (mid == len - 1) {
                return Math.min(nums[len - 1], nums[len - 2]);
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] < nums[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3, 4, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, -10, -10, -10, -9, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -6, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -3, -3, -3, -3, -2, -2, -2, -2, -1, -1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3};
        System.err.println(handle(nums));
        nums = new int[]{2, 2, 2, 0, 2, 2};
        System.err.println(handle(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.err.println(handle(nums));
        nums = new int[]{10, 1, 10, 10, 10};
        System.err.println(handle(nums));
        nums = new int[]{10, 10, 10, 1, 10};
        System.err.println(handle(nums));
    }

}
