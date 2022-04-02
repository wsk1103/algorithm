/**
 * @author sk
 * @time 2022/4/2
 **/
public class L6 {

    /*
     * //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * //
     * // 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * //
     * //
     * //P   A   H   N
     * //A P L S I I G
     * //Y   I   R
     * //
     * // 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * //
     * // 请你实现这个将字符串进行指定行数变换的函数：
     * //
     * //
     * //string convert(string s, int numRows);
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "PAYPALISHIRING", numRows = 3
     * //输出："PAHNAPLSIIGYIR"
     * //
     * //示例 2：
     * //
     * //
     * //输入：s = "PAYPALISHIRING", numRows = 4
     * //输出："PINALSIGYAHRPI"
     * //解释：
     * //P     I    N
     * //A   L S  I G
     * //Y A   H R
     * //P     I
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "A", numRows = 1
     * //输出："A"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 1000
     * // s 由英文字母（小写和大写）、',' 和 '.' 组成
     * // 1 <= numRows <= 1000
     * //
     * // Related Topics 字符串 👍 1633 👎 0
     */

    /**
     * 通过观察可以发现，每一个周期的字符数=2∗numRows−2，由此我们可以进行取模运算，进行规约。进行取模运算后，
     * 我们就可以得到索引 i 在这个周期中的序号数 t。我们将根据这个序号数 t 求得 r 和 c。
     *
     * 我们可以发现每个周期的第一列比较特殊，一共有 numRows 个字符，所以我们由此为分界点。
     *
     * 如果 t <= numRows - 1 ，那么 r = t ，每一个周期有 numRows - 1 列，因此 c = (i/(2*numRows - 2))*(numRows-1)。
     * 否则，r = 2*numRows - 2 - t; c = (i/(2*numRows-2))*(numRows-1) + i%(2*numRows-2)-(numRows-1);
     * @param s
     * @param numRows
     * @return
     */
    public static String handle(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder to = new StringBuilder();
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycle) {
                to.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycle - i < len) {
                    to.append(s.charAt(j + cycle - i));
                }
            }
        }
        return to.toString();
    }

    public static void main(String[] args) {
        String s;
        int n;
        s = "PAYPALISHIRING";
        n = 4;
        System.err.println(handle(s, n));
    }

}
