import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/19
 **/
public class L102 {

    /*
     * //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,9,20,null,null,15,7]
     * //输出：[[3],[9,20],[15,7]]
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
     * // -1000 <= Node.val <= 1000
     * //
     * // Related Topics 树 广度优先搜索 二叉树 👍 1428 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了45.00% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> handle(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int next = 1;
        while (!list.isEmpty()) {
            List<Integer> now = new ArrayList<>();
            int cur = 0;
            while (next > 0) {
                TreeNode temp = list.poll();
                now.add(temp.val);
                TreeNode left = temp.left;
                if (left != null) {
                    cur++;
                    list.offer(left);
                }
                TreeNode right = temp.right;
                if (right != null) {
                    cur++;
                    list.offer(right);
                }
                next--;
            }
            next = cur;
            res.add(now);
        }
        return res;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "3,9,20,null,null,15,7";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
        s = "1";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
    }
}
