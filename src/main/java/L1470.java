import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L1470 {

    /*
     * //给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * //
     * // 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：nums = [2,5,1,3,4,7], n = 3
     * //输出：[2,3,5,4,1,7]
     * //解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：nums = [1,2,3,4,4,3,2,1], n = 4
     * //输出：[1,4,2,3,3,2,4,1]
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：nums = [1,1,2,2], n = 2
     * //输出：[1,2,1,2]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 500
     * // nums.length == 2n
     * // 1 <= nums[i] <= 10^3
     * //
     * //
     * // Related Topics 数组 👍 111 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了70.72% 的Java用户
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] handle(int[] nums, int n) {
        int len = 2 * n;
        int[] to = new int[len];
        int add = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                to[i] = nums[n++];
            } else {
                to[i] = nums[add++];
            }
        }
        return to;
    }

    public static void main(String[] args) {
        int[] nums;
        int n;
        nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        n = 4;
        System.err.println(JSONUtil.toJsonStr(handle(nums, n)));
        nums = new int[]{2, 5, 1, 3, 4, 7};
        n = 3;
        System.err.println(JSONUtil.toJsonStr(handle(nums, n)));
    }
}
