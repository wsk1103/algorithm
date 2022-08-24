import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * @time 2022/8/24
 * @desc say
 **/
public class L1460 {

    /*
     * //给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
     * //
     * // 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：target = [1,2,3,4], arr = [2,4,1,3]
     * //输出：true
     * //解释：你可以按照如下步骤使 arr 变成 target：
     * //1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
     * //2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
     * //3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
     * //上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：target = [7], arr = [7]
     * //输出：true
     * //解释：arr 不需要做任何翻转已经与 target 相等。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：target = [3,7,9], arr = [3,7,11]
     * //输出：false
     * //解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // target.length == arr.length
     * // 1 <= target.length <= 1000
     * // 1 <= target[i] <= 1000
     * // 1 <= arr[i] <= 1000
     * //
     * //
     * // Related Topics 数组 哈希表 排序 👍 53 👎 0
     */

    /**
     * 执行耗时:6 ms,击败了19.81% 的Java用户
     * 内存消耗:41.1 MB,击败了68.87% 的Java用户
     *
     * @param target
     * @param arr
     * @return
     */
    public static boolean handle(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : target) {
            int in = map.getOrDefault(i, 0);
            in = in + 1;
            map.put(i, in);
        }
        for (int i : arr) {
            int in = map.getOrDefault(i, -1);
            if (in == -1) {
                return false;
            }
            in = in - 1;
            if (in < 0) {
                return false;
            }
            map.put(i, in);
        }
        return true;
    }

    /**
     * 执行耗时:3 ms,击败了77.12% 的Java用户
     * 内存消耗:40.8 MB,击败了91.98% 的Java用户
     *
     * @param target
     * @param arr
     * @return
     */
    public static boolean handle2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        int len = target.length;
        for (int i = 0; i < len; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a;
        int[] b;
        a = new int[]{1, 2, 3, 4};
        b = new int[]{2, 4, 1, 3};
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        a = new int[]{1, 2, 3};
        b = new int[]{2, 4, 1};
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
        a = new int[]{1, 2, 3};
        b = new int[]{2, 2, 1};
        System.err.println(handle(a, b));
        System.err.println(handle2(a, b));
    }

}
