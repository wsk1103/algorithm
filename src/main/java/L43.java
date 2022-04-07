import java.util.Random;

/**
 * @author sk
 * @time 2022/4/7
 **/
public class L43 {

    /**
     * //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * //
     * // 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: num1 = "2", num2 = "3"
     * //输出: "6"
     * //
     * // 示例 2:
     * //
     * //
     * //输入: num1 = "123", num2 = "456"
     * //输出: "56088"
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= num1.length, num2.length <= 200
     * // num1 和 num2 只能由数字组成。
     * // num1 和 num2 都不包含任何前导零，除了数字0本身。
     * //
     * // Related Topics 数学 字符串 模拟 👍 895 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:6 ms,击败了45.21% 的Java用户
     * 内存消耗:41.5 MB,击败了32.41% 的Java用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String handle(String num1, String num2) {
        System.err.println(num1 + " * " + num2);
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        } else if ("1".equals(num1)) {
            return num2;
        } else if ("1".equals(num2)) {
            return num1;
        }
        int[][] ch = new int[num1.length()][];
        int i = num1.length();
        for (int j = i - 1; j >= 0; j--) {
            char[] c2 = num2.toCharArray();
            int[] ct = mul(c2, num1.charAt(j), i - 1 - j);
            ch[j] = ct;
        }
        return add(ch);
    }

    public static int mul(char c1, char c2) {
        int i1 = c1 - '0';
        int i2 = c2 - '0';
        return i1 * i2;
    }

    public static int[] mul(char[] ch, char c, int zero) {
        if (c == '0') {
            return new int[0];
        }
        int l = ch.length;
        int[] to = new int[ch.length + 1 + zero];
        int carry = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            int mul = mul(ch[i], c) + carry;
            carry = mul / 10;
            to[l--] = mul % 10;
        }
        if (carry > 0) {
            to[0] = carry;
        }
        return to;
    }


    public static int[] add(int[] s1, int[] s2) {
        int l1 = s1.length - 1;
        int l2 = s2.length - 1;
        int[] to = new int[Math.max(l1, l2) + 1];
        int ad = 0;
        int l = to.length - 1;
        while (l1 >= 0 && l2 >= 0) {
            int c1 = s1[l1--];
            int c2 = s2[l2--];

            int add = c1 + c2 + ad;
            ad = add / 10;
            add = add % 10;
            to[l--] = add;
        }
        while (l1 >= 0) {
            int add = s1[l1--] + ad;
            ad = add / 10;
            add = add % 10;
            to[l--] = add;
        }
        while (l2 >= 0) {
            int add = s2[l2--] + ad;
            ad = add / 10;
            add = add % 10;
            to[l--] = add;
        }
        if (ad > 0) {
            to[0] = 1;
        }
        return to;
    }

    public static String add(int[][] s) {
        int[] to = s[0];
        for (int i = 1; i < s.length; i++) {
            to = add(to, s[i]);
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int j : to) {
            if (j == 0 && first) {
                continue;
            }
            first = false;
            sb.append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1, s2;
        s1 = "729571827754875494684124673";
        s2 = "65565388";
        //47834659960617580700656571625618124
        System.err.println(handle(s1, s2));
        s1 = "1";
        s2 = "2";
        System.err.println(handle(s1, s2));
        s1 = "123";
        s2 = "25";
        System.err.println(handle(s1, s2));
        s1 = "25";
        s2 = "123";
        System.err.println(handle(s1, s2));
        s1 = "255555";
        s2 = "1236666";
        System.err.println(handle(s1, s2));
        Random r = new Random();
        s1 = "";
        for (int i = 0; i < r.nextInt(200) + 1; i++) {
            s1 += r.nextInt(9) + 1;
        }
        s2 = "";
        for (int i = 0; i < r.nextInt(200) + 1; i++) {
            s2 += r.nextInt(9) + 1;
        }
        System.err.println(handle(s1, s2));
    }

}
