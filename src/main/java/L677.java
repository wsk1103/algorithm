import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/17
 * @desc say
 **/
public class L677 {
	/*
	 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
	 * <p>
	 * MapSum() 初始化 MapSum 对象
	 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
	 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：
	 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
	 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
	 * 输出：
	 * [null, null, 3, null, 5]
	 * <p>
	 * 解释：
	 * MapSum mapSum = new MapSum();
	 * mapSum.insert("apple", 3);
	 * mapSum.sum("ap");           // return 3 (apple = 3)
	 * mapSum.insert("app", 2);
	 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= key.length, prefix.length <= 50
	 * key 和 prefix 仅由小写英文字母组成
	 * 1 <= val <= 1000
	 * 最多调用 50 次 insert 和 sum
	 */

	Map<String, Integer> save = new HashMap<>();
	static class Dict {
		String ch;
		int sum;

		public Dict(String ch, int sum) {
			this.ch = ch;
			this.sum = sum;
		}
	}

	//	Dict[] dicts = new Dict[26];
	Map<String, Dict> map = new HashMap<>();
	public void insert(String key, int val) {
		int sub;
		int v = save.getOrDefault(key, 0);
		sub = val - v;
		save.put(key, val);

		char[] chars = key.toCharArray();
//		Dict[] temp = dicts;
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			sb.append(c);
			Dict ii = map.get(sb.toString());
			if (ii == null) {
				ii = new Dict(sb.toString(), sub);
				map.put(sb.toString(), ii);
			} else {
				ii.sum = ii.sum + sub;
			}
		}
	}

	public int getIndex(char c) {
		return c - 'a';
	}

	public int sum(String prefix) {
		Dict ii = map.get(prefix);
		if (ii == null) {
			return 0;
		}
		return ii.sum;
	}

	public static void main(String[] args) {
		L677 l677 = new L677();
		l677.insert("qwerr", 10);
		System.err.println(l677.sum("qwerr"));
		System.err.println(l677.sum("qwerrr"));
		System.err.println(l677.sum("qwe"));
		System.err.println(l677.sum("rqwe"));

		l677.insert("qwe", 20);
		System.err.println(l677.sum("qwerr"));
		System.err.println(l677.sum("qwerrr"));
		System.err.println(l677.sum("qwe"));
		System.err.println(l677.sum("rqwe"));

		l677.insert("qwerr", 1);
		System.err.println(l677.sum("qw"));
		System.err.println(l677.sum("qwe"));
		System.err.println(l677.sum("rqwe"));
		System.err.println(l677.sum("qwerr"));
	}

}
