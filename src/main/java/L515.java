import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L515 {

	/**
	 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
	 *
	 *
	 *
	 * 示例1：
	 *
	 * 输入: root = [1,3,2,5,3,null,9]
	 * 输出: [1,3,9]
	 * 解释:
	 *           1
	 *          / \
	 *         3   2
	 *        / \   \
	 *       5   3   9
	 * 示例2：
	 *
	 * 输入: root = [1,2,3]
	 * 输出: [1,3]
	 * 解释:
	 *           1
	 *          / \
	 *         2   3
	 * 示例3：
	 *
	 * 输入: root = [1]
	 * 输出: [1]
	 * 示例4：
	 *
	 * 输入: root = [1,null,2]
	 * 输出: [1,2]
	 * 解释:
	 *            1
	 *             \
	 *              2
	 * 示例5：
	 *
	 * 输入: root = []
	 * 输出: []
	 *
	 *
	 * 提示：
	 *
	 * 二叉树的节点个数的范围是 [0,104]
	 * -231 <= Node.val <= 231 - 1
	 */

	public static List<Integer> largestValues(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> re = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 1;
		int next = 0;
		int max = root.val;
		while (!queue.isEmpty()) {
			TreeNode node = queue.peek();
			if (node.left != null) {
				queue.offer(node.left);
				next++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				next++;
			}
			TreeNode temp = queue.poll();
			if (temp != null) {
				max = Math.max(temp.val, max);
			}
			count--;
			if (count == 0) {
				re.add(max);
				max = Integer.MIN_VALUE;
				count = next;
				next = 0;
			}
		}
		return re;
	}

	/**
	 * 1.第一个思路是利用一个队列和两个变量来实现，current变量用来记录队列中当前层个数，next变量用来记录队列中下一层元素的个数，根节点插入队列，
	 * 将current初始化为1，之后逐个从队列中取出节点遍历，每当从队列中取出一个节点时，当前层剩余节点就少1个current数量就减1，，
	 * 如果当前遍历的节点有子节点，那么将子节点插入队列中，由于子节点都位于当前遍历节点的下一层，因此队列中添加一个子节点，变量next数量加1。
	 * 当current的数值变为0时，当前层的所有节点都已经遍历完了通过MATH的max函数，通过之前的出队比较就能得出当前层的最大值，之后将current的值设置为next的值，
	 * 并把next初始化为0，重复这个过程，直到遍历完所有节点。
	 * 2.第二个思路时利用两个队列实现，第一个队列存当前层节点，第二个队列存下一层节点，开始将根节点入队队列1，之后每从队列中取出一个节点遍历，
	 * 如果当前层存在子节点，将子节点入队队列2，这样就将每一层分开了，当第一个队列为空时，也就是当前队列都被遍历完了，能找到这一层的最大值了，
	 * 在开始遍历下一层前，把队列queue1指向queue2，并将queue2重新初始化为空，重复此过程，直到所有节点遍历完为止。
	 * @param args
	 */
	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
//		TreeNode n6 = new TreeNode(6);
//		n1.left = n2;
//		n1.right = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n3.right = n6;
		System.err.println(JSON.toJSONString(largestValues(null)));
	}

}
