import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/5
 * @desc say
 **/
public class L129 {

	/*
	 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
	 * <p>
	 * 每条从根节点到叶节点的路径都代表一个数字：
	 * <p>
	 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
	 * 计算从根节点到叶节点生成的 所有数字之和 。
	 * <p>
	 * 叶节点 是指没有子节点的节点。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * 输入：root = [1,2,3]
	 * 输出：25
	 * 解释：
	 * 从根到叶子节点路径 1->2 代表数字 12
	 * 从根到叶子节点路径 1->3 代表数字 13
	 * 因此，数字总和 = 12 + 13 = 25
	 * 示例 2：
	 * <p>
	 * <p>
	 * 输入：root = [4,9,0,5,1]
	 * 输出：1026
	 * 解释：
	 * 从根到叶子节点路径 4->9->5 代表数字 495
	 * 从根到叶子节点路径 4->9->1 代表数字 491
	 * 从根到叶子节点路径 4->0 代表数字 40
	 * 因此，数字总和 = 495 + 491 + 40 = 1026
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中节点的数目在范围 [1, 1000] 内
	 * 0 <= Node.val <= 9
	 * 树的深度不超过 10
	 */

	public static int handle(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> list = new ArrayList<>();
		insert(root, root.val, list);
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		return sum;
	}

	public static void insert(TreeNode node, int v, List<Integer> list) {
		if (node == null || (node.left == null && node.right == null)) {
			list.add(v);
			return;
		}
		if (node.left != null) {
			insert(node.left, v * 10 + node.left.val, list);
		}
		if (node.right != null) {
			insert(node.right, v * 10 + node.right.val, list);
		}
	}

	public static int handle2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return add(root, root.val);
	}

	public static int add(TreeNode node, int sum) {
		if (node == null || (node.left == null && node.right == null)) {
			return sum;
		}
		int temp = 0;
		if (node.left != null) {
			temp += add(node.left, sum * 10 + node.left.val);
		}
		if (node.right != null) {
			temp += add(node.right, sum * 10 + node.right.val);
		}
		return temp;
	}

	public static void main(String[] args) {
		L297 l297 = new L297();
		String s = "4,9,0,n,n,5,1";
		TreeNode node = l297.deserialize(s);
		int sum = handle(node);
		System.err.println(sum);
		sum = handle2(node);
		System.err.println(sum);
	}

}
