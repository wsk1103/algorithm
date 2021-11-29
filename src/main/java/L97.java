/**
 * @author sk
 * @time 2021/11/29
 * @desc say
 **/
public class L97 {

	/*
	 * 给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。
	 *
	 * 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
	 *
	 * s = s1 + s2 + ... + sn
	 * t = t1 + t2 + ... + tm
	 * |n - m| <= 1
	 * 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
	 * 提示：a + b 意味着字符串 a 和 b 连接。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 *
	 *
	 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
	 * aa + dbbc + bc + a + c
	 * t1 + s1 + t2  + s2 + t3
	 * 输出：true
	 * 示例 2：
	 *
	 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
	 * 输出：false
	 * 示例 3：
	 *
	 * 输入：s1 = "", s2 = "", s3 = ""
	 * 输出：true
	 *
	 *
	 * 提示：
	 *
	 * 0 <= s1.length, s2.length <= 100
	 * 0 <= s3.length <= 200
	 * s1、s2、和 s3 都由小写英文字母组成
	 */

	/**
	 * 动态规划。
	 * <p>
	 * 设 f[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否组成 s3 的前 i + j 个字符。
	 * <p>
	 * 状态转移方程为：
	 * <p>
	 * 若 s3[i + j] == s1[i], 则 f[i][j] |= f[i - 1][j]
	 * 若 s3[i + j] == s2[j], 则 f[i][j] |= f[i][j - 1]
	 * 时间复杂度：O ( n ∗ m ) O(n*m)O(n∗m)
	 * <p>
	 * 额外空间复杂度：O ( n ∗ m ) O(n*m)O(n∗m)
	 * 2.
	 * dp[i][j]表示s3[1,len1+len2]是否由s1[1,len1]和s2[1,len2]交错组成
	 *
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean handle(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l1 + l2 != l3) {
			return false;
		}
		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if ((i - 1) >= 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) {
					// dp[i-1][j]=true表示s3[1, i-1+j]由s1[1,i-1]和s2[1,j]交错组成,如果s1.charAt(i-1)与s3.charAt(i-1+j)相等，那么很显然dp[i][j]也为true
					dp[i][j] = true;
				}
				if ((j - 1) >= 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					// dp[i][j-1]=true表示s3[1, i+j-1]由s1[1,i]和s2[1,j-1]交错组成,如果s2.charAt(j-1)与s3.charAt(i+j-1)相等，那么很显然dp[i][j]也为true
					dp[i][j] = true;
				} // 除以上两种情况外，dp[i][j]为false
			}
		}
		return dp[l1][l2];
	}

	public static boolean handle2(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l1 + l2 != l3) {
			return false;
		}
		boolean[][] dp = new boolean[l1][l2];
		dp[0][0] = true;
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (i == 0 && s1.charAt(i) == s3.charAt(i + j)) {
					dp[i][j] = true;
				} else if (i != 0 && dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j)) {
					// dp[i-1][j]=true表示s3[1, i-1+j]由s1[1,i-1]和s2[1,j]交错组成,如果s1.charAt(i-1)与s3.charAt(i-1+j)相等，那么很显然dp[i][j]也为true
					dp[i][j] = true;
				}
				if (j == 0 && s2.charAt(j) == s3.charAt(i + j)) {
					dp[i][j] = true;
				} else if (j != 0 && dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j)) {
					// dp[i][j-1]=true表示s3[1, i+j-1]由s1[1,i]和s2[1,j-1]交错组成,如果s2.charAt(j-1)与s3.charAt(i+j-1)相等，那么很显然dp[i][j]也为true
					dp[i][j] = true;
				}
				// 除以上两种情况外，dp[i][j]为false
			}
		}
		return dp[l1 - 1][l2 - 1];
	}

	public static void main(String[] args) {
		String s1;
		String s2;
		String s3;
		s1 = "aabcc";
		s2 = "dbbca";
		s3 = "aadbbbaccc";
//		System.err.println(handle(s1, s2, s3));
//		System.err.println(handle2(s1, s2, s3));
		s1 = "aabcc";
		s2 = "dbbca";
		s3 = "aadbbcbcac";
		System.err.println(handle(s1, s2, s3));
		System.err.println(handle2(s1, s2, s3));
	}


}
