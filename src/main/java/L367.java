/**
 * @author sk
 * @time 2022/4/21
 **/
public class L367 {

    /**
     * //给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * //
     * // 进阶：不要 使用任何内置的库函数，如 sqrt 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：num = 16
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：num = 14
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= num <= 2^31 - 1
     * //
     * // Related Topics 数学 二分查找 👍 377 👎 0
     */
    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了67.42% 的Java用户
     *
     * @param num
     * @return
     */
    public static boolean handle(int num) {
        int start = 0;
        int end = num;
        while (start <= end) {
            int mid = start + end >> 1;
            long sq = (long) mid * mid;
            if (sq == num) {
                return true;
            } else if (sq > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num;
        num = 16;
        System.err.println(handle(num));
        num = 99;
        System.err.println(handle(num));
        num = 1;
        System.err.println(handle(num));
    }

}
