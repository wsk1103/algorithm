/**
 * @author sk
 * @time 2021/11/18
 * @desc say
 **/
public class L540 {

	/**
	 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: nums = [1,1,2,3,3,4,4,8,8]
	 * 输出: 2
	 * 示例 2:
	 * <p>
	 * 输入: nums =  [3,3,7,7,10,11,11]
	 * 输出: 10
	 * <p>
	 * <p>
	 * <p>
	 * <p>
	 * 提示:
	 * <p>
	 * 1 <= nums.length <= 105
	 * 0 <= nums[i] <= 105
	 * <p>
	 * <p>
	 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
	 */

	public static int handle(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				return nums[i];
			}
			if (nums[i] == nums[i + 1]) {
				i++;
				continue;
			}
			return nums[i];
		}
		return -1;
	}

	public static int handle2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return find(nums, 0, nums.length - 1);
	}

	public static int find(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		if (mid == 0) {
			if (nums[mid] != nums[mid + 1]) {
				return nums[mid];
			}
			return find(nums, mid + 1, end);
		} else if (mid == nums.length - 1) {
			if (nums[mid] != nums[mid - 1]) {
				return nums[mid];
			}
			return find(nums, start, mid - 1);
		}
		if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
			return nums[mid];
		}
		if (nums[mid] == nums[mid - 1]) {
			if (mid % 2 == 0) {
				return find(nums, start, mid - 1);
			} else {
				return find(nums, mid + 1, end);
			}
		} else {
			if (mid % 2 == 0) {
				return find(nums, mid + 1, end);
			} else {
				return find(nums, start, mid - 1);
			}

		}
	}

	public static void main(String[] args) {
		int[] nums;
		nums = new int[]{1,1,2,2,3,3,4,4,5};
		System.err.println(handle2(nums));

		nums = new int[]{1};
		System.err.println(handle2(nums));

		nums = new int[]{1,1,2};
		System.err.println(handle2(nums));

		nums = new int[]{1,2,2};
		System.err.println(handle2(nums));
	}

}
