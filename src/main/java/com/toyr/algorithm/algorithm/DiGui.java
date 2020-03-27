package com.toyr.algorithm.algorithm;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 递归算法思想
 * @create 2020-03-27 10:12 PM
 */
public class DiGui {
    static long fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        int i;
        System.out.println("请输入要求阶乘的一个整数：");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        System.out.println(i + "的阶乘结果为：" + fact(i));
    }
}
