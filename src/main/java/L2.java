import java.util.Random;

/**
 * @author sk
 * @time 2022/4/1
 **/
public class L2 {

    /*
     * //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * //
     * // 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * //
     * // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：l1 = [2,4,3], l2 = [5,6,4]
     * //输出：[7,0,8]
     * //解释：342 + 465 = 807.
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：l1 = [0], l2 = [0]
     * //输出：[0]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * //输出：[8,9,9,9,0,0,0,1]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 每个链表中的节点数在范围 [1, 100] 内
     * // 0 <= Node.val <= 9
     * // 题目数据保证列表表示的数字不含前导零
     * //
     * // Related Topics 递归 链表 数学 👍 7802 👎 0
     */

    public static ListNode handle(ListNode l1, ListNode l2) {
        boolean isAdd = false;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode list = new ListNode();
        ListNode temp = list;
        boolean isFirst = true;
        while (t1 != null && t2 != null) {
            int a = t1.val;
            int b = t2.val;
            int sum = a + b + (isAdd ? 1 : 0);
            isAdd = sum / 10 != 0;
            t1 = t1.next;
            t2 = t2.next;
            if (isFirst) {
                list.val = sum % 10;
                isFirst = false;
            } else {
                ListNode te = new ListNode();
                te.val = sum % 10;
                temp.next = te;
                temp = te;
            }
        }
        while (t1 != null) {
            int sum = t1.val + (isAdd ? 1 : 0);
            isAdd = sum / 10 != 0;
            t1 = t1.next;
            ListNode te = new ListNode();
            te.val = sum % 10;
            temp.next = te;
            temp = te;
        }
        while (t2 != null) {
            int sum = t2.val + (isAdd ? 1 : 0);
            isAdd = sum / 10 != 0;
            t2 = t2.next;
            ListNode te = new ListNode();
            te.val = sum % 10;
            temp.next = te;
            temp = te;
        }
        if (isAdd) {
            ListNode te = new ListNode();
            te.val = 1;
            temp.next = te;
        }
        return list;
    }

    public static void main(String[] args) {
        String l1;
        String l2;
        l1 = "2,4,3";
        l2 = "5,6,4";
        ListNode node1 = ListNodeUtil.to(l1);
        ListNode node2 = ListNodeUtil.to(l2);
        System.err.println(ListNodeUtil.to(handle(node1, node2)));

        Random r = new Random();
        int i = r.nextInt(10) + 1;
        int j = r.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < i; k++) {
            sb.append(r.nextInt(10)).append(",");
        }
        l1 = sb.toString();
        sb = new StringBuilder();
        for (int k = 0; k < j; k++) {
            sb.append(r.nextInt(10)).append(",");
        }
        l2 = sb.toString();
        node1 = ListNodeUtil.to(l1);
        node2 = ListNodeUtil.to(l2);
        System.err.println(ListNodeUtil.to(handle(node1, node2)));
    }

}
