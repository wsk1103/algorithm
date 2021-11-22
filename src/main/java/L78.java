import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/22
 * @desc say
 **/
public class L78 {

	/**
	 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
	 * <p>
	 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,2,3]
	 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 * 示例 2：
	 * <p>
	 * 输入：nums = [0]
	 * 输出：[[],[0]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= nums.length <= 10
	 * -10 <= nums[i] <= 10
	 * nums 中的所有元素 互不相同
	 */

	public static List<List<Integer>> handle(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> link = new LinkedList<>();
		result.add(new ArrayList<>());
		add(result, link, nums, 0);
		return result;
	}

	public static void add(List<List<Integer>> re, LinkedList<Integer> link, int[] nums, int cur) {
		for (int i = cur; i < nums.length; i++) {
			link.offer(nums[i]);
			re.add(new ArrayList<>(link));
			add(re, link, nums, i + 1);
			link.removeLast();
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		result.add(new ArrayList<>());
		add(result, queue, nums, 0);
		return result;
	}

	private static void add(ArrayList<List<Integer>> result, LinkedList<Integer> queue, int[] nums, int lattice) {
		for (int i = lattice; i < nums.length; i++) {
			queue.offer(nums[i]);
			result.add(new ArrayList<>(queue));
			add(result, queue, nums, i + 1);
			queue.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1, 2, 3, 4};
		List<List<Integer>> re = handle(nums);
		System.err.println(JSON.toJSONString(re));
	}

}
