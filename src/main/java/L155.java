import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L155 {

    /*
     * //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * //
     * // 实现 MinStack 类:
     * //
     * //
     * // MinStack() 初始化堆栈对象。
     * // void push(int val) 将元素val推入堆栈。
     * // void pop() 删除堆栈顶部的元素。
     * // int top() 获取堆栈顶部的元素。
     * // int getMin() 获取堆栈中的最小元素。
     * //
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入：
     * //["MinStack","push","push","push","getMin","pop","top","getMin"]
     * //[[],[-2],[0],[-3],[],[],[],[]]
     * //
     * //输出：
     * //[null,null,null,null,-3,null,0,-2]
     * //
     * //解释：
     * //MinStack minStack = new MinStack();
     * //minStack.push(-2);
     * //minStack.push(0);
     * //minStack.push(-3);
     * //minStack.getMin();   --> 返回 -3.
     * //minStack.pop();
     * //minStack.top();      --> 返回 0.
     * //minStack.getMin();   --> 返回 -2.
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= val <= 2³¹ - 1
     * // pop、top 和 getMin 操作总是在 非空栈 上调用
     * // push, pop, top, and getMin最多被调用 3 * 10⁴ 次
     * //
     * //
     * // Related Topics 栈 设计 👍 1423 👎 0
     */

    /**
     * 执行耗时:7 ms,击败了7.80% 的Java用户
     * 内存消耗:43 MB,击败了89.87% 的Java用户
     */
    static class MinStack {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        LinkedList<Integer> list = new LinkedList<>();

        public MinStack() {

        }

        public void push(int val) {
            list.add(val);
            int size = map.getOrDefault(val, 0);
            size++;
            map.put(val, size);
        }

        public void pop() {
            int val = list.pollLast();
            int size = map.getOrDefault(val, 0);
            size--;
            if (size <= 0) {
                map.remove(val);
            } else {
                map.put(val, size);
            }
        }

        public int top() {
            return list.peekLast();
        }

        public int getMin() {
            return map.firstKey();
        }
    }

}
