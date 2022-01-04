import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/19
 * @desc say
 **/
public class L74_56 {

	/*
	 * 数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
	 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
	 * 输出：[[1,6],[8,10],[15,18]]
	 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 * 示例 2：
	 *
	 * 输入：intervals = [[1,4],[4,5]]
	 * 输出：[[1,5]]
	 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
	 *
	 *
	 * 提示：
	 *
	 * 1 <= intervals.length <= 104
	 * intervals[i].length == 2
	 * 0 <= starti <= endi <= 104
	 *
	 * 对二维数组第一个元素进行排序
	 * 遍历数组，如果下一个数组第一个元素 > 当前数组第二个元素时，不用合并，反之合并。
	 */

	public static int[][] merge(int[][] intervals) {
		List<int[]> temp = new ArrayList<>();
		Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
		for (int[] interval : intervals) {
			if (temp.isEmpty()) {
				temp.add(interval);
			} else {
				int[] pre = temp.get(temp.size() - 1);
				if (interval[0] <= pre[1]) {
					pre[1] = Math.max(pre[1], interval[1]);
				} else {
					temp.add(interval);
				}
			}
		}
		int[][] to = new int[temp.size()][2];
		for (int i = 0; i < temp.size(); i++) {
			to[i][0] = temp.get(i)[0];
			to[i][1] = temp.get(i)[1];
		}
		return to;
	}

	public static void findStart(List<Integer> temp, int key) {
		int start = 0;
		int end = temp.size() - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			int mV = temp.get(mid);
			if (mV == key) {
				start = mid;
				break;
			}
			if (mV < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (start >= temp.size()) {
			temp.add(key);
		} else {
			temp.set(start, key);
		}
	}

	public static void findEnd(List<Integer> temp, int key) {
		int start = 0;
		int end = temp.size() - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			int mV = temp.get(mid);
			if (mV == key) {
				end = mid;
				break;
			}
			if (mV < key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (end >= temp.size()) {
			temp.add(key);
		} else {
			temp.set(end, key);
		}
	}

	public static void main(String[] args) {
		int[][] ni;
		ni = new int[][]{
				{1,4},{5,6},{3,8},{9,10}
		};
		System.err.println(JSON.toJSONString(merge(ni)));

		ni = new int[][]{
				{1,4}
		};
		System.err.println(JSON.toJSONString(merge(ni)));

		ni = new int[][]{
				{1,4},{4,8},{3,5},{9,10}
		};
		System.err.println(JSON.toJSONString(merge(ni)));
	}

}
