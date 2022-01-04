import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/18
 * @desc say
 **/
public class L10_560 {

    /*
     * //给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,1,1], k = 2
     * //输出：2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,2,3], k = 3
     * //输出：2
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 2 * 10⁴
     * // -1000 <= nums[i] <= 1000
     * // -10⁷ <= k <= 10⁷
     * //
     * // Related Topics 数组 哈希表 前缀和 👍 1138 👎 0
     */

    public static int handle(int[] nums, int k) {
        if (nums.length == 1) {
            if (nums[0] != k) {
                return 0;
            } else {
                return 1;
            }
        }
        int add = 0;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= k) {
                if (sum == k) {
                    add++;
                }
                sum -= nums[left++];
            }
        }
        return add;
    }

    public static int handle2(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            // 查询表中，与当前前缀之差为k的值的个数
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // 再将当前前缀放入表中
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
//        System.err.println(handle2(nums, 2));
//
//        nums = new int[]{1,2,3};
//        System.err.println(handle2(nums, 3));

        nums = new int[]{1};
        System.err.println(handle2(nums, 1));

//        nums = new int[]{-1,-1,1};
//        System.err.println(handle2(nums, 0));
    }

}
