/**
 * @author sk
 * @time 2022/9/26
 * @desc say
 **/
public class L374 {

    /*
     * //猜数字游戏的规则如下：
     * //
     * //
     * // 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * // 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * //
     * //
     * // 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
     * //
     * //
     * // -1：我选出的数字比你猜的数字小 pick < num
     * // 1：我选出的数字比你猜的数字大 pick > num
     * // 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     * //
     * //
     * // 返回我选出的数字。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 10, pick = 6
     * //输出：6
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 1, pick = 1
     * //输出：1
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：n = 2, pick = 1
     * //输出：1
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：n = 2, pick = 2
     * //输出：2
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 2³¹ - 1
     * // 1 <= pick <= n
     * //
     * //
     * // Related Topics 二分查找 交互 👍 255 👎 0
     */

    /**
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:37.9 MB,击败了97.73% 的Java用户
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int gg = guess(mid);
            if (gg == 0) {
                return mid;
            } else if (gg > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int p;

    static int guess(int num) {
        return Integer.compare(p, num);
    }

    public static void main(String[] args) {
        System.err.println(Integer.MAX_VALUE);
        int n;
        p = 6;
        n = 10;
        System.err.println(guessNumber(n));
    }

}
