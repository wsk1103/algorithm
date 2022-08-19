import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L1 {

	/*
	 //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
	 //
	 // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	 //
	 // 你可以按任意顺序返回答案。
	 //
	 //
	 //
	 // 示例 1：
	 //
	 //
	 //输入：nums = [2,7,11,15], target = 9
	 //输出：[0,1]
	 //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
	 //
	 //
	 // 示例 2：
	 //
	 //
	 //输入：nums = [3,2,4], target = 6
	 //输出：[1,2]
	 //
	 //
	 // 示例 3：
	 //
	 //
	 //输入：nums = [3,3], target = 6
	 //输出：[0,1]
	 //
	 //
	 //
	 // 提示：
	 //
	 //
	 // 2 <= nums.length <= 10⁴
	 // -10⁹ <= nums[i] <= 10⁹
	 // -10⁹ <= target <= 10⁹
	 // 只会存在一个有效答案
	 //
	 //
	 // 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
	 // Related Topics 数组 哈希表 👍 13970 👎 0
	 */

	/**
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] handle(int[] nums, int target) {
		// 使用 map 存储差值，如果存在，返回，不存在返回旧
		// 相当于空间换时间的做法
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			int t = target - nums[i];
			if (map.containsKey(t)) {
				return new int[]{i, map.get(t)};
			}
			map.put(nums[i], i);
		}
		return new int[]{};
	}

	public static int[] handle2(int[] nums, int target) {
		//双重循环
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{};
	}

	public static boolean handle3(int[] nums, int target) {
		// 正数才可以
		// 先排序，然后再双指针
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				return true;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] i;
		i = new int[]{2, 7, 11, 15};
		System.err.println(JSON.toJSONString(handle(i, 9)));
		System.err.println(JSON.toJSONString(handle2(i, 9)));
		i = new int[]{3,2,4};
		System.err.println(JSON.toJSONString(handle(i, 6)));
		System.err.println(JSON.toJSONString(handle2(i, 6)));
		i = new int[]{3, 3};
		System.err.println(JSON.toJSONString(handle(i, 7)));
		System.err.println(JSON.toJSONString(handle2(i, 7)));
	}

}
