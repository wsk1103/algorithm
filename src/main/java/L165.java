/**
 * @author sk
 * @time 2022/9/30
 * @desc say
 **/
public class L165 {

    /*
     * //给你两个版本号 version1 和 version2 ，请你比较它们。
     * //
     * // 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编
     * //号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     * //
     * // 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
     * //如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别
     * //为 0 和 1 ，0 < 1 。
     * //
     * // 返回规则如下：
     * //
     * //
     * // 如果 version1 > version2 返回 1，
     * // 如果 version1 < version2 返回 -1，
     * // 除此之外返回 0。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：version1 = "1.01", version2 = "1.001"
     * //输出：0
     * //解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：version1 = "1.0", version2 = "1.0.0"
     * //输出：0
     * //解释：version1 没有指定下标为 2 的修订号，即视为 "0"
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：version1 = "0.1", version2 = "1.1"
     * //输出：-1
     * //解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 <
     * //version2
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= version1.length, version2.length <= 500
     * // version1 和 version2 仅包含数字和 '.'
     * // version1 和 version2 都是 有效版本号
     * // version1 和 version2 的所有修订号都可以存储在 32 位整数 中
     * //
     * //
     * // Related Topics 双指针 字符串 👍 325 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了67.54% 的Java用户
     * 内存消耗:39.6 MB,击败了41.38% 的Java用户
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int handle(String version1, String version2) {
        System.err.println(version1 + ":" + version2);
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int l1 = s1.length;
        int l2 = s2.length;
        int start1 = 0;
        int start2 = 0;
        while (start1 < l1 && start2 < l2) {
            String tmp1 = s1[start1];
            String tmp2 = s2[start2];
            if (!tmp1.equals(tmp2)) {
                StringBuilder sb1 = new StringBuilder(tmp1);
                StringBuilder sb2 = new StringBuilder(tmp2);
                int sbl1 = sb1.length();
                int sbl2 = sb2.length();
                int start = 0;
                while (start < sbl1 - 1) {
                    if (sb1.charAt(0) == '0') {
                        sb1.delete(0, 1);
                        start++;
                    } else {
                        break;
                    }
                }

                start = 0;
                while (start < sbl2 - 1) {
                    if (sb2.charAt(0) == '0') {
                        sb2.delete(0, 1);
                        start++;
                    } else {
                        break;
                    }
                }
                int i1 = Integer.parseInt(sb1.toString());
                int i2 = Integer.parseInt(sb2.toString());

                if (i1 > i2) {
                    return 1;
                } else if (i1 < i2) {
                    return -1;
                }
            }
            start1++;
            start2++;
        }
        while (start1 < l1) {
            String tmp1 = s1[start1++];
            int sbl1 = tmp1.length();
            int start = 0;
            while (start < sbl1) {
                if (tmp1.charAt(start++) != '0') {
                    return 1;
                }
            }
        }
        while (start2 < l2) {
            String tmp2 = s2[start2++];
            int sbl2 = tmp2.length();
            int start = 0;
            while (start < sbl2) {
                if (tmp2.charAt(start++) != '0') {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * 执行耗时:1 ms,击败了67.54% 的Java用户
     * 内存消耗:39.7 MB,击败了21.23% 的Java用户
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int handle2(String version1, String version2) {
        System.err.println(version1 + ":" + version2);
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int l1 = s1.length;
        int l2 = s2.length;
        int start1 = 0;
        int start2 = 0;
        while (start1 < l1 && start2 < l2) {
            String tmp1 = s1[start1];
            String tmp2 = s2[start2];
            if (!tmp1.equals(tmp2)) {
                int sbl1 = tmp1.length();
                int sbl2 = tmp2.length();
                int start = 0;
                while (start < sbl1 - 1) {
                    if (tmp1.charAt(start) == '0') {
                        start++;
                    } else {
                        break;
                    }
                }
                String ss1 = tmp1.substring(start, sbl1);

                start = 0;
                while (start < sbl2 - 1) {
                    if (tmp2.charAt(start) == '0') {
                        start++;
                    } else {
                        break;
                    }
                }
                String ss2 = tmp2.substring(start, sbl2);
                int i1 = Integer.parseInt(ss1);
                int i2 = Integer.parseInt(ss2);

                if (i1 > i2) {
                    return 1;
                } else if (i1 < i2) {
                    return -1;
                }
            }
            start1++;
            start2++;
        }
        while (start1 < l1) {
            String tmp1 = s1[start1++];
            int sbl1 = tmp1.length();
            int start = 0;
            while (start < sbl1) {
                if (tmp1.charAt(start++) != '0') {
                    return 1;
                }
            }
        }
        while (start2 < l2) {
            String tmp2 = s2[start2++];
            int sbl2 = tmp2.length();
            int start = 0;
            while (start < sbl2) {
                if (tmp2.charAt(start++) != '0') {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1, v2;
        v1 = "0.1";
        v2 = "1.0.0.0";
        System.err.println(handle(v1, v2));
        System.err.println(handle2(v1, v2));
        v1 = "1.0";
        v2 = "1.0.0.0";
        System.err.println(handle(v1, v2));
    }

}
