import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/9/1
 * @desc say
 **/
public class L230 {

    /*
     * //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,1,4,null,2], k = 1
     * //输出：1
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [5,3,6,2,4,null,null,1], k = 3
     * //输出：3
     * //
     * //
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中的节点数为 n 。
     * // 1 <= k <= n <= 10⁴
     * // 0 <= Node.val <= 10⁴
     * //
     * //
     * //
     * //
     * // 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
     * //
     * // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 660 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了78.42% 的Java用户
     *
     * @param root
     * @param k
     * @return
     */
    public static int handle(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        deep(root, k, list);
        return list.get(k - 1).val;
    }

    public static void deep(TreeNode node, int k, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        deep(left, k, list);
        if (list.size() == k) {
            return;
        }
        list.add(node);
        TreeNode right = node.right;
        deep(right, k, list);
    }

    public static void main(String[] args) {
        String s;
        int k;
        TreeNode node;
        s = "3,1,4,null,2";
        k = 1;
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(handle(node, k));
    }

}
