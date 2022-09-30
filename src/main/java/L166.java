import java.util.LinkedHashMap;

/**
 * @author sk
 * @time 2022/9/30
 * @desc say
 **/
public class L166 {

    /*
     * //给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
     * //
     * // 如果小数部分为循环小数，则将循环的部分括在括号内。
     * //
     * // 如果存在多个答案，只需返回 任意一个 。
     * //
     * // 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：numerator = 1, denominator = 2
     * //输出："0.5"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：numerator = 2, denominator = 1
     * //输出："2"
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：numerator = 4, denominator = 333
     * //输出："0.(012)"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= numerator, denominator <= 2³¹ - 1
     * // denominator != 0
     * //
     * //
     * // Related Topics 哈希表 数学 字符串 👍 415 👎 0
     */

    /**
     * 执行耗时:2 ms,击败了43.82% 的Java用户
     * 内存消耗:39.1 MB,击败了38.00% 的Java用户
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public static String handle(int numerator, int denominator) {
        System.err.println(numerator + "/" + denominator + "=" + (numerator * 1.0 / denominator));
        if (numerator == 0) {
            return "0";
        }
        boolean b = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Long, Long> map = new LinkedHashMap<>();
        StringBuilder nsb = new StringBuilder();
        boolean point = true;
        while (n != 0) {
            if (map.containsKey(n)) {
                boolean start = false;
                for (Long integer : map.keySet()) {
                    if (start) {
                        nsb.append(map.get(integer));
                    } else if (n == integer) {
                        start = true;
                        nsb.append(map.get(integer));
                    }
                }
                break;
            }
            if (n == d) {
                sb.append(1);
                break;
            } else if (n > d) {
                long index = n / d;
                if (!point) {
                    map.put(n, index);
                }
                sb.append(index);
                n = n % d;
            } else {
                if (!point) {
                    map.put(n, 0L);
                }
                sb.append(0);
            }
            if (point && n < d) {
                point = false;
                sb.append(".");
            }
            n = n * 10;
        }
        if (nsb.length() > 0) {
            int i = sb.indexOf(nsb.toString());
            if (i > 0) {
                sb.replace(i, i + nsb.length(), nsb.insert(0, "(").append(")").toString());
            }
        }
        if (b) {
            sb.insert(0, "-");
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n, d;
        n = 420;
        d = 226;
        //1.(8584070796460176991150442477876106194690265486725663716814159292035398230088495575221238938053097345132743362831)
        //1..858407079646017699115044247787610619469026548672566371681415929203539823008849557522123893805309734513274336283.
        System.err.println(n % d);
        System.err.println(handle(n, d));
        n = 22;
        d = 7;
        System.err.println(n % d);
        System.err.println(handle(n, d));
        n = 4;
        d = 333;
        System.err.println(handle(n, d));
        n = 1;
        d = 3;
        System.err.println(handle(n, d));
    }

}
