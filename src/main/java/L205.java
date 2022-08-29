import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L205 {

    /*
     * //给定两个字符串 s 和 t ，判断它们是否是同构的。
     * //
     * // 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * //
     * // 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入：s = "egg", t = "add"
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "foo", t = "bar"
     * //输出：false
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "paper", t = "title"
     * //输出：true
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * //
     * //
     * //
     * // 1 <= s.length <= 5 * 10⁴
     * // t.length == s.length
     * // s 和 t 由任意有效的 ASCII 字符组成
     * //
     * //
     * // Related Topics 哈希表 字符串 👍 507 👎 0
     */

    /**
     * 执行耗时:7 ms,击败了88.27% 的Java用户
     * 内存消耗:41.2 MB,击败了70.86% 的Java用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean handle(String s, String t) {
        int len = t.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            Character to = map.get(cs);
            if (to == null) {
                if (map.containsValue(ct)) {
                    return false;
                }
                map.put(cs, ct);
            } else if (to != ct) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s, t;
        s = "bbbaaaba";
        t = "aaabbbba";
        System.err.println(handle(s, t));
        s = "foo";
        t = "bar";
        System.err.println(handle(s, t));
        s = "paper";
        t = "title";
        System.err.println(handle(s, t));
        s = "badc";
        t = "baba";
        System.err.println(handle(s, t));
    }

}
