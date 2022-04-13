import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/4/13
 **/
public class L145 {

    /**
     * //给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,null,2,3]
     * //输出：[3,2,1]
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
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点的数目在范围 [0, 100] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * //
     * //
     * // 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * // Related Topics 栈 树 深度优先搜索 二叉树 👍 811 👎 0
     * <p>
     * <p>
     * //leetcode submit region begin(Prohibit modification and deletion)
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了54.72% 的Java用户
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
        add(list, node.left);
        add(list, node.right);
        list.add(node.val);
    }

    @Deprecated
    public static List<Integer> handle2(TreeNode root) {
        List<Integer> to = new ArrayList<>();
        if (root == null) {
            return to;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root.right);
                to.add(root.val);
                root = root.left;
            }
            root = deque.getFirst();
            deque.pop();
        }
        return to;

    }

}
