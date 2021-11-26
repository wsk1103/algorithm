import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author sk
 * @time 2021/11/26
 * @desc say
 **/
public class L132 {

	/*
	 * 给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。
	 *
	 * 返回符合要求的 最少分割次数 。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：s = "aab"
	 * 输出：1
	 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
	 * 示例 2：
	 *
	 * 输入：s = "a"
	 * 输出：0
	 * 示例 3：
	 *
	 * 输入：s = "ab"
	 * 输出：1
	 *
	 *
	 * 提示：
	 *
	 * 1 <= s.length <= 2000
	 * s 仅由小写英文字母组成
	 */

	/*
	 * 1. 动态规划：
	 * 定义 f[len] 为将 [1,i] 这一段字符分割为若干回文串的最小分割次数，那么最终答案为 f[len]。
	 * 状态转移：
	 * 从「起点字符」到「第 i 个字符」能形成回文串 : 最小分割次数为 0，此时有 f[i] = 0；
	 * 从「起点字符」到「第 i 个字符」不能形成回文串 : 此时我们需要枚举左端点,如果 [j,i] 这一段是回文串的话，那么有 f[i] = f[j - 1] + 1
	 *
	 * g[j][i]记录[j,i]是否是回文串；
	 * 如果g[0][i]为真，[0,i]是回文串，不用再分割，f[i] = 0；
	 * 否则循环选择[j,i]是回文串且f[i], f[j] + 1中分割次数最少的
	 *
	 * 2.
	 * dp[j] = min(dp[j], dp[i] + 1)， 其中 dp[i] 表示将字符串 s[0:i] 分割成若干回文串的最小分割次数。
	 * 那么答案自然就是 dp[n-1]。base case 为 dp[0] = 0，其他初始化为无穷大即可
	 * @param s
	 * @return
	 */
	public static int handle(String s) {
		int l = s.length();
		int size = 0;
		for (int i = 0; i < l; ) {
			int next = cut(s, i, l - 1);
			if (next == i && next != l - 1) {
				i++;
				size++;
			} else {
				if (next != l - 1) {
					size++;
				}
				i = next + 1;
			}
		}
		return size;
	}

	public static int handle2(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = true;
			}
		}
		int[] to = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
			}

		}
		for (int i = 0; i < n; i++) {
			to[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < n; i++) {
			if (dp[0][i]) {
				to[i] = 0;
			} else {
				for (int j = 0; j < i; j++) {
					if (dp[j + 1][i]) {
						to[i] = Math.min(to[i], to[j] + 1);
					}
				}
			}
		}
		return to[n - 1];
	}

	public static int cut(String s, int start, int end) {
		while (start < end) {
			if (is(s, start, end)) {
				return end;
			}
			end--;
		}
		return end;
	}

	public static boolean is(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s;
		s = "abc";
		System.err.println(handle2(s));
		s = "abcba";
		System.err.println(handle2(s));
		s = "aab";
		System.err.println(handle2(s));
		s = "ab";
		System.err.println(handle2(s));
		s = "abb";
		System.err.println(handle2(s));
		s = "a";
		System.err.println(handle2(s));
		s = "google";
		System.err.println(handle2(s));
		s = RandomStringUtils.randomAlphabetic(1000).toLowerCase();
		System.err.println(s);
		System.err.println(handle2(s));
	}

}
