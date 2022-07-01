/**
 * @author sk
 * @time 2022/7/1
 **/
public class L50 {

    /*
     * //实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：x = 2.00000, n = 10
     * //输出：1024.00000
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：x = 2.10000, n = 3
     * //输出：9.26100
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：x = 2.00000, n = -2
     * //输出：0.25000
     * //解释：2-2 = 1/22 = 1/4 = 0.25
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -100.0 < x < 100.0
     * // -231 <= n <= 231-1
     * // -104 <= xⁿ <= 104
     * //
     * // Related Topics 递归 数学 👍 984 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了37.10% 的Java用户
     *
     * @param x
     * @param n
     * @return
     */
    public static double handle(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.err.println(handle(2, 5));
        System.err.println(handle(2, -5));
    }

}
