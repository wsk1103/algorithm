import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/29
 * @desc say
 **/
public class L34_953 {

	/*
	 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
	 *
	 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
	 * 输出：true
	 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
	 * 示例 2：
	 *
	 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
	 * 输出：false
	 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
	 * 示例 3：
	 *
	 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
	 * 输出：false
	 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
	 *
	 *
	 * 提示：
	 *
	 * 1 <= words.length <= 100
	 * 1 <= words[i].length <= 20
	 * order.length == 26
	 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
	 */
	public static boolean handle(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<>();
		int ol = order.length();
		for (int i = 0; i < ol; i++) {
			char c = order.charAt(i);
			map.put(c, i);
		}

		int wl = words.length;
		for (int i = 0; i < wl - 1; i++) {
			String n1 = words[i];
			String n2 = words[i + 1];
			if (!ch(n1, n2, map)) {
				return false;
			}
		}
		return true;
	}

	private static boolean ch(String n1, String n2, Map<Character, Integer> map) {
		if (n1.equals(n2)) {
			return true;
		}
		return check(n1, n2, 0, 0, map);
	}

	private static boolean check(String n1, String n2, int l1, int l2, Map<Character, Integer> map) {
		if (l2 >= n2.length()) {
			return false;
		}
		if (l1 >= n1.length()) {
			return true;
		}
		char c1 = n1.charAt(l1);
		char c2 = n2.charAt(l2);
		int i1 = map.get(c1);
		int i2 = map.get(c2);
		if (i1 < i2) {
			return true;
		} else if (i1 > i2) {
			return false;
		} else {
			return check(n1, n2, l1 + 1, l2 + 1, map);
		}
	}

	public static void main(String[] args) {
		String[] w;
		String order;
		w = new String[]{"word","world","row"};
		order = "worldabcefghijkmnpqstuvxyz";
		System.err.println(handle(w, order));

		w = new String[]{"apple","app"};
		order = "abcdefghijklmnopqrstuvwxyz";
		System.err.println(handle(w, order));

		w = new String[]{"app","apple"};
		order = "abcdefghijklmnopqrstuvwxyz";
		System.err.println(handle(w, order));
		w = new String[]{"hello","leetcode"};
		order = "hlabcdefgijkmnopqrstuvwxyz";
		System.err.println(handle(w, order));
	}




}
