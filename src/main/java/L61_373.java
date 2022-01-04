import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sk
 * @time 2021/11/16
 * @desc say
 **/
public class L61_373 {

	/*
	 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
	 * <p>
	 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
	 * <p>
	 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
	 * 输出: [1,2],[1,4],[1,6]
	 * 解释: 返回序列中的前 3 对数：
	 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	 * 示例 2:
	 * <p>
	 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
	 * 输出: [1,1],[1,1]
	 * 解释: 返回序列中的前 2 对数：
	 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	 * 示例 3:
	 * <p>
	 * 输入: nums1 = [1,2], nums2 = [3], k = 3
	 * 输出: [1,3],[2,3]
	 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= nums1.length, nums2.length <= 104
	 * -109 <= nums1[i], nums2[i] <= 109
	 * nums1, nums2 均为升序排列
	 * 1 <= k <= 1000
	 * 大根堆 + 双指针
	 */

	public List<List<Integer>> handle(int[] nums1, int[] nums2, int k) {
		if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
			return new ArrayList<>();
		}
		PriorityQueue<List<Integer>> queue = new PriorityQueue<>(((o1, o2) -> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1))));
		int a = 0, b = 0, maxA = nums1.length, maxB = nums2.length;
		while (a < maxA && b < maxB) {
			int temp = nums1[a] + nums2[b];
			if (queue.size() == k) {
				List<Integer> as = queue.peek();
				if (temp < as.get(0) + as.get(1)) {
					queue.poll();
					queue.offer(Arrays.asList(nums1[a], nums2[b]));
					b++;
					if (b >= maxB) {
						b = 0;
						a++;
					}
				} else {
					a++;
					maxB = b;
					b = 0;
				}
			} else {
				queue.offer(Arrays.asList(nums1[a], nums2[b]));
				b++;
				if (b >= maxB) {
					b = 0;
					a++;
				}
			}

		}
		List<List<Integer>> re = new ArrayList<>();
		while (!queue.isEmpty()) {
			List<Integer> to = queue.poll();
			re.add(to);
		}
		return re;
	}

	public static void main(String[] args) {
		L61_373 l61373 = new L61_373();
		int[] nums1, nums2;
		int k;
		List<List<Integer>> re;
		nums1 = new int[]{1};
		nums2 = new int[]{1};
		k = 1;
		re = l61373.handle(nums1, nums2, k);
		System.err.println(JSON.toJSONString(re));
		nums1 = new int[]{-10,-4,0,0,6};
		nums2 = new int[]{3,5,6,7,8,100};
		k = 10;
		re = l61373.handle(nums1, nums2, k);
		System.err.println(JSON.toJSONString(re));
		/*
		test:[[-4,7],[0,3],[-4,6],[-4,5],[-4,3],[-10,8],[-10,7],[-10,6],[-10,5],[-10,3]]
		to:[[-10,3],[-10,5],[-10,6],[-10,7],[-10,8],[-4,3],[-4,5],[-4,6],[0,3],[0,3]]
		 */

	}

}
