package com.example.sort;

import java.util.Arrays;

/**
 * @author sk
 * @time 2021/3/26
 * @desc say
 **/
public class QuickSort {

    public static void sort(int[] all, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = all[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (all[i] <= p && i < j) {
                i++;
            }
            while (all[j] >= p && i < j) {
                j--;
            }
            if (i < j) {
                int temp = all[j];
                all[j] = all[i];
                all[i] = temp;
            }
        }
        all[left] = all[i];
        all[i] = p;
        sort(all, left, j - 1);
        sort(all, j + 1, right);
    }

    private static void quicksort(int[] array, int begin, int end) {
        if (begin < end) {  //i和j没相遇之前比较各数据与基准值大小
            int base = array[begin];  //取第一个值为基准值
            int i = begin;  //左标记为i
            int j = end;    //右标记为j

            //一趟排序，找到比基准值大的在基准值右，比基准值小的在基准值左
            while (i < j) {
                //从右往左扫描
                while (i < j && array[j] > base) { //从右往左扫，如果元素比基准值大
                    j--;  //则右边标记--，直到找到第一个比基准值小的，停止扫描
                }
                if (i < j) {
                    array[i] = array[j];  //交换右扫描第一个比基准值小的数
                    i++;  //i标记右移一位
                }
                //从左往右扫描
                while (i < j && array[i] < base) {//从左往右扫，如果元素比基准值小
                    i++;  //则左标记++，直到找到第一个比基准值大的，停止扫描
                }
                if (i < j) {
                    array[j] = array[i];  //交换左扫描第一个比基准值大的数
                    j--;  //j标记左移一位
                }
            }  //此时基准值左右两侧相对有序

            array[i] = base;  //此时i为中间位置k

            quicksort(array, begin, i - 1);  //左侧按照快排思路，递归

            quicksort(array, i + 1, end);    //右侧按照快排思路，递归
        }
    }

    public static void main(String[] args) {
        int[] all = new int[]{3, 1, 4, 9, 5, 7, 2, 6, 8};
        quicksort(all, 0, all.length - 1);
        System.err.println(Arrays.toString(all));
    }


}
