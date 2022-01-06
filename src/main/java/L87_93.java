import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/24
 * @desc say
 **/
public class L87_93 {

	/*
	 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
	 *
	 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
	 *
	 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：s = "25525511135"
	 * 输出：["255.255.11.135","255.255.111.35"]
	 * 示例 2：
	 *
	 * 输入：s = "0000"
	 * 输出：["0.0.0.0"]
	 * 示例 3：
	 *
	 * 输入：s = "1111"
	 * 输出：["1.1.1.1"]
	 * 示例 4：
	 *
	 * 输入：s = "010010"
	 * 输出：["0.10.0.10","0.100.1.0"]
	 * 示例 5：
	 *
	 * 输入：s = "10203040"
	 * 输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
	 *
	 *
	 * 提示：
	 *
	 * 0 <= s.length <= 3000
	 * s 仅由数字组成
	 */

	public static List<String> handle(String s) {
		List<String> to = new ArrayList<>();
		int len = s.length();
		if (len > 12 || len < 4) {
			return to;
		}
		long l = Long.parseLong(s);
		if (l > 255255255255L) {
			return to;
		}
		for (int i = 1; i < len - 2 && i < 4; i++) {
			String one = s.substring(0, i);
			if (!isIp(one)) {
				continue;
			}
			for (int j = i + 1; j < len - 1 && j - i < 4; j++) {
				String tow = s.substring(i, j);
				if (!isIp(tow)) {
					continue;
				}
				for (int k = j + 1; k < len && k - j < 4 && len - k < 7; k++) {
					String three = s.substring(j, k);
					if (!isIp(three)) {
						continue;
					}
					String four = s.substring(k);
					if (!isIp(four)) {
						continue;
					}
					String re = one + "." + tow + "." + three + "." + four;
					to.add(re);
				}
			}
		}
		return to;
	}

	public static boolean isIp(String s) {
		if (s.length() < 1) {
			return false;
		}
		if (s.length() > 1) {
			if (s.startsWith("0")) {
				return false;
			}
			if (s.length() > 3) {
				return false;
			}
			int i = Integer.parseInt(s);
			return i <= 255;
		}
		return true;
	}

	public static void main(String[] args) {
		String s;
		s = "25251525";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "45254525";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "0000";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "010010";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "1111";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "111";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "255255255255";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "255255255256";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "255255255255255255255255";
		System.err.println(JSON.toJSONString(handle(s)));
	}

}
