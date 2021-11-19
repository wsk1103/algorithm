import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class L148 {

	/**
	 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：head = [4,2,1,3]
	 * 输出：[1,2,3,4]
	 * 示例 2：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：head = [-1,5,3,4,0]
	 * 输出：[-1,0,3,4,5]
	 * 示例 3：
	 * <p>
	 * 输入：head = []
	 * 输出：[]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 链表中节点的数目在范围 [0, 5 * 104] 内
	 * -105 <= Node.val <= 105
	 * <p>
	 * <p>
	 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
	 */

	public static ListNode handle(ListNode head) {
		if (head == null) {
			return null;
		}
		List<Integer> treeSet = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			treeSet.add(temp.val);
			temp = temp.next;
		}
		Collections.sort(treeSet);
		ListNode first = null;
		ListNode loop = null;
		for (Integer integer : treeSet) {
			ListNode to = new ListNode();
			to.val = integer;
			if (loop == null) {
				first = to;
				loop = to;
			} else {
				loop.next = to;
				loop = to;
			}
		}
		return first;
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{5,3,4,8,2,4,1,7,8,6,2};
		ListNode node = NodeSer.ser(nums);
		ListNode to = handle(node);

		System.err.println(JSONUtil.toJsonStr(NodeSer.enSer(to)));
	}

}
