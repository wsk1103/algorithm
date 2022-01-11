/**
 * @author sk
 * @time 2021/11/29
 * @desc say
 **/
public class L97_115 {

    /*
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     *
     * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     *
     * 题目数据保证答案符合 32 位带符号整数范围。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：
     * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     * ra b bbit
     * rab b bit
     * rabb b it
     * 示例 2：
     *
     * 输入：s = "babgbag", t = "bag"
     * 输出：5
     * 解释：
     * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     *
     *
     * 提示：
     *
     * 0 <= s.length, t.length <= 1000
     * s 和 t 由英文字母组成
     */

    /**
     *   j →
     * i
     * ↓
     *
     *   '' b a b g b a g
     * '' 1 1 1 1 1 1 1 1
     * b  0 1 1 2 2 3 3 3
     * a  0 0 1 1 1 1 4 4
     * g  0 0 0 0 1 1 1 5
     * dp[i][j] 表示字符串S的前j个元素中有多少个 T的前i个元素
     * dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0);
     * 计算dp[i][j]时要判断S[j-1]==T[i-1],切勿搞错
     *
     * @param s babgbag
     * @param t bag
     * @return
     */
    public static int handle(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (l2 > l1) {
            return 0;
        }
        //设置 i = 0 行时，t表示的字符串为''，则 '' 存在于s中每一个
        //设置 j = 0时，s表示的字符串为''
        int[][] dp = new int[l2 + 1][l1 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < l2 + 1; i++) {
            char ci = t.charAt(i - 1);
            for (int j = 1; j < l1 + 1; j++) {
                char cj = s.charAt(j - 1);
                dp[i][j] = dp[i][j - 1] + (ci == cj ? dp[i - 1][j - 1] : 0);
            }
        }

        return dp[l2][l1];
    }

	//滚动数组优化
    public static int handle2(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            return 0;
        }
        int[] dp = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = dp.length - 1; j >= 0; j--) {
                if (c == t.charAt(j)) {
                    dp[j] = dp[j] + (j != 0 ? dp[j - 1] : 1);
                }
            }
        }
        return dp[t.length() - 1];
    }

    public static void main(String[] args) {
        String s;
        String t;
        s = "babgbag";
        t = "bag";
        System.err.println(handle(s, t));
    }

}
