import com.alibaba.fastjson.JSON;

/**
 * @author sk
 * @time 2021/10/14
 * @desc say
 **/
public class L167 {
    /**
     * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * <p>
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
     * <p>
     * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：numbers = [1,2,4,6,10], target = 8
     * 输出：[1,3]
     * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
     * 示例 2：
     * <p>
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[0,2]
     * 示例 3：
     * <p>
     * 输入：numbers = [-1,0], target = -1
     * 输出：[0,1]
     */
    //1. map 存储值
    //2. 相减 -> 边界优化
    public static int[] handle(int[] numbers, int target) {
        //判空
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        if (numbers[0] > target) {
            return null;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int temp = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == temp) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static int[] handle2(int[] numbers, int target) {
        //判空
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        if (numbers[0] > target) {
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 4, 6, 10};
        System.err.println(JSON.toJSONString(handle(num, 8)));
        System.err.println(JSON.toJSONString(handle2(num, 8)));

        num = new int[]{2,3,4};
        System.err.println(JSON.toJSONString(handle(num, 6)));
        System.err.println(JSON.toJSONString(handle2(num, 6)));

        num = new int[]{-1,0};
        System.err.println(JSON.toJSONString(handle(num, -1)));
        System.err.println(JSON.toJSONString(handle2(num, -1)));
    }
}
