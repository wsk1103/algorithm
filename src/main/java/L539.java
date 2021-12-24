import java.util.Arrays;
import java.util.List;

/**
 * @author sk
 * @time 2021/10/29
 * @desc say
 **/
public class L539 {

	/*
	 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：timePoints = ["23:59","00:00"]
	 * 输出：1
	 * 示例 2：
	 * <p>
	 * 输入：timePoints = ["00:00","23:59","00:00"]
	 * 输出：0
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 2 <= timePoints <= 2 * 104
	 * timePoints[i] 格式为 "HH:MM"
	 */

	public static int handle(List<String> timePoints) {
		int[] times = new int[timePoints.size()];
		int i = 0;
		for (String s : timePoints) {
			String s1 = s.substring(0, 2);
			String s2 = s.substring(3);
			int i1 = Integer.parseInt(s1) * 60;
			int i2 = Integer.parseInt(s2);
			int time = i1 + i2;
			times[i++] = time;
		}
		if (times.length == 2) {
			int jj = Math.abs(times[1] - times[0]);
			return Math.min(1440 - jj, jj);
		}
		Arrays.sort(times);
		int re = times[1] - times[0];
		if (re == 0) {
			return 0;
		}
		for (int j = 1; j < times.length; j++) {
			int tem = j + 1;
			if (tem >= times.length) {
				tem = 0;
			}
			int t = Math.abs(times[tem] - times[j]);
			if (t == 0) {
				return 0;
			}
			t = Math.min(1440 - t, t);
			if (t < re) {
				re = t;
			}
		}
		return re;
	}

	public static void main(String[] args) {
//		System.err.println(handle(Arrays.asList("23:59","00:00")));

		System.err.println(handle(Arrays.asList("23:59","00:00","11:01")));
	}

}
