/**
 * @author sk
 * @time 2022/9/27
 * @desc say
 **/
public class L404 {

    /*
     * //给定二叉树的根节点 root ，返回所有左叶子之和。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入: root = [3,9,20,null,null,15,7]
     * //输出: 24
     * //解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: root = [1]
     * //输出: 0
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 节点数在 [1, 1000] 范围内
     * // -1000 <= Node.val <= 1000
     * //
     * //
     * //
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 504 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了95.78% 的Java用户
     */
    static int sum = 0;

    public static int handle(TreeNode root) {
        loop(root, false);
        return sum;
    }

    public static void loop(TreeNode node, boolean isL) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            if (isL) {
                sum += node.val;
            }
        } else {
            loop(left, true);
            loop(right, false);
        }
    }

}
