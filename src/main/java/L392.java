import java.util.Arrays;

/**
 * @author sk
 * @time 2022/4/21
 **/
public class L392 {

    /**
     * //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * //
     * // 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
     * //"aec"不是）。
     * //
     * // 进阶：
     * //
     * // 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
     * //码？
     * //
     * // 致谢：
     * //
     * // 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "abc", t = "ahbgdc"
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "axc", t = "ahbgdc"
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= s.length <= 100
     * // 0 <= t.length <= 10^4
     * // 两个字符串都只由小写字符组成。
     * //
     * // Related Topics 双指针 字符串 动态规划 👍 634 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了88.66% 的Java用户
     * 内存消耗:39.1 MB,击败了77.83% 的Java用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean handle(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        } else if (s.length() == t.length()) {
            return s.equals(t);
        }

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            for (int j = dp[i]; j < t.length(); j++) {
                char cj = t.charAt(j);
                if (ci == cj) {
                    dp[i + 1] = j + 1;
                    break;
                }
                if (j == t.length() - 1) {
                    return false;
                }
            }
        }
        return dp[s.length()] != -1;
    }

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了88.66% 的Java用户
     * 内存消耗:39.2 MB,击败了71.06% 的Java用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean handle2(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        } else if (s.length() == t.length()) {
            return s.equals(t);
        } else if (s.length() == 0) {
            return true;
        }
        int dp = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            if (dp >= t.length()) {
                return false;
            }
            for (int j = dp; j < t.length(); j++) {
                char cj = t.charAt(j);
                if (ci == cj) {
                    dp = j + 1;
                    break;
                }
                if (j == t.length() - 1) {
                    return false;
                }
            }
        }
        return dp != 0;
    }

    public static void main(String[] args) {
        String s, t;
        s = "abc";
        t = "ahbgdc";
        System.err.println(handle(s, t));
        System.err.println(handle2(s, t));
        s = "axc";
        t = "ahbgdc";
        System.err.println(handle(s, t));
        System.err.println(handle2(s, t));
        s = "acb";
        t = "ahbgdc";
        System.err.println(handle(s, t));
        System.err.println(handle2(s, t));
    }

}
