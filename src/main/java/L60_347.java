import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/15
 * @desc say
 **/
public class L60_347 {

	/*
	 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: nums = [1,1,1,2,2,3], k = 2
	 * 输出: [1,2]
	 * 示例 2:
	 * <p>
	 * 输入: nums = [1], k = 1
	 * 输出: [1]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= nums.length <= 105
	 * k 的取值范围是 [1, 数组中不相同的元素的个数]
	 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
	 * <p>
	 * <p>
	 * 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
	 * 小根堆
	 */

	public int[] handle(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		if (k == 0) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (queue.size() >= k) {
				if (queue.peek()[1] < value) {
					queue.poll();
					queue.offer(new int[]{key, value});
				}
			} else {
				queue.offer(new int[]{key, value});
			}
		}
		int[] to = new int[k];
		int i = 0;
		while (!queue.isEmpty()) {
			to[i++] = queue.poll()[0];
		}
		return to;
	}

	public static void main(String[] args) {
		L60_347 l60347 = new L60_347();
		int[] nums;
		int k;
		nums = new int[]{1, 1,1,1,1, 2, 2, 3, 0, 0, 0,8,8,8,8};
		k = 3;
		System.err.println(JSON.toJSONString(l60347.handle(nums, k)));
	}


}
