import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sk
 * @time 2021/11/2
 * @desc say
 **/
public class L37_735 {

	/*
	 * 给定一个整数数组 asteroids，表示在同一行的小行星。
	 * <p>
	 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
	 * <p>
	 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：asteroids = [5,10,-5]
	 * 输出：[5,10]
	 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
	 * 示例 2：
	 * <p>
	 * 输入：asteroids = [8,-8]
	 * 输出：[]
	 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
	 * 示例 3：
	 * <p>
	 * 输入：asteroids = [10,2,-5]
	 * 输出：[10]
	 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
	 * 示例 4：
	 * <p>
	 * 输入：asteroids = [-2,-1,1,2]
	 * 输出：[-2,-1,1,2]
	 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 2 <= asteroids.length <= 104
	 * -1000 <= asteroids[i] <= 1000
	 * asteroids[i] != 0
	 * 栈
	 */

	public static int[] handle(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (Integer a : asteroids) {
			if (stack.isEmpty()) {
				stack.push(a);
				continue;
			}
			int t = stack.pop();
			while (t > 0 && a < 0) {
				if (Math.abs(t) > Math.abs(a)) {
					a = t;
					t = 0;
				} else if (t + a == 0) {
					a = 0;
					t = 0;
					break;
				} else {
					t = 0;
				}
				if (!stack.isEmpty()) {
					t = stack.pop();
				}
			}
			if (t != 0) {
				stack.push(t);
			}
			if (a != 0) {
				stack.push(a);
			}
		}
		int[] re = new int[stack.size()];
		for (int i = re.length - 1; i >= 0; i--) {
			re[i] = stack.pop();
		}
		return re;
	}

	public static int[] handle2(int[] asteroids) {
		int size = 0;
		for (int a : asteroids) {
			if (size == 0) {
				asteroids[size++] = a;
			} else {
				int l = asteroids[--size];
				while (l > 0 && a < 0) {
					if (Math.abs(l) > Math.abs(a)) {
						a = l;
						l = 0;
					} else if (l + a == 0) {
						a = 0;
						l = 0;
					} else {
						l = 0;
					}
					if (--size >= 0) {
						l = asteroids[size];
					}
				}
				if (size < 0) {
					size = 0;
				}
				if (l != 0) {
					asteroids[size++] = l;
				}
				if (a != 0) {
					asteroids[size++] = a;
				}
			}
		}
		return Arrays.copyOf(asteroids, size);
	}

	public static void main(String[] args) {
		int[] i;
		i = new int[]{5, 10, -5};
		System.err.println(JSON.toJSONString(handle2(i)));
		i = new int[]{2,2,-9};
		System.err.println(JSON.toJSONString(handle2(i)));

		i = new int[]{10, 2, -5};
		System.err.println(JSON.toJSONString(handle2(i)));

		i = new int[]{-2, -1, 1, 2};
		System.err.println(JSON.toJSONString(handle2(i)));

		i = new int[]{8, 8};
		System.err.println(JSON.toJSONString(handle2(i)));
	}


}
