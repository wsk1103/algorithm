import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/7/1
 **/
public class L34 {

    /*
     * //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * //
     * // 如果数组中不存在目标值 target，返回 [-1, -1]。
     * //
     * // 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [5,7,7,8,8,10], target = 8
     * //输出：[3,4]
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [5,7,7,8,8,10], target = 6
     * //输出：[-1,-1]
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [], target = 0
     * //输出：[-1,-1]
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= nums.length <= 10⁵
     * // -10⁹ <= nums[i] <= 10⁹
     * // nums 是一个非递减数组
     * // -10⁹ <= target <= 10⁹
     * //
     * // Related Topics 数组 二分查找 👍 1770 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.2 MB,击败了94.65% 的Java用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] handle(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        int start = 0;
        int end = nums.length - 1;
        int find = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (target == nums[mid]) {
                find = mid;
                break;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (find != -1) {
            res[0] = findLeft(nums, target, 0, find);
            res[1] = findRight(nums, target, end, find);

        }
        return res;
    }

    public static int findLeft(int[] nums, int target, int start, int index) {

        //int to = index;
        int end = index - 1;
        if (end < 0) {
            return index;
        }
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (target == nums[mid]) {
                return findLeft(nums, target, start, mid);
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static int findRight(int[] nums, int target, int end, int index) {

        int start = index + 1;
        if (start >= nums.length) {
            return index;
        }
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (target == nums[mid]) {
                return findRight(nums, target, end, mid);
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] n;
        int target;
        n = new int[]{5, 7, 7, 8, 8, 8, 8, 10};
        target = 8;
        System.err.println(JSONUtil.toJsonStr(handle(n, target)));
    }

}
