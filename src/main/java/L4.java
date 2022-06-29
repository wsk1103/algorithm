import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/6/29
 **/
public class L4 {

    /*
     * //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * //
     * // 算法的时间复杂度应该为 O(log (m+n)) 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums1 = [1,3], nums2 = [2]
     * //输出：2.00000
     * //解释：合并数组 = [1,2,3] ，中位数 2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums1 = [1,2], nums2 = [3,4]
     * //输出：2.50000
     * //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * //
     * //
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // nums1.length == m
     * // nums2.length == n
     * // 0 <= m <= 1000
     * // 0 <= n <= 1000
     * // 1 <= m + n <= 2000
     * // -10⁶ <= nums1[i], nums2[i] <= 10⁶
     * //
     */

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了58.24% 的Java用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double handle(int[] nums1, int[] nums2) {
        System.err.println(JSONUtil.toJsonStr(nums1));
        System.err.println(JSONUtil.toJsonStr(nums2));
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        int mid = sum >> 1;
        int ls1 = 0;
        int ls2 = 0;
        double re = 0;
        int add = 0;
        boolean isB = (sum & 1) == 1;
        if (!isB) {
            mid = mid - 1;
        }
        while (ls1 < l1 && ls2 < l2 && add <= mid) {
            if (nums1[ls1] >= nums2[ls2]) {
                re = nums2[ls2];
                ls2++;
            } else {
                re = nums1[ls1];
                ls1++;
            }
            add++;
        }
        while (ls1 < l1 && add <= mid) {
            re = nums1[ls1];
            ls1++;
            add++;
        }
        while (ls2 < l2 && add <= mid) {
            re = nums2[ls2];
            ls2++;
            add++;
        }
        if (isB) {
            return re;
        } else {
            int next;
            if (ls1 < l1 && ls2 < l2) {
                next = Math.min(nums1[ls1], nums2[ls2]);
            } else if (ls1 >= l1) {
                next = nums2[ls2];
            } else {
                next = nums1[ls1];
            }
            return (re + next) / 2;
        }
    }

    public static void main(String[] args) {
        int[] n1, n2;
        n1 = new int[]{1, 3};
        n2 = new int[]{2};
        System.err.println(handle(n1, n2));
        n1 = new int[]{1, 2};
        n2 = new int[]{3, 4};
        System.err.println(handle(n1, n2));
        n1 = new int[100];
        n2 = new int[100];
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            n1[i] = r.nextInt(10000);
            if ((r.nextInt(10) & 1) == 1) {
                n1[i] = -n1[i];
            }
            n2[i] = r.nextInt(10000);
            if ((r.nextInt(10) & 1) == 1) {
                n2[i] = -n2[i];
            }
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        System.err.println(handle(n1, n2));
    }

}
