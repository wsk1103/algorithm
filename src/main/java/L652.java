import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/5
 * @desc say
 **/
public class L652 {

    /*
     * //给定一棵二叉树 root，返回所有重复的子树。
     * //
     * // 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * //
     * // 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入：root = [1,2,3,4,null,2,4,null,null,4]
     * //输出：[[2,4],[4]]
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入：root = [2,1,1]
     * //输出：[[1]]
     * //
     * // 示例 3：
     * //
     * //
     * //
     * //
     * //输入：root = [2,2,2,3,null,3,null]
     * //输出：[[2,3],[3]]
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中的结点数在[1,10^4]范围内。
     * // -200 <= Node.val <= 200
     * //
     * //
     * // Related Topics 树 深度优先搜索 哈希表 二叉树 👍 506 👎 0
     */

    /**
     * 执行耗时:20 ms,击败了80.88% 的Java用户
     * 内存消耗:48.7 MB,击败了39.39% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<TreeNode> handle(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        loop(root, map, list);
        return list;
    }

    public static String loop(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) {
            return "#";
        }
        String left = loop(node.left, map, list);
        String right = loop(node.right, map, list);
        String cur = left + "," + right + "," + node.val;
        int ss = map.getOrDefault(cur, 0);
        if (ss == 1) {
            list.add(node);
        }
        map.put(cur, ss + 1);
        return cur;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        s = "1,2,3,4,null,2,4,null,null,4";
        node = TreeNodeUtil.toTreeString(s);
        System.err.println(JSONUtil.toJsonStr(handle(node)));
    }

}
