import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L219 {

    /*
     * //给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
     * //- j) <= k 。如果存在，返回 true ；否则，返回 false 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,2,3,1], k = 3
     * //输出：true
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,0,1,1], k = 1
     * //输出：true
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1,2,3,1,2,3], k = 2
     * //输出：false
     * //
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10⁵
     * // -10⁹ <= nums[i] <= 10⁹
     * // 0 <= k <= 10⁵
     * //
     * //
     * // Related Topics 数组 哈希表 滑动窗口 👍 511 👎 0
     */

    /**
     * 执行耗时:19 ms,击败了38.17% 的Java用户
     * 内存消耗:49.6 MB,击败了61.11% 的Java用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean handle(int[] nums, int k) {
        System.err.println(JSONUtil.toJsonStr(nums));
        System.err.println(k);
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        if (len == 1 || k == 0) {
            return false;
        }
        int left = 0;
        int right = 1;
        map.put(nums[left], left);
        while (left < right && left < len && right < len) {
            Integer r = map.get(nums[right]);
            if (r != null) {
                return true;
            }
            if (right - left >= k) {
                map.remove(nums[left]);
                left++;
            }
            map.put(nums[right], right);
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        Random random = new Random();

        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.err.println(handle(nums, k));

        nums = new int[100];
        k = random.nextInt(100) + 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(500) + 1;
        }
        System.err.println(handle(nums, k));
    }

}
