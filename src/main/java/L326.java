import java.util.Random;

/**
 * @author sk
 * @time 2022/9/19
 * @desc say
 **/
public class L326 {

    /*
     * //给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * //
     * // 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 27
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 0
     * //输出：false
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 9
     * //输出：true
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：n = 45
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
     * // 进阶：你能不使用循环或者递归来完成本题吗？
     * //
     * // Related Topics 递归 数学 👍 269 👎 0
     */

    /**
     * 执行耗时:8 ms,击败了82.26% 的Java用户
     * 内存消耗:41.1 MB,击败了56.65% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle(int n) {
        System.err.println(n);
//        if (n < 3) {
//            return false;
//        }
        while (n > 3) {
            int tmp = n % 3;
            if (tmp != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 3 || n == 1;
    }

    public static boolean handle2(int n) {
        System.err.println(n);
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 题中n的范围是-2^31 <= n <= 2^31 - 1，而在这个范围内3的最大幂是1162261467，在比他大就超过int表示的范围了，
     * 我们直接用它对n求余即可，过求余的结果是0，说明n是3的幂次方
     * <p>
     * 执行耗时:8 ms,击败了82.26% 的Java用户
     * 内存消耗:40.9 MB,击败了84.61% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle3(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public static void main(String[] args) {
        int n;
        n = 6;
        System.err.println(handle(n));
        n = 5;
        System.err.println(handle(n));
        n = 3;
        System.err.println(handle(n));
        n = 9;
        System.err.println(handle(n));
        n = -1;
        System.err.println(handle(n));
        Random random = new Random();
        System.err.println(handle(random.nextInt(10000)));
    }

}
