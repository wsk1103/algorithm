import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L202 {

    /*
     * //编写一个算法来判断一个数 n 是不是快乐数。
     * //
     * // 「快乐数」 定义为：
     * //
     * //
     * // 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * // 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * // 如果这个过程 结果为 1，那么这个数就是快乐数。
     * //
     * //
     * // 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：n = 19
     * //输出：true
     * //解释：
     * //1² + 9² = 82
     * //8² + 2² = 68
     * //6² + 8² = 100
     * //1² + 0² + 0² = 1
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：n = 2
     * //输出：false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= n <= 2³¹ - 1
     * //
     * //
     * // Related Topics 哈希表 数学 双指针 👍 1051 👎 0
     */

    /**
     * 执行耗时:1 ms,击败了79.39% 的Java用户
     * 内存消耗:38.9 MB,击败了35.79% 的Java用户
     *
     * @param n
     * @return
     */
    public static boolean handle(int n) {
        System.err.println(n);
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n > 1) {
            int add = 0;
            while (n != 0) {
                add += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = add;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n;
        n = 19;
//        System.err.println(handle(n));
//        n = 2;
//        System.err.println(handle(n));
        n = 7;
        System.err.println(handle(n));
        n = 9400;
        System.err.println(handle(n));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            n = random.nextInt(10000) + 1;
            System.err.println(handle(n));
        }
    }

}
