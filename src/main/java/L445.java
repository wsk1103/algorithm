import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author sk
 * @time 2021/10/26
 * @desc say
 **/
public class L445 {

    /**
     * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * <p>
     * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * <p>
     * <p>
     * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
     * 输出：[7,8,0,7]
     * 示例2：
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[8,0,7]
     * 示例3：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表的长度范围为 [1, 100]
     * 0 <= node.val <= 9
     * 输入数据保证链表代表的数字无前导 0
     * <p>
     * <p>
     * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
     */

    public static ListNode handle(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode to1 = rever2(l1);
        ListNode to2 = rever2(l2);
        ListNode re = null;
        ListNode temp = re;
        boolean add = false;
        while (to1 != null && to2 != null) {
            int v = to1.val + to2.val;
            if (add) {
                v = v + 1;
            }
            add = v / 10 > 0;
            v = v % 10;
            if (temp == null) {
                temp = new ListNode(v);
                re = temp;
            } else {
                ListNode ne = new ListNode(v);
                temp.next = ne;
                temp = ne;
            }
            to1 = to1.next;
            to2 = to2.next;
        }
        while (to1 != null) {
            int v = to1.val;
            if (add) {
                v = v + 1;
            }
            add = (v / 10 > 0);
            v = v % 10;
            if (temp == null) {
                temp = new ListNode(v);
                re = temp;
            } else {
                ListNode ne = new ListNode(v);
                temp.next = ne;
                temp = ne;
            }
            to1 = to1.next;
        }
        while (to2 != null) {
            int v = to2.val;
            if (add) {
                v = v + 1;
            }
            add = (v / 10 > 0);
            v = v % 10;
            if (temp == null) {
                temp = new ListNode(v);
                re = temp;
            } else {
                ListNode ne = new ListNode(v);
                temp.next = ne;
                temp = ne;
            }
            to2 = to2.next;
        }
        if (add) {
            temp.next = new ListNode(1);
        }
        return rever2(re);
    }

    public static ListNode rever2(ListNode head) {
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

    public static ListNode handle2(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = rever(l1);
        Stack<ListNode> s2 = rever(l2);
        Stack<Integer> re = new Stack<>();
        boolean add = false;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode t1 = s1.pop();
            ListNode t2 = s2.pop();
            int v = t1.val + t2.val;
            if (add) {
                v = v + 1;
            }
            add = v / 10 > 0;
            v = v % 10;
            re.push(v);
        }
        while (!s1.isEmpty()) {
            ListNode t1 = s1.pop();
            int v = t1.val;
            if (add) {
                v = v + 1;
            }
            add = v / 10 > 0;
            v = v % 10;
            re.push(v);
        }
        while (!s2.isEmpty()) {
            ListNode t2 = s2.pop();
            int v = t2.val;
            if (add) {
                v = v + 1;
            }
            add = v / 10 > 0;
            v = v % 10;
            re.push(v);
        }
        if (add) {
            re.push(1);
        }
        if (re.isEmpty()) {
            return null;
        }
        Integer i = re.pop();
        ListNode node = new ListNode(i);
        ListNode temp = node;
        while (!re.isEmpty()) {
            i = re.pop();
            ListNode newN = new ListNode(i);
            temp.next = newN;
            temp = newN;
        }
        return node;
    }

    public static Stack<ListNode> rever(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        return stack;

    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(9,9);
        List<Integer> l2 = Arrays.asList(9, 9);
        ListNode node = new ListNode(l1.get(0));
        ListNode t = node;
        for (int i = 1; i < l1.size(); i++) {
            ListNode n = new ListNode(l1.get(i));
            t.next = n;
            t = n;
        }
        ListNode node2 = new ListNode(l2.get(0));
        ListNode t2 = node2;
        for (int i = 1; i < l2.size(); i++) {
            ListNode n = new ListNode(l2.get(i));
            t2.next = n;
            t2 = n;
        }
        ListNode re = handle2(node, node2);
        while (re != null) {
            System.err.print(re.val + ", ");
            re = re.next;
        }
    }

}
