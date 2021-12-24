import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sk
 * @time 2021/10/26
 * @desc say
 **/
public class L143 {

    /*
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln-1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     * <p>
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: head = [1,2,3,4]
     * 输出: [1,4,2,3]
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,5,2,4,3]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表的长度范围为 [1, 5 * 104]
     * 1 <= node.val <= 1000
     * 栈 递归 链表 双指针
     */

    public static ListNode handle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Stack<ListNode> temp = rever(head);
        ListNode pop = null;
        ListNode ru = head;
        ListNode cur = null;
        while (ru != pop && ru.next != pop) {
            pop = temp.pop();
            ru = ru.next;
            if (cur == null) {
                cur = head;
            }
            cur.next = pop;
            pop.next = ru;
            cur = ru;
        }
        ru.next = null;
        return head;
    }

    public static Stack<ListNode> rever(ListNode head) {
        Stack<ListNode> node = new Stack<>();
        if (head == null) {
            return node;
        }
        ListNode temp = head;
        while (temp != null) {
            node.push(temp);
            temp = temp.next;
        }
        return node;
    }

    public static ListNode handle2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        ListNode pop;
        ListNode ru = head;
        ListNode cur = null;
        for (int i = 0; i < list.size() / 2; i++) {
            pop = list.get(list.size() - i - 1);
            ru = ru.next;
            if (cur == null) {
                cur = head;
            }
            cur.next = pop;
            pop.next = ru;
            cur = ru;
        }
        ru.next = null;
        return head;
    }

    public static ListNode handle3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode h1 = head;
        ListNode h2 = head;
        while (h2 != null && h2.next != null) {
            h1 = h1.next;
            h2 = h2.next.next;
        }
        h1 = rever2(h1);
        h2 = head;
        while (h1 != null) {
            ListNode t = h2.next;
            ListNode t2 = h1.next;
            h2.next = h1;
            h1.next = t;
            h2 = t;
            h1 = t2;
        }
        if (h2 != null) {
            h2.next = null;
        }
        return head;
    }

    public static ListNode rever2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i + 1);
        }
        ListNode node = new ListNode(list.get(0));
        ListNode t = node;
        for (int i = 1; i < list.size(); i++) {
            ListNode n = new ListNode(list.get(i));
            t.next = n;
            t = n;
        }
        ListNode re = handle3(node);
        while (re != null) {
            System.err.print(re.val + ", ");
            re = re.next;
        }
    }

}
