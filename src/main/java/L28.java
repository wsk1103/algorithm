import cn.hutool.core.util.RandomUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2022/4/8
 **/
public class L28 {

    /**
     * //实现 strStr() 函数。
     * //
     * // 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
     * //果不存在，则返回 -1 。
     * //
     * //
     * //
     * // 说明：
     * //
     * // 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * //
     * // 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：haystack = "hello", needle = "ll"
     * //输出：2
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：haystack = "aaaaa", needle = "bba"
     * //输出：-1
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：haystack = "", needle = ""
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= haystack.length, needle.length <= 10⁴
     * // haystack 和 needle 仅由小写英文字符组成
     * //
     * // Related Topics 双指针 字符串 字符串匹配 👍 1368 👎 0
     */

    /**
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.5 MB,击败了72.76% 的Java用户
     * @param haystack
     * @param needle
     * @return
     */
    public static int handle(String haystack, String needle) {
        System.err.println(haystack + " " + needle);
        if (needle == null || "".equals(needle) || needle.equals(haystack)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        int top = 0;
        int down = 0;
        while (top <= hl && hl - top >= nl - down) {
            char hc = haystack.charAt(top);
            char nc = needle.charAt(down);
            if (hc == nc) {
                down++;
                if (down >= nl) {
                    return top - down + 1;
                }
                top++;
            } else {
                top = top - down + 1;
                down = 0;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1, s2;
        s1 = "mississippi";
        s2 = "issip";
        System.err.println(handle(s1, s2));
        s1 = "hello";
        s2 = "ll";
        System.err.println(handle(s1, s2));
        s1 = "aaaaa";
        s2 = "bb";
        System.err.println(handle(s1, s2));
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            s1 = "";
            s2 = "";
            int forr = 1000;
            for (int j = 0; j < forr; j++) {
                int rr = r.nextInt(26);
                char c = RandomUtil.BASE_CHAR.charAt(rr);
                s1 += c;
            }
//            s1 = UUID.randomUUID().toString().replace("-", "");
            forr = 3;
            for (int j = 0; j < forr; j++) {
//                r = new Random();
                int rr = r.nextInt(26);
                char c = RandomUtil.BASE_CHAR.charAt(rr);
                s2 += c;
            }
            System.err.println(handle(s1, s2));
        }

    }

}
