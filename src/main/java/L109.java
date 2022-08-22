/**
 * @author sk
 * @time 2022/8/22
 * @desc say
 **/
public class L109 {

    /*
     * //给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
     * //
     * // 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //
     * //
     * //输入: head = [-10,-3,0,5,9]
     * //输出: [0,-3,9,-10,null,5]
     * //解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: head = []
     * //输出: []
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // head 中的节点数在[0, 2 * 10⁴] 范围内
     * // -10⁵ <= Node.val <= 10⁵
     * //
     * //
     * // Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 746 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.4 MB,击败了74.92% 的Java用户
     *
     * @param head
     * @return
     */
    public static TreeNode handle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        if (pre == null) {
            fast = slow.next;
            slow.next = null;
            slow = null;
        } else {
            pre.next = null;
            fast = slow.next;
            slow.next = null;
            slow = head;
        }
        TreeNode root = new TreeNode();
        root.val = mid.val;
        TreeNode left = handle(slow);
        if (left != null) {
            root.left = left;
        }
        TreeNode ri = handle(fast);
        if (ri != null) {
            root.right = ri;
        }
        return root;
    }

    public static void main(String[] args) {
        String s;
        s = "-10,-3,0,5,9";
        ListNode list = ListNodeUtil.to(s);
        System.err.println(handle(list));
    }

}
