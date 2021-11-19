package com.example.sort;

import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2021/4/22
 * @desc say
 **/
public class ShellSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println(JSONUtil.toJsonStr(arr));
        sort(arr);
        System.out.println(JSONUtil.toJsonStr(arr));
    }

    public static void sort(int[] arr) {
        int s = 2;
        for (int gap = arr.length / s; gap > 0; gap /= s) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
