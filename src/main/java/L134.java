import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2022/8/25
 * @desc say
 **/
public class L134 {

    /*
     * //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * //
     * // 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * //
     * // 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * //输出: 3
     * //解释:
     * //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * //因此，3 可为起始索引。
     * //
     * // 示例 2:
     * //
     * //
     * //输入: gas = [2,3,4], cost = [3,4,3]
     * //输出: -1
     * //解释:
     * //你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * //我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * //开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * //开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * //你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * //因此，无论怎样，你都不可能绕环路行驶一周。
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // gas.length == n
     * // cost.length == n
     * // 1 <= n <= 10⁵
     * // 0 <= gas[i], cost[i] <= 10⁴
     * //
     * //
     * // Related Topics 贪心 数组 👍 1023 👎 0
     */

    /**
     * time out
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int handle(int[] gas, int[] cost) {
        System.err.println(JSONUtil.toJsonStr(gas));
        System.err.println(JSONUtil.toJsonStr(cost));
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            boolean cly = false;
            int j = i;
            int last = gas[j];
            boolean can = true;
            while (!cly || j != i) {
                int f = last - cost[j];
                if (f < 0) {
                    can = false;
                    break;
                }
                int next = j + 1;
                if (next >= len) {
                    next = 0;
                    cly = true;
                }
                last = f + gas[next];
                j = next;
            }
            if (can) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 1、如果total_gas >= total_cost，那么必定存在至少一个起点。那么，只要不断排除不可能的点，最后得到的一定是正确的点
     * 2、在上一次重置的时候，既然能作为起始点x，那么，gas[x] - cost[x]必然大于0，那么在新的重置点之前的一个点y，
     * （curr_tank<0,说明任意一个点出发，到达加油站的curr_tank也会小于0）。假定数组长度有0到m（0 1 2 3 ··· m），
     * 0作为第一个起始点，那么gas[0] > cost [m]，而，能到m才出现currt_tank小于0，此时：gas[0:m] < cost[0:m]，gas[0:i] > cost[0:i](0 < i < m)
     * 为了满足上述2个等式，必须满足：gas[i:m] < cost，因此说，任意一个点出发，到达新加油站的curr_tank也会小于0，
     * 所以之前的可以舍去，进行优化。连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个。
     * <p>
     * 执行耗时:2 ms,击败了77.60% 的Java用户
     * 内存消耗:61 MB,击败了61.81% 的Java用户
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int handle2(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                start = i + 1;
                curTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] g;
        int[] c;
        g = new int[]{1, 2, 3, 4, 5};
        c = new int[]{3, 4, 5, 1, 2};
        System.err.println(handle(g, c));
        System.err.println(handle2(g, c));
        g = new int[]{2, 3, 4};
        c = new int[]{3, 4, 3};
        System.err.println(handle(g, c));
        System.err.println(handle2(g, c));
        Random r = new Random();
        g = new int[100];
        c = new int[100];
        for (int i = 0; i < 100; i++) {
            g[i] = r.nextInt(100) + 1;
            c[i] = r.nextInt(100) + 1;
        }
        System.err.println(handle(g, c));
        System.err.println(handle2(g, c));

    }

}
