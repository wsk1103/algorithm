/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L204 {

    /*
     * //给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 10
     * //输出：4
     * //解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 0
     * //输出：0
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 1
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= n <= 5 * 10⁶
     * //
     * //
     * // Related Topics 数组 数学 枚举 数论 👍 936 👎 0
     */

    /**
     * 算法思路：厄拉多塞筛法。比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.
     * 2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
     * 执行耗时:115 ms,击败了70.20% 的Java用户
     * 内存消耗:45.8 MB,击败了62.34% 的Java用户
     *
     * @param n
     * @return
     */
    public static int handle(int n) {
        System.err.println(n);
        int res = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                res++;
                for (int j = i * 2; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        n = 10;
        System.err.println(handle(n));
        n = (int) (5 * Math.pow(10, 5));
        System.err.println(handle(n));
    }

}
