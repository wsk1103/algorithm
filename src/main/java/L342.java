/**
 * @author sk
 * @time 2022/9/19
 * @desc say
 **/
public class L342 {

    /*
     * //给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     * //
     * // 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 16
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 5
     * //输出：false
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 1
     * //输出：true
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
     * // 进阶：你能不使用循环或者递归来完成本题吗？
     * //
     * // Related Topics 位运算 递归 数学 👍 318 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了13.21% 的Java用户
     * 内存消耗:38.5 MB,击败了87.02% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了32.35% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle2(int n) {
        // 排除小于等于0的数和非2的幂次方的数
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }
        return n % 3 == 1;
    }

    public static void main(String[] args) {
        long n = 1;
        while (n < Integer.MAX_VALUE) {
            n *= 4;
        }
        n /= 4;
        System.err.println(n);
        n = 16;
        System.err.println(handle2((int) n));
        System.err.println(1073741824 % 12);
        System.err.println(1073741824 % 6);
        System.err.println(1073741824 % 8);
    }

}
