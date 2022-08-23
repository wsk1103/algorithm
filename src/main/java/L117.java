/**
 * @author sk
 * @time 2022/8/23
 * @desc say
 **/
public class L117 {

    /*
     * //给定一个二叉树
     * //
     * //
     * //struct Node {
     * //  int val;
     * //  Node *left;
     * //  Node *right;
     * //  Node *next;
     * //}
     * //
     * // 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * //
     * // 初始状态下，所有 next 指针都被设置为 NULL。
     * //
     * //
     * //
     * // 进阶：
     * //
     * //
     * // 你只能使用常量级额外空间。
     * // 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //
     * //
     * //输入：root = [1,2,3,4,5,null,7]
     * //输出：[1,#,2,3,#,4,5,7,#]
     * //解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
     * //针连接），'#' 表示每层的末尾。
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中的节点数小于 6000
     * // -100 <= node.val <= 100
     * //
     * //
     * //
     * //
     * //
     * //
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 623 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了62.81% 的Java用户
     *
     * @param root
     * @return
     */
    public static Node handle(Node root) {
        if (root == null) {
            return null;
        }
        Node node = root;
        Node pre = null;
        Node first = null;
        while (node != null) {
            Node left = node.left;
            Node right = node.right;
            if (first == null) {
                if (left != null) {
                    first = left;
                } else if (right != null) {
                    first = right;
                }
            }
            if (pre != null) {
                if (left != null) {
                    pre.next = left;
                } else if (right != null) {
                    pre.next = right;
                }
            }
            if (left != null && right != null) {
                left.next = right;
            }
            if (right != null) {
                pre = right;
            } else if (left != null) {
                pre = left;
            }
            if (node.next == null) {
                node = first;
                pre = null;
                first = null;
            } else {
                node = node.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //	测试用例:[1,2,2,3,3,null,null,4,4]
        //	测试结果:[1,#,2,2,#,3,3,#,4,#]
        //	期望结果:[1,#,2,2,#,3,3,#,4,4,#]
    }

}
