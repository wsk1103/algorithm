import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/22
 * @desc say
 **/
public class L107 {

    /*
     * //给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [3,9,20,null,null,15,7]
     * //输出：[[15,7],[9,20],[3]]
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
     * //
     * // Related Topics 树 广度优先搜索 二叉树 👍 608 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了91.24% 的Java用户
     * 内存消耗:41.6 MB,击败了40.37% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> handle(TreeNode root) {
        LinkedList<List<Integer>> temp = new LinkedList<>();
        if (root == null) {
            return temp;
        }
        LinkedList<TreeNode> link = new LinkedList<>();
        int next = 1;
        link.add(root);

        while (!link.isEmpty()) {
            int cur = 0;
            List<Integer> now = new ArrayList<>();
            while (next > 0) {
                TreeNode node = link.poll();
                now.add(node.val);
                TreeNode left = node.left;
                if (left != null) {
                    link.add(left);
                    cur++;
                }
                TreeNode right = node.right;
                if (right != null) {
                    link.add(right);
                    cur++;
                }
                next--;
            }
            temp.addFirst(now);
            next = cur;
        }
        return temp;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "3,9,20,null,null,15,7";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
        s = "1,2";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
        s = "1";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
    }

}
