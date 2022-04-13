/**
 * @author sk
 * @time 2022/4/13
 **/
public class L104 {

    /**
     * //给定一个二叉树，找出其最大深度。
     * //
     * // 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * //
     * // 说明: 叶子节点是指没有子节点的节点。
     * //
     * // 示例：
     * //给定二叉树 [3,9,20,null,null,15,7]，
     * //
     * //     3
     * //   / \
     * //  9  20
     * //    /  \
     * //   15   7
     * //
     * // 返回它的最大深度 3 。
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1194 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了57.53% 的Java用户
     *
     * @param root
     * @return
     */
    public static int handle(TreeNode root) {
        return loop(root, 1, 0);
    }

    public static int loop(TreeNode node, int now, int max) {
        if (node == null) {
            return max;
        }
        if (node.left == null && node.right == null) {
            return Math.max(now, max);
        } else {
            max = Math.max(loop(node.left, now + 1, max), max);
            max = Math.max(loop(node.right, now + 1, max), max);
        }
        return max;
    }

}
