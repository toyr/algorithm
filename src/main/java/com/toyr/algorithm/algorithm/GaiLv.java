package com.toyr.algorithm.algorithm;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 概率算法
 * @create 2020-03-27 10:30 PM
 */
public class GaiLv {
    static double MontePi(int n) {      // 蒙特卡洛算法
        double PI;
        double x, y;
        int i, sum;
        sum = 0;
        for (i = 1; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x * x + y * y) <= 1) {
                sum++;
            }
        }
        PI = 4.0 * sum / n;             // 计算PI
        return PI;
    }

    public static void main(String[] args) {
        do {
            int n;
            double PI;
            System.out.println("蒙特卡洛概率算法计算PI：");
            Scanner input = new Scanner(System.in);
            System.out.println("输入点的数量");
            n = input.nextInt();
            PI = MontePi(n);
            System.out.println("PI=" + PI);
        } while (true);

    }
}
