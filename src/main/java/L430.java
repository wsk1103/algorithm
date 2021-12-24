/**
 * @author sk
 * @time 2021/10/27
 * @desc say
 **/
public class L430 {

    /*
     * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
     * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     * <p>
     * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
     * 解释：
     * <p>
     * 输入的多级列表如下图所示：
     * <p>
     * <p>
     * <p>
     * 扁平化后的链表如下图：
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2,null,3]
     * 输出：[1,3,2]
     * 解释：
     * <p>
     * 输入的多级列表如下图所示：
     * <p>
     * 1---2---NULL
     * |
     * 3---NULL
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * <p>
     * 如何表示测试用例中的多级链表？
     * <p>
     * 以 示例 1 为例：
     * <p>
     * 1---2---3---4---5---6--NULL
     *         |
     *         7---8---9---10--NULL
     *             |
     *             11--12--NULL
     * 序列化其中的每一级之后：
     * <p>
     * [1,2,3,4,5,6,null]
     * [7,8,9,10,null]
     * [11,12,null]
     * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
     * <p>
     * [1,2,3,4,5,6,null]
     * [null,null,7,8,9,10,null]
     * [null,11,12,null]
     * 合并所有序列化结果，并去除末尾的 null 。
     * <p>
     * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 节点数目不超过 1000
     * 1 <= Node.val <= 10^5
     */

    public static Node handle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        setNext(head);
        return head;
    }

    public static void setNext(Node node) {
        if (node == null) {
            return;
        }
        Node n = node;
        while (n.next != null) {
            n = n.next;
        }
        Node p = n;
        while (p != null) {
            if (p.child != null) {
                n.next = p.child;
                n = p.child;
                p.child = null;
                setNext(n);
                //TODO
                break;
            }
            p = p.prev;
        }
    }

    public static Node handle2(Node head) {
        if (head == null) {
            return head;
        }
        setN2(head);
        return head;
    }

    public static Node setN2(Node head) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        Node ne;
        Node c;
        Node pre = null;
        while (temp != null) {
            pre = temp;
            Node cur = temp;
            temp = temp.next;
            if (cur.child != null) {
                ne = cur.next;
                Node ch = cur.child;
                cur.next = ch;
                ch.prev = cur;
                cur.child = null;
                c = setN2(ch);
                c.next = ne;
                if (ne != null) {
                    ne.prev = c;
                }
                pre = c;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
//        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Node node = new Node(l1.get(0));
//        List<Integer> l2 = Arrays.asList(7, 8, 9, 10);
//        Node node2 = new Node(l2.get(0));
//        List<Integer> l3 = Arrays.asList(11, 12);
//        Node node3 = new Node(l3.get(0));
//        Node t = node;
//        for (int i = 1; i < l1.size(); i++) {
//            Node n = new Node(l1.get(i));
//            n.prev = t;
//            t.next = n;
////            t.prev = te1.get(i - 1);
//            t = n;
//            if (i == 2) {
//                n.child = node2;
//            }
//        }
//
//
//        Node t2 = node2;
//        for (int i = 1; i < l2.size(); i++) {
//            Node n = new Node(l2.get(i));
//            n.prev = t2;
//            t2.next = n;
////            t.prev = te2.get(i - 1);
//            t2 = n;
//            if (i == 1) {
//                n.child = node3;
//            }
//        }
//
//        Node t3 = node3;
//        for (int i = 1; i < l3.size(); i++) {
//            Node n = new Node(l3.get(i));
//            n.prev = t3;
//            t3.next = n;
////            t.prev = te3.get(i - 1);
//            t3 = n;
//        }
//        Node re = handle2(node);
//        System.err.println();
//        while (re != null) {
//            System.err.print(re.val + ", ");
//            re = re.next;
//        }

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        Node re = handle2(n1);
        System.err.println();
        while (re != null) {
            System.err.print(re.val + ", ");
            re = re.next;
        }

    }


}
