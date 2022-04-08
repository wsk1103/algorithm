import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/4/8
 **/
public class L429 {

    /**
     * N 叉树的层序遍历
     * //给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * //
     * // 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入：root = [1,null,3,2,4,null,5,6]
     * //输出：[[1],[3,2,4],[5,6]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
     * //null,13,null,null,14]
     * //输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树的高度不会超过 1000
     * // 树的节点总数在 [0, 10^4] 之间
     * //
     * // Related Topics 树 广度优先搜索 👍 237 👎 0
     * <p>
     * <p>
     * //leetcode submit region begin(Prohibit modification and deletion)
     * /*
     * // Definition for a Node.
     * class Node {
     * public int val;
     * public List<Node> children;
     * <p>
     * public Node() {}
     * <p>
     * public Node(int _val) {
     * val = _val;
     * }
     * <p>
     * public Node(int _val, List<Node> _children) {
     * val = _val;
     * children = _children;
     * }
     * };
     */

    /**
     解答成功:
     执行耗时:2 ms,击败了92.11% 的Java用户
     内存消耗:42.3 MB,击败了44.94% 的Java用户
     * @param root
     * @return
     */
    public static List<List<Integer>> handle(Node root) {
        List<List<Integer>> to = new ArrayList<>();
        if (root == null) {
            return to;
        }
        List<Integer> now = new ArrayList<>();
        now.add(root.val);
        to.add(now);
        List<Node> chi = root.children;
        while (chi != null && !chi.isEmpty()) {
            List<Node> next = new ArrayList<>();
            now = new ArrayList<>(chi.size());
            for (Node n2 : chi) {
                now.add(n2.val);
                if (n2.children != null && !n2.children.isEmpty()) {
                    next.addAll(n2.children);
                }
            }
            to.add(now);
            chi = next;
        }
        return to;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        List<Node> chi1 = new ArrayList<>();
        chi1.add(node1);
        chi1.add(node2);
        chi1.add(node3);
        root.children = chi1;

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> chi2 = new ArrayList<>();
        chi2.add(node5);
        chi2.add(node6);
        node2.children = chi2;

        System.err.println(JSONUtil.toJsonStr(handle(root)));
    }

}
