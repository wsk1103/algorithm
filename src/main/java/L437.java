import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/8
 * @desc say
 **/
public class L437 {

	/**
	 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
	 * <p>
	 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
	 * 输出：3
	 * 解释：和等于 8 的路径有 3 条，如图所示。
	 * 示例 2：
	 * <p>
	 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
	 * 输出：3
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 二叉树的节点个数的范围是 [0,1000]
	 * -109 <= Node.val <= 109
	 * -1000 <= targetSum <= 1000
	 */

	public static int handle(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		return le(root, targetSum);
	}

	/**
	 * 		  10
	 * 	  5			-3
	 *  3,	 2		n	11
	 * 3,-2  n,1
	 */
	private static int ca(TreeNode node, Map<Integer, Integer> pre, int target, int sum) {
		if (node == null) {
			return 0;
		}
		int h;
		int curSum = node.val + sum;
		int next = curSum - target;
		h = pre.getOrDefault(next, 0);
		pre.put(curSum, pre.getOrDefault(curSum, 0) + 1);
//		if (node.val + sum == target) {
//			System.err.println(node.val + ":" + sum);
////			h = h + 1;
//		}
		if (node.left != null) {
			h += ca(node.left, pre, target, curSum);
		}
		if (node.right != null) {
			h += ca(node.right, pre, target, curSum);
		}
		pre.put(curSum, pre.getOrDefault(curSum, 0) - 1);
		return h;
	}

	private int dfs(TreeNode root, HashMap<Integer, Integer> prefix, int curr, int targetSum) {
		if (root == null) {
			return 0;
		}

		int ret;
		curr += root.val;

		ret = prefix.getOrDefault(curr - targetSum, 0);
		prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

		ret += dfs(root.left, prefix, curr, targetSum);
		ret += dfs(root.right, prefix, curr, targetSum);
		prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

		return ret;
	}

	private static int le(TreeNode node, int target) {
		if (node == null) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int h = 0;
		h += ca(node, map, target, 0);
//		h += le(node.left, target);
//		h += le(node.right, target);
		return h;
	}

	/**
	 * 		  10
	 * 	  5			-3
	 *  3,	 2		n	11
	 * 3,-2  n,1
	 */
	public static void main(String[] args) {
		L297 l297 = new L297();
		String s = "10,5,-3,3,2,n,11,3,-2,n,1";
		TreeNode node = l297.deserialize(s);
		int sum = handle(node, 8);
		System.err.println(sum);
	}

}
