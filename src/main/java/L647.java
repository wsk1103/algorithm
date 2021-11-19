import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/25
 * @desc say
 **/
public class L647 {

    /**
     * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由小写英文字母组成
     */

    // abccba  aaaaaaa
    public static int handle(String s) {
        Map<Character, List<Integer>> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list;
            if (map.containsKey(s.charAt(i))) {
                list = map.get(s.charAt(i));
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(s.charAt(i), list);
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                ret++;
                continue;
            }
            List<Integer> list = map.get(s.charAt(i));
            for (int j = list.size() - 1; j >= 0; j--) {
                int num = list.get(j);
                if (num < i) {
                    break;
                }
                if (num == i) {
                    ret++;
                    break;
                } else {
                    if (loop(s, i, num)) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static boolean loop(String s, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (s.charAt(l) == s.charAt(r)) {
            return loop(s, ++l, --r);
        }
        return false;
    }

    //TODO 2.中心拓展
    public static int handle2(String s) {
        return 0;
    }
    public static void main(String[] args) {
        String s;
        s = "aabccba";
        System.err.println(handle(s));
        s = "aaa";
        System.err.println(handle(s));
        s = "abc";
        System.err.println(handle(s));
        s = "aba";
        System.err.println(handle(s));

        s = "abccbaabccbaabccbaabccbaabccba";
        System.err.println(handle(s));
    }

}
