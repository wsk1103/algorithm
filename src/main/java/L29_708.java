/**
 * @author sk
 * @time 2021/10/27
 * @desc say
 **/
public class L29_708 {

    /*
     * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
     * <p>
     * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
     * <p>
     * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
     * <p>
     * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,4,1], insertVal = 2
     * 输出：[3,4,1,2]
     * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。
     * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [], insertVal = 1
     * 输出：[1]
     * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
     * 示例 3：
     * <p>
     * 输入：head = [1], insertVal = 0
     * 输出：[1,0]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= Number of Nodes <= 5 * 10^4
     * -10^6 <= Node.val <= 10^6
     * -10^6 <= insertVal <= 10^6
     */

    public static ListNode handle(ListNode head, ListNode i) {
        if (head == null) {
            i.next = i;
            return i;
        }
        ListNode re = head;
        while (head != null) {
            if (head == head.next) {
                head.next = i;
                i.next = head;
                break;
            } else if (head.val == i.val) {
                ListNode temp = head.next;
                head.next = i;
                i.next = temp;
                break;
            } else if (head.val < i.val && head.next.val > i.val) {
                ListNode temp = head.next;
                head.next = i;
                i.next = temp;
                break;
            } else if (head.val < i.val && head.next.val < i.val && head.val > head.next.val) {
                ListNode temp = head.next;
                head.next = i;
                i.next = temp;
                break;
            } else if (head.val > i.val && i.val < head.next.val && head.val > head.next.val) {
                //3 2
                //1
                ListNode temp = head.next;
                head.next = i;
                i.next = temp;
                break;
            }
            head = head.next;
        }
        return re;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(6);
//        ListNode n2 = new ListNode(3);
        n1.next = n1;
//        n2.next = n1;
        ListNode t = handle(n1, new ListNode(6));
        System.err.println();
    }

}
