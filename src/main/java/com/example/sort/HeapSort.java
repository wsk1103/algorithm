package com.example.sort;


import cn.hutool.json.JSONUtil;

import java.util.Random;

/**
 * @author sk
 * @time 2021/4/19
 * @desc say
 **/

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println(JSONUtil.toJsonStr(arr));
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;
            heap(arr, 0, size);
        }
        System.out.println(JSONUtil.toJsonStr(arr));
    }

    private static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = i;
            int parentIndex = (currentIndex - 1) / 2;
            while (arr[currentIndex] > arr[parentIndex]) {
                swap(arr, currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }
    }

    private static void heap(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            if (right < size && arr[left] < arr[right]) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            if (index == largestIndex) {
                break;
            }
            swap(arr, index, largestIndex);
            index = largestIndex;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void heapI(int[] arr, int start, int end) {
        int leftCld = 2 * start + 1;
        int rightCld = 2 * start + 2;
        while (leftCld < end) {
            int largestIndex;
            if (arr[leftCld] < arr[rightCld] && rightCld < end) {
                largestIndex = rightCld;
            } else {
                largestIndex = leftCld;
            }
            if (arr[start] > largestIndex) {
                largestIndex = start;
            }
            if (largestIndex == start) {
                break;
            }
            swap(arr, largestIndex, start);
            start = largestIndex;
            leftCld = 2 * start + 1;
            rightCld = 2 * start + 2;
        }
    }

}
