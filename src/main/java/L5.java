import java.util.Random;

/**
 * @author sk
 * @time 2022/4/1
 **/
public class L5 {

    /*
     * //给你一个字符串 s，找到 s 中最长的回文子串。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "babad"
     * //输出："bab"
     * //解释："aba" 同样是符合题意的答案。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "cbbd"
     * //输出："bb"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 1000
     * // s 仅由数字和英文字母组成
     * //
     * // Related Topics 字符串 动态规划 👍 4979 👎 0
     */
    public static String handle(String s) {
        System.err.println(s);
        int len = s.length();
        String re = s.substring(0, 1);
        for (int i = 1; i < len; i++) {
            re = hh(i, s, re);
        }
        return re;
    }

    public static String hh(int end, String s, String max) {
        int tEnd = end;
        int ti = 0;
        int len = 0;
        int rollI = -1;
        while (ti <= end) {
            if (s.charAt(ti) == s.charAt(end)) {
                if (ti == end) {
                    len++;
                } else {
                    len += 2;
                }
                ti++;
                end--;

                if (rollI == -1) {
                    rollI = ti;
                }
            } else {
                if (rollI != -1) {
                    if (tEnd - rollI < max.length()) {
                        break;
                    }
                    end = tEnd;
                    ti = rollI;
                    rollI = -1;
                    len = 0;
                } else {
                    ti++;
                }
            }
        }
        if (len > 0 && max.length() < len) {
            max = s.substring(tEnd - len + 1, tEnd + 1);
        }
        return max;
    }

    public static String handle2(String s) {
//        System.err.println(s);
        int len = s.length();
        String re = s.substring(0, 1);
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (ch[left] != ch[right]) {
                    dp[left][right] = false;
                    continue;
                }
                if (left + 1 >= right - 1) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }
                if (dp[left][right] && right - left + 1 > re.length()) {
                    re = s.substring(left, right + 1);
                }
            }
        }

        return re;
    }

    public static void main(String[] args) {
        String s;
        Random r = new Random();
        int i = r.nextInt(1000) + 1;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(r.nextInt(10));
        }
        s = sb.toString();
        System.err.println(handle(s));
        System.err.println(handle2(s));

        s = "aaaabaaa";
        System.err.println(handle(s));
        System.err.println(handle2(s));
        s = "esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
        System.err.println(handle(s));
        System.err.println(handle2(s));

        r = new Random();
        i = r.nextInt(1000) + 1;
        sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(r.nextInt(10));
        }
        s = sb.toString();
        System.err.println(handle(s));
        System.err.println(handle2(s));

        sb = new StringBuilder();
        for (int j = 0; j < 1000; j++) {
            sb.append(1);
        }
        s = sb.toString();
        System.err.println(handle(s));
        System.err.println(handle2(s));
    }
}
