import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/23
 * @desc say
 **/
public class L113 {

    /*
     * //给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * //
     * // 叶子节点 是指没有子节点的节点。
     * //
     * //
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * //输出：[[5,4,11,2],[5,8,4,5]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1,2,3], targetSum = 5
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = [1,2], targetSum = 0
     * //输出：[]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点总数在范围 [0, 5000] 内
     * // -1000 <= Node.val <= 1000
     * // -1000 <= targetSum <= 1000
     * //
     * //
     * // Related Topics 树 深度优先搜索 回溯 二叉树 👍 821 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:41.6 MB,击败了70.46% 的Java用户
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> handle(TreeNode root, int targetSum) {
        List<List<Integer>> to = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        dep(root, to, temp, 0, targetSum);
        return to;
    }

    public static void dep(TreeNode node, List<List<Integer>> list, LinkedList<Integer> temp, int curSum, int target) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        curSum += node.val;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            if (curSum == target) {
                List<Integer> ll = new ArrayList<>(temp);
                list.add(ll);
            }
        } else {
            if (left != null) {
                dep(left, list, temp, curSum, target);
            }
            if (right != null) {
                dep(right, list, temp, curSum, target);
            }
        }
        curSum -= node.val;
        temp.removeLast();
    }

    public static void main(String[] args) {
        int t;
        String s;
        TreeNode node;
        t = 22;
        s = "5,4,8,11,null,13,4,7,2,null,null,5,1";
        node = TreeNodeUtil.toTreeString(s);
//        System.err.println(JSONUtil.toJsonStr(handle(node, t)));
        t = -5;
        s = "-2,null,-3";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node, t)));
    }

}
