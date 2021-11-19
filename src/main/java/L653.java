import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/10
 * @desc say
 **/
public class L653 {

	/**
	 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入: root = [8,6,10,5,7,9,11], k = 12
	 * 输出: true
	 * 解释: 节点 5 和节点 7 之和等于 12
	 * 示例 2：
	 * <p>
	 * 输入: root = [8,6,10,5,7,9,11], k = 22
	 * 输出: false
	 * 解释: 不存在两个节点值之和为 22 的节点
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 二叉树的节点个数的范围是  [1, 104].
	 * -104 <= Node.val <= 104
	 * root 为二叉搜索树
	 * -105 <= k <= 105
	 */

	Map<Integer, Integer> map = new HashMap<>();
	int i = 0;
	public boolean handle(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		boolean b = find(root, k);
		return b;
	}

	public boolean find(TreeNode node, int k) {
		if (node == null) {
			return false;
		}
		if (map.containsKey(k - node.val)) {
			return true;
		}
		map.put(node.val, node.val);
		boolean b;
		b = find(node.left, k);
		if (b) {
			return b;
		} else {
			b = find(node.right, k);
		}
		System.err.println(++i);
		return b;
	}

	public static void main(String[] args) {
		L297 l297 = new L297();
//		String s = "1,2,3,-1,n,n,n,5";
		String s = "5,3,6,2,4,null,8,1,null,null,null,7,9";
		TreeNode node = l297.deserialize(s);
		L653 l124 = new L653();
		boolean max = l124.handle(node, 2);
		System.err.println(max);
	}

}
