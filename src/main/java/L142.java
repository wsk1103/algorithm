/**
 * @author sk
 * @time 2021/10/25
 * @desc say
 **/
public class L142 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * <p>
     * 说明：不允许修改给定的链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     * <p>
     * <p>
     * 进阶：是否可以使用 O(1) 空间解决此题？
     * 如果链表存在环，则fast和slow会在环内相遇，定义相遇点到入口点的距离为X,定义环的长度为C,定义头到入口的距离为L,fast在slow进入环之后一圈内追上slow,则会得知：
     * slow所走的步数为:L + X
     * fast所走的步数为：L + X + N * C
     * 并且fast所走的步数为slow的两倍，故：
     * 2*(L + X) = L + X + N * C
     * 即： L = N * C - X
     * 所以从相遇点开始slow继续走，让一个指针从头开始走，相遇点即为入口节点
     */

    public static ListNode handle(ListNode head) {

        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;

            f = f.next.next;
            if (s == f) {
                ListNode meet = s;
                ListNode start = head;
                while (meet != start) {
                    meet = meet.next;
                    start = start.next;
                }
                return meet;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.err.println(handle(l1));
    }



}
