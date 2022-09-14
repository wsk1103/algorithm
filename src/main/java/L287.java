import java.util.Arrays;

/**
 * @author sk
 * @time 2022/9/14
 * @desc say
 **/
public class L287 {

    /*
     * //给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * //
     * // 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * //
     * // 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,3,4,2,2]
     * //输出：2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [3,1,3,4,2]
     * //输出：3
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 10⁵
     * // nums.length == n + 1
     * // 1 <= nums[i] <= n
     * // nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     * //
     * //
     * //
     * //
     * // 进阶：
     * //
     * //
     * // 如何证明 nums 中至少存在一个重复的数字?
     * // 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
     * //
     * //
     * // Related Topics 位运算 数组 双指针 二分查找 👍 1887 👎 0
     */

    /**
     * time out
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int ci = nums[i];
            if (ci == i + 1) {
                continue;
            }
            int cj = nums[i + 1];
            if (ci == cj) {
                return ci;
            }
            for (int j = i + 1; j < len; j++) {
                cj = nums[j];
                if (cj == i + 1) {
                    swap(nums, i, j);
                    break;
                }
            }

        }
        return nums[len - 1];
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:60.3 MB,击败了5.11% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        int len = nums.length;
        int[] dd = new int[len - 1];
        for (int cur : nums) {
            if (dd[cur - 1] != 0) {
                return cur;
            }
            dd[cur - 1] = 1;
        }
        return nums[len - 1];
    }

    /**
     * 执行耗时:39 ms,击败了5.54% 的Java用户
     * 内存消耗:59.1 MB,击败了13.43% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle3(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[len - 1];
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 3, 4, 2, 2};
        System.err.println(handle(nums));
        nums = new int[]{3, 1, 3, 4, 2};
        System.err.println(handle(nums));
    }


}
