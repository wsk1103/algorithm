/**
 * @author sk
 * @time 2022/6/30
 **/
public class L14 {

    /*
     * //编写一个函数来查找字符串数组中的最长公共前缀。
     * //
     * // 如果不存在公共前缀，返回空字符串 ""。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：strs = ["flower","flow","flight"]
     * //输出："fl"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：strs = ["dog","racecar","car"]
     * //输出：""
     * //解释：输入不存在公共前缀。
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= strs.length <= 200
     * // 0 <= strs[i].length <= 200
     * // strs[i] 仅由小写英文字母组成
     * //
     * // Related Topics 字符串 👍 2312 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了69.42% 的Java用户
     * 内存消耗:39.5 MB,击败了34.69% 的Java用户
     *
     * @param strs
     * @return
     */
    public static String handle(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int l1 = res.length();
            int l2 = strs[i].length();
            if (l1 == 0 || l2 == 0) {
                return "";
            }
            int min = Math.min(l1, l2);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < min; j++) {
                if (res.charAt(j) == strs[i].charAt(j)) {
                    sb.append(res.charAt(j));
                } else {
                    break;
                }
            }
            res = sb.toString();
        }
        return res;
    }

    /**
     * 执行耗时:1 ms,击败了69.42% 的Java用户
     * 内存消耗:39.2 MB,击败了66.38% 的Java用户
     *
     * @param strs
     * @return
     */
    public static String handle2(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int len = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] re;
        re = new String[]{"flower", "flow", "flight"};
        System.err.println(handle(re));
        System.err.println(handle2(re));
        re = new String[]{"flower"};
        System.err.println(handle(re));
        System.err.println(handle2(re));
        re = new String[]{"dog", "racecar", "car"};
        System.err.println(handle(re));
        System.err.println(handle2(re));
    }

}
