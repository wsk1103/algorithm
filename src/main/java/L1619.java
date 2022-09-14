import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/9/14
 * @desc say
 **/
public class L1619 {

    /*
     * //给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
     * //
     * // 与 标准答案 误差在 10⁻⁵ 的结果都被视为正确结果。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
     * //输出：2.00000
     * //解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
     * //输出：4.00000
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0
     * //,6,10,8,2,3,4]
     * //输出：4.77778
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10
     * //,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
     * //输出：5.27778
     * //
     * //
     * // 示例 5：
     * //
     * //
     * //输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,
     * //2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,
     * //5,7,2,10,7,7,8,2,0,1,1]
     * //输出：5.29167
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 20 <= arr.length <= 1000
     * // arr.length 是 20 的 倍数
     * // 0 <= arr[i] <= 10⁵
     * //
     * //
     * // Related Topics 数组 排序 👍 55 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了99.73% 的Java用户
     * 内存消耗:41.1 MB,击败了66.76% 的Java用户
     *
     * @param arr
     * @return
     */
    public static double handle(int[] arr) {
        System.err.println(JSONUtil.toJsonStr(arr));
        int len = arr.length;
        int del = (int) (len * 0.05);
        Arrays.sort(arr);
        for (int i = 0; i < del; i++) {
            arr[i] = 0;
        }
        for (int i = len - 1; i >= len - del; i--) {
            arr[i] = 0;
        }
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum / (len - 2 * del);
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.err.println(handle(nums));
        nums = new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        System.err.println(handle(nums));

        Random random = new Random();
        int size;
        size = random.nextInt(50) + 1;
        size *= 20;
        nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.err.println(handle(nums));
    }

}