import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/9
 **/
public class L99 {

    /*
     * //给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,3,null,null,2]
     * //输出：[3,1,null,null,2]
     * //解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [3,1,4,null,null,2]
     * //输出：[2,1,4,null,null,3]
     * //解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树上节点的数目在范围 [2, 1000] 内
     * // -2³¹ <= Node.val <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
     * // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 761 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:2 ms,击败了40.71% 的Java用户
     * 内存消耗:41.6 MB,击败了40.35% 的Java用户
     *
     * @param root
     */
    public static void handle(TreeNode root) {
        System.err.println(TreeNodeUtil.toTreeString(root));
        List<TreeNode> list = new ArrayList<>();
        mid(root, list);
        int[] ii = find(list);
        TreeNode one = list.get(ii[0]);
        TreeNode tow = list.get(ii[1]);
        int temp = one.val;
        one.val = tow.val;
        tow.val = temp;
        System.err.println(TreeNodeUtil.toTreeString(root));
    }

    private static void mid(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        mid(node.left, list);
        list.add(node);
        mid(node.right, list);
    }

    // 1 2 3 4 5 6
    // 1 2 6 4 5 3
    // 1 3 2 4
    private static int[] find(List<TreeNode> nodes) {
        int[] res = new int[2];

        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode cur = nodes.get(i);
            TreeNode next = nodes.get(i + 1);
            if (cur.val > next.val) {
                res[0] = i;
                i = i + 1;
                while (i < nodes.size() - 1) {
                    cur = nodes.get(i);
                    next = nodes.get(i + 1);
                    if (cur.val > next.val) {
                        res[1] = i + 1;
                        return res;
                    }
                    i++;
                }
                res[1] = res[0] + 1;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s;
        s = "1,3,null,null,2";
        handle(TreeNodeUtil.toTreeString(s));
        s = "3,1,4,null,null,2";
        handle(TreeNodeUtil.toTreeString(s));
    }

}
