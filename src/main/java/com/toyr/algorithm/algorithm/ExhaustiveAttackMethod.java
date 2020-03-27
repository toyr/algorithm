package com.toyr.algorithm.algorithm;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description 穷举算法思想
 * @create 2020-03-27 9:59 PM
 */
public class ExhaustiveAttackMethod {

    static int chichen, habbit;

    public static int qiongJu(int head, int foot) {
        int re, i, j;
        re = 0;
        for (i = 0; i <= head; i++) {
            j = head - i;
            if (i * 2 + j * 4 == foot) {
                re = 1;
                chichen = i;
                habbit = j;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int re, head, foot;
        System.out.println("穷举法求解鸡兔同笼问题：");
        System.out.println("请输入头数：");
        Scanner input = new Scanner(System.in);
        head = input.nextInt();
        System.out.println("请输入脚数：");
        foot = input.nextInt();
        re = qiongJu(head, foot);
        if (re == 1) {
            System.out.println("鸡有" + chichen + "只，兔有" + habbit + "只。");
        } else {
            System.out.println("无法求解！");
        }
    }
}
