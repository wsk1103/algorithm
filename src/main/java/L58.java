/**
 * @author sk
 * @time 2022/4/11
 **/
public class L58 {

    /**
     * //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * //
     * // 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "Hello World"
     * //输出：5
     * //解释：最后一个单词是“World”，长度为5。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "   fly me   to   the moon  "
     * //输出：4
     * //解释：最后一个单词是“moon”，长度为4。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "luffy is still joyboy"
     * //输出：6
     * //解释：最后一个单词是长度为6的“joyboy”。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 10⁴
     * // s 仅有英文字母和空格 ' ' 组成
     * // s 中至少存在一个单词
     * //
     * // Related Topics 字符串 👍 451 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了62.17% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length() - 1;
        int sum = 0;
        boolean first = true;
        while (len >= 0) {
            if (s.charAt(len) != ' ') {
                sum++;
                if (first) {
                    first = false;
                }
            } else if (s.charAt(len) == ' ' && !first) {
                break;
            }
            len--;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s;
        s = "  fly me   to   the moon  ";
        System.err.println(handle(s));
        s = "luffy is still joyboy";
        System.err.println(handle(s));
    }

}
