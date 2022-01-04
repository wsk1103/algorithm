import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class L1122 {

	/*
	 * 给定两个数组，arr1 和 arr2，
	 * <p>
	 * arr2 中的元素各不相同
	 * arr2 中的每个元素都出现在 arr1 中
	 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
	 * <p>
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= arr1.length, arr2.length <= 1000
	 * 0 <= arr1[i], arr2[i] <= 1000
	 * arr2 中的元素 arr2[i] 各不相同
	 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
	 */

	public static int[] handle(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i : arr2) {
			map.put(i, 0);
		}
		PriorityQueue<Integer> other = new PriorityQueue<>();
		for (int ar : arr1) {
			if (map.containsKey(ar)) {
				map.put(ar, map.get(ar) + 1);
			} else {
				other.offer(ar);
			}
		}
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			for (int j = 0; j < value; j++) {
				arr1[i++] = key;
			}
		}
		while (!other.isEmpty()) {
			arr1[i++] = other.poll();
		}
		return arr1;
	}


	public static void main(String[] args) {
		int[] ar1;
		int[] arr2;
		ar1 = new int[]{9,8,4,6,3,2,1,2,5};
		arr2 = new int[]{2,3,1};

		System.err.println(JSON.toJSONString(handle(ar1, arr2)));
	}
}
