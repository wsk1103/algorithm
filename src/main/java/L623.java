import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/8/5
 **/
public class L623 {

    /*
     * //给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
     * //
     * // 注意，根节点 root 位于深度 1 。
     * //
     * // 加法规则如下:
     * //
     * //
     * // 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
     * // cur 原来的左子树应该是新的左子树根的左子树。
     * // cur 原来的右子树应该是新的右子树根的右子树。
     * // 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
     * //
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //
     * //
     * //输入: root = [4,2,6,3,1,5], val = 1, depth = 2
     * //输出: [4,1,1,2,null,null,6,3,1,5]
     * //   4
     *  2       6
     * 3 1     5
     *          4
     *      1       1
     *  2               6
     * 3 1             5
     * // 示例 2:
     * //
     * //
     * //
     * //
     * //输入: root = [4,2,null,3,1], val = 1, depth = 3
     * //输出:  [4,2,null,1,1,3,null,null,1]
     * //       4
     *      2
     *     3  1
     *
     *          4
     *      2
     *     1    1
     * 3            1
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 节点数在 [1, 10⁴] 范围内
     * // 树的深度在 [1, 10⁴]范围内
     * // -100 <= Node.val <= 100
     * // -10⁵ <= val <= 10⁵
     * // 1 <= depth <= the depth of tree + 1
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 154 👎 0
     */

    /**
     * 解答成功:
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了52.64% 的Java用户
     *
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public static TreeNode handle(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        int now = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        int addSize = 1;
        list.add(root);
        while (!list.isEmpty()) {
            int curSize = addSize;
            int nextSize = 0;
            now++;
            if (now == depth) {
                while (!list.isEmpty()) {
                    TreeNode temp = list.poll();
                    TreeNode nextLeft = new TreeNode(val);
                    TreeNode nextRight = new TreeNode(val);
                    TreeNode left = temp.left;
                    TreeNode right = temp.right;
                    temp.left = nextLeft;
                    temp.right = nextRight;
                    nextLeft.left = left;
                    nextRight.right = right;
                }
                return root;
            } else {
                while (curSize > 0 && !list.isEmpty()) {
                    TreeNode temp = list.poll();
                    TreeNode left = temp.left;
                    if (left != null) {
                        nextSize++;
                        list.offer(left);
                    }
                    TreeNode right = temp.right;
                    if (right != null) {
                        nextSize++;
                        list.offer(right);
                    }
                    curSize--;
                }
                addSize = nextSize;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        System.err.println(handle(root1, 5, 4));

    }
}
