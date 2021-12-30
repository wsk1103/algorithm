/**
 * @author sk
 * @time 2021/11/18
 * @desc say
 **/
public class L35 {

	/*
	 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，
	 * 并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * <p>
	 * 请必须使用时间复杂度为 O(log n) 的算法。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: nums = [1,3,5,6], target = 5
	 * 输出: 2
	 * 示例 2:
	 * <p>
	 * 输入: nums = [1,3,5,6], target = 2
	 * 输出: 1
	 * 示例 3:
	 * <p>
	 * 输入: nums = [1,3,5,6], target = 7
	 * 输出: 4
	 * 示例 4:
	 * <p>
	 * 输入: nums = [1,3,5,6], target = 0
	 * 输出: 0
	 * 示例 5:
	 * <p>
	 * 输入: nums = [1], target = 0
	 * 输出: 0
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= nums.length <= 104
	 * -104 <= nums[i] <= 104
	 * nums 为无重复元素的升序排列数组
	 * -104 <= target <= 104
	 */

	public static int handle(int[] nums, int target) {
		return find(nums, 0, nums.length, target);
	}

	public static int find(int[] nums, int start, int end, int target) {
		int mid = (start + end) / 2;
		int temp = nums[mid];
		if (temp == target) {
			return mid;
		}
		if (mid == 0) {
			if (target < nums[mid]) {
				return 0;
			}
			if (mid + 1 < nums.length) {
				int right = nums[mid + 1];
				if (temp < target && right > target) {
					return mid + 1;
				}
			}
		}
		if (mid == nums.length - 1) {
			if (target > nums[mid]) {
				return nums.length;
			}
			if (mid - 1 >= 0) {
				int left = nums[mid - 1];
				if (temp > target && left < target) {
					return mid;
				}

			}
		}
		if (mid > 0 && mid < nums.length - 2) {
			int right = nums[mid + 1];
			if (temp < target && right > target) {
				return mid + 1;
			}
			int left = nums[mid - 1];
			if (temp > target && left < target) {
				return mid;
			}
		}
		if (temp > target) {
			return find(nums, start, mid - 1, target);
		} else {
			return find(nums, mid + 1, end, target);
		}
	}

	public static int handle2(int[] nums, int target) {
		return find2(nums, 0, nums.length - 1, target);
	}

	public static int find2(int[] nums, int start, int end, int target) {
		int mid = (start + end) / 2;
		if (target == nums[mid]) {
			return mid;
		}
		if ((start == 0 && end == 0)
				|| (start == nums.length - 1 && end == nums.length - 1)
				|| start >= end) {
			if (target > nums[mid]) {
				return mid + 1;
			} else {
				return mid;
			}
		}
		if (nums[mid] > target) {
			return find2(nums, start, mid - 1, target);
		} else {
			return find2(nums, mid + 1, end, target);
		}
	}

	public static void main(String[] args) {
		int[] nums;
		int target;
		nums = new int[]{1, 3};
		target = 0;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));
		target = 4;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));
		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 5;
		System.err.println(handle(nums, target));
//		System.err.println(handle2(nums, target));

		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 3;
		System.err.println(handle(nums, target));
//		System.err.println(handle2(nums, target));


		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 4;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));

		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 0;
		System.err.println(handle(nums, target));

		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 8;
		System.err.println(handle(nums, target));

		nums = new int[]{1, 3, 5, 6, 7, 8};
		target = 9;
		System.err.println(handle(nums, target));

		System.err.println("--------");
		nums = new int[]{1, 3, 5, 7, 9};
		target = 5;
		System.err.println(handle(nums, target));

		nums = new int[]{1, 3, 5, 7, 9};
		target = 3;
		System.err.println(handle(nums, target));


		nums = new int[]{1, 3, 5, 7, 9};
		target = 4;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));

		nums = new int[]{1, 3, 5, 7, 9};
		target = 0;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));

		nums = new int[]{1, 3, 5, 7, 9};
		target = 8;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));

		nums = new int[]{1, 3, 5, 7, 9};
		target = 9;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));
		nums = new int[]{1, 3, 5, 7, 9};
		target = 10;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));
		nums = new int[]{3};
		target = 1;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));
		nums = new int[]{3};
		target = 5;
		System.err.println(handle(nums, target));
		System.err.println(handle2(nums, target));

	}

}
