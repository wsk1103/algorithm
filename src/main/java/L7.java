/**
 * @author sk
 * @time 2022/6/29
 **/
public class L7 {

    /*
     * //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * //
     * // 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。
     * //假设环境不允许存储 64 位整数（有符号或无符号）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：x = 123
     * //输出：321
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：x = -123
     * //输出：-321
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：x = 120
     * //输出：21
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：x = 0
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= x <= 2³¹ - 1
     * //
     * // Related Topics 数学 👍 3549 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了41.66% 的Java用户
     * 内存消耗:38.8 MB,击败了41.20% 的Java用户
     *
     * @param x
     * @return
     */
    public static int handle(int x) {
        String s = String.valueOf(x);
        boolean isM = false;
        if (s.startsWith("-")) {
            isM = true;
            s = s.substring(1);
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isZero) {
                if (c == '0') {
                    continue;
                }
                isZero = false;
            }
            sb.append(s.charAt(i));
        }
        if (isM) {
            String min = "2147483648";
            if (sb.length() == min.length()) {
                if (sb.charAt(0) > min.charAt(0)) {
                    return 0;
                } else if (sb.charAt(0) == min.charAt(0)) {
                    for (int i = 1; i < min.length(); i++) {
                        if (sb.charAt(i - 1) == min.charAt(i - 1) && sb.charAt(i) > min.charAt(i)) {
                            return 0;
                        }
                    }
                }
            }
            sb.insert(0, "-");
        } else {
            String max = "2147483647";
            if (sb.length() == max.length()) {
                if (sb.charAt(0) > max.charAt(0)) {
                    return 0;
                } else if (sb.charAt(0) == max.charAt(0)) {
                    for (int i = 1; i < max.length(); i++) {
                        if (sb.charAt(i - 1) == max.charAt(i - 1) && sb.charAt(i) > max.charAt(i)) {
                            return 0;
                        }
                    }
                }
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 执行耗时:2 ms,击败了15.67% 的Java用户
     * 内存消耗:39.1 MB,击败了9.64% 的Java用户
     *
     * @param x
     * @return
     */
    public static int handle2(int x) {
        String s = String.valueOf(x);
        boolean isM = false;
        if (s.startsWith("-")) {
            isM = true;
            s = s.substring(1);
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isZero) {
                if (c == '0') {
                    continue;
                }
                isZero = false;
            }
            sb.append(s.charAt(i));
        }
        if (isM) {
            sb.insert(0, "-");
        }
        if (sb.length() == 0) {
            return 0;
        }
        try {
            int l = Integer.parseInt(sb.toString());
            return l;
        } catch (Exception e) {
            return 0;
        }
        //return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int x;
        x = -2147483412;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = 120;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = 321;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = -120;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = 2147483647;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = 214783647;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = -2147483648;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        x = -214743648;
        System.err.println(handle(x));
        System.err.println(handle2(x));
//        System.err.println(Integer.MAX_VALUE);
//        System.err.println(Integer.MIN_VALUE);
    }

}
