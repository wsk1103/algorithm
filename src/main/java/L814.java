import com.alibaba.fastjson.JSON;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
public class L814 {

	/*
	 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
	 * <p>
	 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: [1,null,0,0,1]
	 * 输出: [1,null,0,null,1]
	 * 解释:
	 * 只有红色节点满足条件“所有不包含 1 的子树”。
	 * 右图为返回的答案。
	 * <p>
	 * <p>
	 * 示例 2:
	 * <p>
	 * 输入: [1,0,1,0,0,0,1]
	 * 输出: [1,null,1,null,1]
	 * 解释:
	 * <p>
	 * <p>
	 * 示例 3:
	 * <p>
	 * 输入: [1,1,0,1,1,0,1,0]
	 * 输出: [1,1,0,1,1,null,1]
	 * 解释:
	 * <p>
	 * <p>
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 二叉树的节点个数的范围是 [1,200]
	 * 二叉树节点的值只会是 0 或 1
	 */

	public static TreeNode handle(TreeNode root) {
		return loop(root);
	}

	public static TreeNode loop(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left = loop(root.left);
		}
		if (root.right != null) {
			root.right = loop(root.right);
		}
		if (root.left == null && root.right == null) {
			if (root.val == 0) {
				return null;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(0);
		TreeNode n6 = new TreeNode();
		n1.left = n2;
//		n1.right = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		TreeNode re = handle(n1);
		System.err.println(JSON.toJSONString(re));
	}

}
