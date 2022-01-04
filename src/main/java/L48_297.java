import java.util.*;

/**
 * @author sk
 * @time 2021/11/5
 * @desc say
 **/
public class L48_297 {

	/*
	 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
	 * <p>
	 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * <p>
	 * <p>
	 * 输入：root = [1,2,3,null,null,4,5]
	 * 输出：[1,2,3,null,null,4,5]
	 * 示例 2：
	 * <p>
	 * 输入：root = []
	 * 输出：[]
	 * 示例 3：
	 * <p>
	 * 输入：root = [1]
	 * 输出：[1]
	 * 示例 4：
	 * <p>
	 * 输入：root = [1,2]
	 * 输出：[1,2]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这个问题。
	 * 树中结点数在范围 [0, 104] 内
	 * -1000 <= Node.val <= 1000
	 */

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int cur = 1, next = 0;
		while (!queue.isEmpty()) {
			TreeNode node;
			while (cur > 0) {
				node = queue.poll();
				if (node == null) {
					s.append("n,");
				} else {
					s.append(node.val).append(",");
					queue.offer(node.left);
					next++;
					queue.offer(node.right);
					next++;
				}
				cur--;
			}
			cur = next;
			next = 0;
		}
		s.delete(s.length() - 1, s.length());
		String t = s.substring(s.length() - 1, s.length());
		while ("n".equals(t)) {
			s.delete(s.length() - 2, s.length());
			t = s.substring(s.length() - 1, s.length());
		}
		return s.toString();
	}

	public String serialize2(TreeNode root) {
		if (root == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int cur = 1, next = 0;
		while (!queue.isEmpty()) {
			TreeNode node;
			boolean last = true;
			StringBuilder sb = new StringBuilder();
			while (cur > 0) {
				node = queue.poll();
				if (node == null) {
					sb.append("n,");
				} else {
					last = false;
					sb.append(node.val).append(",");
					queue.offer(node.left);
					next++;
					queue.offer(node.right);
					next++;
				}
				cur--;
			}
			cur = next;
			next = 0;
			if (!last) {
				s.append(sb);
			}
		}
		s.delete(s.length() - 1, s.length());
		String t = s.substring(s.length() - 1, s.length());
		while ("n".equals(t)) {
			s.delete(s.length() - 2, s.length());
			t = s.substring(s.length() - 1, s.length());
		}
		return s.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || "".equals(data)) {
			return null;
		}
		String[] s = data.split(",");
//		int lastLevel = cal(s.length);
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		for (String value : s) {
			q1.offer(handle(value));
		}
		TreeNode root = q1.poll();
		q2.offer(root);
		while (!q2.isEmpty() && !q1.isEmpty()) {
			TreeNode node = q2.poll();
//			q1.poll();
			if (node == null) {
				continue;
			}
			TreeNode left = q1.poll();
			TreeNode right = q1.poll();
			q2.offer(left);
			q2.offer(right);
			node.left = left;
			node.right = right;
		}
		return root;
	}

	private TreeNode handle(String s) {
		if ("n".equals(s) || "null".equals(s)) {
			return null;
		}
		return new TreeNode(Integer.parseInt(s));
	}

	private static final Map<Integer, TreeNode> map = new HashMap<>();
	Random random = new Random();
	public String serialize3(TreeNode root) {

		int i = random.nextInt(Integer.MAX_VALUE);
		while (map.containsKey(i)) {
			i = random.nextInt(Integer.MAX_VALUE);
		}
		map.put(i, root);
		return Integer.toString(i);
	}

	public TreeNode deserialize3(String data) {
		return map.get(Integer.parseInt(data));
	}


	public static void main(String[] args) {
		L48_297 l48297 = new L48_297();
		String s = "1,2,3,n,n,6,7,8,9";
		TreeNode node = l48297.deserialize3(s);
		String ss = l48297.serialize3(node);
		node = l48297.deserialize3(s);
		System.err.println(ss);
	}

}
