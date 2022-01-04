/**
 * @author sk
 * @time 2021/10/14
 * @desc say
 **/
public class L8_209 {

    /*
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * <p>
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * <p>
     * 示例 3：
     * <p>
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */

    public static int handle(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums[0] == target) {
            return 1;
        }
        int min = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum >= target) {
                min = 1;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int tempMin = j - i + 1;
                if (min != 0 && tempMin >= min) {
                    break;
                }
                sum = sum + nums[j];
                if (sum >= target) {
                    min = tempMin;
                    break;
                }
            }
        }
        return min;
    }

    //滑块模式
    public static int handle2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums[0] == target) {
            return 1;
        }
        int left = 0, right = 0;

        int min = 0;
        int sum = nums[left];
        while (left <= right && right < nums.length) {
            int tempMin = right - left + 1;
            if (min != 0 && tempMin > min) {
                sum = sum - nums[left];
                left++;
                continue;
            }
            if (left == right) {
                if (nums[left] >= target) {
                    return 1;
                }
            }
            if (sum < target) {
                right++;
                if (right > nums.length - 1) {
                    break;
                }
                sum = sum + nums[right];
            } else if (sum >= target) {
                min = tempMin;
                sum = sum - nums[left];
                left++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nu = new int[]{5,1,3,5,10,7,4,9,2,8};
        System.err.println(handle2(nu, 15));

        nu = new int[]{2, 3, 1, 2, 4, 3};
        System.err.println(handle2(nu, 7));

        nu = new int[]{1, 4, 4};
        System.err.println(handle2(nu, 4));

        nu = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.err.println(handle2(nu, 11));
    }

}
