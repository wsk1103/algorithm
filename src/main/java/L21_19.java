import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/10/25
 * @desc say
 **/
public class L21_19 {
    /*
     * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * 提示：
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * <p>
     * <p>
     * 进阶：能尝试使用一趟扫描实现吗？
     */


    // 1, 2, 3, 4, 5
    public static ListNode handle(ListNode head, int n) {
        int i = 1;
        ListNode temp = head;
        ListNode pre = head;
        ListNode cur = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (temp != null) {
            if (i > n + 1) {
                pre = pre.next;
            }
            if (i > n) {
                cur = cur.next;
            }
            temp = temp.next;
            i++;
        }
        if (cur == head) {
            head = cur.next;
        } else if (pre != null && cur != null) {
            pre.next = cur.next;
        } else if (pre != null) {
            pre.next = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ListNode head = new ListNode(i);
            list.add(head);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            ListNode head = list.get(i);
            head.next = list.get(i + 1);
        }
        ListNode h = handle(list.get(0), 1);
        while (h != null) {
            System.err.print(h.val + ", ");
            h = h.next;
        }
    }

}
