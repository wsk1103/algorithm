import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/8/23
 * @desc say
 **/
public class L114 {

    /*
     * //给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * //
     * //
     * // 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * // 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,2,5,3,4,null,6]
     * //输出：[1,null,2,null,3,null,4,null,5,null,6]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = []
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = [0]
     * //输出：[0]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中结点数在范围 [0, 2000] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * //
     * //
     * // 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     * //
     * // Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1278 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了94.11% 的Java用户
     *
     * @param root
     */
    public static void handle(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        dep(root, list);
        TreeNode node = linkRight(list);
        root.left = null;
        root.right = node.right;
    }

    public static void dep(TreeNode node, LinkedList<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        dep(node.left, list);
        dep(node.right, list);
    }

    public static TreeNode linkRight(LinkedList<TreeNode> list) {
        TreeNode node = list.poll();
        TreeNode temp = node;
        while (!list.isEmpty()) {
            TreeNode tt = list.poll();
            temp.right = tt;
            tt.left = null;
            temp = tt;
        }
        return node;
    }

}
