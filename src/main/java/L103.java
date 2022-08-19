import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/19
 **/
public class L103 {

    /*
     * //给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,9,20,null,null,15,7]
     * //输出：[[3],[20,9],[15,7]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1]
     * //输出：[[1]]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = []
     * //输出：[]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目在范围 [0, 2000] 内
     * // -100 <= Node.val <= 100
     * //
     * // Related Topics 树 广度优先搜索 二叉树 👍 681 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了77.66% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> to = new ArrayList<>();
        if (root == null) {
            return to;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        boolean b = false;
        int next = 1;
        while (!list.isEmpty()) {
            LinkedList<Integer> now = new LinkedList<>();
            int cur = 0;
            while (next > 0) {
                TreeNode node;
                node = list.poll();
                if (b) {
                    now.offerFirst(node.val);
                } else {
                    now.add(node.val);
                }
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    list.offer(left);
                    cur++;
                }
                if (right != null) {
                    list.offer(right);
                    cur++;
                }
                next--;
            }
            b = !b;
            next = cur;
            to.add(now);
        }
        return to;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "3,9,20,1,3,15,7,9,8,6,2,4,8,5,3,1,6";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(zigzagLevelOrder(node)));
    }

}
