/**
 * @author sk
 * @time 2022/8/26
 * @desc say
 **/
public class L168 {

    /*
     * //给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * //
     * // 例如：
     * //
     * //
     * //A -> 1
     * //B -> 2
     * //C -> 3
     * //...
     * //Z -> 26
     * //AA -> 27
     * //AB -> 28
     * //...
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：columnNumber = 1
     * //输出："A"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：columnNumber = 28
     * //输出："AB"
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：columnNumber = 701
     * //输出："ZY"
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：columnNumber = 2147483647
     * //输出："FXSHRXW"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= columnNumber <= 2³¹ - 1
     * //
     * //
     * // Related Topics 数学 字符串 👍 551 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了94.45% 的Java用户
     *
     * @param columnNumber
     * @return
     */
    public static String handle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 26) {
            int temp = columnNumber % 26;
            columnNumber = columnNumber / 26;
            if (temp == 0) {
                temp = 26;
                columnNumber = columnNumber - 1;
            }
            sb.insert(0, (char) (temp + 64));
        }
        sb.insert(0, (char) (columnNumber + 64));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.err.println(handle(1));
        System.err.println(handle(28));
        System.err.println(handle(701));
        System.err.println(handle(2147483647));
    }

}
