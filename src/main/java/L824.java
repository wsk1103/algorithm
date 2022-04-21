/**
 * @author sk
 * @time 2022/4/21
 **/
public class L824 {

    /**
     * //给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
     * //
     * // 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
     * //
     * //
     * // 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
     * //
     * //
     * // 例如，单词 "apple" 变为 "applema" 。
     * //
     * //
     * // 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * //
     * // 例如，单词 "goat" 变为 "oatgma" 。
     * //
     * //
     * // 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
     * //
     * // 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
     * //
     * //
     * //
     * //
     * // 返回将 sentence 转换为山羊拉丁文后的句子。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：sentence = "I speak Goat Latin"
     * //输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：sentence = "The quick brown fox jumped over the lazy dog"
     * //输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
     * //hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= sentence.length <= 150
     * // sentence 由英文字母和空格组成
     * // sentence 不含前导或尾随空格
     * // sentence 中的所有单词由单个空格分隔
     * //
     * // Related Topics 字符串 👍 98 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:2 ms,击败了80.74% 的Java用户
     * 内存消耗:39.5 MB,击败了72.65% 的Java用户
     *
     * @param sentence
     * @return
     */
    public static String handle(String sentence) {
        String[] sp = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        String ma = "ma";
        for (int i = 0; i < sp.length; i++) {
            String temp = sp[i];
            char c = temp.charAt(0);
            switch (c) {
                case 'a':
                case 'o':
                case 'e':
                case 'i':
                case 'u':
                case 'A':
                case 'O':
                case 'E':
                case 'I':
                case 'U':
                    sb.append(temp);
                    break;
                default:
                    if (temp.length() != 1) {
                        StringBuilder sb2 = new StringBuilder(temp);
                        sb2.delete(0, 1);
                        sb2.append(c);
                        sb.append(sb2);
                    } else {
                        sb.append(temp);
                    }
            }
            sb.append(ma);
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            if (i != sp.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s;
        s = "I speak Goat Latin";
        System.err.println(handle(s));
        s = "The quick brown fox jumped over the lazy dog";
        System.err.println(handle(s));
    }

}
