/**
 * @author sk
 * @time 2021/11/16
 * @desc say
 **/
public class L62_208 {

	/*
	 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
	 * <p>
	 * 请你实现 Trie 类：
	 * <p>
	 * Trie() 初始化前缀树对象。
	 * void insert(String word) 向前缀树中插入字符串 word 。
	 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
	 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * 输入
	 * inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
	 * inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
	 * 输出
	 * [null, null, true, false, true, null, true]
	 * <p>
	 * 解释
	 * Trie trie = new Trie();
	 * trie.insert("apple");
	 * trie.search("apple");   // 返回 True
	 * trie.search("app");     // 返回 False
	 * trie.startsWith("app"); // 返回 True
	 * trie.insert("app");
	 * trie.search("app");     // 返回 True
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= word.length, prefix.length <= 2000
	 * word 和 prefix 仅由小写英文字母组成
	 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
	 */

	static class Try {
		char c;
		Try[] tries;
		boolean word = false;

		public Try(char c) {
			this.c = c;
			tries = new Try[26];
		}
	}

	static class Trie {

		Try[] ch = new Try[26];

		public Trie() {

		}

		public void insert(String word) {
			char[] w = word.toCharArray();
			Try tr = null;
			Try[] ch = this.ch;
			for (char c : w) {
				int index = getIndex(c);
				tr = ch[index];
				if (tr == null) {
					tr = new Try(c);
					ch[index] = tr;
				}
				ch = tr.tries;
			}
			if (tr != null) {
				tr.word = true;
			}
		}

		public boolean search(String word) {
			Try tr = has(word);
			return tr != null && tr.word;
		}

		public boolean startsWith(String prefix) {
			Try tr = has(prefix);
			return tr != null;
		}

		private Try has(String prefix) {
			char[] w = prefix.toCharArray();
			Try[] ch = this.ch;
			Try tr = null;
			for (char c : w) {
				int index = getIndex(c);
				tr = ch[index];
				if (tr == null) {
					return null;
				}
				ch = tr.tries;
			}
			return tr;
		}

		private int getIndex(char c) {
			return c - 'a';
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("well");
		trie.insert("well");
		System.err.println(trie.search("well"));
		System.err.println(trie.search("we"));
		System.err.println(trie.startsWith("we"));
		trie.insert("we");
		System.err.println(trie.search("we"));
		System.err.println(trie.search("well"));
	}

}
