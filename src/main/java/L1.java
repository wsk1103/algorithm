import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L1 {

	public static int[] handle(int[] nums, int target) {
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

	public static void main(String[] args) {
		int[] i;
		i = new int[]{2, 7, 11, 15};
		System.err.println(JSON.toJSONString(handle(i, 9)));
		i = new int[]{3,2,4};
		System.err.println(JSON.toJSONString(handle(i, 6)));
		i = new int[]{3, 3};
		System.err.println(JSON.toJSONString(handle(i, 7)));
	}

}
