/**
 * @author sk
 * @time 2022/8/22
 * @desc say
 **/
public class L111 {

    /*
     * //给定一个二叉树，找出其最小深度。
     * //
     * // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * //
     * // 说明：叶子节点是指没有子节点的节点。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,9,20,null,null,15,7]
     * //输出：2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [2,null,3,null,4,null,5,null,6]
     * //输出：5
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数的范围在 [0, 10⁵] 内
     * // -1000 <= Node.val <= 1000
     * //
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 822 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了89.56% 的Java用户
     * 内存消耗:60.3 MB,击败了89.85% 的Java用户
     */
    static int min = Integer.MAX_VALUE;

    public static int handle(TreeNode root) {
        if (root == null) {
            return 0;
        }
        min = Integer.MAX_VALUE;
        dep(root, 0);
        return min;
    }

    public static void dep(TreeNode node, int dep) {
        if (node == null) {
            return;
        }
        if (dep > min) {
            return;
        }
        dep++;
        if (node.left == null && node.right == null) {
            if (dep < min) {
                min = dep;
            }
        } else {
            dep(node.left, dep);
            dep(node.right, dep);
//            min = Math.min(l, r);
        }
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "3,9,20,null,null,15,7";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        s = "2,null,3,null,4,null,5,null,6";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node));
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;
        n5.right = n6;
        System.err.println(handle(n2));
    }

}
