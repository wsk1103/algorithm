import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/9/7
 * @desc say
 **/
public class L1592 {

    /*
     * //给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证
     * //text 至少包含一个单词 。
     * //
     * // 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也
     * //意味着返回的字符串应当与原 text 字符串的长度相等。
     * //
     * // 返回 重新排列空格后的字符串 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：text = "  this   is  a sentence "
     * //输出："this   is   a   sentence"
     * //解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：text = " practice   makes   perfect"
     * //输出："practice   makes   perfect "
     * //解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：text = "hello   world"
     * //输出："hello   world"
     * //
     * //
     * // 示例 4：
     * //
     * // 输入：text = "  walks  udp package   into  bar a"
     * //输出："walks  udp  package  into  bar  a "
     * //
     * //
     * // 示例 5：
     * //
     * // 输入：text = "a"
     * //输出："a"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= text.length <= 100
     * // text 由小写英文字母和 ' ' 组成
     * // text 中至少包含一个单词
     * //
     * //
     * // Related Topics 字符串 👍 44 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了60.00% 的Java用户
     *
     * @param text
     * @return
     */
    public static String handle(String text) {
        int len = text.length();
        int size = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                size++;
            } else if (i == len - 1) {
                count++;
            } else if (text.charAt(i) != ' ' && text.charAt(i + 1) == ' ') {
                count++;
            }
        }
        if (size == 0) {
            return text;
        }
        int t;
        if (count == 1) {
            t = size;
        } else {
            t = size / (count - 1);
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (text.charAt(start) == ' ') {
            start++;
        }
        int end = len - 1;
        while (text.charAt(end) == ' ') {
            end--;
        }

        for (int i = start; i <= end; ) {
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i++));
            } else {
                for (int j = 0; j < t; j++) {
                    sb.append(' ');
                    size--;
                }
                while (text.charAt(i) == ' ') {
                    i++;
                }
            }
        }
        while (size > 0) {
            sb.append(' ');
            size--;
        }
        return sb.toString();
    }

    /**
     * 执行耗时:1 ms,击败了89.84% 的Java用户
     * 内存消耗:39.6 MB,击败了51.74% 的Java用户
     *
     * @param text
     * @return
     */
    public static String handle2(String text) {
        char[] chars = text.toCharArray();
        int size = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                size++;
            }
        }
        if (size == 0) {
            return text;
        }
        String[] ss = text.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : ss) {
            if (!"".equals(s)) {
                list.add(s);
            }
        }
        int t;
        if (list.size() == 1) {
            t = size;
        } else {
            t = size / (list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            for (int i = 0; i < t && size > 0; i++) {
                sb.append(" ");
                size--;
            }
        }
        while (size > 0) {
            sb.append(" ");
            size--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s;
        s = "a";
//        System.err.println(handle(s));
        s = " practice   makes   perfect";
        System.err.println(handle(s));
        System.err.println(handle2(s));
        s = "  walks  udp package   into  bar a";
        System.err.println(handle(s));
        System.err.println(handle2(s));
        s = "  this   is  a sentence ";
        System.err.println(handle(s));
    }

}
