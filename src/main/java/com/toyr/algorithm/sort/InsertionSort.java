package com.toyr.algorithm.sort;

/**
 * @author unisk1123
 * @Description 插入排序
 * @create 2020-03-28 11:22 AM
 */
public class InsertionSort {

    static final int SIZE = 100;

    static void insertionSort(int[] a) {
        int i, j, t, h;
        for (i = 1; i < a.length; i++) {
            t = a[i];
            j = i - 1;
            while (j >= 0 && t < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1]=t;

            System.out.println("第" + i + "步排序结果");
            for (h = 0; h < a.length; h++) {
                System.out.print(" " + a[h]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] shuzu = new int[SIZE];
        int i;
        for (i = 0; i < SIZE; i++) {
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));     // 初始化数组
        }
        System.out.println("排序前的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + shuzu[i]);
        }
        System.out.println();
        insertionSort(shuzu);
        System.out.println("排序后的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + shuzu[i]);
        }
        System.out.println();
    }
}
