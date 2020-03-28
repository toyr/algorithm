package com.toyr.algorithm.sort;

/**
 * @author unisk1123
 * @Description 冒泡排序法
 * @create 2020-03-27 11:53 PM
 */
public class BubbleSort {

    static final int SIZE = 10;

    public static void bubbleSort(int[] a) {
        int temp;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {          // 将相邻两个数进行比较，较大的数往后冒泡¬
                    // 交换相邻两个数
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "步排序结果");
            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + a[j]);
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
        bubbleSort(shuzu);
        System.out.println("排序后的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + shuzu[i]);
        }
        System.out.println();
    }
}
