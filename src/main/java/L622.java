/**
 * @author sk
 * @time 2022/8/2
 **/
public class L622 {

    /*
     * //设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
     * //。
     * //
     * // 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
     * //队列，我们能使用这些空间去存储新的值。
     * //
     * // 你的实现应该支持如下操作：
     * //
     * //
     * // MyCircularQueue(k): 构造器，设置队列长度为 k 。
     * // Front: 从队首获取元素。如果队列为空，返回 -1 。
     * // Rear: 获取队尾元素。如果队列为空，返回 -1 。
     * // enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
     * // deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
     * // isEmpty(): 检查循环队列是否为空。
     * // isFull(): 检查循环队列是否已满。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * // MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
     * //circularQueue.enQueue(1);  // 返回 true
     * //circularQueue.enQueue(2);  // 返回 true
     * //circularQueue.enQueue(3);  // 返回 true
     * //circularQueue.enQueue(4);  // 返回 false，队列已满
     * //circularQueue.Rear();  // 返回 3
     * //circularQueue.isFull();  // 返回 true
     * //circularQueue.deQueue();  // 返回 true
     * //circularQueue.enQueue(4);  // 返回 true
     * //circularQueue.Rear();  // 返回 4
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 所有的值都在 0 至 1000 的范围内；
     * // 操作数将在 1 至 1000 的范围内；
     * // 请不要使用内置的队列库。
     * //
     * // Related Topics 设计 队列 数组 链表 👍 343 👎 0
     */

    static class KV {

        private int value;

        public KV(int value) {
            this.value = value;
        }


    }

    /**
     * 执行耗时:4 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了63.72% 的Java用户
     */
    static class MyCircularQueue {

        private int size;
        private int index;

        private KV[] kv;


        public MyCircularQueue(int k) {
            index = -1;
            this.size = k;
            this.kv = new KV[k];
        }

        public boolean enQueue(int value) {
            if (index + 1 >= size) {
                return false;
            }
            kv[++index] = new KV(value);
            return true;
        }

        public boolean deQueue() {
            if (index < 0) {
                return false;
            }
            System.arraycopy(kv, 1, kv, 0, index);
            kv[index] = null;
            index--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return kv[0].value;
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return kv[index].value;
        }

        public boolean isEmpty() {
            return index < 0;
        }

        public boolean isFull() {
            return index >= size - 1;
        }
    }

    public static void main(String[] args) {
        //测试用例:["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","deQueue","deQueue","isEmpty","isEmpty","Rear","Rear","deQueue"]
        //		[[8],[3],[9],[5],[0],[],[],[],[],[],[],[]]
        //		测试结果:[null,true,true,true,true,true,true,false,false,9,9,true]
        //		期望结果:[null,true,true,true,true,true,true,false,false,0,0,true]
        //

        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        System.err.println(myCircularQueue.enQueue(3));
        System.err.println(myCircularQueue.enQueue(9));
        System.err.println(myCircularQueue.enQueue(5));
        System.err.println(myCircularQueue.enQueue(0));
        System.err.println(myCircularQueue.deQueue());
        System.err.println(myCircularQueue.deQueue());
        System.err.println(myCircularQueue.isEmpty());
        System.err.println(myCircularQueue.isEmpty());
        System.err.println(myCircularQueue.Rear());
        System.err.println(myCircularQueue.Rear());
        System.err.println(myCircularQueue.deQueue());
//        System.err.println(myCircularQueue.deQueue());
//        System.err.println(myCircularQueue.isEmpty());
//        System.err.println(myCircularQueue.isFull());

    }

}
