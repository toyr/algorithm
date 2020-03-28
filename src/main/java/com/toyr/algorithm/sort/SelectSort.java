package com.toyr.algorithm.sort;

/**
 * @author unisk1123
 * @Description 选择排序
 * @create 2020-03-28 12:13 AM
 */
public class SelectSort {
    static final int SIZE = 10;

    public static void selectSort(int[] a) {
        int index, temp;
        for (int i = 0; i < a.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            // 交换两个数
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
            System.out.println("第" + i + "步排序结果：");
            for (int j = 0; j < a.length; j++) {
                System.out.printf(" " + a[j]);
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
        selectSort(shuzu);
        System.out.println("排序后的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + shuzu[i]);
        }
        System.out.println();
    }
}
