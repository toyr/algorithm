package com.toyr.algorithm.algorithm;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 递推算法思想
 * @create 2020-03-27 10:06 PM
 */
public class DiTui {
    public static int fibonacci(int n) {
        int t1, t2;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            t1 = fibonacci(n - 1);
            t2 = fibonacci(n - 2);
            return t1 + t2;
        }
    }

    public static void main(String[] args) {
        System.out.println("递推算法求解兔子产仔问题！");
        System.out.println("请先输入时间：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num = fibonacci(n);
        System.out.println("经过" + n + "月的时间， 共能繁殖成" + num + "对兔子！");
    }
}
