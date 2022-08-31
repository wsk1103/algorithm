import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/31
 * @desc say
 **/
public class L229 {

    /*
     * //给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [3,2,3]
     * //输出：[3]
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1]
     * //输出：[1]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1,2]
     * //输出：[1,2]
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 5 * 10⁴
     * // -10⁹ <= nums[i] <= 10⁹
     * //
     * //
     * //
     * //
     * // 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
     * //
     * // Related Topics 数组 哈希表 计数 排序 👍 624 👎 0
     */

    /**
     * 执行耗时:9 ms,击败了45.21% 的Java用户
     * 内存消耗:45.1 MB,击败了54.34% 的Java用户
     *
     * @param nums
     * @return
     */
    public static List<Integer> handle(int[] nums) {
        int len = nums.length;
        int n = len / 3;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int size = map.getOrDefault(num, 0);
            if (size == -1) {
                continue;
            }
            size++;
            if (size > n) {
                list.add(num);
                map.put(num, -1);
            } else {
                map.put(num, size);
            }
        }
        return list;
    }

}
