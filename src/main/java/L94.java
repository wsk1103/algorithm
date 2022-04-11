import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/4/11
 **/
public class L94 {

    /**
     * //给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,null,2,3]
     * //输出：[1,3,2]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = []
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：root = [1]
     * //输出：[1]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数目在范围 [0, 100] 内
     * // -100 <= Node.val <= 100
     * //
     * //
     * //
     * //
     * // 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * // Related Topics 栈 树 深度优先搜索 二叉树 👍 1375 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了82.63% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<Integer> handle(TreeNode root) {
        List<Integer> to = new ArrayList<>();
        add(to, root);
        return to;
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了75.87% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<Integer> handle2(TreeNode root) {
        List<Integer> to = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            to.add(root.val);
            root = root.right;
        }
        return to;
    }

    public static void add(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        add(list, root.left);
        list.add(root.val);
        add(list, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        System.err.println(JSONUtil.toJsonStr(handle(root)));
        System.err.println(JSONUtil.toJsonStr(handle2(root)));
    }

}
