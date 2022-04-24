/**
 * @author sk
 * @time 2022/4/24
 **/
public class L1422 {

    /**
     * //给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
     * //
     * //
     * // 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：s = "011101"
     * //输出：5
     * //解释：
     * //将字符串 s 划分为两个非空子字符串的可行方案有：
     * //左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
     * //左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
     * //左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
     * //左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
     * //左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：s = "00111"
     * //输出：5
     * //解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：s = "1111"
     * //输出：3
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= s.length <= 500
     * // 字符串 s 仅由字符 '0' 和 '1' 组成。
     * //
     * // Related Topics 字符串 👍 33 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了98.17% 的Java用户
     * 内存消耗:38.9 MB,击败了92.31% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        char[] ch = s.toCharArray();
        int cur = 1;
        int left = 0;
        int right = 0;
        int max;

        int rTemp = cur;
        if (ch[0] == '0') {
            left++;
        }

        while (rTemp < ch.length) {
            char lch = ch[rTemp];
            if (lch == '1') {
                right++;
            }
            rTemp++;
        }
        max = left + right;
        while (cur < ch.length - 1) {
            char c = ch[cur];
            if (c == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left + right);
            cur++;
        }

        return max;
    }

    public static void main(String[] args) {
        String s;
        s = "011101";
        System.err.println(handle(s));
        s = "00111";
        System.err.println(handle(s));
        s = "00000";
        System.err.println(handle(s));
        s = "11111";
        System.err.println(handle(s));
        s = "11";
        System.err.println(handle(s));
        s = "00";
        System.err.println(handle(s));
    }

}
