import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/23
 * @desc say
 **/
public class L47 {

	/**
	 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,1,2]
	 * 输出：
	 * [[1,1,2],
	 * [1,2,1],
	 * [2,1,1]]
	 * 示例 2：
	 * <p>
	 * 输入：nums = [1,2,3]
	 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= nums.length <= 8
	 * -10 <= nums[i] <= 10
	 */

	public static List<List<Integer>> handle(int[] nums) {
		List<List<Integer>> to = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> list = new ArrayList<>(map.keySet());
		handle(to, path, map, list, 0, nums.length);
		return to;
	}

	public static void handle(List<List<Integer>> to, LinkedList<Integer> path, Map<Integer, Integer> map, List<Integer> list, int cur, int total) {
		if (cur >= list.size()) {
			return;
		}
		for (Integer iv : list) {
			int size = map.get(iv);
			if (size < 1) {
				continue;
			}
			map.put(iv, size - 1);
			path.add(iv);
			if (path.size() == total) {
				to.add(new ArrayList<>(path));
			}
			if (size - 1 >= 1) {
				cur = cur - 1;
			}
			handle(to, path, map, list, cur + 1, total);
			path.removeLast();
			map.put(iv, size);
		}
//		for (int i = 0; i < list.size(); i++) {
//			int size = map.get(list.get(i));
//			if (size < 1) {
//				continue;
//			}
//			map.put(list.get(i), size - 1);
//			path.add(list.get(i));
//			if (path.size() == total) {
//				to.add(new ArrayList<>(path));
//			}
//			if (size - 1 >= 1) {
//				cur = cur - 1;
//			}
//			handle(to, path, map, list, cur + 1, total);
//			path.removeLast();
//			map.put(list.get(i), size);
//		}
	}

	public static void main(String[] args) {
		int[] nums;
//		nums = new int[]{1,2,3};
//		System.err.println(JSON.toJSONString(handle(nums)));
		nums = new int[]{1, 1, 3, 3};
		System.err.println(JSON.toJSONString(handle(nums)));
		nums = new int[]{1, 1};
		System.err.println(JSON.toJSONString(handle(nums)));

		nums = new int[]{1};
		System.err.println(JSON.toJSONString(handle(nums)));
	}

}
