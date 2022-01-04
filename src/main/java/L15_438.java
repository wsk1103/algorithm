import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/10/20
 * @desc say
 **/
public class L15_438 {

    /*
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 变位词 指字母相同，但排列不同的字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     * 滑动模块(双指针)
     */

    public static List<Integer> handle(String s, String p) {
        List<Integer> to = new ArrayList<>();
        if (p.length() > s.length()) {
            return to;
        }
        if (s.equals(p)) {
            to.add(0);
            return to;
        }
        int fei1 = 0;
        int sum = 0;
        for (char c : p.toCharArray()) {
            int temp = 1 << (c - 'a');
            fei1 |= temp;
            sum += temp;
        }
//        System.err.println(Integer.toBinaryString(sum));

        char[] c2 = s.toCharArray();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int fei2 = 0;
            int sum2 = 0;
            for (int j = i; j < i + p.length(); j++) {
                int temp = 1 << (c2[j] - 'a');
                fei2 |= temp;
                sum2 += temp;
            }
//            System.err.println(Integer.toBinaryString(sum2));
            if (fei1 == fei2 && sum == sum2) {
                to.add(i);
            }
        }
        return to;
    }

    public static List<Integer> handle2(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        List<Integer> to = new ArrayList<>();
        if (l2 > l1) {
            return to;
        }
        int count = l2;
        int left = 0;
        int right = 0;
        int[] arr = new int[26];
        for (int i = 0; i < l2; i++) {
            char c = p.charAt(i);
            int temp = c - 'a';
            arr[temp] = arr[temp] + 1;
        }
        while (right < l1) {
            char c = s.charAt(right++);
            int temp = c - 'a';
            if (arr[temp]-- >= 1) {
                count--;
            }
            if (count == 0) {
                to.add(left);
            }
            char lc = s.charAt(left);
            temp = lc - 'a';
            if ((right - left) == l2) {
                left++;
                if (arr[temp]++ >= 0) {
                    count++;
                }
            }
        }
        return to;
    }

    public static void main(String[] args) {
        String s, p;
        s = "cbaebabacd";
        p = "abc";
        System.err.println(JSON.toJSONString(handle(s, p)));
        System.err.println(JSON.toJSONString(handle2(s, p)));

        s = "abab";
        p = "ab";
        System.err.println(JSON.toJSONString(handle(s, p)));
        System.err.println(JSON.toJSONString(handle2(s, p)));
    }

}
