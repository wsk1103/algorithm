import lombok.Data;

/**
 * @author sk
 * @time 2021/11/4
 * @desc say
 **/
@Data
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String l = left != null ? left.val + "" : "null";
		String r = right != null ? right.val + "" : "null";
		return "TreeNode{" +
				"val=" + val +
				", left=" + l +
				", right=" + r +
				'}';
	}
}
