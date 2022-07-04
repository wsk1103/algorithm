import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * @author sk
 * @time 2022/7/4
 **/
public class L1200 {

    /*
     * //给你个整数数组 arr，其中每个元素都 不相同。
     * //
     * // 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * // 输入：arr = [4,2,1,3]
     * //输出：[[1,2],[2,3],[3,4]]
     * //
     * //
     * // 示例 2：
     * //
     * // 输入：arr = [1,3,6,10,15]
     * //输出：[[1,3]]
     * //
     * //
     * // 示例 3：
     * //
     * // 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * //输出：[[-14,-10],[19,23],[23,27]]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= arr.length <= 10^5
     * // -10^6 <= arr[i] <= 10^6
     * //
     * // Related Topics 数组 排序 👍 89 👎 0
     */

    /**
     * 执行耗时:21 ms,击败了9.09% 的Java用户
     * 内存消耗:52 MB,击败了32.52% 的Java用户
     *
     * @param arr
     * @return
     */
    public static List<List<Integer>> handle(int[] arr) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>(arr.length);
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.abs(arr[i] - arr[i - 1]);
            if (temp <= min) {
                List<Integer> add = new ArrayList<>(2);
                add.add(arr[i - 1]);
                add.add(arr[i]);
                min = temp;
                List<List<Integer>> list = map.get(temp);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(add);
                    map.put(temp, list);
                } else {
                    list.add(add);
                }
            } else {
                map.remove(temp);
            }
        }
        return map.get(min);
    }

    /**
     * 执行耗时:17 ms,击败了63.46% 的Java用户
     * 内存消耗:52.3 MB,击败了12.76% 的Java用户
     *
     * @param arr
     * @return
     */
    public static List<List<Integer>> handle2(int[] arr) {
        List<List<Integer>> map = new ArrayList<>(arr.length);
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.abs(arr[i] - arr[i - 1]);
            if (temp <= min) {
                if (temp < min) {
                    map = new ArrayList<>();
//                    map.clear();
                }
                List<Integer> add = new ArrayList<>(2);
                add.add(arr[i - 1]);
                add.add(arr[i]);
                min = temp;
                map.add(add);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{4, 2, 1, 3};
        System.err.println(JSONUtil.toJsonStr(handle2(nums)));
        nums = new int[]{4, 2, 1, 3, 5, 7, 9, 10, 15};
        System.err.println(JSONUtil.toJsonStr(handle2(nums)));
        nums = new int[]{-1, 9};
        System.err.println(JSONUtil.toJsonStr(handle2(nums)));
        nums = new int[]{-1, -9};
        System.err.println(JSONUtil.toJsonStr(handle2(nums)));
        nums = new int[]{1, 9};
        System.err.println(JSONUtil.toJsonStr(handle2(nums)));
    }
}
