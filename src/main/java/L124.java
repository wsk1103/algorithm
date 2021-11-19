import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/11/9
 * @desc say
 **/
public class L124 {

	/**
	 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
	 * 该路径 至少包含一个 节点，且不一定经过根节点。
	 * <p>
	 * 路径和 是路径中各节点值的总和。
	 * <p>
	 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * 1
	 * 2		3
	 * <p>
	 * <p>
	 * 输入：root = [1,2,3]
	 * 输出：6
	 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
	 * 示例 2：
	 * -10
	 * 9			20
	 * 15		7
	 * <p>
	 * <p>
	 * 输入：root = [-10,9,20,null,null,15,7]
	 * 输出：42
	 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 树中节点数目范围是 [1, 3 * 104]
	 * -1000 <= Node.val <= 1000
	 */
	/**
	 * 1
	 * -2,3
	 *
	 * @param root
	 * @return
	 */
	public static Map<String, Integer> map = new HashMap<>();
	public static int handle(TreeNode root) {
		if (root == null) {
			return 0;
		}
//		Map<String, Integer> map = new HashMap<>();
		int rootL = sumMax(root.left, root.val);
		int rootR = sumMax(root.right, root.val);
		map.put(root.toString() + "U", rootR);//1

		int m = han(root, root.left, root.val);
		map.put(root.toString() + "U", rootL);//1
		int j = han(root, root.right, root.val);
		return Math.max(m, j);
	}

	public static int han(TreeNode parent, TreeNode root, int max) {
		if (root == null) {
			return max;
		}
		int temp = cal(parent, root, map);
		max = Math.max(temp, max);
		if (root.left != null) {
			max = han(root, root.left, max);
		}
		if (root.right != null) {
			max = han(root, root.right, max);
		}
		return max;
	}

	public static int cal(TreeNode parent, TreeNode node, Map<String, Integer> map) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
//		if (node.val < 0) {
//			map.put(node.toString() + "U", node.val);
//			map.put(node.toString() + "D", node.val);
//			return node.val;
//		}
		int maxP;
		int sumL = node.val, sumR = node.val;
		if (parent == null) {
			maxP = node.val;
		} else {
			maxP = Math.max(map.get(parent.toString() + "U") + node.val, node.val);
			if (parent.left != null && parent.left != node) {
				maxP = Math.max(maxP, map.get(parent.left.toString() + "D") + parent.val + node.val);
			}
		}
		if (node.left != null) {
			sumL = sumMax(node.left, sumL);
		}
		if (node.right != null) {
			sumR = sumMax(node.right, sumR);
		}
		int sum = Math.max(sumL, sumR);
		int max = Math.max(maxP, sum);
		map.put(node.toString() + "D", sum);
		map.put(node.toString() + "U", maxP);
		return max;
	}

	/**
	 * 1,2,3,-1,n,n,n,5
	 * 		1
	 * 2		3
	 * -1
	 * 5
	 */
	public static int sumMax(TreeNode node, int sum) {
		if (node == null) {
			return sum;
		}
//		if (map.containsKey(node.toString())) {
//			return map.get(node.toString());
//		}
		int ret = node.val + sum;
		if (node.left != null) {
			ret = sumMax(node.left, ret);
		}
		int temp = Integer.MIN_VALUE;
		if (node.right != null) {
			temp = sumMax(node.right, node.val + sum);
		}
		ret = Math.max(ret, sum);
		ret = Math.max(ret, temp);
//		map.put(node.toString(), ret);
		return ret;
	}

	/**
	 * f(n) = max(f(n.parent.U), f(n.parent.left.D) + n.parent.val) + max(sum(left), sum(right))
	 * f(n.U) = f(n.parent.U) + n.val
	 * f(n.D) = sum(n) = max(sum(left), sum(right))
	 *
	 * sum(n) = max(sum(n.left), sum(n.right))
	 *
	 * root.parent = null
	 * root.parent.U = int.min
	 * root.parent.left.D = int.min
	 */
	public static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		}
//		int ret = node.val + sum;
//		int m = Math.max(ret, sum);
		if (node.left == null && node.right == null) {
			map.put(node.toString(), node.val);
			return node.val;
		}
		int l = node.val;
		if (node.left != null) {
			l += sum(node.left);
//			map.put(node.left.toString(), l);
		}
		int r = node.val;
		if (node.right != null) {
			r += sum(node.right);
//			map.put(node.right.toString(), r);
		}
		int max = Math.max(l, r);
		map.put(node.toString(), max);
		return max;
	}

	public static int handle2(TreeNode root) {

		int i = sum(root);
		if (root.right == null) {
			i = root.val;
		} else {
			i = root.val + map.get(root.right.toString());
		}
		map.put(root.toString() + "U", i);
		int re = loop(root, root.left, root.val);

		if (root.left == null) {
			i = root.val;
		} else {
			i = root.val + map.get(root.left.toString());
		}
		map.put(root.toString() + "U", i);
		int re2 = loop(root, root.right, root.val);

		return Math.max(re, re2);
	}

	public static int loop(TreeNode parent, TreeNode node, int max) {
		if (node == null) {
			return max;
		}
		int mm = hhc(parent, node, max);
		int temp = loop(parent, node.left, max);
		int temp2 = loop(parent, node.right, max);
		mm = Math.max(mm, temp);
		mm = Math.max(mm, temp2);
		return mm;
	}

	public static int hhc(TreeNode parent, TreeNode node, int max) {

		if (node == null) {
			return max;
		}
		int pU = Integer.MIN_VALUE;
		int pLd = Integer.MIN_VALUE;
		int maxP = Integer.MIN_VALUE;
		if (parent != null) {
			pU = map.get(parent.toString() + "U");
			if (parent.left != null && parent.left != node) {
				pLd = map.get(parent.left.toString() + "D") + parent.val;
			}
			maxP = Math.max(pU, pLd);
			map.put(node.toString() + "U", pU + node.val);
		}
		int maxL = node.val;
		if (node.left != null) {
			maxL = map.get(node.left.toString());
		}
		int maxR = node.val;
		if (node.right != null) {
			maxR = map.get(node.right.toString());
		}
		int maxT = Math.max(maxL, maxR);
		map.put(node.toString() + "D", maxT);
		maxT = maxT + maxP;
		max = Math.max(maxL, maxT);
		return max;

	}


	int max = Integer.MIN_VALUE;

	public int handle3(TreeNode root) {

		loop2(root);
		return max;
	}

	public int loop2(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, loop2(node.left));
		int right = Math.max(0, loop2(node.right));

		max = Math.max(max, node.val + left + right);
		return Math.max(left, right) + node.val;

	}

	/**
	 *		1
	 * 2 		3
	 * -1
	 * 5
	 */
	public static void main(String[] args) {
		L297 l297 = new L297();
//		String s = "1,2,3,-1,n,n,n,5";
		String s = "1,2,3";
		TreeNode node = l297.deserialize(s);
		L124 l124 = new L124();
		int max = l124.handle3(node);
		System.err.println(max);

		l124 = new L124();
		s = "1,2";
		node = l297.deserialize(s);
		max = l124.handle3(node);
		System.err.println(max);

		l124 = new L124();
		s = "-10,9,20,null,null,15,7";
		node = l297.deserialize(s);
		max = l124.handle3(node);
		System.err.println(max);
		l124 = new L124();
		s = "1,2,3,-1,n,n,n,5";
		node = l297.deserialize(s);
		max = l124.handle3(node);
		System.err.println(max);

//		System.err.println(sum(node));
//		System.err.println();
	}

}
