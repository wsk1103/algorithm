import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/12/17
 * @desc say
 **/
public class L119_128 {

    /*
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     *
     *
     * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     */

    public static int handle(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Set<Integer> vis = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (vis.contains(num)) {
                continue;
            }
            int tempNum = num;
            int temp = 0;
            while (set.contains(tempNum)) {
                if (vis.contains(tempNum)) {
                    break;
                }
                vis.add(tempNum);
                temp++;
                tempNum++;
            }
            tempNum = num - 1;
            while (set.contains(tempNum)) {
                if (vis.contains(tempNum)) {
                    break;
                }
                vis.add(tempNum);
                temp++;
                tempNum--;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n;
        n = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.err.println(handle(n));
        List<Integer> set = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int tt = r.nextInt(1000);
            if (set.contains(tt)) {
                continue;
            }
            set.add(tt);
        }
        n = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            n[i] = set.get(i);
        }
        System.err.println(JSON.toJSONString(n));
        System.err.println(handle(n));
    }

}
