/**
 * @author sk
 * @time 2021/11/18
 * @desc say
 **/
public class L852 {

	/**
	 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
	 * <p>
	 * arr.length >= 3
	 * 存在 i（0 < i < arr.length - 1）使得：
	 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
	 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
	 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，
	 * 即山峰顶部。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：arr = [0,1,0]
	 * 输出：1
	 * 示例 2：
	 * <p>
	 * 输入：arr = [1,3,5,4,2]
	 * 输出：2
	 * 示例 3：
	 * <p>
	 * 输入：arr = [0,10,5,2]
	 * 输出：1
	 * 示例 4：
	 * <p>
	 * 输入：arr = [3,4,5,1]
	 * 输出：2
	 * 示例 5：
	 * <p>
	 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
	 * 输出：2
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 3 <= arr.length <= 104
	 * 0 <= arr[i] <= 106
	 * 题目数据保证 arr 是一个山脉数组
	 * <p>
	 * <p>
	 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
	 */

	public static int handle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return i;
			}
			if (arr[i + 1] < arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int handle2(int[] arr) {
		if (arr.length == 1) {
			return 0;
		}
		return find(arr, 0, arr.length);
	}

	public static int find(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		if (mid == 0) {
			if (arr[mid] > arr[mid + 1]) {
				return mid;
			}
			return find(arr, mid + 1, end);
		}
		if (mid == arr.length - 1) {
			if (arr[mid] > arr[mid - 1]) {
				return mid;
			}
			return find(arr, start, mid - 1);
		}
		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return mid;
		} else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
			return find(arr, mid + 1, end);
		} else {
			return find(arr, start, mid - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1,2,3,4,3,2,1,0};
		System.err.println(handle2(nums));

		nums = new int[]{1};
		System.err.println(handle2(nums));

		nums = new int[]{1,2,3,4};
		System.err.println(handle2(nums));

		nums = new int[]{4,3,2,1};
		System.err.println(handle2(nums));
	}

}
