/**
 * @author sk
 * @time 2022/8/24
 * @desc say
 **/
public class L123 {

    /*
     * //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * //
     * // 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * //
     * // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入：prices = [3,3,5,0,0,3,1,4]
     * //输出：6
     * //解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * //     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * //
     * // 示例 2：
     * //
     * //
     * //输入：prices = [1,2,3,4,5]
     * //输出：4
     * //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     * //     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     * //     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：prices = [7,6,4,3,1]
     * //输出：0
     * //解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * //
     * // 示例 4：
     * //
     * //
     * //输入：prices = [1]
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= prices.length <= 10⁵
     * // 0 <= prices[i] <= 10⁵
     * //
     * //
     * // Related Topics 数组 动态规划 👍 1206 👎 0
     */

    /**
     * 有了前面两个问题的基础，我们首先想通过贪心解决这个问题。但是这个问题不行，因为有最多两比交易的限制。
     * 但是正因为如此这个问题也变得非常容易，我们可以参考第一个问题的解决思路。
     * 我们主要有这样几种状态buy1、buy2、sell1和sell2，涉及的状态方程为
     * <p>
     * buy1 = max(buy1, −prices[i])
     * <p>
     * sell1 = max(sell1, buy1 + prices[i])
     * <p>
     * buy2 = max(buy2, sell1 − prices[i])
     * <p>
     * sell2 = max(sell2, buy2 + prices[i])
     * <p>
     * 然后就是考虑边界问题，很显然buy1[0]=-prices[0]，而sell1=0（相当于买入后再卖出）、
     * buy2-prices[0]（相当于买入后再卖出再买入）、sell2=0（相当于买入后再卖出再买入再卖出）。
     * 最后我们只要只需要返回sell2即可，因为sell2>=sell1一定成立。最后代码就是
     * <p>
     * 执行耗时:2 ms,击败了85.63% 的Java用户
     * 内存消耗:57 MB,击败了54.55% 的Java用户
     *
     * @param prices
     * @return
     */
    public static int handle(int[] prices) {
        int len = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] p;
        p = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.err.println(handle(p));
        p = new int[]{1, 2, 3, 4, 5};
        System.err.println(handle(p));
    }

}
