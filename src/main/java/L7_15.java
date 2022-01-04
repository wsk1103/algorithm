import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sk
 * @time 2021/10/14
 * @desc say
 **/
public class L7_15 {

    /*
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     */

    //1. 3重for循环
    //2. 排序，固定一个后，双指针
    public static List<Integer[]> handle(int[] arr, int target) {
        List<Integer[]> list = new ArrayList<>();
        if (arr == null || arr.length < 3) {
            return list;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[0] > target) {
                break;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            int temp = target - arr[i];
            while (left < right) {
                if (arr[left] + arr[right] == temp) {
                    Integer[] ints = new Integer[]{arr[i], arr[left], arr[right]};
                    list.add(ints);
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (arr[left] + arr[right] > temp) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int temp = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == temp) {
                    List<Integer> ints = new ArrayList<>();
                    ints.add(nums[i]);
                    ints.add(nums[left]);
                    ints.add(nums[right]);
                    list.add(ints);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > temp) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.err.println(JSON.toJSONString(handle(arr, 0)));
    }

}
