import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/9/26
 * @desc say
 **/
public class L383 {

    /*
     * //给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * //
     * // 如果可以，返回 true ；否则返回 false 。
     * //
     * // magazine 中的每个字符只能在 ransomNote 中使用一次。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：ransomNote = "a", magazine = "b"
     * //输出：false
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：ransomNote = "aa", magazine = "ab"
     * //输出：false
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：ransomNote = "aa", magazine = "aab"
     * //输出：true
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= ransomNote.length, magazine.length <= 10⁵
     * // ransomNote 和 magazine 由小写英文字母组成
     * //
     * //
     * // Related Topics 哈希表 字符串 计数 👍 492 👎 0
     */

    /**
     * 执行耗时:5 ms,击败了30.77% 的Java用户
     * 内存消耗:41.8 MB,击败了42.93% 的Java用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean handle(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] rs = ransomNote.toCharArray();
        for (char c : rs) {
            int size = map.getOrDefault(c, 0);
            size++;
            map.put(c, size);
        }
        char[] ms = magazine.toCharArray();
        for (char c : ms) {
            int size = map.getOrDefault(c, 0);
            if (size > 0) {
                size--;
                if (size <= 0) {
                    map.remove(c);
                } else {
                    map.put(c, size);
                }
            }
        }
        return map.isEmpty();
    }

    /**
     * 执行耗时:9 ms,击败了27.85% 的Java用户
     * 内存消耗:41.8 MB,击败了46.10% 的Java用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean handle2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ms = magazine.toCharArray();
        for (char c : ms) {
            int size = map.getOrDefault(c, 0);
            size++;
            map.put(c, size);
        }
        char[] rs = ransomNote.toCharArray();
        for (char c : rs) {
            int size = map.getOrDefault(c, 0);
            if (size == 0) {
                return false;
            } else {
                size--;
                map.put(c, size);
            }
        }
        return true;
    }

}
