import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/22
 * @desc say
 **/
public class L82_40 {

	/*
	 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 * <p>
	 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
	 * 输出:
	 * [
	 * [1,1,6],
	 * [1,2,5],
	 * [1,7],
	 * [2,6]
	 * ]
	 * 示例 2:
	 * <p>
	 * 输入: candidates = [2,5,2,1,2], target = 5,
	 * 输出:
	 * [
	 * [1,2,2],
	 * [5]
	 * ]
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= candidates.length <= 100
	 * 1 <= candidates[i] <= 50
	 * 1 <= target <= 30
	 */


	public List<List<Integer>> handle(int[] candidates, int target) {
		if (candidates == null || candidates.length < 1) {
			return new ArrayList<>();
		}
		List<List<Integer>> to = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int ca : candidates) {
//			if (!map.containsKey(ca)) {
//				temp.add(ca);
//			}
			map.put(ca, map.getOrDefault(ca, 0) + 1);
		}
		List<Integer> temp = new ArrayList<>(map.keySet());
		hh(temp, to, path, map, 0, target);
		return to;
	}


	public void hh(List<Integer> nums, List<List<Integer>> to, LinkedList<Integer> path, Map<Integer, Integer> map, int cur, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			to.add(new ArrayList<>(path));
			return;
		}
		for (int i = cur; i < nums.size(); i++) {
			int size = map.get(nums.get(i));
			if (size > 1) {
				if (nums.get(i) <= target) {
					map.put(nums.get(i), --size);
					path.add(nums.get(i));
					hh(nums, to, path, map, i, target - nums.get(i));
					path.removeLast();
					map.put(nums.get(i), ++size);
				}
			} else {
				if (nums.get(i) <= target) {
					path.add(nums.get(i));
					hh(nums, to, path, map, i + 1, target - nums.get(i));
					path.removeLast();
				}

			}
		}
	}

	public static void main(String[] args) {
		L82_40 l8240;
		int[] nums;
		int target;
		nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		target = 30;
		l8240 = new L82_40();
		System.err.println(JSON.toJSONString(l8240.handle(nums, target)));

		nums = new int[]{10, 1, 2, 7, 6, 1, 5};
		target = 8;
		l8240 = new L82_40();
		System.err.println(JSON.toJSONString(l8240.handle(nums, target)));
		nums = new int[]{3,1,3,5,1,1};
		target = 8;
		l8240 = new L82_40();
		System.err.println(JSON.toJSONString(l8240.handle(nums, target)));
	}
}
