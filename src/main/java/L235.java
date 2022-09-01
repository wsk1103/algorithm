/**
 * @author sk
 * @time 2022/9/1
 * @desc say
 **/
public class L235 {

    /*
     * //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * //
     * // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
     * //一个节点也可以是它自己的祖先）。”
     * //
     * // 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
     * //
     * //
     * //
     * //
     * //
     * // 示例 1:
     * //
     * // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * //输出: 6
     * //解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * //
     * //
     * // 示例 2:
     * //
     * // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * //输出: 2
     * //解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     * //
     * //
     * //
     * // 说明:
     * //
     * //
     * // 所有节点的值都是唯一的。
     * // p、q 为不同节点且均存在于给定的二叉搜索树中。
     * //
     * //
     * // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 916 👎 0
     */

    /**
     * 执行耗时:5 ms,击败了99.97% 的Java用户
     * 内存消耗:41.9 MB,击败了93.81% 的Java用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode handle(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val == root.val || q.val == root.val) {
            //有一个值相等，返回相等的值
            return root;
        }
        if ((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) {
            //两个值分部在root左右，返回root
            return root;
        } else if (p.val < root.val) {
            return handle(root.left, p, q);
        } else {
            return handle(root.right, p, q);
        }
    }


}
