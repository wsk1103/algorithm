import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sk
 * @time 2021/10/27
 * @desc say
 **/
public class L234 {

    /**
     * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
     * <p>
     * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入: head = [1,2,3,3,2,1]
     * 输出: true
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入: head = [1,2]
     * 输出: fasle
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表 L 的长度范围为 [1, 105]
     * 0 <= node.val <= 9
     * <p>
     * <p>
     * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    public static boolean handle(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode t = head;
        ListNode t2 = head;
        while (t2 != null && t2.next != null) {
            t2 = t2.next.next;
            t = t.next;
        }
        t2 = rever2(t);
        while (t2 != null) {
            if (head.val != t2.val) {
                return false;
            }
            t2 = t2.next;
            head = head.next;
        }
        return true;
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

    public static boolean handle2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode l1 = head;
        List<ListNode> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).val != list.get(list.size() - i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            list.add(i + 1);
//        }
        List<Integer> list = Arrays.asList(1,2, 1, 1, 2, 1);
        ListNode node = new ListNode(list.get(0));
        ListNode t = node;
        for (int i = 1; i < list.size(); i++) {
            ListNode n = new ListNode(list.get(i));
            t.next = n;
            t = n;
        }
        System.err.println(handle2(node));
//        ListNode re = handle3(node);
//        while (re != null) {
//            System.err.print(re.val + ", ");
//            re = re.next;
//        }
    }


}
