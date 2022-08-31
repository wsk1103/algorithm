import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/8/31
 * @desc say
 **/
public class L227 {

    /*
     * //给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * //
     * // 整数除法仅保留整数部分。
     * //
     * // 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。
     * //
     * // 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "3+2*2"
     * //输出：7
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = " 3/2 "
     * //输出：1
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = " 3+5 / 2 "
     * //输出：5
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 3 * 10⁵
     * // s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * // s 表示一个 有效表达式
     * // 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内
     * // 题目数据保证答案是一个 32-bit 整数
     * //
     * //
     * // Related Topics 栈 数学 字符串 👍 609 👎 0
     */

    /**
     * 执行耗时:25 ms,击败了19.58% 的Java用户
     * 内存消耗:61.3 MB,击败了4.99% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        char[] chars = s.toCharArray();
        LinkedList<String> list = new LinkedList<>();
        int len = chars.length;
        for (int i = 0; i < len; ) {
            char now = chars[i];
            if (now == ' ') {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            if (now >= '0' && now <= '9') {
                int add = find(chars, i, sb);
                list.addLast(sb.toString());
                i = add;
            } else if (now == '+' || now == '-') {
                sb.append(now);
                list.addLast(sb.toString());
                i++;
            } else if (now == '*' || now == '/') {
                String last = list.pollLast();
                int add = find(chars, i + 1, sb);
                int l = Integer.parseInt(last);
                int n = Integer.parseInt(sb.toString());
                int mul;
                if (now == '*') {
                    mul = l * n;
                } else {
                    mul = l / n;
                }
                list.addLast(String.valueOf(mul));
                i = add;
            }
        }
        while (!list.isEmpty()) {
            String one = list.poll();
            if (list.isEmpty()) {
                return Integer.parseInt(one);
            }
            String tow = list.poll();
            String third = list.poll();
            String res = "0";
            if ("+".equals(tow)) {
                int add = Integer.parseInt(one) + Integer.parseInt(third);
                res = Integer.toString(add);
            } else if ("-".equals(tow)) {
                int add = Integer.parseInt(one) - Integer.parseInt(third);
                res = Integer.toString(add);
            }
            list.addFirst(res);
        }
        return 0;
    }


    private static int find(char[] chars, int start, StringBuilder sb) {
        char now = chars[start];
        int add = start;
        while ((now >= '0' && now <= '9') || now == ' ') {
            if (now == ' ') {
            } else {
                sb.append(now);
            }
            add++;
            if (add >= chars.length) {
                break;
            }
            now = chars[add];
        }
        return add;
    }

    /**
     * 执行耗时:45 ms,击败了9.62% 的Java用户
     * 内存消耗:64 MB,击败了4.99% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle2(String s) {
        s = s.replace(" ", "");
        LinkedList<String> list = new LinkedList<>();
        String[] add = s.split("\\+");
        for (String s1 : add) {
            list.addLast(s1);
            list.addLast("+");
        }
        list.pollLast();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String tmp = list.pollFirst();
            if ("+".equals(tmp)) {
                list.addLast(tmp);
            } else {
                String[] sub = tmp.split("-");
                for (String s1 : sub) {
                    list.addLast(s1);
                    list.addLast("-");
                }
                list.pollLast();
            }
        }
        size = list.size();
        for (int i = 0; i < size; i++) {
            String tmp = list.pollFirst();
            if ("+".equals(tmp) || "-".equals(tmp)) {
                list.addLast(tmp);
            } else {
                String[] sub = tmp.split("\\*");
                for (String s1 : sub) {
                    list.addLast(s1);
                    list.addLast("*");
                }
                list.pollLast();
            }
        }
        size = list.size();
        for (int i = 0; i < size; i++) {
            String tmp = list.pollFirst();
            if ("+".equals(tmp) || "-".equals(tmp) || "*".equals(tmp)) {
                list.addLast(tmp);
            } else {
                String[] sub = tmp.split("/");
                for (String s1 : sub) {
                    list.addLast(s1);
                    list.addLast("/");
                }
                list.pollLast();
            }
        }
        LinkedList<String> next = new LinkedList<>();
        while (!list.isEmpty()) {
            String tmp = list.pollFirst();
            if (tmp.equals("*")) {
                String n = list.pollFirst();
                String fn = next.pollLast();
                int mul = Integer.parseInt(n) * Integer.parseInt(fn);
                next.addLast(Integer.toString(mul));
            } else if (tmp.equals("/")) {
                String n = list.pollFirst();
                String fn = next.pollLast();
                int mul = Integer.parseInt(fn) / Integer.parseInt(n);
                next.addLast(Integer.toString(mul));
            } else {
                next.addLast(tmp);
            }
        }
        while (!next.isEmpty()) {
            String one = next.poll();
            if (next.isEmpty()) {
                return Integer.parseInt(one);
            }
            String tow = next.poll();
            String third = next.poll();
            String res = "0";
            if ("+".equals(tow)) {
                int addS = Integer.parseInt(one) + Integer.parseInt(third);
                res = Integer.toString(addS);
            } else if ("-".equals(tow)) {
                int addS = Integer.parseInt(one) - Integer.parseInt(third);
                res = Integer.toString(addS);
            }
            next.addFirst(res);
        }
        return 0;
    }

    public static void main(String[] args) {
        String s;
//        s = "0-2147483647";
//        System.err.println(handle(s));
        s = "3+2*2+9-14/44*583 +58+ 45 -21 * 52 /12 *6 /45";
        System.err.println(handle(s));
        s = "3+2*2+9-14/44*583 +58+ 45 -21 * 52 /12 *6 /45";
        System.err.println(handle(s));
        System.err.println(handle2(s));
        s = "3+2*2+9+1+58+ 45 +21 * 52 /12 *6 /45";
        System.err.println(handle(s));
        s = " 3/2 ";
        System.err.println(handle(s));
        s = " 3+5 / 2 ";
        System.err.println(handle(s));
    }
}
