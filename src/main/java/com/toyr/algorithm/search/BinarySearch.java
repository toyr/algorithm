package com.toyr.algorithm.search;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 折半查找算法
 * @create 2020-03-28 11:04 PM
 */
public class BinarySearch {

    static final int N = 15;

    static void quickSort(int[] arr, int left, int right) {
        int f, t;
        int rtemp, ltemp;

        ltemp = left;
        rtemp = right;
        f = arr[(left + right) / 2];

        while (ltemp < rtemp) {
            while (arr[ltemp] < f) {
                ++ltemp;
            }
            while (arr[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = arr[ltemp];
                arr[ltemp] = arr[rtemp];
                arr[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }

        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) {
            quickSort(arr, left, ltemp - 1);
        }
        if (ltemp < right) {
            quickSort(arr, rtemp + 1, right);
        }
    }

    static int searchFun(int[] a, int n, int x) {
        int mid, low, high;

        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x, n, i;
        int[] shuzu = new int[N];
        for (i = 0; i < N; i++) {
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));     // 初始化数组
        }

        System.out.println("折半查找算法演示！");
        System.out.println("排序前数据序列：");
        for (i = 0; i < N; i++) {
            System.out.printf(" " + shuzu[i]);
        }
        System.out.println();

        quickSort(shuzu, 0, N - 1);
        System.out.println("排序后数据序列：");
        for (i = 0; i < N; i++) {
            System.out.printf(" " + shuzu[i]);
        }

        System.out.println();
        System.out.println("输入要查找的数");
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        n = searchFun(shuzu, N, x);
        if (n < 0) {
            System.out.println("没有找到数据：" + x);
        } else {
            System.out.println("数据：" + x + " 位于数组的第" + (n + 1) + " 个元素处。");
        }
    }
}
