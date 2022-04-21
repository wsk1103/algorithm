import java.util.Random;

/**
 * @author sk
 * @time 2022/4/21
 **/
public class L258 {

    /**
     * //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: num = 38
     * //输出: 2
     * //解释: 各位相加的过程为：
     * //38 --> 3 + 8 --> 11
     * //11 --> 1 + 1 --> 2
     * //由于 2 是一位数，所以返回 2。
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: num = 0
     * //输出: 0
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= num <= 2³¹ - 1
     * //
     * //
     * //
     * //
     * // 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
     * // Related Topics 数学 数论 模拟 👍 508 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了39.16% 的Java用户
     *
     * @param num
     * @return
     */
    public static int handle(int num) {
        System.err.println(num);
//        if (num < 10) {
//            return num;
//        }
        int to;
        do {
            to = 0;
            while (num > 0) {
                to += num % 10;
                num = num / 10;
            }
        } while (to >= 10);
        return to;
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了86.64% 的Java用户
     * ab = 10a + b
     * ab = 9a + a + b
     * ab - 9a = a + b
     * @param num
     * @return
     */
    public static int handle2(int num) {
        if (num == 0) {
            return 0;
        }
        int i = num % 9;
        return i == 0 ? 9 : i;
    }

    public static void main(String[] args) {
        int num;
        num = 51;
        System.err.println(handle(num));
        System.err.println(handle2(num));

        num = 38;
        System.err.println(handle(num));
        System.err.println(handle2(num));
        num = 0;
        System.err.println(handle(num));
        System.err.println(handle2(num));
        num = 1;
        System.err.println(handle(num));
        System.err.println(handle2(num));
        num = Integer.MAX_VALUE;
        System.err.println(handle(num));
        System.err.println(handle2(num));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            num = random.nextInt(Integer.MAX_VALUE);
            System.err.println(handle(num));
            System.err.println(handle2(num));
        }
    }


}
