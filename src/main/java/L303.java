/**
 * @author sk
 * @time 2022/9/15
 * @desc say
 **/
public class L303 {

    /*
     * //给定一个整数数组 nums，处理以下类型的多个查询:
     * //
     * //
     * // 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     * //
     * //
     * // 实现 NumArray 类：
     * //
     * //
     * // NumArray(int[] nums) 使用数组 nums 初始化对象
     * // int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和
     * //right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：
     * //["NumArray", "sumRange", "sumRange", "sumRange"]
     * //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * //输出：
     * //[null, 1, -1, -3]
     * //
     * //解释：
     * //NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * //numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     * //numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     * //numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10⁴
     * // -10⁵ <= nums[i] <= 10⁵
     * // 0 <= i <= j < nums.length
     * // 最多调用 10⁴ 次 sumRange 方法
     * //
     * //
     * // Related Topics 设计 数组 前缀和 👍 502 👎 0
     */

    /**
     * 执行耗时:7 ms,击败了100.00% 的Java用户
     * 内存消耗:44.1 MB,击败了72.36% 的Java用户
     */
    static class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            int add = 0;
            for (int i = 0; i < nums.length; i++) {
                add += nums[i];
                sum[i] = add;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sum[right];
            }
            return sum[right] - sum[left - 1];
        }
    }

}
