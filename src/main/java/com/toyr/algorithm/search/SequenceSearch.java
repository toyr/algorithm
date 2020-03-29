package com.toyr.algorithm.search;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 顺序查找
 * @create 2020-03-28 10:55 PM
 */
public class SequenceSearch {

    static final int N = 15;

    static int searchFun(int a[], int n, int x) {
        int i, f = -1;
        for (i = 0; i < n; i++) {
            if (x == a[i]) {
                f = i;
                break;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        int x, n, i;
        int[] shuzu = new int[N];
        for (i = 0; i < N; i++) {
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));     // 初始化数组
        }

        System.out.println("顺序查找算法演示！");
        System.out.println("数据序列：");
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
