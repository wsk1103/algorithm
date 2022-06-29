import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/6/28
 **/
public class L31 {

    /*
     * //整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
     * //
     * //
     * // 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * //
     * //
     * // 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
     * //是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * //
     * //
     * // 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * // 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * // 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * //
     * //
     * // 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * //
     * // 必须 原地 修改，只允许使用额外常数空间。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,2,3]
     * //输出：[1,3,2]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [3,2,1]
     * //输出：[1,2,3]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1,1,5]
     * //输出：[1,5,1]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 100
     * // 0 <= nums[i] <= 100
     * //
     * // Related Topics 数组 双指针 👍 1769 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了34.17% 的Java用户
     * 内存消耗:41.6 MB,击败了55.69% 的Java用户
     *
     * @param nums
     */
    public static void handle(int[] nums) {
        System.out.println(JSONUtil.toJsonStr(nums));
        int len = nums.length;
        if (len <= 0) {
            return;
        }
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        System.err.println(JSONUtil.toJsonStr(nums));
                        return;
                    }
                }
            }

        }
        Arrays.sort(nums);
        System.err.println(JSONUtil.toJsonStr(nums));
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{1, 47, 42, 75, 76, 96, 77, 14, 38, 24, 50, 42, 69, 36, 70, 44, 67, 44, 89, 80, 53, 36, 35, 75, 54, 72, 34, 50, 61, 60, 12, 41, 89, 82, 30, 38, 61, 20, 51, 52, 57, 65, 63, 54, 48, 27, 12, 57, 87, 35};
        handle(n);
        n = new int[]{1, 2, 3};
        handle(n);
        n = new int[]{1, 3, 2};
        handle(n);
        n = new int[]{3, 2, 1};
        handle(n);
        n = new int[]{1, 1, 5};
        handle(n);
        n = new int[]{1, 1, 5, 4};
        handle(n);
        n = new int[]{1, 7, 5, 6};
        handle(n);
        n = new int[]{1, 1};
        handle(n);
        n = new int[]{1, 2};
        handle(n);
        n = new int[]{12, 2};
        handle(n);
        n = new int[50];
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            n[i] = r.nextInt(99) + 1;
        }
        handle(n);

    }

}
