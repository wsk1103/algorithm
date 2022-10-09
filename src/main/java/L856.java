import java.util.Stack;

/**
 * @author sk
 * @time 2022/10/9
 * @desc say
 **/
public class L856 {

    /*
     * //给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
     * //
     * //
     * // () 得 1 分。
     * // AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
     * // (A) 得 2 * A 分，其中 A 是平衡括号字符串。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入： "()"
     * //输出： 1
     * //
     * //
     * // 示例 2：
     * //
     * // 输入： "(())"
     * //输出： 2
     * //
     * //
     * // 示例 3：
     * //
     * // 输入： "()()"
     * //输出： 2
     * //
     * //
     * // 示例 4：
     * //
     * // 输入： "(()(()))"
     * //输出： 6
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // S 是平衡括号字符串，且只含有 ( 和 ) 。
     * // 2 <= S.length <= 50
     * //
     * //
     * // Related Topics 栈 字符串 👍 358 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了45.62% 的Java用户
     * 内存消耗:39.6 MB,击败了31.48% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        Stack<String> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else {
                String cur = ")";
                String tmp;
                while (!stack.isEmpty() && !(tmp = stack.pop()).equals("(")) {
                    if (cur.equals(")")) {
                        cur = tmp;
                    } else {
                        cur = Integer.parseInt(cur) + Integer.parseInt(tmp) + "";
                    }
                }
                //stack.pop();
                if (cur.equals(")")) {
                    stack.push("1");
                } else {
                    stack.push(Integer.parseInt(cur) * 2 + "");
                }
            }
        }
        int cur = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            cur = cur + Integer.parseInt(tmp);
        }
        return cur;
    }

    public static void main(String[] args) {
        String s;
        s = "(())";
        System.err.println(handle(s));
        s = "()";
        System.err.println(handle(s));
        s = "()()";
        System.err.println(handle(s));
        s = "(()(()))";
        System.err.println(handle(s));
    }

}
