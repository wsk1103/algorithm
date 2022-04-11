/**
 * @author sk
 * @time 2022/4/11
 **/
public class L70 {

    /**
     * //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * //
     * // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 2
     * //输出：2
     * //解释：有两种方法可以爬到楼顶。
     * //1. 1 阶 + 1 阶
     * //2. 2 阶
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 3
     * //输出：3
     * //解释：有三种方法可以爬到楼顶。
     * //1. 1 阶 + 1 阶 + 1 阶
     * //2. 1 阶 + 2 阶
     * //3. 2 阶 + 1 阶
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 45
     * //
     * // Related Topics 记忆化搜索 数学 动态规划 👍 2347 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了79.25% 的Java用户
     *
     * @param n
     * @return
     */
    public static int handle(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        //f(n) = f(n-1) + f(n-2)
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    public static int handle2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return handle2(n - 1) + handle2(n - 2);
    }

    public static void main(String[] args) {
        int n;
        n = 3;
        System.err.println(handle(n));
        n = 4;
        System.err.println(handle(n));
        n = 5;
        System.err.println(handle(n));
    }

}
