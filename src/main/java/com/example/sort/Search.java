package com.example.sort;

/**
 * @author sk
 * @time 2021/5/17
 * @desc say
 **/
public class Search {


    public static int search(int[] nums, int val) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < val) {
                low = mid + 1;
            } else {
                // 如果nums[mid]是第一个元素，或者nums[mid-1]小于val
                // 说明nums[mid]就是第一个大于等于给定值的元素
                if (mid == 0 || nums[mid - 1] < val) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int removeDuplicates(int[] nums) {
        int cnt = 0, cur = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) ++cnt;
            else cnt = 0;
            if (cnt < 2) nums[cur++] = nums[i];
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] aa = {1, 3, 3, 3, 3, 5, 7, 9};
//        int s = search(aa, 9);
//        System.err.println(s);
        System.err.println(removeDuplicates(aa));
    }
}
