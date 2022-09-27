import java.util.Random;

/**
 * @author sk
 * @time 2022/9/27
 * @desc say
 **/
public class L405 {

    /*
     * //给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     * //
     * // 注意:
     * //
     * //
     * // 十六进制中所有字母(a-f)都必须是小写。
     * // 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
     * // 给定的数确保在32位有符号整数范围内。
     * // 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入:
     * //26
     * //
     * //输出:
     * //"1a"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入:
     * //-1
     * //
     * //输出:
     * //"ffffffff"
     * //
     * //
     * // Related Topics 位运算 数学 👍 255 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了16.26% 的Java用户
     * 内存消耗:38.6 MB,击败了83.50% 的Java用户
     *
     * @param num
     * @return
     */
    public static String handle(int num) {
        System.err.println(num);
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isB = num < 0;
        long num2 = Math.abs((long) num);
        while (num2 != 0) {
            long tmp = num2 % 16;
            sb.append(to(tmp));
            num2 = num2 / 16;
        }
        if (isB) {
            for (int i = 0; i < sb.length(); i++) {
                sb.replace(i, i + 1, to(sb.charAt(i)) + "");
            }
            while (sb.length() < 8) {
                sb.append('f');
            }
            boolean add = true;
            int i = 0;
            while (add && i < sb.length()) {
                char tt = toAdd(sb.charAt(i));
                sb.replace(i, i + 1, tt + "");
                if (tt != '0') {
                    add = false;
                }
                i++;
            }
        }
        return sb.reverse().toString();
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了16.50% 的Java用户
     *
     * @param num
     * @return
     */
    public static String handle2(int num) {
        return Integer.toUnsignedString(num, 16);
    }

    /**
     * a - f = 97 - 102
     * 0 - 9 = 48 - 57
     *
     * @param num
     * @return
     */
    public static char to(long num) {
        if (num >= 10) {
            return (char) (num + 87);
        }
        return (char) (num + 48);
    }

    public static char toAdd(char ch) {
        switch (ch) {
            case 'f':
                return '0';
            case 'e':
                return 'f';
            case 'd':
                return 'e';
            case 'c':
                return 'd';
            case 'b':
                return 'c';
            case 'a':
                return 'b';
            case '9':
                return 'a';
            case '8':
                return '9';
            case '7':
                return '8';
            case '6':
                return '7';
            case '5':
                return '6';
            case '4':
                return '5';
            case '3':
                return '4';
            case '2':
                return '3';
            case '1':
                return '2';
            case '0':
                return '1';
            default:
                return ch;
        }
    }

    public static char to(char ch) {
        switch (ch) {
            case 'f':
                return '0';
            case 'e':
                return '1';
            case 'd':
                return '2';
            case 'c':
                return '3';
            case 'b':
                return '4';
            case 'a':
                return '5';
            case '9':
                return '6';
            case '8':
                return '7';
            case '7':
                return '8';
            case '6':
                return '9';
            case '5':
                return 'a';
            case '4':
                return 'b';
            case '3':
                return 'c';
            case '2':
                return 'd';
            case '1':
                return 'e';
            case '0':
                return 'f';
            default:
                return ch;
        }
    }

    public static void main(String[] args) {
        int num;
        num = -2147483648;
        System.err.println(handle(num));
        System.err.println(handle2(num));

        num = 26;
        System.err.println(handle(num));
        System.err.println(handle2(num));


        Random random = new Random();
        num = random.nextInt(10000000);
        System.err.println(handle(num));
        System.err.println(handle2(num));
    }

}
