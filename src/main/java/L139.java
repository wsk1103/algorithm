import java.util.*;

/**
 * @author sk
 * @time 2022/8/25
 * @desc say
 **/
public class L139 {

    /*
     * //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * //
     * // 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入: s = "leetcode", wordDict = ["leet", "code"]
     * //输出: true
     * //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * //输出: true
     * //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     * //     注意，你可以重复使用字典中的单词。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * //输出: false
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 300
     * // 1 <= wordDict.length <= 1000
     * // 1 <= wordDict[i].length <= 20
     * // s 和 wordDict[i] 仅有小写英文字母组成
     * // wordDict 中的所有字符串 互不相同
     * //
     * //
     * // Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1771 👎 0
     */

    /**
     * Time Limit Exceeded
     * 测试用例:"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean handle(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        Map<Character, DictTree> dts = init(wordDict);
        LinkedList<Link> list = new LinkedList<>();
        int len = s.length();
//        Map<Character, DictTree> now = dts;
//        char[] ch = s.toCharArray();
//        DictTree dt = null;
//        for (int i = 0; i < ch.length; i++) {
//            char c = ch[i];
//            dt = now.get(c);
//            if (dt == null) {
//                if (list.size() > 0) {
//                    Link link = list.pollFirst();
//                    now = link.map;
//                    i = link.i;
//                    continue;
//                }
//                return false;
//            }
//            if (dt.end) {
//                if (dt.next.size() > 0) {
//                    Link link = new Link();
//                    link.i = i;
//                    link.map = now;
//                    now = dt.next;
//                    list.addLast(link);
//                } else {
//                    now = dts;
//                }
//            } else {
//                now = dt.next;
//            }
//        }
//        if (dt == null || !dt.end) {
//            return false;
//        }
//        return true;
        boolean b = can(s, 0, len, dts, dts, list);
        if (b) {
            return true;
        }
        while (!list.isEmpty()) {
            Link link = list.pollFirst();
            Map<Character, DictTree> map = link.map;
            b = can(s, link.i, len, map, dts, list);
            if (b) {
                return true;
            }
        }
        return false;
    }

    private static boolean can(String s, int start, int end, Map<Character, DictTree> map, Map<Character, DictTree> first, LinkedList<Link> list) {
        if (start >= end) {
            char ch = s.charAt(start - 1);
            DictTree dt = map.get(ch);
            if (dt == null) {
                return false;
            }
            return dt.end;
        }
        DictTree dt = null;
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            dt = map.get(ch);
            if (dt == null) {
                return false;
            }
            if (dt.end) {
                if (dt.next.size() > 0) {
                    Link link = new Link();
                    link.i = i + 1;
                    link.map = dt.next;
                    list.addLast(link);
                }
                map = first;
            } else {
                map = dt.next;
            }
        }
        return dt.end;
    }

    private static Map<Character, DictTree> init(List<String> wordDict) {
        Map<Character, DictTree> dictTrees = new HashMap<>();
        for (String s : wordDict) {
            char[] chars = s.toCharArray();
            Map<Character, DictTree> now = dictTrees;
            DictTree curD = null;
            for (char c : chars) {
//                int index = index(c);
                curD = now.get(c);
                if (curD == null) {
                    curD = new DictTree();
                    now.put(c, curD);
//                    now[index] = curD;
                }
                now = curD.next;
            }
            curD.end = true;
        }
        return dictTrees;
    }

    private static class DictTree {
        Map<Character, DictTree> next = new HashMap<>();
        boolean end;

    }

    private static class Link {
        Map<Character, DictTree> map;
        int i;
    }

    /**
     * time out
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean handle2(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s1 : wordDict) {
            int len = s1.length();
            List<String> list = map.get(len);
            if (list == null) {
                list = new ArrayList<>();
                list.add(s1);
                map.put(len, list);
            } else {
                list.add(s1);
            }
        }
        int len = s.length();
        LinkedList<Integer> nexts = new LinkedList<>();
        boolean b = can(s, 0, len, map, nexts);
        if (b) {
            return true;
        }
        while (!nexts.isEmpty()) {
            int i = nexts.poll();
            b = can(s, i, len, map, nexts);
            if (b) {
                return true;
            }
        }
        return false;
    }

    private static boolean can(String s, int start, int end, Map<Integer, List<String>> map, LinkedList<Integer> nexts) {
        if (start >= end) {
            return false;
        }
        boolean to = false;
        String temp = "";
        for (int i = start; i < end; i++) {
            temp += s.charAt(i);
            int nowLen = temp.length();
            List<String> list = map.get(nowLen);
            if (list == null || !list.contains(temp)) {
                to = false;
                continue;
            }
            to = true;
            nexts.push(i + 1);
        }
        return to;
    }

    /**
     * 执行耗时:3 ms,击败了88.59% 的Java用户
     * 内存消耗:40.9 MB,击败了86.79% 的Java用户
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean handle3(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        List<Integer> index = new ArrayList<>();
        index.add(0);
        for (int i = 0; i < len; i++) {
            for (int j = index.size() - 1; j >= 0; j--) {
                int in = index.get(j);
                String temp = s.substring(in, i + 1);
                if (set.contains(temp)) {
                    index.add(i + 1);
                    break;
                }
            }
        }
        return index.get(index.size() - 1) == len;
    }

    public static void main(String[] args) {
        String s;
        List<String> words;
        s = "bb";
        words = Arrays.asList("a", "b", "bbb", "bbbb");
        System.err.println(handle(s, words));
        System.err.println(handle3(s, words));
//        System.err.println(handle3(s, words));
        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        words = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
//        System.err.println(handle(s, words));
        System.err.println(handle3(s, words));
        s = "applepenapple";
        words = Arrays.asList("apple", "pen");
        System.err.println(handle(s, words));
//        System.err.println(handle2(s, words));
        System.err.println(handle3(s, words));
        s = "catsg";
        words = Arrays.asList("cat", "cats", "g");
        System.err.println(handle(s, words));
        System.err.println(handle3(s, words));
        s = "catssg";
        words = Arrays.asList("cat", "cats", "catss", "g");
        System.err.println(handle(s, words));
        System.err.println(handle3(s, words));
        s = "catssg";
        words = Arrays.asList("cat", "cats", "catss", "gg");
        System.err.println(handle(s, words));
        System.err.println(handle3(s, words));
    }

}
