import java.util.*;

/**
 * @author sk
 * @time 2022/6/30
 **/
public class L17 {

    /*
     * //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * //
     * // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * //
     * //      abc def
     * // ghi  jkl mno
     * // pqrs tuv wxyz
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：digits = "23"
     * //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：digits = ""
     * //输出：[]
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：digits = "2"
     * //输出：["a","b","c"]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= digits.length <= 4
     * // digits[i] 是范围 ['2', '9'] 的一个数字。
     * //
     * // Related Topics 哈希表 字符串 回溯 👍 1977 👎 0
     */

    public static Map<Character, String> map = new HashMap<>(8);

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    /**
     * 执行耗时:1 ms,击败了48.47% 的Java用户
     * 内存消耗:41.3 MB,击败了10.03% 的Java用户
     *
     * @param digits
     * @return
     */
    public static List<String> handle(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        LinkedList<Character> chs = new LinkedList<>();
        loop(0, chs, list, digits);
        return list;
    }

    public static void loop(int now, LinkedList<Character> chs, List<String> list, String digits) {
        if (now >= digits.length()) {
            if (chs.size() == digits.length()) {
                StringBuilder sb = new StringBuilder();
                for (Character ch : chs) {
                    sb.append(ch);
                }
                list.add(sb.toString());
            }
            return;
        }
        for (int i = now; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            String s = map.get(ch);
            for (int j = 0; j < s.length(); j++) {
                chs.addLast(s.charAt(j));
                loop(i + 1, chs, list, digits);
                chs.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        String d;
        d = "234";
        System.err.println(handle(d));
        d = "";
        System.err.println(handle(d));
        d = "3";
        System.err.println(handle(d));
    }

}
