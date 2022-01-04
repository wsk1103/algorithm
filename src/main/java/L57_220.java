import java.util.*;

/**
 * @author sk
 * @time 2021/11/10
 * @desc say
 **/
public class L57_220 {

	/*
	 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
	 * <p>
	 * 如果存在则返回 true，不存在返回 false。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,2,3,1], k = 3, t = 0
	 * 输出：true
	 * 示例 2：
	 * <p>
	 * 输入：nums = [1,0,1,1], k = 1, t = 2
	 * 输出：true
	 * 示例 3：
	 * <p>
	 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
	 * 输出：false
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 0 <= nums.length <= 2 * 104
	 * -231 <= nums[i] <= 231 - 1
	 * 0 <= k <= 104
	 * 0 <= t <= 231 - 1
	 * 数组 桶排序 有序集合 排序 滑动窗口
	 */

	public static boolean handle(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2) {
			return false;
		}
		if (k == 0) {
			return false;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < Math.min(nums.length, i + k + 1); j++) {
				long toJ = Math.abs((long)nums[i] - nums[j]);
				boolean isT = toJ <= t;
				if (isT) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean handle2(int[] nums, int k, int t) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}
		Map<Integer, Integer> m2 = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(e -> m2.put(e.getKey(), e.getValue()));
		List<Integer> key = new ArrayList<>(m2.keySet());
		for (int i = 0; i < key.size() - 1; i++) {
			for (int j = i + 1; j < key.size(); j++) {
				int ii = key.get(i);
				int jj = key.get(j);
				int isI = map.get(ii);
				int isJ = map.get(jj);
				if ((long) isJ - isI > t) {
					break;
				}
				if (Math.abs(jj - ii) <= k) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean handle3(int[] nums, int k, int t) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int index = getIndex(nums[i], t);
			if (map.containsKey(index)) {
				return true;
			}
			if (map.containsKey(index - 1) && (long) nums[i] - map.get(index - 1) <= (long) t) {
				return true;
			}
			if (map.containsKey(index + 1) && map.get(index + 1) - (long) nums[i] <= (long) t) {
				return true;
			}
			map.put(index, nums[i]);
			if (i >= k) {
				map.remove(getIndex(nums[i - k], t));
			}
		}
		return false;
	}

	public static int getIndex(int num, int t) {
		if (num < 0) {
			return num / (t + 1) - 1;
		}
		return num / (t + 1);
	}



	public static void main(String[] args) {
		int[] nums;
		int k, t;
//		nums = new int[]{1,2,3,1};
//		k = 3;
//		t = 0;
//		System.err.println(handle2(nums, k, t));
//
//		nums = new int[]{1,0,1,1};
//		k = 1;
//		t = 2;
//		System.err.println(handle2(nums, k, t));
		nums = new int[]{1,5,9,1,5,9};
		k = 2;
		t = 3;
		System.err.println(handle3(nums, k, t));

		nums = new int[]{1};
		k = 2;
		t = 3;
		System.err.println(handle3(nums, k, t));

		nums = new int[]{-2147483648,2147483647};
		k = 1;
		t = 1;
		System.err.println(handle3(nums, k, t));
	}

}
