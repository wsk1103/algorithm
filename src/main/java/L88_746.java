/**
 * @author sk
 * @time 2021/11/24
 * @desc say
 **/
public class L88_746 {

    /*
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     *
     * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
     *
     * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     *
     *
     *
     * 示例 1：
     *
     * 输入：cost = [10, 15, 20]
     * 输出：15
     * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
     *  示例 2：
     *
     * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出：6
     * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
     *
     *
     * 提示：
     *
     * 2 <= cost.length <= 1000
     * 0 <= cost[i] <= 999
     *
     * f(0) = 0
     * f(1) = 0
     * f(2) = min(dp[1], dp[0]), i = 1
     * t = i + 1
     * f(t) = min(f(t-3) + dp[i] + dp[i-2], f(t-2) + dp[i-1])
     */

    /**
     * f(0) = 0
     * f(1) = 0
     * f(2) = min(dp[1], dp[0]), i = 1
     * t = i + 1
     * f(t) = min(f(t-3) + dp[i] + dp[i-2], f(t-2) + dp[i-1])
     * @param cost
     * @return
     */
    public static int handle(int[] cost) {
        int[] sum = new int[cost.length + 1];
        sum[0] = 0;
        sum[1] = 0;
        sum[2] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            int ii = i + 1;
            int t1;
            if (i - 3 < 0) {
                t1 = cost[i - 2] + cost[i];
            } else {
                t1 = sum[ii - 3] + cost[i - 2] + cost[i];
            }
            int t2 = sum[ii - 2] + cost[i - 1];
            sum[ii] = Math.min(t1, t2);
        }
        return sum[cost.length];
    }

    public static int handle2(int[] cost) {
        int[] sum = new int[cost.length + 1];
        sum[0] = 0;
        sum[1] = 0;
        sum[2] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            int ii = i + 1;
            int t1;
            t1 = sum[ii - 3] + cost[i - 2] + cost[i];
            int t2 = sum[ii - 2] + cost[i - 1];
            sum[ii] = Math.min(t1, t2);
        }
        return sum[cost.length];
    }

    /**
     * f(0) = 0
     * f(2) = 0
     * f(i) = min(f(i-1), f(i-2)) + dp[i]
     * @param cost
     * @return min(f(n), f(n-1))
     */
    public static int handle3(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost;
        cost = new int[]{10, 20, 23, 40};
        System.err.println(handle(cost));
        System.err.println(handle2(cost));
        System.err.println(handle3(cost));
        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1, 1, 1};
        System.err.println(handle(cost));
        System.err.println(handle2(cost));
        System.err.println(handle3(cost));
        cost = new int[]{1, 100};
        System.err.println(handle(cost));
        System.err.println(handle2(cost));
        System.err.println(handle3(cost));
        cost = new int[]{10, 15, 20};
        System.err.println(handle(cost));
        System.err.println(handle2(cost));
        System.err.println(handle3(cost));
    }

}
