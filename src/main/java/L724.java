/**
 * @author sk
 * @time 2021/10/19
 * @desc say
 **/
public class L724 {

    /*
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,7,3,6,5,6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * 示例 3：
     * <p>
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10 ^ 4
     * -1000 <= nums[i] <= 1000
     */


    public static int handle(int[] nums) {
        int sum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            int left;
            int right;
            if (i == 0) {
                left = 0;
                right = sums[sums.length - 1] - sums[i];
            } else if (i == nums.length - 1) {
                right = 0;
                left = sums[i] - nums[i];
            } else {
                left = sums[i] - nums[i];
                right = sums[sums.length - 1] - sums[i];
            }
            if (left - right == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nu = new int[]{1,7,3,6,5,6};
        System.err.println(handle(nu));

        nu = new int[]{1, 2, 3};
        System.err.println(handle(nu));

        nu = new int[]{2, 1, -1};
        System.err.println(handle(nu));
    }


}
