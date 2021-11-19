import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/16
 * @desc say
 **/
public class L676 {

	/**
	 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
	 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
	 *
	 * 实现 MagicDictionary 类：
	 *
	 * MagicDictionary() 初始化对象
	 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
	 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
	 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
	 *
	 *
	 * 示例：
	 *
	 * 输入
	 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
	 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
	 * 输出
	 * [null, null, false, true, false, false]
	 *
	 * 解释
	 * MagicDictionary magicDictionary = new MagicDictionary();
	 * magicDictionary.buildDict(["hello", "leetcode"]);
	 * magicDictionary.search("hello"); // 返回 False
	 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
	 * magicDictionary.search("hell"); // 返回 False
	 * magicDictionary.search("leetcoded"); // 返回 False
	 *
	 *
	 * 提示：
	 *
	 * 1 <= dictionary.length <= 100
	 * 1 <= dictionary[i].length <= 100
	 * dictionary[i] 仅由小写英文字母组成
	 * dictionary 中的所有字符串 互不相同
	 * 1 <= searchWord.length <= 100
	 * searchWord 仅由小写英文字母组成
	 * buildDict 仅在 search 之前调用一次
	 * 最多调用 100 次 search
	 */

	static class Try {
		char c;
		Map<Character, Try> map = new HashMap<>();
		boolean word = false;

		public Try(char c) {
			this.c = c;
		}
	}

	static Map<Character, Try> map = new HashMap<>();

	public static void insert(String word, Map<Character, Try> map) {
		char[] w = word.toCharArray();
		Try tr = null;
		Map<Character, Try> ch = map;
		for (char c : w) {
			tr = ch.get(c);
			if (tr == null) {
				tr = new Try(c);
				ch.put(c, tr);
			}
			ch = tr.map;
		}
		if (tr != null) {
			tr.word = true;
		}
	}

	public static boolean search(String word, Map<Character, Try> map) {
		char[] chars = word.toCharArray();
		if (chars.length == 1) {
			for (Map.Entry<Character, Try> next : map.entrySet()) {
				if (chars[0] == next.getKey()) {
					continue;
				} else {
					if (next.getValue().word) {
						return true;
					}
				}
			}
			return false;
		}
		Map<Character, Try> temp = map;
		for (int i = 0; i < chars.length; i++) {
			Try tr = temp.get(chars[i]);
			if (tr == null) {
				for (Map.Entry<Character, Try> next : temp.entrySet()) {
					boolean re = findOther(i + 1, chars, next.getValue().map);
					if (re) {
						return true;
					}
				}
				return false;
			} else {
				for (Map.Entry<Character, Try> next : temp.entrySet()) {
					if (chars[i] == next.getKey()) {
						continue;
					}
					boolean re = findOther(i + 1, chars, next.getValue().map);
					if (re) {
						return true;
					}
				}
			}
			temp = tr.map;
		}
		return false;
	}

	public static boolean findOther(int start, char[] chars, Map<Character, Try> map) {
		if (start >= chars.length) {
			for (Map.Entry<Character, Try> next : map.entrySet()) {
				if (chars[start - 1] == next.getKey()) {
					continue;
				} else {
					if (next.getValue().word) {
						return true;
					}
				}
			}
			return false;
		}
		Map<Character, Try> temp = map;
		boolean isW = false;
		for (int i = start; i < chars.length; i++) {
			Try tr = temp.get(chars[i]);
			if (tr == null) {
				return false;
			}
			temp = tr.map;
			isW = tr.word;
		}
		return isW;
	}

	public static void buildDict(String[] dictionary) {
		for (String s : dictionary) {
			insert(s, map);
		}
	}

	public static boolean search(String searchWord) {
		return search(searchWord, map);
	}

	static Map<Integer, List<String>> map2 = new HashMap<>();
	public static void buildDict2(String[] dictionary) {

		for (String s : dictionary) {
			int length = s.length();
			List<String> temp = map2.get(length);
			if (temp == null) {
				temp = new ArrayList<>();
				temp.add(s);
				map2.put(length, temp);
			} else {
				temp.add(s);
			}
		}
	}

	public static boolean search2(String searchWord) {
		int length = searchWord.length();
		List<String> temp = map2.get(length);
		if (temp == null || temp.size() == 0) {
			return false;
		}
		for (String ss : temp) {
			char[] cc = ss.toCharArray();
			char[] cc2 = searchWord.toCharArray();
			int mod = 0;
			for (int j = 0; j < cc.length; j++) {
				if (cc[j] != cc2[j]) {
					mod++;
				}
				if (mod >= 2) {
					break;
				}
			}
			if (mod == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] dict;
		String key;
		dict = new String[]{"hello", "helll"};
		key = "hello";
		buildDict2(dict);
		System.err.println(search2(key));
	}

}
