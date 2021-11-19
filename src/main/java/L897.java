import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/10
 * @desc say
 **/
public class L897 {

	/**
	 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
	 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
	 * 示例 2：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [5,1,7]
	 * 输出：[1,null,5,null,7]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中节点数的取值范围是 [1, 100]
	 * 0 <= Node.val <= 1000
	 */

	private final Queue<TreeNode> queue = new LinkedList<>();

	public TreeNode handle(TreeNode root) {

		loop(root);
		if (queue.isEmpty()) {
			return root;
		}
//		TreeNode node;
		TreeNode re = queue.peek();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode right = null;
			if (!queue.isEmpty()) {
				right = queue.peek();
				right.left = null;
			}
			node.left = null;
			node.right = right;
		}
		return re;
	}

	private void loop(TreeNode node) {
		if (node == null) {
			return;
		}
		loop(node.left);
		queue.offer(node);
		loop(node.right);
	}

	public static void main(String[] args) {
		L297 l297 = new L297();
//		String s = "1,2,3,-1,n,n,n,5";
		String s = "5,3,6,2,4,null,8,1,null,null,null,7,9";
		TreeNode node = l297.deserialize(s);
		L897 l124 = new L897();
		TreeNode max = l124.handle(node);
		System.err.println(max);

		//		String s = "1,2,3,-1,n,n,n,5";
		s = "2";
		node = l297.deserialize(s);
		l124 = new L897();
		max = l124.handle(node);
		System.err.println(max);
	}

}
