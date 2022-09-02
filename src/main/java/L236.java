/**
 * @author sk
 * @time 2022/9/2
 * @desc say
 **/
public class L236 {

    /*
     * //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * //
     * // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
     * //一个节点也可以是它自己的祖先）。”
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * //输出：3
     * //解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * //输出：5
     * //解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = [1,2], p = 1, q = 2
     * //输出：1
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目在范围 [2, 10⁵] 内。
     * // -10⁹ <= Node.val <= 10⁹
     * // 所有 Node.val 互不相同 。
     * // p != q
     * // p 和 q 均存在于给定的二叉树中。
     * //
     * //
     * // Related Topics 树 深度优先搜索 二叉树 👍 1935 👎 0
     */

    /**
     * 执行耗时:686 ms,击败了5.08% 的Java用户
     * 内存消耗:43.1 MB,击败了18.40% 的Java用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode handle(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) {
            return root;
        }
        boolean findP = find(root.left, p.val);
        boolean findQ = find(root.left, q.val);
        if ((findP && findQ)) {
            return handle(root.left, p, q);
        } else if (!findP && !findQ) {
            return handle(root.right, p, q);
        } else {
            return root;
        }
    }

    public static boolean find(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        boolean temp = find(node.left, val);
        if (temp) {
            return true;
        } else {
            return find(node.right, val);
        }
    }

    /**
     * 执行耗时:6 ms,击败了100.00% 的Java用户
     * 内存消耗:42.6 MB,击败了71.05% 的Java用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode handle2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) {
            return root;
        }
        TreeNode left = handle2(root.left, p, q);
        TreeNode right = handle2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "3,5,1,6,2,0,8,null,null,7,4";
        node = TreeNodeUtil.toTreeString(s);
//        System.err.println(handle(node, new TreeNode(1), new TreeNode(8)));
//        System.err.println(handle2(node, new TreeNode(5), new TreeNode(4)));
        s = "-1,0,3,-2,4,null,null,8";
        node = TreeNodeUtil.toTreeString(s);
//        System.err.println(handle(node, new TreeNode(1), new TreeNode(8)));
        System.err.println(handle2(node, new TreeNode(3), new TreeNode(8)));
    }

}
