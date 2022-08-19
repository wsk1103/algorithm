/**
 * @author sk
 * @time 2022/4/11
 **/
public class L101 {

    /*
     * //给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,2,2,3,4,4,3]
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1,2,2,null,3,null,3]
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目在范围 [1, 1000] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * //
     * //
     * // 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1855 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了88.90% 的Java用户
     *
     * @param root
     * @return
     */
    public static boolean handle(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        return next(left, right);
    }

    public static boolean next(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        if (!next(left.left, right.right)) {
            return false;
        }
        return next(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root;
        String s;
        s = "1,2,2,3,4,4,3";
        root = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(root));
        s = "1,2,2,null,3,null,3";
        root = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(root));
    }

}
