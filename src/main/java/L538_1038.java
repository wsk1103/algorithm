import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/10
 * @desc say
 **/
public class L538_1038 {

	/*
	 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
	 * <p>
	 * <p>
	 * <p>
	 * 提醒一下，二叉搜索树满足下列约束条件：
	 * <p>
	 * 节点的左子树仅包含键 小于 节点键的节点。
	 * 节点的右子树仅包含键 大于 节点键的节点。
	 * 左右子树也必须是二叉搜索树。
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
	 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
	 * 示例 2：
	 * <p>
	 * 输入：root = [0,null,1]
	 * 输出：[1,null,1]
	 * 示例 3：
	 * <p>
	 * 输入：root = [1,0,2]
	 * 输出：[3,3,2]
	 * 示例 4：
	 * <p>
	 * 输入：root = [3,2,4,1]
	 * 输出：[7,9,4,10]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中的节点数介于 0 和 104 之间。
	 * 每个节点的值介于 -104 和 104 之间。
	 * 树中的所有值 互不相同 。
	 * 给定的树为二叉搜索树。
	 */

	List<TreeNode> queue = new ArrayList<>();

	public TreeNode handle(TreeNode root) {
		loop(root);

		if (queue.isEmpty()) {
			return root;
		}
		for (int i = queue.size() - 2; i >= 0; i--) {
			TreeNode node = queue.get(i);
			TreeNode next = queue.get(i + 1);
			node.val = node.val + next.val;
		}
		return root;
	}

	public TreeNode handle2(TreeNode root) {
		loop2(root);
		return root;
	}

	public void loop(TreeNode node) {
		if (node == null) {
			return;
		}
//		node.val = node.val + r;
		loop(node.left);
		queue.add(node);
		loop(node.right);
	}

	public int loop2(TreeNode node) {
		if (node == null) {
			return 0;
		}
//		int sum = node.val;
		int l = node.val;
		int r = node.val;
		l += loop2(node.left);
		node.val = l;
		r += loop2(node.right);
		if (node.left == null && node.right == null) {
			return node.val;
		} else if (node.left == null) {
			return node.val + r;
		} else if (node.right == null) {
			return node.val + l;
		}
		return l + r;
	}

	public static void main(String[] args) {
		L297 l297 = new L297();
//		String s = "1,2,3,-1,n,n,n,5";
		String s = "5,3,6,2,4,null,8,1,null,null,null,7,9";
		TreeNode node = l297.deserialize(s);
		L538_1038 l124 = new L538_1038();
		TreeNode max = l124.handle2(node);
		System.err.println(l297.serialize(max));
		node = l297.deserialize(s);
		max = l124.handle(node);
		System.err.println(l297.serialize(max));

		//		String s = "1,2,3,-1,n,n,n,5";
		s = "2";
		node = l297.deserialize(s);
		l124 = new L538_1038();
		max = l124.handle(node);
		System.err.println(max);
	}

}
