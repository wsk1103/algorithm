/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L231 {

    /*
     * //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * //
     * // 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 1
     * //输出：true
     * //解释：2⁰ = 1
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 16
     * //输出：true
     * //解释：2⁴ = 16
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 3
     * //输出：false
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：n = 4
     * //输出：true
     * //
     * //
     * // 示例 5：
     * //
     * //
     * //输入：n = 5
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= n <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：你能够不使用循环/递归解决此问题吗？
     * //
     * // Related Topics 位运算 递归 数学 👍 532 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了16.57% 的Java用户
     * 内存消耗:38.5 MB,击败了88.68% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle(int n) {
        System.err.println(n);
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        while (n != 1) {
            if ((n & 1) == 1) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了38.09% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle2(int n) {
        if (n <= 0) {
            return false;
        } else if (n <= 2) {
            return true;
        }
        int a = n - 1;
        a |= a >>> 1;
        a |= a >>> 2;
        a |= a >>> 4;
        a |= a >>> 8;
        a |= a >>> 16;
        a = a + 1;
        return n == a;
    }

    public static void main(String[] args) {
        System.err.println(handle(6));
        System.err.println(handle2(6));
        System.err.println(handle(4));
        System.err.println(handle2(4));
        System.err.println(handle(8));
        System.err.println(handle2(8));
        System.err.println(handle(Integer.MAX_VALUE >> 1));
        System.err.println(handle2(Integer.MAX_VALUE >> 1));
        System.err.println(handle(Integer.MAX_VALUE));
        System.err.println(handle2(Integer.MAX_VALUE));
    }

}
