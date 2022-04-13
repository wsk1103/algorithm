import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @time 2022/4/13
 **/
public class L225 {

    /**
     * //请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     * //
     * // 实现 MyStack 类：
     * //
     * //
     * // void push(int x) 将元素 x 压入栈顶。
     * // int pop() 移除并返回栈顶元素。
     * // int top() 返回栈顶元素。
     * // boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     * //
     * //
     * //
     * //
     * // 注意：
     * //
     * //
     * // 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     * // 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //输入：
     * //["MyStack", "push", "push", "top", "pop", "empty"]
     * //[[], [1], [2], [], [], []]
     * //输出：
     * //[null, null, null, 2, 2, false]
     * //
     * //解释：
     * //MyStack myStack = new MyStack();
     * //myStack.push(1);
     * //myStack.push(2);
     * //myStack.top(); // 返回 2
     * //myStack.pop(); // 返回 2
     * //myStack.empty(); // 返回 False
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= x <= 9
     * // 最多调用100 次 push、pop、top 和 empty
     * // 每次调用 pop 和 top 都保证栈不为空
     * //
     * //
     * //
     * //
     * // 进阶：你能否仅用一个队列来实现栈。
     * // Related Topics 栈 设计 队列 👍 489 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了16.12% 的Java用户
     */
    public static class MyStack {
        Queue<Integer> d1 = new LinkedList<>();
        Queue<Integer> d2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            if (d1.isEmpty()) {
                d2.offer(x);
            } else if (d2.isEmpty()) {
                d1.offer(x);
            } else {
                d1.offer(x);
            }
        }

        /**
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:39 MB,击败了54.32% 的Java用户
         *
         * @param x
         */
        public void push2(int x) {
            d1.offer(x);
        }

        public int pop2() {
            int size = d1.size();
            while (size > 1) {
                d1.offer(d1.poll());
                size--;
            }
            return d1.poll();
        }

        public int top2() {
            int v = pop2();
            push2(v);
            return v;
        }

        public boolean empty2() {
            return d1.isEmpty();
        }

        public int pop() {
            if (!d1.isEmpty()) {
                int temp = d1.poll();
                while (!d1.isEmpty()) {
                    d2.offer(temp);
                    if (!d1.isEmpty()) {
                        temp = d1.poll();
                    }
                }
                return temp;
            } else {
                int temp = d2.poll();
                while (!d2.isEmpty()) {
                    d1.offer(temp);
                    if (!d2.isEmpty()) {
                        temp = d2.poll();
                    }
                }
                return temp;
            }
        }

        public int top() {
            int v = pop();
            push(v);
            return v;
        }

        public boolean empty() {
            return d1.isEmpty() && d2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.err.println(myStack.top());
        System.err.println(myStack.pop());
        System.err.println(myStack.empty());

    }

}
