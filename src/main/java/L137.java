import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/13
 * @desc say
 **/
public class L137 {

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
