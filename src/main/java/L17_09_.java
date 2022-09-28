/**
 * @author sk
 * @time 2022/9/28
 * @desc say
 **/
public class L17_09_ {

    /*
     * //有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
     * //5，7，9，15，21。
     * //
     * // 示例 1:
     * //
     * // 输入: k = 5
     * //
     * //输出: 9
     * //
     * //
     * // Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 131 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了82.32% 的Java用户
     *
     * @param k
     * @return
     */
    public static int handle(int k) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[a] * 3, dp[b] * 5), dp[c] * 7);
            if (dp[i] == dp[a] * 3) {
                a++;
            }
            if (dp[i] == dp[b] * 5) {
                b++;
            }
            if (dp[i] == dp[c] * 7) {
                c++;
            }
        }
        return dp[k - 1];
    }

}
