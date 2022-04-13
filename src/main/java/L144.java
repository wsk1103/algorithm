import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/4/13
 **/
public class L144 {

    /**
     * //给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,null,2,3]
     * //输出：[1,2,3]
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
     * //输入：root = [1]
     * //输出：[1]
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：root = [1,2]
     * //输出：[1,2]
     * //
     * //
     * // 示例 5：
     * //
     * //
     * //输入：root = [1,null,2]
     * //输出：[1,2]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目在范围 [0, 100] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * //
     * //
     * // 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * // Related Topics 栈 树 深度优先搜索 二叉树 👍 794 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了28.35% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<Integer> handle(TreeNode root) {
        List<Integer> to = new ArrayList<>();
        add(to, root);
        return to;
    }

    public static void add(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        add(list, node.left);
        add(list, node.right);
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了55.10% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<Integer> handle2(TreeNode root) {
        List<Integer> to = new ArrayList<>();
        if (root == null) {
            return to;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pop();
            to.add(temp.val);
            if (temp.right != null) {
                deque.push(temp.right);
            }
            if (temp.left != null) {
                deque.push(temp.left);
            }
        }
        return to;
    }

}
