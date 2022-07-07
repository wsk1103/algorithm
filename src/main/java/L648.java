import java.util.Arrays;
import java.util.List;

/**
 * @author sk
 * @time 2022/7/7
 **/
public class L648 {

    /*
     * //在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
     * //根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * //
     * // 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
     * //承词有许多可以形成它的词根，则用最短的词根替换它。
     * //
     * // 你需要输出替换之后的句子。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by
     * //the battery"
     * //输出："the cat was rat by the bat"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
     * //输出："a a b c"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= dictionary.length <= 1000
     * // 1 <= dictionary[i].length <= 100
     * // dictionary[i] 仅由小写字母组成。
     * // 1 <= sentence.length <= 10^6
     * // sentence 仅由小写字母和空格组成。
     * // sentence 中单词的总量在范围 [1, 1000] 内。
     * // sentence 中每个单词的长度在范围 [1, 1000] 内。
     * // sentence 中单词之间由一个空格隔开。
     * // sentence 没有前导或尾随空格。
     * //
     * //
     * //
     * // Related Topics 字典树 数组 哈希表 字符串 👍 190 👎 0
     */

    static class DTree {
        DTree[] next = new DTree[26];
        boolean end = false;
        char ch;

        DTree(char c) {
            this.ch = c;
        }

    }

    static int index(char ch) {
        return ch - 'a';
    }

    /**
     * 执行耗时:10 ms,击败了63.23% 的Java用户
     * 内存消耗:52.8 MB,击败了30.95% 的Java用户
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static String handle(List<String> dictionary, String sentence) {
        //dictionary.sort(null);
        DTree[] root = new DTree[26];
        for (String s : dictionary) {
            DTree[] cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = index(c);
                DTree dTree = cur[index];
                if (dTree == null) {
                    dTree = new DTree(c);
                    cur[index] = dTree;
                } else {
                    if (dTree.end) {
                        break;
                    }
                }
                cur = dTree.next;
                if (i == s.length() - 1) {
                    dTree.end = true;
                }
            }
        }
        String[] ss = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            StringBuilder temp = new StringBuilder();
            DTree[] cur = root;
            for (int i = 0; i < s.length(); i++) {
                int index = index(s.charAt(i));
                DTree dTree = cur[index];
                if (dTree == null) {
                    temp = new StringBuilder(s);
                    break;
                } else if (dTree.end) {
                    temp.append(s.charAt(i));
                    break;
                } else {
                    temp.append(s.charAt(i));
                    cur = dTree.next;
                }
            }
            sb.append(temp).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list;
        String ss;
        list = Arrays.asList("e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw");
        ss = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
        System.err.println(handle(list, ss));
        //测试结果:"i m w gvcfldkiavww v d bxahfzcfanteibiltins ueebf lqhflvwxksi d k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i m w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc m c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj m nenrqfkbf s w c d c d bgnnoxgyynol h d m z h q i d r nlipyfszvxlwqw yoq d q i k bqprarpgnyemzwifqzz o pnqottd nygesjtlpala q gyvukjpc s m uvwmerplaibeknltuvd o f c pxbd o"
        //测试结果:"i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp
        //期望结果:"i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp"
    }
}
