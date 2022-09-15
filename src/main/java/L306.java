/**
 * @author sk
 * @time 2022/9/15
 * @desc say
 **/
public class L306 {

    /*
     * //累加数 是一个字符串，组成它的数字可以形成累加序列。
     * //
     * // 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
     * //
     * // 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
     * //
     * // 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入："112358"
     * //输出：true
     * //解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入："199100199"
     * //输出：true
     * //解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= num.length <= 35
     * // num 仅由数字（0 - 9）组成
     * //
     * //
     * //
     * //
     * // 进阶：你计划如何处理由过大的整数输入导致的溢出?
     * //
     * // Related Topics 字符串 回溯 👍 378 👎 0
     */

    /**
     * 执行耗时:7 ms,击败了6.16% 的Java用户
     * 内存消耗:39.9 MB,击败了17.61% 的Java用户
     *
     * @param num
     * @return
     */
    public static boolean handle(String num) {
        int len = num.length();
        for (int i = 1; i <= len; i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                continue;
            }
            for (int j = i + 1; j <= len; j++) {
                String cur2 = num.substring(i, j);
                if (cur2.length() > 1 && cur2.charAt(0) == '0') {
                    break;
                }
                long n1 = Long.parseLong(cur);
                long n2 = Long.parseLong(cur2);
                long n3 = n1 + n2;
                StringBuilder tmp = new StringBuilder(n1 + "" + n2 + "" + n3);
                while (tmp.length() < len) {
                    n1 = n2;
                    n2 = n3;
                    n3 = n1 + n2;
                    tmp.append(n3);
                }
                if (tmp.toString().equals(num)) {
                    return true;
                }
            }
        }
        return false;
    }

}
