import java.util.Arrays;

/**
 * @author sk
 * @time 2021/11/18
 * @desc say
 **/
public class L875_$ {

	/*
	 * 狒狒喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
	 * <p>
	 * 狒狒可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
	 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
	 * <p>
	 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
	 * <p>
	 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入: piles = [3,6,7,11], H = 8
	 * 输出: 4
	 * 示例 2：
	 * <p>
	 * 输入: piles = [30,11,23,4,20], H = 5
	 * 输出: 30
	 * 示例 3：
	 * <p>
	 * 输入: piles = [30,11,23,4,20], H = 6
	 * 输出: 23
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= piles.length <= 10^4
	 * piles.length <= H <= 10^9
	 * 1 <= piles[i] <= 10^9
	 */

	public static int handle(int[] piles, int h) {
		Arrays.sort(piles);
		int start = 1;
		int end = piles[ piles.length - 1];
		while (start < end) {
			int mid = (end + start) / 2;
			int cur = 0;
			for (int pile : piles) {
				//二分终止条件设置的是 l >= r ，所以 l 的更新必须是 l = m + 1 ，因为如果 l = r - 1 的话，m 会等于 l 。
				//为了防止整型溢出，计算 l 和 r 均值的时候不要写 (l + r) / 2 。
				//向上取整简单写法就是 (p + m - 1) / m 。
				//向下取整简单写法就是 (p + m) / m 。
				cur += (pile + mid - 1) / mid;
			}
			if (cur > h) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		int[] num;
		int h;
		num = new int[]{312884470};
		h = 312884469;
		System.err.println(handle(num, h));
	}

}
