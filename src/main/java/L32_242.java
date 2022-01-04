import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/28
 * @desc say
 **/
public class L32_242 {

	/*
	 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
	 * <p>
	 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: s = "anagram", t = "nagaram"
	 * 输出: true
	 * 示例 2:
	 * <p>
	 * 输入: s = "rat", t = "car"
	 * 输出: false
	 * 示例 3:
	 * <p>
	 * 输入: s = "a", t = "a"
	 * 输出: false
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= s.length, t.length <= 5 * 104
	 * s and t 仅包含小写字母
	 * <p>
	 * <p>
	 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	 * 1. 排序后一一比较
	 *
	 * 2. map
	 */

	public static boolean handle(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		char[] c2 = t.toCharArray();
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean handle2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>(32);
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for (int i = 0; i < t.length(); i++) {
			char tt = t.charAt(i);
			int j = map.getOrDefault(tt, 0);
			j--;
			if (j < 0) {
				return false;
			}
			map.put(tt, j);
		}
		return true;
	}

	public static void main(String[] args) {
		String s, t;
		s = "rat";
		t = "car";
		System.err.println(handle(s, t));
		System.err.println(handle2(s, t));

		s = "anagram";
		t = "nagaram";
		System.err.println(handle(s, t));
		System.err.println(handle2(s, t));
	}

}
