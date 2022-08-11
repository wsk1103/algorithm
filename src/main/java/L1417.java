import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/11
 **/
public class L1417 {

    /*
     * //给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
     * //
     * // 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
     * //
     * // 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：s = "a0b1c2"
     * //输出："0a1b2c"
     * //解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：s = "leetcode"
     * //输出：""
     * //解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：s = "1229857369"
     * //输出：""
     * //解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
     * //
     * //
     * // 示例 4：
     * //
     * // 输入：s = "covid2019"
     * //输出："c2o0v1i9d"
     * //
     * //
     * // 示例 5：
     * //
     * // 输入：s = "ab123"
     * //输出："1a2b3"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 500
     * // s 仅由小写英文字母和/或数字组成。
     * //
     * // Related Topics 字符串 👍 46 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:4 ms,击败了55.13% 的Java用户
     * 内存消耗:41.9 MB,击败了25.00% 的Java用户
     *
     * @param s
     * @return
     */
    public static String handle(String s) {
        List<Character> one = new ArrayList<>();
        List<Character> tow = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c >= '0' && c <= '9') {
                one.add(c);
            } else {
                tow.add(c);
            }
        }
        int oneS = one.size();
        int towS = tow.size();
        if (Math.abs(oneS - towS) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean b = oneS > towS;
        int min = Math.min(oneS, towS);
        for (int i = 0; i < min; i++) {
            if (b) {
                sb.append(one.get(i));
                sb.append(tow.get(i));
            } else {
                sb.append(tow.get(i));
                sb.append(one.get(i));
            }
        }
        if (b) {
            sb.append(one.get(oneS - 1));
        } else if (oneS != towS) {
            sb.append(tow.get(towS - 1));
        }
        return sb.toString();
    }

    @Deprecated
    public static String handle3(String s) {
        char[] ch = s.toCharArray();
        // one = 字母
        int one = 0, tow = 0;
        int len = ch.length;
        StringBuilder sb = new StringBuilder();
        while (one < len && tow < len) {
            while (one < len && ch[one] >= '0' && ch[one] <= '9') {
                one++;
            }
            if (one < len) {
                sb.append(ch[one++]);
            }
            while (tow < len && !(ch[tow] >= '0' && ch[tow] <= '9')) {
                tow++;
            }
            if (tow < len) {
                sb.append(ch[tow++]);
            }
//            one++;
//            tow++;
        }
        if (Math.abs(one - tow) > 1) {
            return "";
        }
        if (tow > one) {
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, ch[len - 1]);
        }
        return sb.toString();
    }

    public static String handle2(String s) {
        List<Character> one = new ArrayList<>();
        List<Character> tow = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c >= '0' && c <= '9') {
                one.add(c);
            } else {
                tow.add(c);
            }
        }
        int oneS = one.size();
        int towS = tow.size();
        if (Math.abs(oneS - towS) > 1) {
            return "";
        }
        String sb = "";
        boolean b = oneS > towS;
        int min = Math.min(oneS, towS);
        for (int i = 0; i < min; i++) {
            if (b) {
                sb += one.get(i).toString() + tow.get(i).toString();
            } else {
                sb += tow.get(i).toString() + one.get(i).toString();
            }
        }
        if (b) {
            sb += one.get(oneS - 1).toString();
        } else if (oneS != towS) {
            sb += tow.get(towS - 1).toString();
        }
        return sb;
    }

    public static void main(String[] args) {
        String s;
//        s = "a0b1c2d";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
//        s = "1229857369";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
//        s = "ab123";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
//        s = "abc12";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
//        s = "abc123";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
//        s = "1";
//        System.err.println(handle(s));
//        System.err.println(handle2(s));
//        System.err.println(handle3(s));
        s = "covid2019";
        System.err.println(handle(s));
        System.err.println(handle2(s));
        System.err.println(handle3(s));
    }

}
