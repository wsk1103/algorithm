import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/9/5
 * @desc say
 **/
public class L257 {

    /*
     * //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * //
     * // 叶子节点 是指没有子节点的节点。
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,2,3,null,5]
     * //输出：["1->2->5","1->3"]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1]
     * //输出：["1"]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点的数目在范围 [1, 100] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * // Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 809 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:41.3 MB,击败了94.49% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<String> handle(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<String> res = new ArrayList<>();
        loop(root, list, res);
        return res;
    }

    public static void loop(TreeNode node, LinkedList<TreeNode> list, List<String> res) {
        if (node == null) {
            return;
        }
        list.addLast(node);
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode s : list) {
                sb.append(s.val).append("->");
            }
            res.add(sb.delete(sb.length() - 2, sb.length()).toString());
        } else {
            loop(node.left, list, res);
            loop(node.right, list, res);
        }
        list.removeLast();
    }

}
