/**
 * @author sk
 * @time 2022/4/8
 **/
public class L21 {

    /**
     * //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：l1 = [1,2,4], l2 = [1,3,4]
     * //输出：[1,1,2,3,4,4]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：l1 = [], l2 = []
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：l1 = [], l2 = [0]
     * //输出：[0]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 两个链表的节点数目范围是 [0, 50]
     * // -100 <= Node.val <= 100
     * // l1 和 l2 均按 非递减顺序 排列
     * //
     * // Related Topics 递归 链表 👍 2328 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了46.70% 的Java用户
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode to = new ListNode();
        ListNode temp = new ListNode();
        to.next = temp;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            ListNode node = new ListNode();
            if (v1 > v2) {
                node.val = v2;
                list2 = list2.next;
            } else {
                node.val = v1;
                list1 = list1.next;
            }
            temp.next = node;
            temp = node;
        }
        while (list1 != null) {
            ListNode node = new ListNode();
            node.val = list1.val;
            temp.next = node;
            temp = node;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode node = new ListNode();
            node.val = list2.val;
            temp.next = node;
            temp = node;
            list2 = list2.next;
        }
        return to.next.next;
    }

    public static void main(String[] args) {
        String l1;
        String l2;
        ListNode n1;
        ListNode n2;
        l1 = "1,3,5";
        l2 = "2,4,6,7";
        n1 = ListNodeUtil.to(l1);
        n2 = ListNodeUtil.to(l2);
        System.err.println(ListNodeUtil.to(mergeTwoLists(n1, n2)));
        l1 = "1";
        l2 = "2";
        n1 = ListNodeUtil.to(l1);
        n2 = ListNodeUtil.to(l2);
        System.err.println(ListNodeUtil.to(mergeTwoLists(n1, n2)));
        l1 = "";
        l2 = "";
        n1 = ListNodeUtil.to(l1);
        n2 = ListNodeUtil.to(l2);
        System.err.println(ListNodeUtil.to(mergeTwoLists(n1, n2)));
        System.err.println(ListNodeUtil.to(mergeTwoLists(null, null)));
    }

}
