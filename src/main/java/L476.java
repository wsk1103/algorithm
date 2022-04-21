import java.util.Random;

/**
 * @author sk
 * @time 2022/4/21
 **/
public class L476 {

    /**
     * //对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
     * //
     * //
     * // 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
     * //
     * //
     * // 给你一个整数 num ，输出它的补数。
     * //
     * //
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：num = 5
     * //输出：2
     * //解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：num = 1
     * //输出：0
     * //解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= num < 2³¹
     * //
     * //
     * //
     * //
     * // 注意：本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相
     * //同
     * // Related Topics 位运算 👍 296 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了17.07% 的Java用户
     * 内存消耗:38 MB,击败了81.76% 的Java用户
     *
     * @param num
     * @return
     */
    public static int handle(int num) {
        System.err.println(num);
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        int sum = 0;
        int len = sb.length();
        int car = len - 1;
        for (int i = 0; i < len; i++) {
            int tem = sb.charAt(i) - '0';
            if (tem != 0) {
                sum += 1 << car;
            }
            car--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num;
        num = 5;
//        System.err.println(handle(num));
        num = 1;
//        System.err.println(handle(num));
        num = 0;
//        System.err.println(handle(num));
        num = 2;
        System.err.println(handle(num));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            num = random.nextInt(Integer.MAX_VALUE);
            System.err.println(handle(num));
        }
    }
}
