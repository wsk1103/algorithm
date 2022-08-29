/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L226 {

    /*
     * //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入：root = [4,2,7,1,3,6,9]
     * //输出：[4,7,2,9,6,3,1]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入：root = [2,1,3]
     * //输出：[2,3,1]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = []
     * //输出：[]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目范围在 [0, 100] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1391 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了56.28% 的Java用户
     *
     * @param root
     * @return
     */
    public static TreeNode handle(TreeNode root) {
        TreeNode node = root;
        rec(node);
        return root;
    }

    public static void rec(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        rec(left);
        rec(right);
    }

}
