import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/14
 * @desc say
 **/
public class L290 {

    /*
     * //给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     * //
     * // 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     * //
     * //
     * //
     * // 示例1:
     * //
     * //
     * //输入: pattern = "abba", s = "dog cat cat dog"
     * //输出: true
     * //
     * // 示例 2:
     * //
     * //
     * //输入:pattern = "abba", s = "dog cat cat fish"
     * //输出: false
     * //
     * // 示例 3:
     * //
     * //
     * //输入: pattern = "aaaa", s = "dog cat cat dog"
     * //输出: false
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= pattern.length <= 300
     * // pattern 只包含小写英文字母
     * // 1 <= s.length <= 3000
     * // s 只包含小写英文字母和 ' '
     * // s 不包含 任何前导或尾随对空格
     * // s 中每个单词都被 单个空格 分隔
     * //
     * //
     * // Related Topics 哈希表 字符串 👍 497 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了83.65% 的Java用户
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        Map<Character, String> map = new HashMap<>();
        String[] ss = s.split(" ");
        int len2 = ss.length;
        if (len != len2) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char cur = pattern.charAt(i);
            String curS = map.get(cur);
            if (curS == null) {
                if (map.containsValue(ss[i])) {
                    return false;
                }
                map.put(cur, ss[i]);
            } else {
                if (!ss[i].equals(curS)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String p, s;
        p = "abba";
        s = "dog cat cat dog";
        System.err.println(wordPattern(p, s));
        p = "abba";
        s = "dog dog dog dog";
        System.err.println(wordPattern(p, s));
    }

}
