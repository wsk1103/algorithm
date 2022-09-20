/**
 * @author sk
 * @time 2022/9/20
 * @desc say
 **/
public class L345 {

    /*
     * //给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * //
     * // 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "hello"
     * //输出："holle"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "leetcode"
     * //输出："leotcede"
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 3 * 10⁵
     * // s 由 可打印的 ASCII 字符组成
     * //
     * //
     * // Related Topics 双指针 字符串 👍 264 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了95.49% 的Java用户
     * 内存消耗:41.4 MB,击败了81.40% 的Java用户
     *
     * @param s
     * @return
     */
    public static String handle(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chs = s.toCharArray();
        a:
        while (start < end) {
            char ce = chs[end];
            while (ce != 'a' && ce != 'o' && ce != 'e' && ce != 'i' && ce != 'u'
                    && ce != 'A' && ce != 'O' && ce != 'E' && ce != 'I' && ce != 'U') {
                end--;
                if (end < start) {
                    break a;
                }
                ce = chs[end];
            }
            char cs = chs[start];
            while (cs != 'a' && cs != 'o' && cs != 'e' && cs != 'i' && cs != 'u'
                    && cs != 'A' && cs != 'O' && cs != 'E' && cs != 'I' && cs != 'U') {
                start++;
                if (end < start) {
                    break a;
                }
                cs = chs[start];
            }
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s;
        s = "Ui";
        System.err.println(handle(s));
    }

}
