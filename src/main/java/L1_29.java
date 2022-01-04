/**
 * @author sk
 * @time 2021/12/17
 * @desc say
 **/
public class L1_29 {

    /*
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     *
     *
     *
     * 注意：
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
     *
     *
     * 示例 1：
     *
     * 输入：a = 15, b = 2
     * 输出：7
     * 解释：15/2 = truncate(7.5) = 7
     * 示例 2：
     *
     * 输入：a = 7, b = -3
     * 输出：0
     * 解释：7/-3 = truncate(-2.33333..) = -2
     * 示例 3：
     *
     * 输入：a = 0, b = 1
     * 输出：0
     * 示例 4：
     *
     * 输入：a = 1, b = 1
     * 输出：1
     *
     *
     * 提示:
     *
     * -231 <= a, b <= 231 - 1
     * b != 0
     */

    /**
     * 位运算 加减乘除
     * @param dividend
     * @param divisor
     * @return
     */
    public static int handle(int dividend, int divisor) {
        boolean t = (dividend <= 0 || divisor >= 0) && (dividend >= 0 || divisor <= 0);
        long tempB = divisor;
        long tempA = dividend;
        tempA = Math.abs(tempA);
        tempB = Math.abs(tempB);
        long addB = tempB;
        if (tempA < tempB) {
            return 0;
        }
        long to = 0;
        if (tempB == 1) {
            to = tempA;
        } else {
            while (tempA >= tempB) {
                tempB = addB + tempB;
                to++;
            }
        }
        if (to > Integer.MAX_VALUE) {
            return t ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (to < Integer.MIN_VALUE) {
            return t ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return t ? (int) to : -(int) to;
    }

    public static int handle2(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        long ll = a / b;
        if (ll > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ll < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)ll;
    }

    public static long add(long a, long b) {
        long carry;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static long sub(long a, long b) {
        b = ~b + 1;
        return add(a, b);
    }

    public static long mul(long a, long b) {
        long i = 0;
        long res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res += (a << i);
            }
            b = b >> 1;
            i++;
        }
        return res;
    }

    public static long div(long a, long b) {
        long res;
        if (a < b) {
            return 0;
        } else {
            res = div(sub(a, b), b) + 1;
        }
        return res;
    }

//    public static long div2(long a, long b) {
//        if (a < b) {
//            return 0;
//        }
//    }

    public static int handle3(int dividend, int divisor) {
        boolean t = (dividend <= 0 || divisor >= 0) && (dividend >= 0 || divisor <= 0);
        long to;
        if (divisor == 1) {
            to = dividend;
        } else if (divisor == -1) {
            to = -dividend;
        } else {
            to = div(dividend, divisor);
        }
        if (to > Integer.MAX_VALUE) {
            return t ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (to < Integer.MIN_VALUE) {
            return t ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return t ? (int) to : -(int) to;
    }

    public static void main(String[] args) {
        int a, b;
        a = -2147483648;
        b = -2147483648;
        System.err.println(handle3(a, b));
        a = -2147483648;
        b = 1;
        System.err.println(handle2(a, b));

        a = -5;
        b = 2;
        System.err.println(handle(a, b));
        a = 5;
        b = -2;
        System.err.println(handle(a, b));
        a = -5;
        b = -2;
        System.err.println(handle(a, b));

    }

}
