/**
 * @author sk
 * @time 2022/4/13
 **/
public class L108 {

    /**
     * //给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * //
     * // 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [-10,-3,0,5,9]
     * //输出：[0,-3,9,-10,null,5]
     * //解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     * //
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,3]
     * //输出：[3,1]
     * //解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10⁴
     * // -10⁴ <= nums[i] <= 10⁴
     * // nums 按 严格递增 顺序排列
     * //
     * // Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1006 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了45.20% 的Java用户
     *
     * @param nums
     * @return
     */
    public static TreeNode handle(int[] nums) {
        return loop(nums, 0, nums.length);
    }

    public static TreeNode loop(int[] nums, int start, int end) {
        if (start == end && end != nums.length) {
            return new TreeNode(nums[start]);
        } else if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode now = new TreeNode(nums[mid]);
        now.left = loop(nums, start, mid - 1);
        now.right = loop(nums, mid + 1, end);
        return now;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode node = handle(nums);
        System.err.println("===");

        nums = new int[]{1, 3};
        node = handle(nums);
        System.err.println("===");

        nums = new int[]{1};
        node = handle(nums);
        System.err.println("===");
    }

}
