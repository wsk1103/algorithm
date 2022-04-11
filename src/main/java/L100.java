/**
 * @author sk
 * @time 2022/4/11
 **/
public class L100 {

    /**
     * //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * //
     * // 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：p = [1,2,3], q = [1,2,3]
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：p = [1,2], q = [1,null,2]
     * //输出：false
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：p = [1,2,1], q = [1,1,2]
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 两棵树上的节点数目都在范围 [0, 100] 内
     * // -10⁴ <= Node.val <= 10⁴
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 806 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了54.96% 的Java用户
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean handle(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        boolean b = check(p.left, q.left);
        if (!b) {
            return false;
        }
        return check(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p, q;
        p = new TreeNode(1);
        q = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode q2 = new TreeNode(3);

        p.left = p1;
        q.left = q1;

        p.right = p2;
        q.right = q2;

        System.err.println(check(p, q));

        p = new TreeNode(1);
        q = new TreeNode(1);
        p1 = new TreeNode(2);
        q1 = new TreeNode(2);
        p2 = new TreeNode(3);
        q2 = new TreeNode(3);

        p.left = p1;
        q.left = q1;

        p.right = p2;
        q.right = null;

        System.err.println(check(p, q));
    }

}
