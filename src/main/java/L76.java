import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/21
 * @desc say
 **/
public class L76 {

    /**
     * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
     * <p>
     * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
     * <p>
     * <p>
     * <p>
     * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3：
     * <p>
     * 输入：s = "a", t = "aa"
     * 输出：""
     * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * <p>
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     */


    public static String handle(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        String min = "";
        Map<Character, Integer> sm = new HashMap<>(t.length());
        Map<Character, Integer> tm = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            sm.put(t.charAt(i), sm.getOrDefault(t.charAt(i), 0) + 1);
            tm.put(t.charAt(i), sm.getOrDefault(t.charAt(i), 0) + 1);

        }
        for (int i = 0; i < s.length(); i++) {
            System.err.println(i + " = " + s.charAt(i));
        }
        int left = 0, right = 0;
        while (right < s.length() && left < s.length()) {
            if (sm.containsKey(s.charAt(right))) {
                int temp = sm.get(s.charAt(right));
                temp--;
                if (temp <= 0) {
                    sm.remove(s.charAt(right));
                } else {
                    sm.put(s.charAt(right), temp);
                }
                if (!sm.isEmpty()) {
                    right++;
                }
            } else {
                right++;
            }
            if (sm.isEmpty()) {
                if ((right > left && right - left < min.length()) || min.length() == 0) {
                    min = s.substring(left, right);
                }
                if (left < right) {
                    sm.put(s.charAt(left), 1);
                }
                left++;
                while (!tm.containsKey(s.charAt(left)) && left < right) {
                    left++;
                }
            }


//            if (sm.isEmpty()) {
//                Character temp = s.charAt(left);
//                if (tm.containsKey(s.charAt(left))) {
//                    sm.put(temp, 1);
//                }
//                if (right > left || min.length() == 0) {
//                    min = s.substring(left, right);
//                }
//                left++;
//                while (!sm.containsKey(s.charAt(left)) && left < right) {
//                    left++;
//                }
//            } else {
//                if (sm.containsKey(s.charAt(right))) {
//                    int temp = sm.get(s.charAt(right));
//                    temp--;
//                    if (temp <= 0) {
//                        sm.remove(s.charAt(right));
//                    } else {
//                        sm.put(s.charAt(right), temp);
//                    }
//                    right++;
//                } else {
//                    if (left == right) {
//                        left++;
//                        right++;
//                    } else {
//                        right++;
//                    }
//                }
//            }
        }

        return min;
    }

    public static String handle2(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        String min = "";
        Map<Character, Integer> sm = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            sm.put(t.charAt(i), sm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int count = t.length();
        while (right < s.length()) {
            Character c = s.charAt(right++);
            if (sm.containsKey(c)) {
                int temp = sm.get(c);
                if (temp > 0) {
                    count--;
                }
                temp--;
                sm.put(c, temp);
            }
            while (count == 0) {
                if ((right > left && right - left < min.length()) || min.length() == 0) {
                    min = s.substring(left, right);
                }
                Character cl = s.charAt(left++);
                if (sm.containsKey(cl)) {
                    int temp = sm.get(cl);
                    if (temp == 0) {
                        count++;
                    }
                    sm.put(cl, sm.get(cl) + 1);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s, t;
        s = "ABCDAAQQ";
        t = "ACD";
        System.err.println(handle2(s, t));

        s = "ADOBECODEBANC";
        t = "ABC";
        System.err.println(handle2(s, t));

        s = "a";
        t = "a";
        System.err.println(handle2(s, t));

        s = "a";
        t = "aa";
        System.err.println(handle2(s, t));

        s = "aaaaaaaaaaaa";
        t = "aa";
        System.err.println(handle2(s, t));

        s = "ABC";
        t = "AB";
        System.err.println(handle2(s, t));

        s = "BA";
        t = "AB";
        System.err.println(handle2(s, t));
        s = "bba";
        t = "ab";
        System.err.println(handle2(s, t));
    }

}
