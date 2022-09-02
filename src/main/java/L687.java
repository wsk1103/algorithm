/**
 * @author sk
 * @time 2022/9/2
 * @desc say
 **/
public class L687 {

    /*
     * //给定一个二叉树的
     * // root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
     * //
     * // 两个节点之间的路径长度 由它们之间的边数表示。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //
     * //
     * //输入：root = [5,4,5,1,1,5]
     * //输出：2
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //
     * //
     * //输入：root = [1,4,5,4,4,5]
     * //输出：2
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 树的节点数的范围是
     * // [0, 10⁴]
     * // -1000 <= Node.val <= 1000
     * // 树的深度将不超过 1000
     * //
     * //
     * // Related Topics 树 深度优先搜索 二叉树 👍 630 👎 0
     */

    static int max = 0;

    /**
     * 执行耗时:2 ms,击败了96.54% 的Java用户
     * 内存消耗:44.7 MB,击败了84.35% 的Java用户
     *
     * @param root
     * @return
     */
    public static int handle(TreeNode root) {
        loop(root);
        return max;
    }

    public static int loop(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = loop(node.left);
        int right = loop(node.right);

        int lc = 0, rc = 0;
        if (node.left != null && node.left.val == node.val) {
            lc = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rc = right + 1;
        }
        max = Math.max(max, lc + rc);
        return Math.max(lc, rc);

    }


    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "5,4,5,1,1,null,5";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        s = "5,5,4,5,1,1";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        s = "1,4,5,4,4,5";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
    }

}
