import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/11
 * @desc say
 **/
public class L58_729 {

    /*
     * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
     * <p>
     * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
     * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
     * <p>
     * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
     * <p>
     * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
     * <p>
     * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入:
     * ["MyCalendar","book","book","book"]
     * [[],[10,20],[15,25],[20,30]]
     * 输出: [null,true,false,true]
     * 解释:
     * MyCalendar myCalendar = new MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(15, 25); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
     * MyCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
     * 0 <= start < end <= 109
     * 线段树，有序集合
     */

    static class MyCalendar {

        static class KV {
            int start;
            int end;
        }

        List<KV> list = new ArrayList<>();

        public boolean book(int start, int end) {
            for (KV k : list) {
                if (start < k.end && start >= k.start) {
                    return false;
                }
                if (end < k.end && end > k.start) {
                    return false;
                }
                if (start <= k.start && end >= k.end) {
                    return false;
                }
            }
            KV k = new KV();
            k.start = start;
            k.end = end;
            list.add(k);
            return true;
        }

        static class Tree {
            int start;
            int end;
            int next;
            int pre;
            Tree left;
            Tree right;
        }

        Tree root = null;

        public boolean book2(int start, int end) {
            if (root == null) {
                Tree t = new Tree();
                t.start = start;
                t.end = end;
                t.next = -1;
                t.pre = -1;
                root = t;
                return true;
            }
            Tree t = find(root, start);
            if (t == null) {
                return false;
            }
            if (start > t.start) {
                if (start < t.end || (end > t.next && t.next > 0)) {
                    return false;
                }
                Tree right = new Tree();
                right.start = start;
                right.end = end;
                right.next = t.next;
                right.pre = t.end;
                t.right = right;
            } else {
                if (end > t.start || (start < t.pre && t.pre > 0)) {
                    return false;
                }
                Tree left = new Tree();
                left.start = start;
                left.end = end;
                left.next = t.start;
                left.pre = t.pre;
                t.left = left;
            }
            return true;

        }

        public Tree find(Tree t, int start) {
            if (start > t.start) {
                if (t.right == null) {
                    return t;
                }
                return find(t.right, start);
            } else if (start < t.start) {
                if (t.left == null) {
                    return t;
                }
                return find(t.left, start);
            } else {
                return null;
            }
        }

        class TNode {
            int start;
            int end;
            TNode left;
            TNode right;

            TNode(int start, int end) {
                this.start = start;
                this.end = end;
            }

            boolean insert(TNode node) {
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
                } else {
                    return false;
                }
            }
        }
        TNode root3;
        public MyCalendar() {
            root3 = null;
        }

        public boolean book3(int start, int end) {
            if (root3 == null){
                root3 = new TNode(start, end);
                return true;
            }
            return root3.insert(new TNode(start, end));
        }
    }

    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();
//		System.err.print(m.book2(10, 20) + ",");
//		System.err.print(m.book2(15,30) + ",");
//		System.err.print(m.book2(20,30) + ",");


        System.err.print(m.book3(20, 29) + ",");
        System.err.print(m.book3(13, 22) + ",");
        System.err.print(m.book3(44, 50) + ",");
        System.err.print(m.book3(1, 7) + ",");
        System.err.print(m.book3(2, 10) + ",");
        System.err.print(m.book3(14, 20) + ",");
        System.err.print(m.book3(19, 25) + ",");
        System.err.print(m.book3(36, 42) + ",");
        System.err.print(m.book3(45, 50) + ",");
        System.err.print(m.book3(47, 50) + ",");
        System.err.print(m.book3(39, 45) + ",");
        System.err.print(m.book3(44, 50) + ",");
        System.err.print(m.book3(16, 25) + ",");
        System.err.print(m.book3(45, 50) + ",");
        System.err.print(m.book3(45, 50) + ",");
        System.err.print(m.book3(12, 20) + ",");
        System.err.print(m.book3(21, 29) + ",");
//		m.book(15, 25);
//		m.book(20, 30);
        //		[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        //[null,true,true,false,false,true,false,true,true,true,true]
        //期望[null,true,true,false,false,true,false,true,true,true,false]
        //21,29
//		[[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
//		测试结果:[null,true,false,true,true,false,true,false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false]
//		期望结果:[null,true,false,true,true,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]

    }


}
