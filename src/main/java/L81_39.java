import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/22
 * @desc say
 **/
public class L81_39 {

	/*
	 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
	 * <p>
	 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
	 * <p>
	 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入: candidates = [2,3,6,7], target = 7
	 * 输出: [[7],[2,2,3]]
	 * 示例 2：
	 * <p>
	 * 输入: candidates = [2,3,5], target = 8
	 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
	 * 示例 3：
	 * <p>
	 * 输入: candidates = [2], target = 1
	 * 输出: []
	 * 示例 4：
	 * <p>
	 * 输入: candidates = [1], target = 1
	 * 输出: [[1]]
	 * 示例 5：
	 * <p>
	 * 输入: candidates = [1], target = 2
	 * 输出: [[1,1]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= candidates.length <= 30
	 * 1 <= candidates[i] <= 200
	 * candidate 中的每个元素都是独一无二的。
	 * 1 <= target <= 500
	 */

	static List<List<Integer>> to = new ArrayList<>();
	static LinkedList<Integer> link = new LinkedList<>();

	public static List<List<Integer>> handle(int[] candidates, int target) {
		hh(candidates, 0, target);
		return to;
	}

	public static void hh(int[] nums, int cur, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			to.add(new ArrayList<>(link));
		}
		for (int i = cur; i < nums.length; i++) {
			if (nums[i] <= target) {
				link.add(nums[i]);
				hh(nums, i, target - nums[i]);
				link.removeLast();
			}
		}
	}

	public static void main(String[] args) {
		int[] nums;
		int target;

		nums = new int[]{1,2,3,4};
		target = 250;
		System.err.println(JSON.toJSONString(handle(nums, target)));
	}

}
