import java.util.Random;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L201 {

    /*
     * //给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
     * //。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：left = 5, right = 7
     * //输出：4
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：left = 0, right = 0
     * //输出：0
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：left = 1, right = 2147483647
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= left <= right <= 2³¹ - 1
     * //
     * //
     * // Related Topics 位运算 👍 398 👎 0
     */

    /**
     * 找规律。
     * <p>
     * 我们只观察后面 6 位二进制。假设 l = 5, r = 7，那么：
     * <p>
     * 5 0 0 1 0 1
     * 6 0 0 1 1 0
     * 7 0 0 1 1 1
     * 可以发现，5 和 7 有一部分公共前缀 0 0 1
     * <p>
     * 假设 l = 5, r = 8，那么：
     * <p>
     * 5 0 0 1 0 1
     * 6 0 0 1 1 0
     * 7 0 0 1 1 1
     * 8 0 1 0 0 0
     * 可以发现，5 和 8 有一部分公共前缀 0
     * <p>
     * 而对于 l 和 r ，如果它们有公共的前缀，那么对于 [l + 1, r - 1] ，它们一定有相同的公共前缀。对于剩下的部分，0 和 1 都有，按位与 肯定为 0。
     * <p>
     * 所以，这题就是求 l 与 r 的公共前缀。
     * <p>
     * <p>
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了51.63% 的Java用户
     *
     * @param left
     * @param right
     * @return
     */
    public static int handle(int left, int right) {
        if (left == right) {
            return left;
        }
        int ret = 0;
        int l, r;
        for (int i = 31; i >= 0; i--) {
            l = left >> i;
            r = right >> i;
            if (l == r) {
                if ((l & 1) == 1) {
                    ret |= 1 << i;
                }
            } else {
                break;
            }
        }
        return ret;
    }

    /**
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了55.28% 的Java用户
     *
     * @param left
     * @param right
     * @return
     */
    public static int handle2(int left, int right) {
        while (right > left) {
            right &= right - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int left, right;
        left = 5;
        right = 7;
        System.err.println(handle(left, right));
        System.err.println(handle2(left, right));
        left = 0;
        right = 0;
        System.err.println(handle(left, right));
        System.err.println(handle2(left, right));
        left = 1;
        right = 2147483647;
        System.err.println(handle(left, right));
        System.err.println(handle2(left, right));
        left = 5;
        right = 16;
        System.err.println(handle(left, right));
        System.err.println(handle2(left, right));
        Random random = new Random();
        left = random.nextInt(10000);
        right = random.nextInt(10000) + left;
        System.err.println(handle(left, right));
        System.err.println(handle2(left, right));
    }

}
