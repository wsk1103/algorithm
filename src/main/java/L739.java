import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author sk
 * @time 2021/11/2
 * @desc say
 **/
public class L739 {

	/*
	 * 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
	 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: temperatures = [73,74,75,71,69,72,76,73]
	 * 输出: [1,1,4,2,1,1,0,0]
	 * 示例 2:
	 * <p>
	 * 输入: temperatures = [30,40,50,60]
	 * 输出: [1,1,1,0]
	 * 示例 3:
	 * <p>
	 * 输入: temperatures = [30,60,90]
	 * 输出: [1,1,0]
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= temperatures.length <= 105
	 * 30 <= temperatures[i] <= 100
	 */

	public static int[] handle(int[] temperatures) {
		int[] aa = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}
			int t = temperatures[i];
			int s = stack.peek();
			while (t > temperatures[s]) {
				s = stack.pop();
				int b = i - s;
				aa[s] = b;
				if (stack.isEmpty()) {
					break;
				}
				s = stack.peek();
			}
			stack.push(i);
		}
		return aa;
	}

	public static void main(String[] args) {
		int[] i;
		i = new int[]{73,74,75,71,69,72,76,73};
		System.err.println(JSON.toJSONString(handle(i)));
		i = new int[]{30,40,50,60};
		System.err.println(JSON.toJSONString(handle(i)));
		i = new int[]{30,60,90};
		System.err.println(JSON.toJSONString(handle(i)));
		i = new int[]{90, 60, 30};
		System.err.println(JSON.toJSONString(handle(i)));
	}

}
