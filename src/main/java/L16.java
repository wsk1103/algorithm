import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/6/30
 **/
public class L16 {

    /*
     * //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * //
     * // 返回这三个数的和。
     * //
     * // 假定每组输入只存在恰好一个解。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [-1,2,1,-4], target = 1
     * //输出：2
     * //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [0,0,0], target = 1
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 3 <= nums.length <= 1000
     * // -1000 <= nums[i] <= 1000
     * // -10⁴ <= target <= 10⁴
     * //
     * // Related Topics 数组 双指针 排序 👍 1180 👎 0
     */

    /**
     * 执行耗时:65 ms,击败了21.24% 的Java用户
     * 内存消耗:41.3 MB,击败了16.34% 的Java用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int handle(int[] nums, int target) {
        System.err.println(JSONUtil.toJsonStr(nums));
        System.err.println(target);
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int reAbs = Integer.MAX_VALUE;
        int re = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            //int min = Integer.MAX_VALUE;
            while (begin < end) {
                int two = nums[begin];
                int three = nums[end];
                int sum = one + two + three;
                if (sum == target) {
                    return target;
                }
                int sub = sum - target;
                int abs = Math.abs(sub);
                if (abs < reAbs) {
                    reAbs = abs;
                    re = sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    begin++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums;
        int target;
        nums = new int[]{-1, 2, 1, -4};
        target = 1;
        System.err.println(handle(nums, target));
        nums = new int[]{0, 0, 0};
        target = 2;
        System.err.println(handle(nums, target));
        Random random = new Random();
        nums = new int[100];
        target = random.nextInt(300);
        for (int i = 0; i < 100; i++) {
            nums[i] = random.nextInt(1000);
            if (random.nextInt(2) == 1) {
                nums[i] = -nums[i];
            }
        }
        System.err.println(handle(nums, target));
    }

}
