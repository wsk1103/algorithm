import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/26
 * @desc say
 **/
public class L169 {

    /*
     * //给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * //
     * // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [3,2,3]
     * //输出：3
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [2,2,1,1,1,2,2]
     * //输出：2
     * //
     * //
     * //
     * //提示：
     * //
     * //
     * // n == nums.length
     * // 1 <= n <= 5 * 10⁴
     * // -10⁹ <= nums[i] <= 10⁹
     * //
     * //
     * //
     * //
     * // 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     * //
     * // Related Topics 数组 哈希表 分治 计数 排序 👍 1539 👎 0
     */

    /**
     * 执行耗时:11 ms,击败了27.52% 的Java用户
     * 内存消耗:46.4 MB,击败了21.96% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int i = nums[0];
        int limit = nums.length / 2;
        for (int num : nums) {
            int size = map.getOrDefault(num, 0);
            size++;
            if (size > limit) {
                return num;
            }
            if (size > max) {
                i = num;
                max = size;
            }
            map.put(num, size);
        }
        return i;
    }

    /**
     * 执行耗时:2 ms,击败了58.88% 的Java用户
     * 内存消耗:45.1 MB,击败了44.17% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{3, 2, 3};
        System.err.println(handle(n));
        System.err.println(handle2(n));
        n = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.err.println(handle(n));
        System.err.println(handle2(n));
        n = new int[]{2};
        System.err.println(handle(n));
        System.err.println(handle2(n));
        n = new int[]{2, 1};
        System.err.println(handle(n));
        System.err.println(handle2(n));
    }

}
