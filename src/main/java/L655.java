import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/22
 **/
public class L655 {

    /*
     * //给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
     * //阵需要遵循以下规则：
     * //
     * //
     * // 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
     * // 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
     * // 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
     * // 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在
     * // res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
     * // 继续这一过程，直到树中的所有节点都妥善放置。
     * // 任意空单元格都应该包含空字符串 "" 。
     * //
     * //
     * // 返回构造得到的矩阵 res 。
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：root = [1,2]
     * //输出：
     * //[["","1",""],
     * // ["2","",""]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：root = [1,2,3,null,4]
     * //输出：
     * //[["","","","1","","",""],
     * // ["","2","","","","3",""],
     * // ["","","4","","","",""]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 树中节点数在范围 [1, 2¹⁰] 内
     * // -99 <= Node.val <= 99
     * // 树的深度在范围 [1, 10] 内
     * //
     * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 147 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了12.97% 的Java用户
     * 内存消耗:41.5 MB,击败了79.11% 的Java用户
     *
     * @param root
     * @return
     */
    public static List<List<String>> handle(TreeNode root) {
        List<List<String>> to = new ArrayList<>();
        List<List<String>> nn = he(root);
        int m = nn.size();
        int h = m - 1;
        int n = (int) (Math.pow(2, m) - 1);
        int n0 = (n - 1) / 2;
        LinkedList<Integer> changeSize = new LinkedList<>();
        changeSize.add(n0);
        int cur = 0;
        while (!changeSize.isEmpty() && cur < m) {
            List<String> now = nn.get(cur);
            List<String> toAdd = new ArrayList<>();
            int curS = 0;
            int index = changeSize.poll();
            for (int i = 0; i < n; i++) {
                if (i == index) {
                    String nowS = now.get(curS++);
                    toAdd.add(nowS);
                    if (!"".equals(nowS)) {
                        //设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹]
                        //res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹]
                        int left = index - (int) Math.pow(2, h - cur - 1);
                        int right = index + (int) Math.pow(2, h - cur - 1);
                        changeSize.add(left);
                        changeSize.add(right);
                    }
                    if (curS < now.size()) {
                        index = changeSize.poll();
                    }
                } else {
                    toAdd.add("");
                }
            }
            cur++;
            to.add(toAdd);
        }
        return to;
    }

    public static List<List<String>> he(TreeNode note) {
        List<List<String>> list = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(note);
        int next = 1;
        while (!link.isEmpty()) {
            int cur = 0;
            ArrayList<String> now = new ArrayList<>();
            while (next > 0) {
                TreeNode n = link.poll();
                if (n == null) {
                    now.add("");
                } else {
                    now.add(n.val + "");
                    TreeNode left = n.left;
                    TreeNode right = n.right;
                    cur++;
                    link.add(left);
                    cur++;
                    link.add(right);
                }
                next--;
            }
            next = cur;
            list.add(now);
        }
        list.remove(list.size() - 1);
        return list;
    }

    public static void main(String[] args) {
        String s;
        TreeNode node;
        //[3,null,30,10,null,null,15,null,45]
//        s = "3,null,30,,null,null,10,null,null,15,null,45";
//        node = TreeNodeUtil.toTreeString(s);
        //[["","","","","","","","","","","X","","","","","3 ","","","","","","","","","","","","","","",""],
        // ["","","","","","","","","","","X","","","","","XV","","","","","","","","30","","","","","","",""],
        // ["","","","","","","","","","","X","","","","","XV","","","","10","","","","","","","","","","",""],
        // ["","","","","","","","","","","X","","","","","XV","","","","","","15","","","","","","","","",""],
        // ["","","","","","","","","","","X","","","","","XV","","","","","","","45","","","","","","","",""]]
        TreeNode node3 = new TreeNode(3);
        TreeNode node30 = new TreeNode(30);
        TreeNode node10 = new TreeNode(10);
        TreeNode node15 = new TreeNode(15);
        TreeNode node45 = new TreeNode(45);
        node3.right = node30;
        node30.left = node10;
        node10.right = node15;
        node15.right = node45;
        System.err.println(JSONUtil.toJsonStr(handle(node3)));
        s = "1,2,3,null,4";
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
