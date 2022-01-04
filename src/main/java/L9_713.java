/**
 * @author sk
 * @time 2021/10/15
 * @desc say
 **/
public class L9_713 {

    /*
     * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3], k = 0
     * 输出: 0
     */

    public static int handle(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k < 2) {
            return 0;
        }
        int mu = 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            mu *= nums[right++];
            while (mu >= k) {
                mu /= nums[left++];
            }
            sum += (right - left);
        }
        return sum;
    }

    /**
     * 1 2 3 4 5 ,k=24
     * 1
     * 2,12
     * 3,123,23
     * 4,1234,234,34
     */
    public static int handle2(int[] nums, int target) {
        if (target < 2) {
            return 0;
        }
        int left = 0, right = 0, mul = 1, res = 0;
        while (right < nums.length) {
            mul *= nums[right++];
            while (mul >= target) {
                mul /= nums[left++];
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        System.err.println(handle(nums, 100));
        System.err.println(handle2(nums, 100));

        nums = new int[]{1,2, 3};
        System.err.println(handle(nums, 3));
        System.err.println(handle2(nums, 3));
    }

}
