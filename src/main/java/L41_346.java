import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/3
 * @desc say
 **/
public class L41_346 {

    /*
     * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
     *
     * 实现 MovingAverage 类：
     *
     * MovingAverage(int size) 用窗口大小 size 初始化对象。
     * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
     *
     *
     * 示例：
     *
     * 输入：
     * inputs = ["MovingAverage", "next", "next", "next", "next"]
     * inputs = [[3], [1], [10], [3], [5]]
     * 输出：
     * [null, 1.0, 5.5, 4.66667, 6.0]
     *
     * 解释：
     * MovingAverage movingAverage = new MovingAverage(3);
     * movingAverage.next(1); // 返回 1.0 = 1 / 1
     * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
     * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
     * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
     *
     *
     * 提示：
     *
     * 1 <= size <= 1000
     * -105 <= val <= 105
     * 最多调用 next 方法 104 次
     */
    public static class MovingAverage {
        int sum = 0;
        int size;
        Queue<Integer> queue = new LinkedList<>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() > size) {
                sum -= queue.poll();
                return sum * 1.00 / size;
            } else {
                return sum * 1.00 / queue.size();
            }
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.err.println(m.next(1));
        System.err.println(m.next(10));
        System.err.println(m.next(3));
        System.err.println(m.next(5));
        System.err.println(m.next(5));
        System.err.println(m.next(5));
        System.err.println(m.next(5));
        System.err.println(m.next(5));
    }

}
