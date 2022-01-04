/**
 * @author sk
 * @time 2021/11/17
 * @desc say
 **/
public class L67_421_$ {

	/*
	 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。异或运算
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [3,10,5,25,2,8]
	 * 输出：28
	 * 解释：最大运算结果是 5 XOR 25 = 28.
	 * 示例 2：
	 * <p>
	 * 输入：nums = [0]
	 * 输出：0
	 * 示例 3：
	 * <p>
	 * 输入：nums = [2,4]
	 * 输出：6
	 * 示例 4：
	 * <p>
	 * 输入：nums = [8,10,2]
	 * 输出：10
	 * 示例 5：
	 * <p>
	 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
	 * 输出：127
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= nums.length <= 2 * 104
	 * 0 <= nums[i] <= 231 - 1
	 * <p>
	 * <p>
	 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
	 */

	static class Tree {
		Tree left; //0
		Tree right; //1
	}

//	static char c0 = '0';
//	static char c1 = '1';
//
//	public static int handle(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		if (nums.length == 1) {
//			return nums[0];
//		}
//		Tree left = null;
//		Tree right = null;
//
//		int max = Integer.MIN_VALUE;
//		for (int num : nums) {
//			char[] ch = Integer.toBinaryString(num).toCharArray();
//			if (ch[ch.length - 1] == c0 && left == null) {
//				left = initTree(ch);
//				max = num ^ Math.max(max, 0);
//				continue;
//			} else if (ch[ch.length - 1] == c1 && right == null) {
//				right = initTree(ch);
//				max = num ^ Math.max(max, 0);
//				continue;
//			}
//			for (int i = ch.length - 1; i >= 0; i--) {
//				if (ch[i] == c0 && left == null) {
//					Tree tree = new Tree();
//					tree.c = ch[i];
//					left = tree;
//				}
//			}
//		}
//
//		return max;
//	}
//
//	public static int cal(char[] ch, int max, Tree root) {
//		Tree temp = root;
//		for (int i = ch.length - 1; i >= 0; i--) {
//
//		}
//		return 0;
//	}
//
//	public static int handle2(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		} else if (nums.length == 1) {
//			return 0;
//		}
//
//		int res = 0;
//		for (int i = 0; i < nums.length; i++) {
//			int temp = nums[i];
//			for (int j = i + 1; j < nums.length; j++) {
//				res = Math.max(temp ^ nums[j], res);
//			}
//		}
//		return res;
//	}
//
//	public static Tree initTree(char[] ch) {
//		Tree root = new Tree();
//		root.c = ch[ch.length - 1];
//		Tree temp = root;
//		for (int i = ch.length - 1; i >= 0; i--) {
//			Tree loop = new Tree();
//			loop.c = ch[i];
//			if (ch[i] == c0) {
//				temp.left = loop;
//			} else {
//				temp.right = loop;
//			}
//			temp = loop;
//		}
//		temp.isEnd = true;
//		return root;
//	}

	public static void main(String[] args) {
		L67_421_$ l421$难 = new L67_421_$();
		int[] nums;
		nums = new int[]{2,7,8};
		System.err.println(l421$难.findMaximumXOR(nums));
	}

	// 全局变量，一直累计前面数的值
	Tree root = new Tree();
	private static final int MAX_BIT = 31;

	/**
	 * 这个函数是计算num的各个位数，将每一位存入tree中
	 */
	private void split(int num) {
		// 赋值全局变量，在root的基础上将num进行拆分，这样在num之前的数，已经存入了tree
		Tree node = root;
		// 将num从高到低位存入
		for (int i = MAX_BIT; i >= 0; i--) {
			int bit = (num >> i) & 1;
			// 这一位为1，存入右节点
			if (bit == 1) {
				if (node.right == null) {
					node.right = new Tree();
				}
				node = node.right;
			} else {
				if (node.left == null) {
					node.left = new Tree();
				}
				node = node.left;
			}
		}
	}

	/**
	 * 假设num对应的下标为i，那么这个函数是为了求得nums[i]与num[j]的最大亦或值
	 * 其中j <= i，[0, j]下标对应的数，都已经按位拆分到了tree中，
	 * 这里只需要从高位开始，拆分num，对于每一位，只需要在tree中找到与num相反的位，异或即为1，
	 * 如此下来，每一层尽量让亦或值为1，得到的就是最大的异或值。
	 * 注意：从tree的根节点到叶子节点，表示一个数。
	 */
	private int maxAdd(int num) {
		Tree node = root;
		int res = 0;
		for (int i = MAX_BIT; i >= 0; i--) {
			int bit = (num >> i) & 1;
			// num该位为1，要找tree中的左节点即0
			if (bit == 1) {
				if (node.left != null) {
					res = res * 2 + 1;
					node = node.left;
				} else {
					res = res * 2;
					node = node.right;
				}
			} else {
				if (node.right != null) {
					res = res * 2 + 1;
					node = node.right;
				} else {
					res = res * 2;
					node = node.left;
				}
			}
		}

		return res;
	}

	public int findMaximumXOR(int[] nums) {
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			// 下标[0, i - 1]的数都会存在Tree中
			split(nums[i - 1]);
			max = Math.max(max, maxAdd(nums[i]));
		}

		return max;
	}
}
