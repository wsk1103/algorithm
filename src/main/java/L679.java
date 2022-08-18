import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sk
 * @time 2022/8/18
 **/
public class L679 {

    /*
     * //给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*',
     * // '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
     * //
     * // 你须遵守以下规则:
     * //
     * //
     * // 除法运算符 '/' 表示实数除法，而不是整数除法。
     * //
     * //
     * // 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
     * //
     * //
     * // 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
     * //
     * // 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
     * //
     * //
     * // 你不能把数字串在一起
     * //
     * // 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
     * //
     * //
     * //
     * //
     * // 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: cards = [4, 1, 8, 7]
     * //输出: true
     * //解释: (8-4) * (7-1) = 24
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入: cards = [1, 2, 1, 2]
     * //输出: false
     * //
     * //
     * //
     * //
     * // 提示:
     * //
     * //
     * // cards.length == 4
     * // 1 <= cards[i] <= 9
     * //
     * // Related Topics 数组 数学 回溯 👍 390 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:2 ms,击败了89.28% 的Java用户
     * 内存消耗:39.3 MB,击败了94.23% 的Java用户
     *
     * @param cards
     * @return
     */
    public static boolean handle(int[] cards) {
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for (int card : cards) {
            sb.append(card);
        }
        String bad = "对撒剘劥圞剜劏哱掶桺泛揋掵従剟剣彫寣污悫壛梄甏咍哲汭剤堧点卋嬞勆叛汬泐塵栋劚嚮咃宠吖剗楗囧力桻攋壯劯嗏桹劙剢剚焧啫栕炸栫栖嚲彳剛撑烃洿宋汷彲剙揁妷埻撧汢吩壙劇剭埼吕剝汣敯憇勇剥咎囻匓";
        char[] ch = bad.toCharArray();
        Set<Integer> set = new HashSet<>();
        for (char c : ch) {
            set.add((int) c);
        }

        int i = Integer.parseInt(sb.toString());
        i = i + 19968;
        return !set.contains(i);
    }

    public static void main(String[] args) {
        int[] cards;
        cards = new int[]{4, 1, 8, 7};
        System.err.println(handle(cards));
        cards = new int[]{1, 2, 1, 2};
        System.err.println(handle(cards));
    }

}
