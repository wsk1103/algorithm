/**
 * @author sk
 * @time 2022/7/6
 **/
public class L82 {

    /*
     * //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,2,3,3,4,4,5]
     * //输出：[1,2,5]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：head = [1,1,1,2,3]
     * //输出：[2,3]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 链表中节点数目在范围 [0, 300] 内
     * // -100 <= Node.val <= 100
     * // 题目数据保证链表已经按升序 排列
     * //
     * // Related Topics 链表 双指针 👍 933 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了59.91% 的Java用户
     *
     * @param head
     * @return
     */
    public static ListNode handle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode();
        node.next = head;
        ListNode cur = node;

        while (cur.next != null && cur.next.next != null) {
            ListNode pre = cur.next;
            ListNode next = pre.next;
            if (pre.val != next.val) {
                cur = pre;
            } else {
                while (next != null && pre.val == next.val) {
                    next = next.next;
                }
                cur.next = next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        String s;
        s = "[1,1,1,2,3]";
        System.err.println(ListNodeUtil.to(handle(ListNodeUtil.to(s))));
        s = "[1,2,3,3,4,4,5]";
        System.err.println(ListNodeUtil.to(handle(ListNodeUtil.to(s))));
        s = "[1,2,3,3,4,4,5,5]";
        System.err.println(ListNodeUtil.to(handle(ListNodeUtil.to(s))));
    }
}
