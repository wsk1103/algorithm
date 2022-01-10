import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sk
 * @time 2021/11/26
 * @desc say
 **/
public class L95_1143 {

	/*
	 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
	 *
	 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
	 *
	 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
	 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：text1 = "abcde", text2 = "ace"
	 * 输出：3
	 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
	 * 示例 2：
	 *
	 * 输入：text1 = "abc", text2 = "abc"
	 * 输出：3
	 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
	 * 示例 3：
	 *
	 * 输入：text1 = "abc", text2 = "def"
	 * 输出：0
	 * 解释：两个字符串没有公共子序列，返回 0 。
	 *
	 *
	 * 提示：
	 *
	 * 1 <= text1.length, text2.length <= 1000
	 * text1 和 text2 仅由小写英文字符组成。
	 * 动态规划
	 */

	@Deprecated
	public static int handle(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		List<int[]> list1 = new ArrayList<>();
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					int[] in = new int[2];
					in[0] = i;
					in[1] = j;
					list1.add(in);
				}
			}
		}
		//0-0
		//0-3
		//2-2
		//4-1
//		Map<Integer, String> map = new HashMap<>();
		int size = 0;
		for (int i = 0; i < list1.size() - size; i++) {
			int temp = 0;
			for (int j = i + 1; j < list1.size(); j++) {
				int[] in1 = list1.get(j - 1);
				int[] in2 = list1.get(j);
				if (in1[0] < in2[0] && in1[1] < in2[1]) {
					temp++;
					size = Math.max(temp, size);
//					String ss = map.getOrDefault(i, "");
//					map.put(i, ss + i + "-" + j + ",");
				}
			}
		}
		return size == 0 ? 0 : size + 1;
	}

	@Deprecated
	public static int handle2(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		int[][] g = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			char c1 = text1.charAt(i);
			for (int j = 0; j < l2; j++) {
				char c2 = text2.charAt(j);
				boolean add = c1 == c2;
				if (i == 0) {
					if (add) {
						g[i][j] = 1;
					} else {
						g[i][j] = 0;
					}
				} else {
					if (add) {
						g[i][j] = g[i - 1][Math.max(j - 1, 0)] + 1;
					} else {
						g[i][j] = Math.max(g[i - 1][j], g[i][Math.max(j - 1, 0)]);
					}
				}
			}
		}
		return g[l1 - 1][l2 - 1];
	}

	/**
	 * f(i, j) i表示 text1的第i个字符串，j表示text2的第j个字符串
	 * if text1(i) == text(j)，则 f(i, j) = f(i - 1, j - 1) + 1
	 * else f(i, j) = max(f(i, j - 1), f(i - 1, j))
	 * @param text1
	 * @param text2
	 * @return
	 */
	public static int handle3(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		int[][] dp = new int[l1 + 1][l2 + 1];
		for (int i = 1; i < l1 + 1; i++) {
			char c1 = text1.charAt(i - 1);
			for (int j = 1; j < l2 + 1; j++) {
				char c2 = text2.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[l1][l2];
	}

	public static int handle4(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		if (text1.equals(text2)) {
			return l1;
		}
		int[][] dp = new int[l1][l2];
		for (int i = 0; i < l1; i++) {
			char c1 = text1.charAt(i);
			for (int j = 0; j < l2; j++) {
				char c2 = text2.charAt(j);
				if (c1 == c2) {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
				} else {
					if (j == 0 && i == 0) {
						dp[i][j] = 0;

					} else if (j == 0) {
						dp[i][j] =dp[i - 1][j];
					} else if (i == 0) {
						dp[i][j] = dp[i][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
					}
				}
			}
		}

		return dp[l1 - 1][l2 - 1];
	}

	public static void main(String[] args) {
		String s1;
		String s2;
		Random random = new Random();
		s1 = RandomStringUtils.randomAlphabetic(random.nextInt(999) + 1).toLowerCase();
		s2 = RandomStringUtils.randomAlphabetic(random.nextInt(999) + 1).toLowerCase();
//		System.err.println(handle2(s1, s2));
		System.err.println(handle3(s1, s2));
		System.err.println(handle4(s1, s2));
//		s2 = "xgsvmbqcsaiyydcusbjemjdacbuwjdbtglkcnxtnrxawrtwcrztsdfclwpwutboeshhptuizxciwjkeyizrclceanjoyznmhfuftwskrfsqwulimzvoizobsiqnlvdnsifnjzeurqojirivceztdzkicudrclygqjbteehkqeqwlktcqoxiqtxhunfuhrhvuuwuqcgzgbjyldwwyhnywpllzepqzrhtsjfssaabexedmiacnpswhgctbejqzgfoeywyngnhlsfkgslykufiddcyizpdprxjzeleonuhpdglqbhvemhlxjjucbqdosdrslolrvwabikdaivqfezotyttdfbsfhpxfohdfpldfrikkmqetgvuqsxmfvedudvwcaf";
//		s1 = "wkkfjxicpzmfeohmpqaywqsfoojceikpofygysqzlpwgvbmfemsgghpvvvfslwmlvgp";
//		System.err.println(handle3(s1, s2));
//		System.err.println(handle2(s1, s2));
//		s1 = "ace";
//		s2 = "abcde";
//		System.err.println(handle2(s1, s2));
//		s1 = "abcde";
//		s2 = "acea";
//		System.err.println(handle2(s1, s2));
//		s1 = "abcde";
//		s2 = "aeca";
//		System.err.println(handle2(s1, s2));
//		s1 = "aeca";
//		s2 = "abcde";
//		System.err.println(handle2(s1, s2));
//		s1 = "abcde";
//		s2 = "abcde";
//		System.err.println(handle2(s1, s2));
	}

}
