import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/3
 * @desc say
 **/
public class L919 {

	/*
	 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
	 * <p>
	 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
	 * <p>
	 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
	 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
	 * CBTInserter.get_root() 将返回树的根节点。
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
	 * 输出：[null,1,[1,2]]
	 * 示例 2：
	 * <p>
	 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
	 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 最初给定的树是完全二叉树，且包含 1 到 1000 个节点。
	 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
	 * 给定节点或插入节点的每个值都在 0 到 5000 之间。
	 * <p>
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */

	static class CBTInserter {

		Queue<TreeNode> queue;
		TreeNode root;

		public CBTInserter(TreeNode root) {
			this.root = root;
			queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.peek();
				if (temp.left == null || temp.right == null) {
					break;
				}
				queue.offer(temp.left);
				queue.offer(temp.right);
				queue.poll();
			}

		}

		public int insert(int val) {
			TreeNode node = new TreeNode(val);
			TreeNode temp = queue.peek();
			if (temp.left == null) {
				temp.left = node;
			} else {
				temp.right = node;
				queue.offer(temp.left);
				queue.offer(temp.right);
				queue.poll();
			}
			return temp.val;

		}

		public TreeNode get_root() {
			return root;
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		root.left = l;
		root.right = r;

		CBTInserter cbtInserter = new CBTInserter(root);
		System.err.println(cbtInserter.insert(4));
		System.err.println(cbtInserter.insert(5));
		System.err.println(cbtInserter.insert(6));
		System.err.println(cbtInserter.insert(7));
		System.err.println(cbtInserter.insert(8));
		System.err.println(cbtInserter.insert(9));
		System.err.println(cbtInserter.insert(10));
		System.err.println(root);

	}

}
