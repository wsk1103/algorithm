/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L205 {

    /*
     * //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,2,6,3,4,5,6], val = 6
     * //输出：[1,2,3,4,5]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：head = [], val = 1
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：head = [7,7,7,7], val = 7
     * //输出：[]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 列表中的节点数目在范围 [0, 10⁴] 内
     * // 1 <= Node.val <= 50
     * // 0 <= val <= 50
     * //
     * //
     * // Related Topics 递归 链表 👍 1008 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了50.41% 的Java用户
     * 内存消耗:42.2 MB,击败了59.51% 的Java用户
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode handle(ListNode head, int val) {
        ListNode node = head;
        while (node != null && node.val == val) {
            node = node.next;
        }
        head = node;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }


}
