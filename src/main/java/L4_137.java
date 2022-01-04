import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/13
 * @desc say
 **/
public class L4_137 {

    /*
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [0,1,0,1,0,1,100]
     * 输出：100
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     *
     *
     * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    public static int handle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        //2, 2, 2, 3, 3, 4, 4, 5
        for (int i = 0; i < nums.length; i++) {
            boolean left = false;
            boolean right = false;
            if (i - 1 < 0) {
                left = true;
            } else if (nums[i] != nums[i - 1]) {
                left = true;
            }
            if (i + 1 >= nums.length) {
                right = true;
            } else if (nums[i] != nums[i + 1]) {
                right = true;
            }
            if (left && right) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int handle2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(String.valueOf(i), 1, Integer::sum);
        }
        for (String k : map.keySet()) {
            Integer v = map.get(k);
            if (v == 1) {
                return Integer.parseInt(k);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 2, 2, 3, 3, 4, 4, 5};
//        System.err.println(handle(arr));
//
//        arr = new int[]{2};
//        System.err.println(handle(arr));
//
//        arr = new int[]{2, 3, 3};
//        System.err.println(handle(arr));
//
//        arr = new int[]{2, 3};
//        System.err.println(handle(arr));
//
//        arr = new int[]{3, 3, 3};
//        System.err.println(handle(arr));
        int[] arr = new int[]{2, 2, 2, 3, 3, 4, 4, 5};
        System.err.println(handle2(arr));

        arr = new int[]{0,1,0,1,0,1,100};
        System.err.println(handle(arr));
    }

}
