import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/4/8
 **/
public class L20 {

    /**
     * //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * //
     * // 有效字符串需满足：
     * //
     * //
     * // 左括号必须用相同类型的右括号闭合。
     * // 左括号必须以正确的顺序闭合。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "()"
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "()[]{}"
     * //输出：true
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "(]"
     * //输出：false
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：s = "([)]"
     * //输出：false
     * //
     * //
     * // 示例 5：
     * //
     * //
     * //输入：s = "{[]}"
     * //输出：true
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 10⁴
     * // s 仅由括号 '()[]{}' 组成
     * //
     * // Related Topics 栈 字符串 👍 3154 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了98.79% 的Java用户
     * 内存消耗:39.3 MB,击败了56.67% 的Java用户
     *
     * @param s
     * @return
     */
    public static boolean handle(String s) {
        char[] ch = s.toCharArray();
        Deque<Character> queue = new LinkedList<>();
        for (char cc : ch) {
            switch (cc) {
                case '(':
                case '{':
                case '[':
                    queue.push(cc);
                    break;
                case ')':
                    if (queue.isEmpty()) {
                        return false;
                    }
                    char temp = queue.poll();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (queue.isEmpty()) {
                        return false;
                    }
                    temp = queue.poll();
                    if (temp != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (queue.isEmpty()) {
                        return false;
                    }
                    temp = queue.poll();
                    if (temp != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        String s;
        s = "()";
        System.err.println(handle(s));
        s = "(";
        System.err.println(handle(s));
        s = "{[]}";
        System.err.println(handle(s));
        s = "([)]";
        System.err.println(handle(s));
        s = "()[]{}";
        System.err.println(handle(s));
    }
}
