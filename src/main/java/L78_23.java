/**
 * @author sk
 * @time 2021/11/22
 * @desc say
 **/
public class L78_23 {

    /*
     * 给定一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     * <p>
     * <p>
     * 提示：
     * <p>
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */

    public static ListNode handle(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        ListNode me = null;
        for (int i = 0; i < lists.length - 1; i++) {
            if (i == 0) {
                ListNode node1 = lists[i];
                ListNode node2 = lists[i + 1];
                me = merge(node1, node2);
            } else {
                ListNode node2 = lists[i + 1];
                me = merge(me, node2);
            }
        }
        return me;
    }

    public static ListNode handle3(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        ListNode me = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode node2 = lists[i];
            me = merge(me, node2);
        }
        return me;
    }

    public static ListNode handle2(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        int count = lists.length;
        while (count > 1) {
            int temp = 0;
            for (int i = 0; i < count; i += 2) {
                ListNode me;
                if (i + 1 >= count) {
                    me = lists[i];
                } else {
                    me = merge(lists[i], lists[i + 1]);
                }
                lists[temp++] = me;
            }
            count = temp;
        }
        return lists[0];
    }

    private static ListNode merge(ListNode fast, ListNode slow) {
        if (fast == null) {
            return slow;
        }
        if (slow == null) {
            return fast;
        }

        ListNode re = null;
        ListNode temp = null;
        while (fast != null && slow != null) {
            if (fast.val > slow.val) {
                if (re == null) {
                    re = slow;
                    temp = re;
                } else {
                    temp.next = slow;
                    temp = temp.next;
                }
                slow = slow.next;
            } else {
                if (re == null) {
                    re = fast;
                    temp = re;
                } else {
                    temp.next = fast;
                    temp = temp.next;
                }
                fast = fast.next;
            }
        }
        if (fast != null) {
            temp.next = fast;
        }
        if (slow != null) {
            temp.next = slow;
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums1, nums2, nums3;
        nums1 = new int[]{1,4,5};
        nums2 = new int[]{1,3,4};
        nums3 = new int[]{2,6};

        ListNode n1, n2, n3;
        n1 = NodeSer.ser(nums1);
        n2 = NodeSer.ser(nums2);
        n3 = NodeSer.ser(nums3);
        ListNode[] nodes = new ListNode[3];
        nodes[0] = n1;
        nodes[1] = n2;
        nodes[2] = n3;

        ListNode re = handle3(nodes);
        NodeSer.enToString(re);
    }

}
