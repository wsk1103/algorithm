/**
 * @author sk
 * @time 2021/12/17
 * @desc say
 **/
public class L2_67 {

    /*
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "10"
     * 输出: "101"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     *
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     */

    public static String handle(String a, String b) {
        int al = a.length();
        int bl = b.length();
        StringBuilder to = new StringBuilder();
        int add = 0;
        al--;
        bl--;
        while (al >= 0 && bl >= 0) {
            char ac = a.charAt(al--);
            char bc = b.charAt(bl--);
            int ai = ac - '0';
            int bi = bc - '0';
            int sum = ai + bi + add;
            if (sum > 1) {
                add = 1;
            } else {
                add = 0;
            }
            if (sum == 2) {
                to.insert(0, 0);
            } else if (sum == 3) {
                to.insert(0, 1);
            } else {
                to.insert(0, sum);
            }
        }
        while (al >= 0) {
            int ac = a.charAt(al--) - '0';
            int sum = ac + add;
            if (sum > 1) {
                add = 1;
            } else {
                add = 0;
            }
            if (sum == 2) {
                to.insert(0, 0);
            } else {
                to.insert(0, sum);
            }
        }
        while (bl >= 0) {
            int bc = b.charAt(bl--) - '0';
            int sum = bc + add;
            if (sum > 1) {
                add = 1;
            } else {
                add = 0;
            }
            if (sum == 2) {
                to.insert(0, 0);
            } else {
                to.insert(0, sum);
            }
        }
        if (add == 1) {
            to.insert(0, 1);
        }
        return to.toString();
    }

    public static String handle3(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int la = ca.length - 1;
        int lb = cb.length - 1;
        String to = "";
        boolean isAdd = false;
        while (la >= 0 && lb >= 0) {
            int ia = ca[la--] - '0';
            int ib = cb[lb--] - '0';
            int sum = ia + ib + (isAdd ? 1 : 0);
            isAdd = sum / 2 > 0;
            to = sum % 2 + to;
        }

        while (la >= 0) {
            int ia = ca[la--] - '0';
            int sum = ia + (isAdd ? 1 : 0);
            isAdd = sum / 2 > 0;
            to = sum % 2 + to;
        }

        while (lb >= 0) {
            int ib = cb[lb--] - '0';
            int sum = ib + (isAdd ? 1 : 0);
            isAdd = sum / 2 > 0;
            to = sum % 2 + to;
        }

        if (isAdd) {
            to = "1" + to;
        }
        return to;
    }

    @Deprecated
    /**
     * 越界
     */
    public static String handle2(String a, String b) {
        int a1 = Integer.valueOf(a, 2);
        int b1 = Integer.valueOf(b, 2);
        int re = a1 + b1;
        return Integer.toBinaryString(re);
    }

    public static void main(String[] args) {
        String a, b;
        a = "1";
        b = "111";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
        a = "100";
        b = "101";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
        a = "1001";
        b = "101";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
        a = "100";
        b = "1011";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
        a = "0";
        b = "0";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
        a = "0";
        b = "1";
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        System.err.println(handle3(a, b));
    }

}
