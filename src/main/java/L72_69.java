/**
 * @author sk
 * @time 2021/11/18
 * @desc say
 **/
public class L72_69 {

	/*
	 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
	 * <p>
	 * 正数的平方根有两个，只输出其中的正数平方根。
	 * <p>
	 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: x = 4
	 * 输出: 2
	 * 示例 2:
	 * <p>
	 * 输入: x = 8
	 * 输出: 2
	 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 0 <= x <= 231 - 1
	 */

	public static int handle(int x) {
		long min = 1;
		long max = x;
		long mid = (min + max) >> 1;
		long temp;
		do {
			if (mid * mid == x) {
				break;
			}
			if (mid * mid > x) {
				max = mid;
			} else {
				min = mid;
			}
			temp = min;
			mid = (min + max) >> 1;
		} while (Math.abs(temp - mid) > 0);
		return (int)mid;
	}

	public static int handle2(int x) {
		long min = 1;
		long max = x;
		long mid = (min + max) >> 1;
		long temp = 0;
		while (Math.abs(temp - mid) > 0) {
			if (mid * mid == x) {
				break;
			}
			if (mid * mid > x) {
				max = mid;
			} else {
				min = mid;
			}
			temp = min;
			mid = (min + max) >> 1;
		}
		return (int)mid;
	}

//	public static int min(int x, int s) {
//		while (s * s > x) {
//			s = (s + s / 2) / 2;
//		}
//		return s;
//	}
//
//	public static int max(int x, int s) {
//		while (s * s < x) {
//			s = (s + s / 2);
//		}
//		return s;
//	}

	public static void main(String[] args) {
		System.err.println(handle(2147395599));
		System.err.println(handle2(2147395599));
		System.err.println(handle(1));
		System.err.println(handle2(1));
		System.err.println(handle(2));
		System.err.println(handle(3));
		System.err.println(handle(4));
		System.err.println(handle(5));
		System.err.println(handle(6));
		System.err.println(handle(7));
		System.err.println(handle(8));
		System.err.println(handle(9));
		System.err.println(handle(1024));
	}
}
