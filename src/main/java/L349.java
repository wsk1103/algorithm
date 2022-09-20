import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sk
 * @time 2022/9/20
 * @desc say
 **/
public class L349 {

    /*
     * //给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * //输出：[2]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * //输出：[9,4]
     * //解释：[4,9] 也是可通过的
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums1.length, nums2.length <= 1000
     * // 0 <= nums1[i], nums2[i] <= 1000
     * //
     * //
     * // Related Topics 数组 哈希表 双指针 二分查找 排序 👍 624 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了95.04% 的Java用户
     * 内存消耗:41.5 MB,击败了53.34% 的Java用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] handle(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                ans.add(i);
                set.remove(i);
            }
        }
        int[] ii = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ii[i] = ans.get(i);
        }
        return ii;
    }

}
