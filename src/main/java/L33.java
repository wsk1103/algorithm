/**
 * @author sk
 * @time 2022/7/1
 **/
public class L33 {

    /*
     * //整数数组 nums 按升序排列，数组中的值 互不相同 。
     * //
     * // 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
     * //k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
     * //,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * //
     * // 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * //
     * // 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [4,5,6,7,0,1,2], target = 0
     * //输出：4
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [4,5,6,7,0,1,2], target = 3
     * //输出：-1
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1], target = 0
     * //输出：-1
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 5000
     * // -10⁴ <= nums[i] <= 10⁴
     * // nums 中的每个值都 独一无二
     * // 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * // -10⁴ <= target <= 10⁴
     * //
     * // Related Topics 数组 二分查找 👍 2161 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了71.66% 的Java用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int handle(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] == target) {
                return start;
            } else if (end < nums.length && nums[end] == target) {
                return end;
            }
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > nums[start] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] num;
        int target;
        num = new int[]{5, 1, 2, 3, 4};
        target = 1;
        System.err.println(handle(num, target));
        num = new int[]{1, 4};
        target = 4;
        System.err.println(handle(num, target));
        num = new int[]{7, 8, 1, 2, 3, 4, 5, 6};
        target = 2;
        System.err.println(handle(num, target));
        num = new int[]{1};
        target = 1;
        System.err.println(handle(num, target));
        num = new int[]{1};
        target = 0;
        System.err.println(handle(num, target));
    }


}
