/**
 * @author sk
 * @time 2022/9/8
 * @desc say
 **/
public class L279 {

    /*
     * //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * //
     * // 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 12
     * //输出：3
     * //解释：12 = 4 + 4 + 4
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 13
     * //输出：2
     * //解释：13 = 4 + 9
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 10⁴
     * //
     * //
     * // Related Topics 广度优先搜索 数学 动态规划 👍 1484 👎 0
     */

    /**
     * 执行耗时:20 ms,击败了91.52% 的Java用户
     * 内存消耗:40.9 MB,击败了28.67% 的Java用户
     * dp[i] 表示i的完全平方和的最少数量，dp[i - j * j] + 1表示减去一个完全平方数j的完全平方之后的数量加1就等于dp[i]
     *
     * @param n
     * @return
     */
    public static int handle4(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //计算构建[i-j^2]所需的最小数
            int min = Integer.MAX_VALUE;
            //构建i的完全平方数范围是[1,根号i]
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了99.01% 的Java用户
     *
     * @param n
     * @return
     */
    public static int handle2(int n) {
        if (isSquares1(n)) {
            return 1;
        }
        if (isSquares2(n)) {
            return 2;
        }
        if (isSquares4(n)) {
            return 4;
        }
        return 3;
    }

    public static boolean isSquares1(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    public static boolean isSquares2(int x) {
        for (int i = 1; i * i <= x; i++) {
            int j = x - i * i;
            if (isSquares1(j)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSquares4(int x) {
        //4^k(8m+7)
        //第一步 除掉4^k次方
        while (x % 4 == 0) {
            x /= 4;
        }
        //第二步判断余数是不是7
        return x % 8 == 7;
    }

    public static void main(String[] args) {
        int n;
        n = 43;
        // 1 4 9 16 25 36 49 64 91
        //43 = 36 + 7 = 36 + 4 + 1 + 1 + 1
        //43 = 25 + 18 = 25 + 9 + 9
        //43 = 16 + 16 + 11
//        System.err.println(handle(n));
        System.err.println(handle2(n));
        System.err.println(handle4(n));
    }

}
