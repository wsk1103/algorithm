import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/4/8
 **/
public class L26 {

    /**
     * //给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致
     * //。
     * //
     * // 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个
     * //元素应该保存最终结果。
     * //
     * // 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * //
     * // 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * //
     * // 判题标准:
     * //
     * // 系统会用下面的代码来测试你的题解:
     * //
     * //
     * //int[] nums = [...]; // 输入数组
     * //int[] expectedNums = [...]; // 长度正确的期望答案
     * //
     * //int k = removeDuplicates(nums); // 调用
     * //
     * //assert k == expectedNums.length;
     * //for (int i = 0; i < k; i++) {
     * //    assert nums[i] == expectedNums[i];
     * //}
     * //
     * // 如果所有断言都通过，那么您的题解将被 通过。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [1,1,2]
     * //输出：2, nums = [1,2,_]
     * //解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * //输出：5, nums = [0,1,2,3,4]
     * //解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= nums.length <= 3 * 10⁴
     * // -10⁴ <= nums[i] <= 10⁴
     * // nums 已按 升序 排列
     * //
     * // Related Topics 数组 双指针 👍 2573 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.9 MB,击败了50.38% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int len = nums.length;
        int now = nums[left];
        while (left < len) {
            while (++right < len && now == nums[right]) {
                //right++;
            }
            if (right >= len) {
                left++;
                break;
            }
            if (right - left == 1) {
                left++;
                now = nums[left];
            } else {
                left++;
                if (left < len) {
                    nums[left] = nums[right];
                    now = nums[right];
                }
            }
        }
        System.err.println(JSONUtil.toJsonStr(nums));
        return left;
    }

    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了56.93% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int left = 1;
        int right = 1;
        int len = nums.length;
        while (right < len) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        System.err.println(JSONUtil.toJsonStr(nums));
        return left;
    }


    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.err.println(handle(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.err.println(handle2(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        System.err.println(handle(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        System.err.println(handle2(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9, 9, 9};
        System.err.println(handle(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9, 9, 9};
        System.err.println(handle2(nums));
        nums = new int[]{0, 0};
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
        nums = new int[]{0, 0, 0};
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
        nums = new int[]{0, 1};
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
        nums = new int[]{0, 1, 2};
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
        nums = new int[]{0, 1, 2, 3};
        System.err.println(handle(nums));
        System.err.println(handle2(nums));
    }
}
