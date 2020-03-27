package com.toyr.algorithm.algorithm;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 分治算法
 * @create 2020-03-27 10:16 PM
 */
public class FenZhi {
    static final int MAXNUM = 30;

    static int FalseCoin(int coin[], int low, int high) {
        int i, sum1, sum2, sum3;
        int re = 0;
        sum1 = sum2 = sum3 = 0;
        if (low + 1 == high) {
            if (coin[low] < coin[high]) {
                re = low + 1;
                return re;
            } else {
                re = high + 1;
                return re;
            }
        }

        if ((high - low + 1) % 2 == 0) {
            for (i = low; i <= low + (high - low) / 2; i++) {
                sum1 = sum1 + coin[i];
            }
            for (i = low + (high - low) / 2; i <= high; i++) {
                sum2 = sum2 + coin[i];
            }
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2);
                return re;
            } else {

            }
        } else {
            for (i = low; i <= low + (high - low) / 2 - 1; i++) {
                sum1 = sum1 + coin[i];
            }
            for (i = low + (high - low) / 2 + 1; i <= high; i++) {
                sum2 = sum2 + coin[i];
            }

            sum3 = coin[low + (high - low) / 2];
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2 - 1);
                return re;
            } else {

            }

            if (sum1 + sum3 == sum2 + sum3) {
                re = low + (high - low) / 2 + 1;
                return re;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] coin = new int[MAXNUM];
        int i, n;
        int weizhi;
        System.out.println("分治算法求解假银币问题！");
        System.out.println("请输入银币总的个数：");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        System.out.println("请输入银币的真假");
        for (i = 0; i < n; i++) {
            coin[i] = input.nextInt();
        }
        weizhi = FalseCoin(coin, 0, n - 1);
        System.out.println("在上述" + MAXNUM + "个银币中，第" + weizhi + "个银币是假的！");
    }
}
