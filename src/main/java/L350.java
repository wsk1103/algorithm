import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/21
 * @desc say
 **/
public class L350 {

    /*
     * //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
     * //次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * //输出：[2,2]
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * //输出：[4,9]
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
     * //
     * //
     * // 进阶：
     * //
     * //
     * // 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * // 如果 nums1 的大小比 nums2 小，哪种方法更优？
     * // 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * //
     * //
     * // Related Topics 数组 哈希表 双指针 二分查找 排序 👍 836 👎 0
     */

    /**
     * 执行耗时:3 ms,击败了39.81% 的Java用户
     * 内存消耗:41.2 MB,击败了96.61% 的Java用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] handle(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int ii = map.getOrDefault(i, 0);
            map.put(i, ++ii);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            int ii = map.getOrDefault(i, 0);
            if (ii > 0) {
                list.add(i);
            }
            map.put(i, --ii);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
