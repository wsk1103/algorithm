import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L153 {

    /*
     * //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
     * //化后可能得到：
     * //
     * //
     * // 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * // 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * //
     * //
     * // 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
     * //..., a[n-2]] 。
     * //
     * // 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * //
     * // 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [3,4,5,1,2]
     * //输出：1
     * //解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [4,5,6,7,0,1,2]
     * //输出：0
     * //解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [11,13,15,17]
     * //输出：11
     * //解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
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
     * // nums 中的所有整数 互不相同
     * // nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     * //
     * //
     * // Related Topics 数组 二分查找 👍 838 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了73.72% 的Java用户
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
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0) {
                return Math.min(nums[0], nums[1]);
            } else if (mid == len - 1) {
                return Math.min(nums[len - 1], nums[len - 2]);
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了89.34% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nm;
        nm = new int[]{2, 1};
        System.err.println(handle(nm));
        nm = new int[]{3, 1, 2};
        System.err.println(handle(nm));
        nm = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.err.println(handle(nm));
        nm = new int[]{1, 2, 3, 4, 5, 6, 0};
        System.err.println(handle(nm));
    }

}
