import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2021/10/18
 * @desc say
 **/
public class L525 {

    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
     * 示例 2:
     * <p>
     * 输入: nums = [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10 ^ 5
     * nums[i] 不是 0 就是 1
     */

    public static int handle(int[] nums) {
        int max = 0;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (map.containsKey(sum)) {
                int size = i - map.get(sum);
                max = Math.max(size, max);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nu = new int[]{0,1};
//        System.err.println(handle(nu));
//
//        nu = new int[]{0};
//        System.err.println(handle(nu));
//
//        nu = new int[]{0,1,0};
//        System.err.println(handle(nu));

        nu = new int[]{0,0,0,0,0,1};
        System.err.println(handle(nu));

        nu = new int[]{0,1,0, 0, 1, 0};
        System.err.println(handle(nu));
    }

}
