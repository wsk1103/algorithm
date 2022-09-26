import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/26
 * @desc say
 **/
public class L387 {

    /*
     * //给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入: s = "leetcode"
     * //输出: 0
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: s = "loveleetcode"
     * //输出: 2
     * //
     * //
     * // 示例 3:
     * //
     * //
     * //输入: s = "aabb"
     * //输出: -1
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // 1 <= s.length <= 10⁵
     * // s 只包含小写字母
     * //
     * //
     * // Related Topics 队列 哈希表 字符串 计数 👍 605 👎 0
     */

    /**
     * 执行耗时:24 ms,击败了48.38% 的Java用户
     * 内存消耗:42 MB,击败了34.97% 的Java用户
     *
     * @param s
     * @return
     */
    public static int handle(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            int size = map.getOrDefault(ch, 0);
            size++;
            map.put(ch, size);
        }
        int index = 0;
        for (char ch : chs) {
            int size = map.getOrDefault(ch, -1);
            if (size == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s;
        s = "loveleetcode";
        System.err.println(handle(s));
    }

}
