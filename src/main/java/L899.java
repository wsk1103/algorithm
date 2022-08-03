import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sk
 * @time 2022/8/3
 **/
public class L899 {

    /*
     * //给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
     * //
     * // 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "cba", k = 1
     * //输出："acb"
     * //解释：
     * //在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
     * //在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "baaca", k = 3
     * //输出："aaabc"
     * //解释：
     * //在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
     * //在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= k <= S.length <= 1000
     * // s 只由小写字母组成。
     * //
     * // Related Topics 数学 字符串 排序 👍 100 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了93.84% 的Java用户
     * 内存消耗:41.8 MB,击败了9.95% 的Java用户
     *
     * @param s
     * @param k
     * @return
     */
    public static String handle(String s, int k) {
        System.err.println(s);
        if (k == 1) {
//            String temp = s;
//            int comTo = 0;
//            int len = s.length();
//            for (int i = 0; i < len; i++) {
//                s = s.substring(1) + s.charAt(0);
//                int cc = s.compareTo(temp);
//                if (cc < comTo) {
//                    temp = s;
//                }
//            }
//            return temp;
            StringBuilder str = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char temp = str.charAt(0);
                str.deleteCharAt(0);
                str.append(temp);
                s = s.compareTo(str.toString()) > 0 ? str.toString() : s;
            }
            return s;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String s;
        int k;
        Random random = new Random();
        s = "cba";
        k = 1;
        System.err.println(handle(s, k));
        s = RandomUtil.randomString(RandomUtil.BASE_CHAR, random.nextInt(100) + 1).toLowerCase();
        k = 1;
        System.err.println(handle(s, k));
    }

}
