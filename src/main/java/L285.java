import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/10
 * @desc say
 **/
public class L285 {

	/**
	 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
	 * <p>
	 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [2,1,3], p = 1
	 * 输出：2
	 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
	 * 示例 2：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
	 * 输出：null
	 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中节点的数目在范围 [1, 104] 内。
	 * -105 <= Node.val <= 105
	 * 树中各节点的值均保证唯一。
	 */

	private List<TreeNode> queue = new ArrayList<>();
	private int i = Integer.MAX_VALUE;

	public TreeNode handle(TreeNode root, TreeNode p) {
		loop(root, p);
		if (queue.size() <= i) {
			return null;
		}
		return queue.get(i);
	}

	private void loop(TreeNode node, TreeNode p) {
		if (node == null) {
			return;
		}
		if (p.val < node.val) {
			loop(node.left, p);
		}
		queue.add(node);
		if (p.val == node.val) {
//			queue.add(node);
			i = queue.size();
//			queue.add(node.right);
		}
		if (p.val >= node.val) {
			loop(node.right, p);
		}
	}

	public static void main(String[] args) {
		L297 l297 = new L297();
//		String s = "1,2,3,-1,n,n,n,5";
		String s = "5,3,6,2,4,null,8,1,null,null,null,7,9";
		TreeNode node = l297.deserialize(s);
		L285 l124 = new L285();
		TreeNode max = l124.handle(node, new TreeNode(6));
		System.err.println(max);

		//		String s = "1,2,3,-1,n,n,n,5";
		s = "2";
		node = l297.deserialize(s);
		l124 = new L285();
		max = l124.handle(node, new TreeNode(2));
		System.err.println(max);
	}

}
