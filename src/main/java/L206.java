import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sk
 * @time 2021/10/26
 * @desc say
 **/
public class L206 {

    /**
     * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * <p>
     * <p>
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     */

    public static ListNode handle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = stack.pop();
        ListNode t = node;
        while (t != null) {
            if (stack.isEmpty()) {
                t.next = null;
                t = null;
            } else {
                ListNode temp = stack.pop();
                t.next = temp;
                t = temp;
            }
        }
        return node;
    }

    public static ListNode handle2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }
        ListNode node = new ListNode(list.get(0));
        ListNode t = node;
        for (int i = 1; i < list.size(); i++) {
            ListNode n = new ListNode(list.get(i));
            t.next = n;
            t = n;
        }
        ListNode re = handle2(node);
        while (re != null) {
            System.err.print(re.val + ", ");
            re = re.next;
        }
    }

}
