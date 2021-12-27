import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sk
 * @time 2021/11/3
 * @desc say
 **/
public class L933 {

	/*
	 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
	 * <p>
	 * 请实现 RecentCounter 类：
	 * <p>
	 * RecentCounter() 初始化计数器，请求数为 0 。
	 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
	 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
	 * <p>
	 * <p>
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：
	 * inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
	 * inputs = [[], [1], [100], [3001], [3002]]
	 * 输出：
	 * [null, 1, 2, 3, 3]
	 * <p>
	 * 解释：
	 * RecentCounter recentCounter = new RecentCounter();
	 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
	 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
	 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
	 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= t <= 109
	 * 保证每次对 ping 调用所使用的 t 值都 严格递增
	 * 至多调用 ping 方法 104 次
	 */

	private List<Integer> list = new ArrayList<>();
	public int ping(int t) {
		list.add(t);
		int min = t - 3000;
		int i = 0;
		if (list.size() > 6000) {
			i = list.size() - 3000 - 1;
		}
		for (; i < list.size(); i++) {
			if (list.get(i) >= min) {
				return list.size() - i;
			}
		}
		return 1;
	}

	private Queue<Integer> queue = new ArrayDeque<>();
	public int ping2(int t) {
		queue.add(t);
		while (queue.peek() < t - 3000) {
			queue.poll();
			if (queue.isEmpty()) {
				break;
			}
		}
		return queue.size();
	}

	public static void main(String[] args) {
		L933 l933 = new L933();
//		System.err.println(l933.ping2(1));
//		System.err.println(l933.ping2(100));
//		System.err.println(l933.ping2(3001));
//		System.err.println(l933.ping2(3002));
//		System.err.println(l933.ping2(2002));
		for (int i = 1; i <= 7002; i++) {
			System.err.println(l933.ping2(i));
		}
	}

}
