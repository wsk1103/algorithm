/**
 * @author sk
 * @time 2022/9/29
 * @desc say
 **/
public class L01_09_ {

    /*
     * //字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * //
     * // 示例1:
     * //
     * //  输入：s1 = "waterbottle", s2 = "erbottlewat"
     * // 输出：True
     * //
     * //
     * // 示例2:
     * //
     * //  输入：s1 = "aa", s2 = "aba"
     * // 输出：False
     * //
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 字符串长度在[0, 100000]范围内。
     * //
     * //
     * // 说明:
     * //
     * //
     * // 你能只调用一次检查子串的方法吗？
     * //
     * //
     * // Related Topics 字符串 字符串匹配 👍 158 👎 0
     */

    /**
     * 执行耗时:13 ms,击败了10.94% 的Java用户
     * 内存消耗:42.1 MB,击败了7.32% 的Java用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean handle(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(s1);
        for (int i = 0; i < len1; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (sb.toString().equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1, s2;
        s1 = "waterbottle";
        s2 = "erbottlewat";
        System.err.println(handle(s1, s2));
    }

}
