import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/23
 * @desc say
 **/
public class L83_46 {

	/**
	 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,2,3]
	 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * 示例 2：
	 * <p>
	 * 输入：nums = [0,1]
	 * 输出：[[0,1],[1,0]]
	 * 示例 3：
	 * <p>
	 * 输入：nums = [1]
	 * 输出：[[1]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= nums.length <= 6
	 * -10 <= nums[i] <= 10
	 * nums 中的所有整数 互不相同
	 */

	public static List<List<Integer>> handle(int[] nums) {
		List<List<Integer>> to = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		Set<Integer> map = new HashSet<>();
		handle(to, path, map, nums, 0);
		return to;
	}

	public static void handle(List<List<Integer>> to, LinkedList<Integer> path, Set<Integer> map, int[] nums, int cur) {
		if (cur >= nums.length) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.contains(nums[i])) {
				continue;
			}
			map.add(nums[i]);
			path.add(nums[i]);
			if (path.size() == nums.length) {
				to.add(new ArrayList<>(path));
			}
			handle(to, path, map, nums, cur + 1);
			path.removeLast();
			map.remove(nums[i]);
		}
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1,2,3};
		System.err.println(JSON.toJSONString(handle(nums)));

		nums = new int[]{1};
		System.err.println(JSON.toJSONString(handle(nums)));
		nums = new int[]{};
		System.err.println(JSON.toJSONString(handle(nums)));
	}
}
