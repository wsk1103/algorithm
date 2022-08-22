import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * @author sk
 * @time 2022/8/18
 **/
public class L1224 {

    /*
     * //给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
     * //
     * //
     * // 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
     * //
     * //
     * // 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：nums = [2,2,1,1,5,3,3,5]
     * //输出：7
     * //解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
     * //字都出现了两次。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
     * //输出：13
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 2 <= nums.length <= 10⁵
     * // 1 <= nums[i] <= 10⁵
     * //
     * // Related Topics 数组 哈希表 👍 90 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:64 ms,击败了25.56% 的Java用户
     * 内存消耗:55.1 MB,击败了5.56% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        System.err.println(JSONUtil.toJsonStr(nums));
        if (nums.length == 1) {
            return 1;
        } else if (nums.length == 2) {
            return 2;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int one = 0, two = 0;
//        int oneSize = 0, twoSize = 0, other = 0;
        Set<Integer> oneMap = new HashSet<>();
        Set<Integer> twoMap = new HashSet<>();
        Set<Integer> other = new HashSet<>();
        int max = 0;

        int i0 = nums[0];
        int i1 = nums[1];
        if (i0 == i1) {
            one = 2;
            oneMap.add(i0);
            map.put(i0, 2);
        } else {
            one = 1;
            oneMap.add(i0);
            oneMap.add(i1);
            map.put(i0, 1);
            map.put(i1, 1);
        }

        for (int i = 2; i < nums.length; i++) {
            int cur = nums[i];
            Integer temp = map.get(cur);
            if (temp == null) {
                temp = 1;
            } else {
                temp++;
            }
            map.put(cur, temp);
            if (temp > one) {
                oneMap.remove(cur);
                if (!oneMap.isEmpty()) {
                    two = one;
                    other.addAll(twoMap);
                    twoMap = oneMap;
                }
                one = temp;
                Set<Integer> now = new HashSet<>();
                now.add(cur);
                oneMap = now;
            } else if (temp == one) {
                oneMap.add(cur);
                twoMap.remove(cur);
                if (twoMap.size() == 0 && two != 0) {
                    two = 0;
                }
            } else if (temp > two) {
                twoMap.remove(cur);
                two = temp;
                Set<Integer> now = new HashSet<>();
                now.add(cur);
                other.addAll(twoMap);
                twoMap = now;
            } else if (temp == two) {
                twoMap.add(cur);
                other.remove(cur);
            } else {
                other.add(cur);
            }
            if ((other.isEmpty() && oneMap.size() == 1 && twoMap.isEmpty())
                    || (other.isEmpty() && twoMap.isEmpty() && one == 1)
                    || (other.isEmpty() && oneMap.size() == 1 && one - two == 1)
                    || (other.size() == 1 && oneMap.isEmpty() && !twoMap.isEmpty())
                    || (other.size() == 1 && twoMap.isEmpty() && !oneMap.isEmpty())
                    || (other.isEmpty() && twoMap.size() == 1 && two == 1)) {
                max = i + 1;
//                System.err.println(max);
            }
        }
        if (map.size() == 1 || map.size() == nums.length) {
            return nums.length;
        }
        return max;
    }

    public static int handle2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        } else if (nums.length == 2) {
            return 2;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int one = 0, two = 0;
//        int oneSize = 0, twoSize = 0, other = 0;
        Set<Integer> oneMap = new HashSet<>();
        Set<Integer> twoMap = new HashSet<>();
        int other = 0;
        int max = 0;

        int i0 = nums[0];
        int i1 = nums[1];
        if (i0 == i1) {
            one = 2;
            oneMap.add(i0);
            map.put(i0, 2);
        } else {
            one = 1;
            oneMap.add(i0);
            oneMap.add(i1);
            map.put(i0, 1);
            map.put(i1, 1);
        }

        for (int i = 2; i < nums.length; i++) {
            int cur = nums[i];
            Integer temp = map.get(cur);
            if (temp == null) {
                temp = 1;
            } else {
                temp++;
            }
            other++;
            map.put(cur, temp);
            if (temp > one) {
                oneMap.remove(cur);
                if (!oneMap.isEmpty()) {
                    other += twoMap.size();
                    two = one;
                    twoMap = oneMap;
                }
                one = temp;
                Set<Integer> now = new HashSet<>();
                now.add(cur);
                oneMap = now;
                other--;
            } else if (temp == one) {
                oneMap.add(cur);
                twoMap.remove(cur);
                if (twoMap.size() == 0 && two != 0) {
                    two = 0;
                }
                other--;
            } else if (temp > two) {
                twoMap.remove(cur);
                other += twoMap.size();
                two = temp;
                Set<Integer> now = new HashSet<>();
                now.add(cur);
                twoMap = now;
                other--;
            } else if (temp == two) {
                twoMap.add(cur);
                other--;
            }
            if ((other == 0 && oneMap.size() == 1 && twoMap.isEmpty())
                    || (other == 0 && twoMap.isEmpty() && one == 1)
                    || (other == 0 && oneMap.size() == 1 && one - two == 1)
                    || (other == 1 && oneMap.isEmpty() && !twoMap.isEmpty())
                    || (other == 1 && twoMap.isEmpty() && !oneMap.isEmpty())
                    || (other == 0 && twoMap.size() == 1 && two == 1)) {
                max = i + 1;
//                System.err.println(max);
            }
        }
        if (map.size() == 1 || map.size() == nums.length) {
            return nums.length;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        //13
        nums = new int[]{1, 2, 3, 1, 2, 3, 4, 4, 4, 4, 1, 2, 3, 5, 6};
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
        nums = new int[]{1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 42, 97, 5, 46, 53, 100, 63, 27, 12, 83, 82, 21, 77, 58, 93, 86, 5, 72, 16, 23, 99, 88, 47, 96, 16, 26, 89, 41, 19, 40, 42, 78, 43, 29, 51, 50, 92, 76, 76, 54, 7, 46, 93, 26, 56, 94, 34, 100, 26, 97, 60, 73, 46, 31, 26, 2, 50, 15, 55, 42, 64, 30, 72, 18, 8, 58, 50, 81, 84, 60, 91, 2, 3, 48, 65, 65, 5, 49, 31, 9, 78, 94, 32, 11, 33, 31, 53, 19, 92, 14, 94, 27, 65, 92, 14};
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
        nums = new int[]{6, 6, 6, 6, 6, 6, 2, 2, 1, 1, 5, 3, 3, 5};
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
        nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
        nums = new int[]{2, 2, 1, 1, 5, 3, 3, 5};
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
        nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums[i] = random.nextInt(10) + 1;
        }
        System.err.println("===" + handle(nums));
        System.err.println("===" + handle2(nums));
    }
}
