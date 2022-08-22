/**
 * @author sk
 * @time 2022/8/22
 * @desc say
 **/
public class L110 {

    /*
     * //给定一个二叉树，判断它是否是高度平衡的二叉树。
     * //
     * // 本题中，一棵高度平衡二叉树定义为：
     * //
     * //
     * // 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,9,20,null,null,15,7]
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1,2,2,3,3,null,null,4,4]
     * //输出：false
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = []
     * //输出：true
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中的节点数在范围 [0, 5000] 内
     * // -10⁴ <= Node.val <= 10⁴
     * //
     * //
     * // Related Topics 树 深度优先搜索 二叉树 👍 1118 👎 0
     */

    public static boolean handle(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = add(root.left);
        int r = add(root.right);
        boolean isL = handle(root.left);
        boolean isR = handle(root.right);
        return Math.abs(l - r) < 1 && isL && isR;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了76.96% 的Java用户
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = height(root.left);
        if (-1 == left) {
            return -1;
        }
        int right = height(root.right);
        if (-1 == right) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static int add(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = add(node.left);
        int r = add(node.right);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "1,2,5,3,null,null,6,4,null,null,7";
        //[1,2,2,3,null,null,3,4,null,null,4]
//        node = TreeNodeUtil.toTreeString(s);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n5.right = n6;
        n6.left = n4;
        n4.left = n7;
        System.err.println(handle(n1));
        s = "1,2,2,3,3,null,null,4,4";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        System.err.println(isBalanced(node));
        s = "3,9,20,null,null,15,7";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        System.err.println(isBalanced(node));
    }

}
