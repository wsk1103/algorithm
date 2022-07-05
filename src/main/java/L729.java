/**
 * @author sk
 * @time 2022/7/5
 **/
public class L729 {

    /*
     * //实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
     * //
     * // 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
     * //
     * // 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x <
     * //end 。
     * //
     * // 实现 MyCalendar 类：
     * //
     * //
     * // MyCalendar() 初始化日历对象。
     * // boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回
     * //false 并且不要将该日程安排添加到日历中。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //输入：
     * //["MyCalendar", "book", "book", "book"]
     * //[[], [10, 20], [15, 25], [20, 30]]
     * //输出：
     * //[null, true, false, true]
     * //
     * //解释：
     * //MyCalendar myCalendar = new MyCalendar();
     * //myCalendar.book(10, 20); // return True
     * //myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
     * //。
     * //myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
     * // ，且不包含时间 20 。
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= start < end <= 10⁹
     * // 每个测试用例，调用 book 方法的次数最多不超过 1000 次。
     * //
     * // Related Topics 设计 线段树 二分查找 有序集合 👍 163 👎 0
     */

    static class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean insert(TreeNode node) {
            if (node.end <= this.start) {
                if (this.left == null) {
                    this.left = node;
                    return true;
                }
                return this.left.insert(node);
            } else if (node.start >= this.end) {
                if (this.right == null) {
                    this.right = node;
                    return true;
                }
                return this.right.insert(node);
            }
            return false;
        }
    }

    /**
     * 执行耗时:12 ms,击败了98.91% 的Java用户
     * 内存消耗:42.3 MB,击败了30.35% 的Java用户
     */
    static class MyCalendar {

        TreeNode root = null;

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            TreeNode node = new TreeNode(start, end);
            if (root == null) {
                root = node;
                return true;
            } else {
                return root.insert(node);
            }
        }
    }

    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();


        System.err.print(m.book(20, 29) + ",");
        System.err.print(m.book(13, 22) + ",");
        System.err.print(m.book(44, 50) + ",");
        System.err.print(m.book(1, 7) + ",");
        System.err.print(m.book(2, 10) + ",");
        System.err.print(m.book(14, 20) + ",");
        System.err.print(m.book(19, 25) + ",");
        System.err.print(m.book(36, 42) + ",");
        System.err.print(m.book(45, 50) + ",");
        System.err.print(m.book(47, 50) + ",");
        System.err.print(m.book(39, 45) + ",");
        System.err.print(m.book(44, 50) + ",");
        System.err.print(m.book(16, 25) + ",");
        System.err.print(m.book(45, 50) + ",");
        System.err.print(m.book(45, 50) + ",");
        System.err.print(m.book(12, 20) + ",");
        System.err.print(m.book(21, 29) + ",");
    }

}
