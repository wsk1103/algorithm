import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/23
 * @desc say
 **/
public class L131 {

	/**
	 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
	 *
	 * 回文串 是正着读和反着读都一样的字符串。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：s = "google"
	 * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
	 * 示例 2：
	 *
	 * 输入：s = "aab"
	 * 输出：[["a","a","b"],["aa","b"]]
	 * 示例 3：
	 *
	 * 输入：s = "a"
	 * 输出：[["a"]
	 *
	 *
	 * 提示：
	 *
	 * 1 <= s.length <= 16
	 * s 仅由小写英文字母组成
	 */




	/*
    用来保存从任意一位置至任意一位置的子串是否是回文串，类似于动态规划中保存之前的状态来减小时间复杂度
    不同之处在于这里的状态并没有发生转移，所以不算是动态规划与回溯算法的结合
    这一步是优化时间复杂度的关键
     */
	int[][] dp;

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (null == s || s.length() == 0) {
			return res;
		}
		int length = s.length();
        /*
        它是一个二维矩阵，有三种状态值：
        0表示之前还没有计算过
        1表示从下表i到j的子串是回文串
        2表示不是回文串
        我们只用到了数组的右上半部分
        当然这里也可以使用char数组，空间复杂度更低
         */
		dp = new int[length][length];
		//初始化，单个字符的肯定是回文串
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}

		ArrayList<String> templist = new ArrayList<>();
		helper(res, templist, s, length, 0);
		return res;
	}

	/**
	 * 回溯算法
	 *
	 * @param res      结果集
	 * @param templist 中间list
	 * @param s        字符串
	 * @param length   字符串长度
	 * @param index    从当前位置向后组合判断
	 */
	private void helper(List<List<String>> res, ArrayList<String> templist, String s, int length, int index) {
		//走到这一步就表示走到了最后，添加到结果集
		if (index == length) {
			res.add(new ArrayList<>(templist));//一定要重新new一个对象，templist可以得到重用
		}
		//走到某一步有若干的选择继续走下一步
		for (int i = index; i < length; i++) {
			if (isPalindrome(s, index, i)) {
				templist.add(s.substring(index, i + 1));
				helper(res, templist, s, length, i + 1);
				templist.remove(templist.size() - 1);//回溯算法中回退一定要记得这一步
			}
		}
	}

	//判断是否是回文串，这里首先需要到保存的状态中查看是否之前已经有了，优化时间复杂度
	private boolean isPalindrome(String s, int from, int to) {
		if (dp[from][to] == 1) {
			return true;
		} else if (dp[from][to] == 2) {
			return false;
		} else {
			for (int i = from, j = to; i < j; i++, j--) {
				if (s.charAt(i) != s.charAt(j)) {
					dp[from][to] = 2;
					return false;
				}
			}
			dp[from][to] = 1;
			return true;
		}
	}

	public static List<List<String>> handle(String s) {
		if (s == null || s.length() < 1) {
			return new ArrayList<>();
		}
		int l = s.length();
		int[][] dp = new int[l][l];
		for (int i = 0; i < l; i++) {
			dp[i][i] = 1;
		}
		List<List<String>> to = new ArrayList<>();
		List<String> path = new ArrayList<>();
		handle(dp, to, path, s, l, 0);
		return to;
	}

	public static void handle(int[][] dp, List<List<String>> to, List<String> path, String s, int length, int next) {
		if (length == next) {
			to.add(new ArrayList<>(path));
		}
		for (int i = next; i < length; i++) {
			if (isP(dp, s, next, i)) {
				path.add(s.substring(next, i + 1));
				handle(dp, to, path, s, length, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	public static boolean isP(int[][] dp, String s, int from, int to) {
		if (dp[from][to] == 1) {
			return true;
		} else if (dp[from][to] == 2){
			return false;
		} else {
			for (int i = from, j = to; i < j; i++, j--) {
				if (s.charAt(i) != s.charAt(j)) {
					dp[i][j] = 2;
					return false;
				}
			}
			dp[from][to] = 1;
			return true;
		}
	}

	public static void main(String[] args) {
		String s;
		s = "abcc";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "goo";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "a";
		System.err.println(JSON.toJSONString(handle(s)));
		s = "";
		System.err.println(JSON.toJSONString(handle(s)));
	}
}
