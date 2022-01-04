import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L45_513 {

	/*
	 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
	 * <p>
	 * 假设二叉树中至少有一个节点。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * <p>
	 * <p>
	 * 输入: root = [2,1,3]
	 * 输出: 1
	 * 示例 2:
	 * <p>
	 * <p>
	 * <p>
	 * 输入: [1,2,3,4,null,5,6,null,null,7]
	 * 输出: 7
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 二叉树的节点个数的范围是 [1,104]
	 * -231 <= Node.val <= 231 - 1
	 */

	public static int handle(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		q1.offer(root);
		int cur = 1;
		int next = 0;
		while (!q1.isEmpty()) {
			TreeNode t = q1.poll();
			q2.offer(t.val);
			if (t.left != null) {
				q1.offer(t.left);
				next++;
			}
			if (t.right != null) {
				q1.offer(t.right);
				next++;
			}
			if (--cur <= 0) {
				if (next != 0) {
					q2.clear();
				}
				cur = next;
				next = 0;
			}
		}
		return q2.poll();
	}

	//从右边 -> 左边
	public static int handle2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (queue.size() == 0) {
				queue.add(node);
				break;
			}
		}
		return queue.poll().val;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
//		n1.right = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		System.err.println(JSON.toJSONString(handle(n1)));
		System.err.println(JSON.toJSONString(handle2(n1)));
	}

}
