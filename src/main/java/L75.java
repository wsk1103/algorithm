import cn.hutool.json.JSONUtil;

/**
 * @author sk
 * @time 2022/7/4
 **/
public class L75 {

    /*
     * //给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * //
     * // 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * //
     * //
     * //
     * //
     * // 必须在不使用库的sort函数的情况下解决这个问题。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [2,0,2,1,1,0]
     * //输出：[0,0,1,1,2,2]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [2,0,1]
     * //输出：[0,1,2]
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // n == nums.length
     * // 1 <= n <= 300
     * // nums[i] 为 0、1 或 2
     * //
     * //
     * //
     * //
     * // 进阶：
     * //
     * //
     * // 你可以不使用代码库中的排序函数来解决这道题吗？
     * // 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * //
     * // Related Topics 数组 双指针 排序 👍 1323 👎 0
     */

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了55.62% 的Java用户
     *
     * @param nums
     */
    public static void handle(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start <= end && nums[start] == 0) {
                start++;
            }
            while (end >= start && nums[end] == 2) {
                end--;
            }
            if (end < start) {
                return;
            }
            if (nums[start] == nums[end]) {
                int te = end;
                while (te > start && nums[te] != 2) {
                    te--;
                }
                if (te > start && te != end) {
                    swap(nums, te, end);
                }
                end--;
                continue;
            }
            swap(nums, start, end);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{1, 0, 1};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
        n = new int[]{1, 2, 1};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
        n = new int[]{2, 0, 2, 1, 1, 0};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
        n = new int[]{2, 0, 1};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
        n = new int[]{0, 0, 0, 0, 0, 0};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
        n = new int[]{0, 0, 1, 0, 1, 0};
        handle(n);
        System.err.println(JSONUtil.toJsonStr(n));
    }

}
