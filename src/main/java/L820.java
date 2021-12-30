import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/17
 * @desc say
 **/
public class L820 {

	/*
	 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
	 * <p>
	 * words.length == indices.length
	 * 助记字符串 s 以 '#' 字符结尾
	 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
	 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：words = ["time", "me", "bell"]
	 * 输出：10
	 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
	 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
	 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
	 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
	 * 示例 2：
	 * <p>
	 * 输入：words = ["t"]
	 * 输出：2
	 * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= words.length <= 2000
	 * 1 <= words[i].length <= 7
	 * words[i] 仅由小写字母组成
	 */
	public static int handle(String[] words) {
		Arrays.sort(words, ((o1, o2) -> o2.length() - o1.length()));
		List<String> temp = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			if (temp.isEmpty()) {
				temp.add(word);
				sb.append(word).append("#");
				continue;
			}
			boolean isSub = false;
			for (String s : temp) {
				if (word.equals(s)) {
					isSub = true;
					break;
				} else if (s.length() == word.length()) {
					continue;
				}
				String sSub = s.substring(s.length() - word.length());
				if (sSub.equals(word)) {
					isSub = true;
					break;
				}
			}
			if (!isSub) {
				sb.append(word).append("#");
				temp.add(word);
			}
		}
		System.err.println(sb);
		return sb.length();
	}


	static class Dict {
		char c;
		Dict[] dicts = new Dict[26];
		boolean isEnd = false;

		public Dict(char c) {
			this.c = c;
		}
	}
	public static int handle2(String[] words) {
		Arrays.sort(words, ((o1, o2) -> o2.length() - o1.length()));
		Dict[] dicts = new Dict[26];
		int to = 0;
		for (String word : words) {
			int temp =  find(word, dicts);
			if (temp > 0) {
				to += temp + 1;
			}
		}
		return to;
	}

	public static int find(String word, Dict[] dicts) {
		char[] ch = word.toCharArray();
		Dict[] temp = dicts;
		boolean setNull = false;
		Dict dict = null;
		for (int i = ch.length - 1; i >= 0; i--) {
			int index = getIndex(ch[i]);
			dict = temp[index];
			if (dict == null) {
				dict = new Dict(ch[i]);
				temp[index] = dict;
				temp = dict.dicts;
				setNull = true;
			} else {
				temp = dict.dicts;
			}
		}
		if (setNull) {
			dict.isEnd = true;
			return word.length();
		}
		return 0;
	}

	private static int getIndex(char c) {
		return c - 'a';
	}

	public static void main(String[] args) {
		String[] words;
//		words = new String[]{"t"};
//		System.err.println(JSON.toJSONString(words));
//		System.err.println(handle2(words));

		words = new String[]{"a","bca"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"time", "atime", "btime"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"abc", "a", "bc", "c"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"time", "me", "bell"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"me", "time", "bell"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"time", "ti", "bell"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"aba", "a", "bell"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
		words = new String[]{"aba", "abb", "aba"};
		System.err.println(JSON.toJSONString(words));
		System.err.println(handle2(words));
	}
}
