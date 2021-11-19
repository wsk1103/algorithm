import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/20
 * @desc say
 **/
public class L3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * <p>
     * 输入: s = ""
     * 输出: 0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */

    public static int handle(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int left = 0;
        int right = 0;
        int max = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        while (right < s.length()) {
            int temp;
            if (map.containsKey(s.charAt(right))) {
                temp = map.get(s.charAt(right)) + 1;
                if (left > temp) {
                    temp = right - left + 1;
                    max = max > temp ? max : temp;
                } else {
                    left = map.get(s.charAt(right)) + 1;
                }

            } else {
                temp = right - left + 1;
                max = max > temp ? max : temp;
            }
            map.put(s.charAt(right), right);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s;
        s = "abcabcbb";
        System.err.println(handle(s));

        s = "bbbbb";
        System.err.println(handle(s));

        s = "pwwkew";
        System.err.println(handle(s));
        s = "au";
        System.err.println(handle(s));
        s = "tmmzuxt";
        System.err.println(handle(s));
    }


}
