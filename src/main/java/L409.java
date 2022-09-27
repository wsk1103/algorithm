import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/27
 * @desc say
 **/
public class L409 {

    /*
     * //给定一个包含大写字母和小写字母的字符串
     * // s ，返回 通过这些字母构造成的 最长的回文串 。
     * //
     * // 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入:s = "abccccdd"
     * //输出:7
     * //解释:
     * //我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入:s = "a"
     * //输入:1
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= s.length <= 2000
     * // s 只由小写 和/或 大写英文字母组成
     * //
     * //
     * // Related Topics 贪心 哈希表 字符串 👍 467 👎 0
     */

    /**
     * 执行耗时:8 ms,击败了23.30% 的Java用户
     * 内存消耗:39.4 MB,击败了86.54% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int size = map.getOrDefault(s.charAt(i), 0);
            size++;
            map.put(s.charAt(i), size);
        }
        int to = 0;
        int ff = 0;
        boolean is = false;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                to += value;
            } else {
                int tmp = value - 1;
                if (tmp > 0) {
                    to += tmp;
                }
                if (!is) {
                    is = true;
                }
            }
        }
        return to + ff + (is ? 1 : 0);
    }

    public static void main(String[] args) {
        //aaabbb aabbba
        String s;
        s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.err.println(handle(s));
    }

}
