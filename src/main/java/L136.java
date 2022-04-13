/**
 * @author sk
 * @time 2022/4/13
 **/
public class L136 {

    /**
     * //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * //
     * // 说明：
     * //
     * // 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * //
     * // 示例 1:
     * //
     * // 输入: [2,2,1]
     * //输出: 1
     * //
     * //
     * // 示例 2:
     * //
     * // 输入: [4,1,2,1,2]
     * //输出: 4
     * // Related Topics 位运算 数组 👍 2364 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了50.63% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int to = nums[0];
        for (int i = 1; i < nums.length; i++) {
            to = to ^ nums[i];
        }
        return to;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{4, 1, 2, 1, 2};
        System.err.println(handle(nums));
        nums = new int[]{2, 2, 1};
        System.err.println(handle(nums));
    }

}
