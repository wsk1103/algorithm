import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/20
 * @desc say
 **/
public class L567 {

    /*
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * <p>
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     *
     * 其实我们并不需要生成字符串的所有排列，只需要将第一个字符串的各个字符及其个数用map存起来，然后在第二个字符串中取与s1等长的字符串，
     * 也用map存起来，然后对比两个map中相同的字符，它的个数是否相同，如果相同的话，就能说明第一个字符串的排列之一是第二个字符串的子串
     * //滑动窗口 + map
     */

    public static boolean handle(String s1, String s2) {
        System.err.println();
        int fei1 = 0;
        int sum = 0;
        for (char c : s1.toCharArray()) {
            int temp = 1 << (c - 'a');
            fei1 |= temp;
            sum += temp;
        }

        char[] c2 = s2.toCharArray();
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int fei2 = 0;
            int sum2 = 0;
            for (int j = i; j < i + s1.length(); j++) {
                int temp = 1 << (c2[j] - 'a');
                fei2 |= temp;
                sum2 += temp;
            }
            if (fei1 == fei2 && sum == sum2) {
                return true;
            }
        }
        return false;
    }

    public static boolean handle2(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = 0;
        while (l <= r && l < l2 && r < l2) {
            char c = s2.charAt(r);
            if (map.containsKey(c)) {
                int i = map.get(c);
                map.put(c, i - 1);
                if (sum(map)) {
                    return true;
                }
                if (r - l >= l1 - 1) {
                    char lc = s2.charAt(l);
                    if (map.containsKey(lc)) {
                        map.put(lc, map.get(lc) + 1);
                    }
                    r++;
                    l++;
                } else {
                    r++;
                }
            } else {
                for (int i = l; i < r; i++) {
                    char lc = s2.charAt(i);
                    if (map.containsKey(lc)) {
                        map.put(lc, map.get(lc) + 1);
                    }
                }
                r++;
                l = r;
            }

        }
        return false;
    }

    public static boolean handle3(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int count = l1;
        int[] arr = new int[26];
        for (int i = 0; i < l1; i++) {
            char c = s1.charAt(i);
            int temp = c - 'a';
            arr[temp]++;
        }
        int left = 0;
        int right = 0;
        while (right < l2) {
            char c = s2.charAt(right++);
            int temp = c - 'a';
            if (arr[temp]-- >= 1) {
                count--;
            }
            if (count == 0) {
                return true;
            }
            char lc = s2.charAt(left);
            temp = lc - 'a';
            if (right - left == l1) {
                left++;
                if (arr[temp]++ >= 0) {
                    count++;
                }
            }
        }
        return false;
    }

    private static boolean sum(Map<Character, Integer> map) {
        for (Integer set : map.values()) {
            if (set != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s2 = "eidboaoo";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "a";
        s2 = "eidboaoo";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "o";
        s2 = "eidboaoo";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "abc";
        s2 = "ccccbbbbaaaa";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "dbb";
        s2 = "ccc";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));

        s1 = "hello";
        s2 = "ooolleoooleh";
        System.err.println(handle(s1, s2));
        System.err.println(handle2(s1, s2));
        System.err.println(handle3(s1, s2));
    }

}
