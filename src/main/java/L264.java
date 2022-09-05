/**
 * @author sk
 * @time 2022/9/5
 * @desc say
 **/
public class L264 {

    /*
     * //给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * //
     * // 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 10
     * //输出：12
     * //解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 1
     * //输出：1
     * //解释：1 通常被视为丑数。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 1690
     * //
     * //
     * // Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 963 👎 0
     */

    /**
     * 	执行耗时:2 ms,击败了97.68% 的Java用户
     * 	内存消耗:40.9 MB,击败了37.68% 的Java用户
     * @param n
     * @return
     */
    public static int handle(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

}
