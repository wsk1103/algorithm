/**
 * @author sk
 * @time 2022/4/13
 **/
public class L112 {

    /**
     * //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
     * // targetSum 。如果存在，返回 true ；否则，返回 false 。
     * //
     * // 叶子节点 是指没有子节点的节点。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * //输出：true
     * //解释：等于目标和的根节点到叶节点路径如上图所示。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1,2,3], targetSum = 5
     * //输出：false
     * //解释：树中存在两条根节点到叶子节点的路径：
     * //(1 --> 2): 和为 3
     * //(1 --> 3): 和为 4
     * //不存在 sum = 5 的根节点到叶子节点的路径。
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = [], targetSum = 0
     * //输出：false
     * //解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点的数目在范围 [0, 5000] 内
     * // -1000 <= Node.val <= 1000
     * // -1000 <= targetSum <= 1000
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 853 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了70.67% 的Java用户
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean handle(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return add(root, 0, targetSum);
    }

    public static boolean add(TreeNode node, int sum, int target) {
        if (node.left == null && node.right == null) {
            return node.val + sum == target;
        }
        int add = node.val + sum;
        if (node.left != null) {
            if (add(node.left, add, target)) {
                return true;
            }
        }
        if (node.right != null) {
            if (add(node.right, add, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //1,2,null,3,null,4,null,5
        //6
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(4);
//        TreeNode root5 = new TreeNode(5);
//
        root1.left = root2;
        root1.right = root3;
        System.err.println(handle(root1, 5));
    }

}
