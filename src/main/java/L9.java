import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/4/8
 **/
public class L9 {

    /**
     * //输入：x = 121
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：x = -121
     * //输出：false
     * //解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：x = 10
     * //输出：false
     * //解释：从右向左读, 为 01 。因此它不是一个回文数。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= x <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：你能不将整数转为字符串来解决这个问题吗？
     * // Related Topics 数学 👍 1934 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:7 ms,击败了27.22% 的Java用户
     * 内存消耗:40.8 MB,击败了37.28% 的Java用户
     *
     * @param x
     * @return
     */
    public static boolean handle(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int temp = x;
        List<Integer> list = new ArrayList<>();
        long ca = 1;
        while (temp > 0) {
            list.add(temp % 10);
            temp = temp / 10;
            ca *= 10;
        }
        ca /= 10;
        int to = 0;
//        }
        for (Integer i : list) {
            to += i * ca;
            ca /= 10;
        }
        System.err.println(x + " == " + to + ": " + (to == x));
        return to == x;
    }

    /**
     * 解答成功:
     * 执行耗时:5 ms,击败了72.71% 的Java用户
     * 内存消耗:40.5 MB,击败了64.77% 的Java用户
     *
     * @param x
     * @return
     */
    public static boolean handle2(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int temp = x;
        long ca = 1;
        while (temp > 0) {
            temp = temp / 10;
            ca *= 10;
        }
        ca /= 10;
        int ca3 = (int) ca;
        int to = 0;
        temp = x;
        long ca2 = 1;
        while (ca3 > 0) {
            to += ca2 * (temp / ca3);
            temp = temp % ca3;
            ca3 /= 10;
            ca2 = ca2 * 10;
        }
        System.err.println(x + " == " + to + ": " + (to == x));
        return to == x;
    }

    /**
     * 解答成功:
     * 执行耗时:5 ms,击败了72.71% 的Java用户
     * 内存消耗:40.2 MB,击败了79.72% 的Java用户
     *
     * @param x
     * @return
     */
    public static boolean handle3(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        String temp = String.valueOf(x);
        int len = temp.length();
        int tempLen = len - 1;
        for (int i = 0; i < len / 2; i++) {
            if (temp.charAt(i) != temp.charAt(tempLen--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x;
        x = 1001;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        System.err.println(handle3(x));
        x = 1000000001;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        System.err.println(handle3(x));
        x = 445221;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        System.err.println(handle3(x));
        x = 123321;
        System.err.println(handle(x));
        System.err.println(handle2(x));
        System.err.println(handle3(x));
    }
}
