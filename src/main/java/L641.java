/**
 * @author sk
 * @time 2022/8/15
 **/
public class L641 {

    /*
     * //设计实现双端队列。
     * //
     * // 实现 MyCircularDeque 类:
     * //
     * //
     * // MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
     * // boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     * // boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     * // boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     * // boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     * // int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     * // int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     * // boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。
     * // boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入
     * //["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront",
     * //"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
     * //[[3], [1], [2], [3], [4], [], [], [], [4], []]
     * //输出
     * //[null, true, true, true, false, 2, true, true, true, 4]
     * //
     * //解释
     * //MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
     * //circularDeque.insertLast(1);			        // 返回 true
     * //circularDeque.insertLast(2);			        // 返回 true
     * //circularDeque.insertFront(3);			        // 返回 true
     * //circularDeque.insertFront(4);			        // 已经满了，返回 false
     * //circularDeque.getRear();  				// 返回 2
     * //circularDeque.isFull();				        // 返回 true
     * //circularDeque.deleteLast();			        // 返回 true
     * //circularDeque.insertFront(4);			        // 返回 true
     * //circularDeque.getFront();				// 返回 4
     * // 
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= k <= 1000
     * // 0 <= value <= 1000
     * // insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
     * // isFull 调用次数不大于 2000 次
     * //
     * // Related Topics 设计 队列 数组 链表 👍 154 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:4 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了69.08% 的Java用户
     */
    public static class MyCircularDeque {

        int size;
        int count = 0;
        Deq head;
        Deq tail;

        public MyCircularDeque(int k) {
            this.size = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            Deq deq = new Deq(value);
            if (head != null) {
                Deq temp = head;
                temp.pre = deq;
                deq.next = temp;
            }
            head = deq;
            if (tail == null) {
                tail = deq;
            }
            count++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Deq deq = new Deq(value);
            if (tail != null) {
                Deq temp = tail;
                temp.next = deq;
                deq.pre = temp;
            }
            tail = deq;
            if (head == null) {
                head = deq;
            }
            count++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            Deq temp = head;
            head = head.next;
            if (head != null) {
                head.pre = null;
            }
            if (tail == temp) {
                tail = head;
            }
            count--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            Deq temp = tail;
            tail = temp.pre;
            if (tail != null) {
                tail.next = null;
            }
            if (head == temp) {
                head = tail;
            }
            count--;
            return true;
        }

        public int getFront() {
            return head == null ? -1 : head.value;
        }

        public int getRear() {
            return tail == null ? -1 : tail.value;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count >= size;
        }

        public static class Deq {
            int value;
            Deq pre;
            Deq next;

            public Deq(int value) {
                this.value = value;
            }

        }
    }

    public static void main(String[] args) {
        MyCircularDeque my = new MyCircularDeque(3);
//        System.err.println(my.insertLast(1));
//        System.err.println(my.insertLast(2));
//        System.err.println(my.insertLast(3));
//        System.err.println(my.insertLast(4));
//        System.err.println(my.getRear());
//        System.err.println(my.isFull());
//        System.err.println(my.deleteLast());
//        System.err.println(my.getRear());
//        System.err.println(my.insertFront(4));
//        System.err.println(my.getFront());
        my = new MyCircularDeque(8);
        System.err.println(my.insertFront(5));
        System.err.println(my.getFront());
        System.err.println(my.isEmpty());
        System.err.println(my.deleteFront());
    }

}
