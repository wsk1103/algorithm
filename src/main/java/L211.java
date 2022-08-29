
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L211 {

    /*
     * //请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
     * //
     * // 实现词典类 WordDictionary ：
     * //
     * //
     * // WordDictionary() 初始化词典对象
     * // void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
     * // bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些
     * //'.' ，每个 . 都可以表示任何一个字母。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //输入：
     * //["WordDictionary","addWord","addWord","addWord","search","search","search",
     * //"search"]
     * //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     * //输出：
     * //[null,null,null,null,false,true,true,true]
     * //
     * //解释：
     * //WordDictionary wordDictionary = new WordDictionary();
     * //wordDictionary.addWord("bad");
     * //wordDictionary.addWord("dad");
     * //wordDictionary.addWord("mad");
     * //wordDictionary.search("pad"); // 返回 False
     * //wordDictionary.search("bad"); // 返回 True
     * //wordDictionary.search(".ad"); // 返回 True
     * //wordDictionary.search("b.."); // 返回 True
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= word.length <= 25
     * // addWord 中的 word 由小写英文字母组成
     * // search 中的 word 由 '.' 或小写英文字母组成
     * // 最多调用 10⁴ 次 addWord 和 search
     * //
     * //
     * // Related Topics 深度优先搜索 设计 字典树 字符串 👍 453 👎 0
     */

    /**
     * 执行耗时:808 ms,击败了16.33% 的Java用户
     * 内存消耗:115.5 MB,击败了5.06% 的Java用户
     */
    static class WordDictionary {

        Map<Character, DictTree> map = new HashMap<>();

        public WordDictionary() {

        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Map<Character, DictTree> now = map;
            DictTree dt = null;
            for (char aChar : chars) {
                dt = now.get(aChar);
                if (dt == null) {
                    dt = new DictTree(aChar);
                    now.put(aChar, dt);
                }
                now = dt.next;
            }
            if (dt != null) {
                dt.end = true;
            }
        }

        public boolean search(String word) {
            return search(word, 0, map);
        }

        private boolean search(String word, int start, Map<Character, DictTree> map) {
            int len = word.length();
            if (start >= len) {
                return false;
            }
            DictTree dt = null;
            for (int i = start; i < len; i++) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    for (DictTree ne : map.values()) {
                        if (i == len - 1 && ne.end) {
                            return true;
                        }
                        boolean b = search(word, i + 1, ne.next);
                        if (b) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    dt = map.get(ch);
                    if (dt == null) {
                        return false;
                    } else {
                        map = dt.next;
                    }
                }
            }
            return dt.end;
        }
    }

    static class DictTree {
        Map<Character, DictTree> next = new HashMap<>();
        boolean end = false;
        char ch;

        DictTree(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
//        wordDictionary.addWord("mad");
        System.err.println(wordDictionary.search("."));
        System.err.println(wordDictionary.search("a"));
        System.err.println(wordDictionary.search("aa"));
        System.err.println(wordDictionary.search(".a"));
        System.err.println(wordDictionary.search("a."));

    }
}
