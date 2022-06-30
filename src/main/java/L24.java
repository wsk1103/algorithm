/**
 * @author sk
 * @time 2022/6/30
 **/
public class L24 {

    /*
     * //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,2,3,4]
     * //输出：[2,1,4,3]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：head = []
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：head = [1]
     * //输出：[1]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 链表中节点的数目在范围 [0, 100] 内
     * // 0 <= Node.val <= 100
     * //
     * // Related Topics 递归 链表 👍 1443 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了46.69% 的Java用户
     *
     * @param head
     * @return
     */
    public static ListNode handle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode now = head;
        ListNode to = null;
        ListNode pre = null;
        while (now != null && now.next != null) {
            if (to == null) {
                to = now.next;
            }
            ListNode temp = now;
            ListNode next = now.next;
            ListNode tt = next.next;
            temp.next = tt;
            next.next = temp;
            if (pre != null) {
                pre.next = next;
            }
            pre = now;
            now = tt;
        }
        return to;
    }

    public static void main(String[] args) {
        String n;
        n = "1,2,3,4,5,6";
        ListNode node = ListNodeUtil.to(n);
        System.err.println(ListNodeUtil.to(handle(node)));
        n = "1,2,3,4,5";
        node = ListNodeUtil.to(n);
        System.err.println(ListNodeUtil.to(handle(node)));
        n = "1,2,3";
        node = ListNodeUtil.to(n);
        System.err.println(ListNodeUtil.to(handle(node)));
        n = "";
        node = ListNodeUtil.to(n);
        System.err.println(ListNodeUtil.to(handle(node)));
        n = "1";
        node = ListNodeUtil.to(n);
        System.err.println(ListNodeUtil.to(handle(node)));
    }


}
