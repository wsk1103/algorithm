import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/22
 * @desc say
 **/
public class L80_77 {

	/*
	 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: n = 4, k = 2
	 * 输出:
	 * [
	 * [2,4],
	 * [3,4],
	 * [2,3],
	 * [1,2],
	 * [1,3],
	 * [1,4],
	 * ]
	 * 示例 2:
	 * <p>
	 * 输入: n = 1, k = 1
	 * 输出: [[1]]
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= n <= 20
	 * 1 <= k <= n
	 */

	public static List<List<Integer>> handle(int n, int k) {
		List<List<Integer>> re = new ArrayList<>();
		LinkedList<Integer> link = new LinkedList<>();
		add(re, link, n + 1, k, 1);
		return re;
	}

	public static void add(List<List<Integer>> re, LinkedList<Integer> link, int n, int k, int next) {
		for (int i = next; i < n; i++) {
			if (link.size() > k) {
				break;
			}
			link.add(i);
			if (link.size() == k) {
				re.add(new ArrayList<>(link));
			}
			add(re, link, n, k, i + 1);
			link.removeLast();
		}
	}

	public static void main(String[] args) {
		int n, k;
		n = 4;
		k = 3;
		System.err.println(JSON.toJSONString(handle(n, k)));

		n = 5;
		k = 5;
		System.err.println(JSON.toJSONString(handle(n, k)));

		n = 5;
		k = 4;
		System.err.println(JSON.toJSONString(handle(n, k)));
		n = 1;
		k = 1;
		System.err.println(JSON.toJSONString(handle(n, k)));
		n = 2;
		k = 1;
		System.err.println(JSON.toJSONString(handle(n, k)));
	}

}
