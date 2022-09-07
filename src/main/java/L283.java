import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/9/7
 * @desc say
 **/
public class L283 {

    /*
     * //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * //
     * // 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: nums = [0,1,0,3,12]
     * //输出: [1,3,12,0,0]
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: nums = [0]
     * //输出: [0]
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * //
     * // 1 <= nums.length <= 10⁴
     * // -2³¹ <= nums[i] <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：你能尽量减少完成的操作次数吗？
     * //
     * // Related Topics 数组 双指针 👍 1729 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了35.89% 的Java用户
     * 内存消耗:43 MB,击败了31.80% 的Java用户
     *
     * @param nums
     */
    public static void handle(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = 1;
        while (start < len && end < len) {
            if (nums[start] == 0) {
                while (nums[end] == 0) {
                    end++;
                    if (end >= len) {
                        return;
                    }
                }
                swap(nums, start, end);
            }
            end++;
            start++;
        }
    }

    private static void swap(int[] n, int a, int b) {
        int tmp = n[a];
        n[a] = n[b];
        n[b] = tmp;
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{0, 1, 0, 3, 12};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
    }

}
