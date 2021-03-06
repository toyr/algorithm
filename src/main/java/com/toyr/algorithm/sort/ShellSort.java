package com.toyr.algorithm.sort;

/**
 * @author unisk1123
 * @Description Shell排序
 * @create 2020-03-28 11:40 AM
 */
public class ShellSort {

    static final int SIZE = 100;

    static void shellSort(int[] a) {
        int i, j, h;
        int r, temp;
        int x = 0;

        for (r = a.length / 2; r >= 1; r /= 2) {
            for (i = r; i < a.length; i++) {
                temp = a[i];
                j = i - r;
                while (j >= 0 && temp < a[j]) {
                    a[j + r] = a[j];
                    j -= r;
                }
                a[j + r] = temp;
            }

            x++;
            System.out.println("第" + x + "步排序结果");
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
        shellSort(shuzu);
        System.out.println("排序后的数组：");
        for (i = 0; i < SIZE; i++) {
            System.out.print(" " + shuzu[i]);
        }
        System.out.println();
    }
}
