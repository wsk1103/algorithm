import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/10/29
 * @desc say
 **/
public class L49 {

	/*
	 //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
	 //
	 // 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
	 //
	 //
	 //
	 // 示例 1:
	 //
	 //
	 //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
	 //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 //
	 // 示例 2:
	 //
	 //
	 //输入: strs = [""]
	 //输出: [[""]]
	 //
	 //
	 // 示例 3:
	 //
	 //
	 //输入: strs = ["a"]
	 //输出: [["a"]]
	 //
	 //
	 //
	 // 提示：
	 //
	 //
	 // 1 <= strs.length <= 10⁴
	 // 0 <= strs[i].length <= 100
	 // strs[i] 仅包含小写字母
	 //
	 // Related Topics 哈希表 字符串 排序 👍 891 👎 0
	 */

	public static List<List<String>> handle(String[] strs) {
		if (strs == null || strs.length == 1) {
			return Arrays.asList(Arrays.asList(strs));
		}
		List<List<String>> result = new ArrayList<>();
		for (String str : strs) {
			if (result.isEmpty()) {
				List<String> temp = new ArrayList<>();
				temp.add(str);
				result.add(temp);
			} else {
				boolean add = true;
				for (List<String> list : result) {
					String head = list.get(0);
					if (head == null) {
						list.add(str);
					} else {
						if (handle(head, str)) {
							list.add(str);
							add = false;
							break;
						}
					}
				}
				if (add) {
					List<String> temp = new ArrayList<>();
					temp.add(str);
					result.add(temp);
				}
			}
		}
		return result;
	}

	public static List<List<String>> handle2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String tem = new String(c);
			if (map.containsKey(tem)) {
				List<String> list = map.get(tem);
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(tem, list);
			}
		}
		return new ArrayList<>(map.values());
	}

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

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hashMap = new HashMap<>();
		for (String str : strs) {
			char[] tmpArr = str.toCharArray();
			Arrays.sort(tmpArr);
			// 设置key值
			String key = new String(tmpArr);
			// 存储字母异位词
			List<String> tmpList = new ArrayList<>();
			if (hashMap.containsKey(key)) {
				tmpList = hashMap.get(key);
			} else {
				hashMap.put(key, new ArrayList<>());
			}
			tmpList.add(str);
			hashMap.put(key, tmpList);
		}
		return new ArrayList<>(hashMap.values());
	}


	public static void main(String[] args) {
		String[] s;
		s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.err.println(JSON.toJSONString(handle2(s)));

		s = new String[]{""};
		System.err.println(JSON.toJSONString(handle2(s)));
		s = new String[]{"a"};
		System.err.println(JSON.toJSONString(handle2(s)));
	}
}
