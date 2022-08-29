import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2022/8/29
 * @desc say
 **/
public class L228 {

    /*
     * //给定一个 无重复元素 的 有序 整数数组 nums 。
     * //
     * // 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
     * //nums 的数字 x 。
     * //
     * // 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * //
     * //
     * // "a->b" ，如果 a != b
     * // "a" ，如果 a == b
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [0,1,2,4,5,7]
     * //输出：["0->2","4->5","7"]
     * //解释：区间范围是：
     * //[0,2] --> "0->2"
     * //[4,5] --> "4->5"
     * //[7,7] --> "7"
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [0,2,3,4,6,8,9]
     * //输出：["0","2->4","6","8->9"]
     * //解释：区间范围是：
     * //[0,0] --> "0"
     * //[2,4] --> "2->4"
     * //[6,6] --> "6"
     * //[8,9] --> "8->9"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= nums.length <= 20
     * // -2³¹ <= nums[i] <= 2³¹ - 1
     * // nums 中的所有值都 互不相同
     * // nums 按升序排列
     * //
     * //
     * // Related Topics 数组 👍 229 👎 0
     */

    /**
     * 执行耗时:6 ms,击败了41.59% 的Java用户
     * 内存消耗:39.6 MB,击败了60.42% 的Java用户
     *
     * @param nums
     * @return
     */
    public static List<String> handle(int[] nums) {
        List<String> to = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int cur = nums[i];
            if (i == len - 1) {
                to.add(cur + "");
                break;
            } else {
                int j = i;
                while (++j < len) {
                    if (nums[j] - cur != j - i) {
                        break;
                    }
                }
                if (i + 1 == j) {
                    to.add(cur + "");
                } else {
                    to.add(cur + "->" + nums[j - 1]);
                }
                i = j;
            }
        }
        return to;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0, 1, 2, 4, 5, 7};
        System.err.println(JSONUtil.toJsonStr(handle(nums)));
        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.err.println(JSONUtil.toJsonStr(handle(nums)));
    }

}
