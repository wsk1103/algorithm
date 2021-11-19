/**
 * @author sk
 * @time 2021/10/13
 * @desc say
 **/
public class L318 {
    //给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
    // 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。

    /**
     * 示例 1:
     * <p>
     * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
     * 示例 2:
     * <p>
     * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * 示例 3:
     * <p>
     * 输入: words = ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     */

    public static int handle(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                if (max > a.length() * b.length()) {
                    continue;
                }
                boolean ok = true;
                for (char c : a.toCharArray()) {
                    if (b.contains(String.valueOf(c))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    max = a.length() * b.length();
                }
            }
        }

        return max;
    }

    public static int handle2(String[] words) {
        //判空....
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 0;
        }
        int[] w = new int[words.length];
        //aa = 0001
        //ab = 0011
        //ac = 0101
        //abc = 0111
        //相当于 a ，b，c按照字典顺序填补到二进制相应的位置，
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                w[i] |= (1 << (words[i].charAt(j) - 'a'));
                //abc
                //w[0] = 0 | (1 << 0) = 001 = 1
                //w[0] = 1 | (1 << 1) = 011 = 3
                //w[0] = 3 | (1 << 2) = 0011 | 100 = 0111 = 7
            }
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int temp = words[i].length() * words[j].length();
                if (max > temp) {
                    continue;
                }
                if ((w[i] & w[j]) == 0) {
                    max = temp;
                }
            }
        }
        return max;
    }

    //比较多个字符串，可以尝试使用位运算比较
    public static void main(String[] args) {
        String[] w = new String[]{"abcw","baz","foo","bar","fxyz","abcdef"};
        System.err.println(handle2(w));

        w = new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        System.err.println(handle2(w));


        w = new String[]{"a","aa","aaa","aaaa"};
        System.err.println(handle2(w));
    }

}
