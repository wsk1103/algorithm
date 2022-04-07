/**
 * @author sk
 * @time 2022/4/7
 **/
public class L796 {

    /**
     * //给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
     * //
     * // s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
     * //
     * //
     * // 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
     * //
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: s = "abcde", goal = "cdeab"
     * //输出: true
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: s = "abcde", goal = "abced"
     * //输出: false
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= s.length, goal.length <= 100
     * // s 和 goal 由小写英文字母组成
     * //
     * // Related Topics 字符串 字符串匹配 👍 195 👎 0
     */

    /**
     解答成功:
     执行耗时:1 ms,击败了27.05% 的Java用户
     内存消耗:39.9 MB,击败了9.05% 的Java用户
     * @param s
     * @param goal
     * @return
     */
    public static boolean handle(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        int l = s.length();
        for (int j = 0; j < l; j++) {
            String a = s.substring(0, 1);
            s = s.substring(1, l);
            s = s + a;
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    /**
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.1 MB,击败了57.68% 的Java用户
     * @param s
     * @param goal
     * @return
     */
    public static boolean handle2(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        char[] cs = s.toCharArray();
        char[] gs = goal.toCharArray();
        for (int j = 0; j < cs.length; j++) {
            change(cs);
            if (eq(cs, gs)) {
                return true;
            }
        }
        return false;
    }

    public static void change(char[] s) {
        char a = s[0];
        System.arraycopy(s, 1, s, 0, s.length - 1);
        s[s.length - 1] = a;
    }

    public static boolean eq(char[] s, char[] g) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != g[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s, goal;
        s = "abcde";
        goal = "cdeab";
        System.err.println(handle(s, goal));
        System.err.println(handle2(s, goal));
        s = "abcde";
        goal = "abced";
        System.err.println(handle(s, goal));
        System.err.println(handle2(s, goal));
    }

}
