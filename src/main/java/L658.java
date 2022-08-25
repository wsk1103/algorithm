import cn.hutool.json.JSONUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author sk
 * @time 2022/8/25
 * @desc say
 **/
public class L658 {

    /*
     * //给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     * //
     * // 整数 a 比整数 b 更接近 x 需要满足：
     * //
     * //
     * // |a - x| < |b - x| 或者
     * // |a - x| == |b - x| 且 a < b
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：arr = [1,2,3,4,5], k = 4, x = 3
     * //输出：[1,2,3,4]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：arr = [1,2,3,4,5], k = 4, x = -1
     * //输出：[1,2,3,4]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= k <= arr.length
     * // 1 <= arr.length <= 10⁴
     * //
     * // arr 按 升序 排列
     * // -10⁴ <= arr[i], x <= 10⁴
     * //
     * //
     * // Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 379 👎 0
     */

    /**
     * 执行耗时:8 ms,击败了41.61% 的Java用户
     * 内存消耗:44.4 MB,击败了5.07% 的Java用户
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> handle(int[] arr, int k, int x) {
        System.err.println(JSONUtil.toJsonStr(arr));
        System.err.println(k);
        System.err.println(x);
        int next = Integer.MAX_VALUE;
        int first = Integer.MIN_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int now = arr[i];
            int abs = Math.abs(now - x);
            if (list.size() < k) {
                if (list.size() == 0) {
                    next = abs;
                    first = abs;
                } else {
                    next = abs;
                }
                list.addLast(now);
            } else {
                if (abs < next) {
                    next = abs;
                    list.addLast(now);
                    list.removeFirst();
                    first = Math.abs(list.getFirst() - x);
                } else if (abs < first) {
                    list.addLast(now);
                    list.removeFirst();
                    first = Math.abs(list.getFirst() - x);
                }
            }

        }
        return list;
    }


    /**
     * 执行耗时:6 ms,击败了47.07% 的Java用户
     * 内存消耗:43.5 MB,击败了38.18% 的Java用户
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> handle2(int[] arr, int k, int x) {
        int sea = search(arr, x);
        LinkedList<Integer> to = new LinkedList<>();
        to.add(arr[sea]);
        k--;
        int left = sea - 1;
        int right = sea + 1;
        while (left >= 0 && right < arr.length) {
            if (k <= 0) {
                return to;
            }
            int leftAbs = Math.abs(arr[left] - x);
            int rightAbs = Math.abs(arr[right] - x);

            if (leftAbs > rightAbs) {
                to.addLast(arr[right]);
                right++;
            } else {
                to.addFirst(arr[left]);
                left--;
            }
            k--;
        }
        while (k > 0 && right < arr.length) {
            to.addLast(arr[right++]);
            k--;
        }
        while (k > 0 && left >= 0) {
            to.addFirst(arr[left--]);
            k--;
        }

        return to;
    }

    public static int search(int[] arr, int x) {
        int sea = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid] == x) {
                return mid;
            }
            int abs = Math.abs(arr[mid] - x);
            if (abs <= sea) {
                if (abs == sea) {
                    index = Math.min(index, mid);
                } else {
                    index = mid;
                }
                sea = abs;
            }
            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr;
        int k, x;
        arr = new int[]{3, 5, 8, 10};
        k = 2;
        x = 15;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        arr = new int[]{1, 2};
        k = 1;
        x = 1;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        k = 3;
        x = 5;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        arr = new int[]{1, 2, 5, 6, 7};
        k = 2;
        x = 4;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        arr = new int[]{1, 2, 4, 5, 6};
        k = 2;
        x = 3;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        arr = new int[]{1, 2, 3, 4, 5};
        k = 4;
        x = 4;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
        Random r = new Random();
        arr = new int[1000];
        arr[0] = 1;
        for (int i = 1; i < 1000; i++) {
            arr[i] = arr[i - 1] + r.nextInt(20);
        }

        k = r.nextInt(100) + 1;
        x = r.nextInt(1000) + 1;
        System.err.println(JSONUtil.toJsonStr(handle(arr, k, x)));
        System.err.println(JSONUtil.toJsonStr(handle2(arr, k, x)));
    }
}
