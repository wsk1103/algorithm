import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L199 {

	/*
	 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * <p>
	 * <p>
	 * 输入: [1,2,3,null,5,null,4]
	 * 输出: [1,3,4]
	 * 示例 2:
	 * <p>
	 * 输入: [1,null,3]
	 * 输出: [1,3]
	 * 示例 3:
	 * <p>
	 * 输入: []
	 * 输出: []
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 二叉树的节点个数的范围是 [0,100]
	 * -100 <= Node.val <= 100
	 */

	public static List<Integer> handle(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> a = new ArrayList<>();
		queue.offer(root);
		int cur = 1;
		int next = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				next++;
				queue.offer(node.left);
			}
			if (node.right != null) {
				next++;
				queue.offer(node.right);
			}
			if (--cur <= 0) {
				cur = next;
				next = 0;
				a.add(node.val);
			}
		}
		return a;
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
	}

}
