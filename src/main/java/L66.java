import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/4/11
 **/
public class L66 {

    /**
     * //给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * //
     * // 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * //
     * // 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：digits = [1,2,3]
     * //输出：[1,2,4]
     * //解释：输入数组表示数字 123。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：digits = [4,3,2,1]
     * //输出：[4,3,2,2]
     * //解释：输入数组表示数字 4321。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：digits = [0]
     * //输出：[1]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= digits.length <= 100
     * // 0 <= digits[i] <= 9
     * //
     * // Related Topics 数组 数学 👍 985 👎 0
     */
    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了41.02% 的Java用户
     *
     * @param digits
     * @return
     */
    public static int[] handle(int[] digits) {
        int add = 0;
        int len = digits.length - 1;

        int temp = digits[len] + 1 + add;
        digits[len] = temp % 10;
        add = temp / 10;
        len--;
        while (add > 0) {
            if (len < 0) {
                int[] now = new int[digits.length + 1];
                now[0] = 1;
                System.arraycopy(digits, 0, now, 1, digits.length);
                return now;
            }
            temp = digits[len] + add;
            digits[len] = temp % 10;
            add = temp / 10;
            len--;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{9};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
        n = new int[]{1, 2, 3, 0};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
        n = new int[]{2, 9, 9};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
        n = new int[]{9, 9, 9};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
        n = new int[]{9, 9, 9, 9};
        System.err.println(JSONUtil.toJsonStr(handle(n)));
    }
}
