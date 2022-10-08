import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sk
 * @time 2022/10/8
 * @desc say
 **/
public class L870 {

    /*
     * //给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
     * //目来描述。
     * //
     * // 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
     * //输出：[2,11,7,15]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
     * //输出：[24,32,8,12]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums1.length <= 10⁵
     * // nums2.length == nums1.length
     * // 0 <= nums1[i], nums2[i] <= 10⁹
     * //
     * //
     * // Related Topics 贪心 数组 双指针 排序 👍 233 👎 0
     */

    /**
     * 执行耗时:77 ms,击败了22.59% 的Java用户
     * 内存消耗:58.1 MB,击败了82.16% 的Java用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] handle(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] ans = new int[len];
        Arrays.sort(nums1);
        PriorityQueue<P> queue = new PriorityQueue<>((a, b) -> (b.num - a.num));
        for (int i = 0; i < len; i++) {
            queue.offer(new P(nums2[i], i));
        }
        int l = 0, r = len - 1;
        while (!queue.isEmpty()) {
            P pair = queue.poll();
            int i = pair.index, temp = pair.num;
            if (nums1[r] <= temp) {
                ans[i] = nums1[l];
                l++;
            } else {
                ans[i] = nums1[r];
                r--;
            }
        }

        return ans;
    }

    static class P {
        int num;
        int index;

        public P(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }


}
