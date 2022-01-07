import java.util.Arrays;

/**
 * @author sk
 * @time 2021/11/25
 * @desc say
 **/
public class L92_926 {

	/*
	 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。
	 *
	 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
	 *
	 * 返回使 s 单调递增 的最小翻转次数。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：s = "00110"
	 * 输出：1
	 * 解释：我们翻转最后一位得到 00111.
	 * 示例 2：
	 *
	 * 输入：s = "010110"
	 * 输出：2
	 * 解释：我们翻转得到 011111，或者是 000111。
	 * 示例 3：
	 *
	 * 输入：s = "00011000"
	 * 输出：2
	 * 解释：我们翻转得到 00000000。
	 *
	 *
	 * 提示：
	 *
	 * 1 <= s.length <= 20000
	 * s 中只包含字符 '0' 和 '1'
	 */

	public static int handle(String s) {
		if (s.length() == 1) {
			return 0;
		}
		char[] ch = s.toCharArray();
		han(ch, 0, 0);
		return to;
	}

	static int to = Integer.MAX_VALUE;
	public static void han(char[] ch, int start, int size) {
		if (size >= to) {
			return;
		}
		if (is(ch)) {
			System.err.println(size);
			System.err.println(Arrays.toString(ch));
			to = Math.min(size, to);
			return;
		}
		for (int i = start; i < ch.length; i++) {
			if (i < 1) {
				if (ch[i] == '0') {
					han(ch, i + 1, size);
					ch[i] = '1';
					han(ch, i + 1, size + 1);
					ch[i] = '0';
				} else {
					han(ch, i + 1, size);
					ch[i] = '0';
					han(ch, i + 1, size + 1);
					ch[i] = '1';
				}
			} else {
				if (ch[i - 1] <= ch[i]) {
					//0-1 00 1-1
					if (ch[i - 1] == '1') {
						if (ch[i] == '1') {
							han(ch, i + 1, size);
						} else {
							ch[i] = '1';
							han(ch, i + 1, size + 1);
							ch[i] = '0';
						}
					} else {
						// ch[i - 1] = 0
						if (ch[i] == '1') {
							han(ch, i + 1, size);
							ch[i] = '0';
							han(ch, i + 1, size + 1);
							ch[i] = '1';
						} else {
							han(ch, i + 1, size);
							ch[i] = '1';
							han(ch, i + 1, size + 1);
							ch[i] = '0';
						}
					}
				} else {
					//10
					if (ch[i] == '1') {
						han(ch, i + 1, size);
					} else {
						ch[i] = '1';
						han(ch, i + 1, size + 1);
						ch[i] = '0';
					}
				}
			}
		}
	}

	public static int handle2(String s) {
		//同时翻转之后最后一个数字是0，i==0 -> f(n-1)， i==1 -> f(n-1) + 1
		//f(n) = f(n-1) or f(n-1) + 1
		//翻转成1, i==0 -> g(n) = min(f(n-1), g(n-1)) + 1
		//  i==1 -> g(n) = min(f(n-1), g(n-1))
		if (s.length() == 1) {
			return 0;
		}
		int dp0 = s.charAt(0) == '0' ? 0 : 1;
		int dp1 = s.charAt(0) == '1' ? 0 : 1;
		for (int i = 1; i < s.length(); i++) {
			dp1 = Math.min(dp0, dp1) + (s.charAt(i) == '1' ? 0 : 1);
			dp0 = dp0 + (s.charAt(i) == '0' ? 0 : 1);
		}
		return Math.min(dp0, dp1);
	}

	public static void cal(char[] ch, int size, int index) {
		if (size > ch.length || size >= to) {
			return;
		}
		if (index >= ch.length) {
			to = size;
		}
		for (int i = index; i < ch.length; i++) {
			if (ch[i] < ch[i - 1]) {
				size++;
				if (ch[i - 1] == '1') {
					ch[i] = '1';
				} else {
					ch[i] = '0';
				}
			}
		}

	}

	public static boolean is(char[] ch, int start) {
		if (start < 0) {
			return false;
		}
		for (int i = start; i < ch.length; i++) {
			if (i != ch.length - 1) {
				if (ch[i] > ch[i + 1]) {
					return false;
				}
			}
			if (i != 0) {
				if (ch[i - 1] > ch[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean is(char[] ch) {
		for (int i = 0; i < ch.length; i++) {
			if (i != ch.length - 1) {
				if (ch[i] > ch[i + 1]) {
					return false;
				}
			}
			if (i != 0) {
				if (ch[i - 1] > ch[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s;
//		s = "0001101";
//		System.err.println(handle(s));
//		to = Integer.MAX_VALUE;
//		s = "00011000";
//		System.err.println(handle(s));
//		to = Integer.MAX_VALUE;
//		s = "010110";
//		System.err.println(handle(s));
//		to = Integer.MAX_VALUE;
//		s = "001100000111010101010";
//		System.err.println(handle(s));
		to = Integer.MAX_VALUE;
		s = "0000100001000100000000000";
		System.err.println(handle2(s));
		to = Integer.MAX_VALUE;
	}


}
