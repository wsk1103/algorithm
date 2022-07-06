/**
 * @author sk
 * @time 2022/7/6
 **/
public class L86 {

    /*
     * //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * //
     * // 你应当 保留 两个分区中每个节点的初始相对位置。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,4,3,2,5,2], x = 3
     * //输出：[1,2,2,4,3,5]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：head = [2,1], x = 2
     * //输出：[1,2]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 链表中节点的数目在范围 [0, 200] 内
     * // -100 <= Node.val <= 100
     * // -200 <= x <= 200
     * //
     * // Related Topics 链表 双指针 👍 584 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了80.53% 的Java用户
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode handle(ListNode head, int x) {
        ListNode one = new ListNode(), tow = new ListNode();
        ListNode oneHead = one;
        ListNode towHead = tow;
        while (head != null) {
            ListNode temp = head.next;

            if (head.val < x) {
                one.next = head;
                one = one.next;
            } else {
                tow.next = head;
                tow = tow.next;
            }
            head.next = null;
            head = temp;
        }
        towHead = towHead.next;
        while (towHead != null) {
            one.next = towHead;
            one = one.next;
            towHead = towHead.next;
        }
        return oneHead.next;
    }

    public static void main(String[] args) {
        String s;
        ListNode node;
        int x;
        s = "[2,6,8,9,4,1]";
        x = 3;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[2,6,8,9,4,1]";
        x = 5;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[1,4,3,2,5,2]";
        x = 3;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[1,4,3,2,5,2]";
        x = 9;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[1,4,3,2,5,2]";
        x = 0;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[1,2]";
        x = 2;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
        s = "[2,1]";
        x = 2;
        node = ListNodeUtil.to(s);
        System.err.println(ListNodeUtil.to(handle(node, x)));
    }

}
