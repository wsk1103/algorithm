import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/9/8
 * @desc say
 **/
public class L284 {

    /*
     * //请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。
     * //
     * // 实现 PeekingIterator 类：
     * //
     * //
     * // PeekingIterator(Iterator<int> nums) 使用指定整数迭代器 nums 初始化迭代器。
     * // int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
     * // bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
     * // int peek() 返回数组中的下一个元素，但 不 移动指针。
     * //
     * //
     * // 注意：每种语言可能有不同的构造函数和迭代器 Iterator，但均支持 int next() 和 boolean hasNext() 函数。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：
     * //["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
     * //[[[1, 2, 3]], [], [], [], [], []]
     * //输出：
     * //[null, 1, 2, 2, 3, false]
     * //
     * //解释：
     * //PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
     * //peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
     * //peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
     * //peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
     * //peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
     * //peekingIterator.hasNext(); // 返回 False
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 1000
     * // 1 <= nums[i] <= 1000
     * // 对 next 和 peek 的调用均有效
     * // next、hasNext 和 peek 最多调用 1000 次
     * //
     * //
     * //
     * //
     * // 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
     * //
     * // Related Topics 设计 数组 迭代器 👍 171 👎 0
     */

    class PeekingIterator implements Iterator<Integer> {

        /**
         * 执行耗时:4 ms,击败了75.61% 的Java用户
         * 内存消耗:41.3 MB,击败了48.42% 的Java用户
         */
        MyList<Integer> myList;

        /**
         * 执行耗时:4 ms,击败了75.61% 的Java用户
         * 内存消耗:41.5 MB,击败了13.59% 的Java用户
         */
        LinkedList<Integer> list;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            if (iterator.hasNext()) {
                myList = new MyList<>(iterator.next());
                MyList<Integer> next = myList;
                while (iterator.hasNext()) {
                    MyList<Integer> tmp = new MyList<>(iterator.next());
                    next.next = tmp;
                    next = tmp;
                }
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return myList.t;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            MyList<Integer> tmp = myList;
            Integer ans = myList.t;
            myList = tmp.next;
            return ans;
        }

        @Override
        public boolean hasNext() {
            return myList != null;
        }

    }

    public static class MyList<T> {
        T t;
        MyList<T> next;

        MyList(T t) {
            this.t = t;
        }
    }

    interface Iterator<T> {
        T next();

        boolean hasNext();
    }

}
