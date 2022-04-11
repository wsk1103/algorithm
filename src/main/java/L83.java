/**
 * @author sk
 * @time 2022/4/11
 **/
public class L83 {

    /**
     * //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,1,2]
     * //输出：[1,2]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：head = [1,1,2,3,3]
     * //输出：[1,2,3]
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
     * // Related Topics 链表 👍 768 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了66.03% 的Java用户
     *
     * @param head
     * @return
     */
    public static ListNode handle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode now = head;
        while (now.next != null) {
            ListNode next = now.next;
            if (next.val == now.val) {
                now.next = next.next;
            } else {
                now = now.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        String node = "1,2,3,3,4,4,5,6";
        ListNode head = ListNodeUtil.to(node);
        System.err.println(ListNodeUtil.to(handle(head)));

        node = "1,1,2,3,3";
        head = ListNodeUtil.to(node);
        System.err.println(ListNodeUtil.to(handle(head)));
        node = "1,1,2";
        head = ListNodeUtil.to(node);
        System.err.println(ListNodeUtil.to(handle(head)));
    }
}
