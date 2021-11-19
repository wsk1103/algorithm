import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class NodeSer {

	public static ListNode ser(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		ListNode first = null;
		ListNode loop = null;
		for (Integer integer : nums) {
			ListNode to = new ListNode();
			to.val = integer;
			if (loop == null) {
				first = to;
				loop = to;
			} else {
//				first.next = to;
				loop.next = to;
				loop = to;
			}
		}
		return first;
	}

	public static int[] enSer(ListNode node) {
		if (node == null) {
			return new int[0];
		}
		List<Integer> to = new ArrayList<>();
		while (node != null) {
			to.add(node.val);
			node = node.next;
		}
		int[] re = new int[to.size()];
		for (int i = 0; i < to.size(); i++) {
			re[i] = to.get(i);
		}
		return re;
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1,2,3,4,5,6,7,8};
		ListNode head = ser(nums);

		int[] rr = enSer(head);
		System.err.println(JSONUtil.toJsonStr(rr));

	}

}
