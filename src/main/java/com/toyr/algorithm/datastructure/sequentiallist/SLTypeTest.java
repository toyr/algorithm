package com.toyr.algorithm.datastructure.sequentiallist;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description
 * @create 2020-03-27 2:13 PM
 */
public class SLTypeTest {
    public static void main(String[] args) {
        int i;
        SLType SL = new SLType();
        DATA pdata;
        String key;

        System.out.println("顺序表操作演示！");

        SL.SLInit(SL);
        System.out.println("初始化顺序表完成");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("输入添加的节点（学号 姓名 年龄）");
            DATA data = new DATA();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();

            if (data.age != 0) {
                if (SL.SLAdd(SL, data) == 0) {
                    break;
                }
            } else {
                break;
            }
        } while (true);

        System.out.println("\n 顺序表中的结点顺序为：");
        SL.SLAll(SL);

        System.out.println("\n 要取出结点的序号");
        i = input.nextInt();
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s,%s,%d) \n", i, pdata.key, pdata.name, pdata.age);
        }

        System.out.println("要查找结点的关键字:");
        key = input.next();
        i = SL.SLFindByCont(SL, key);
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：（%s,%s,%d）\n", i, pdata.key, pdata.name, pdata.age);
        }
    }
}

class DATA {
    String key;
    String name;
    int age;
}

class SLType {
    static final int MAXLEN = 100;
    DATA[] ListDate = new DATA[MAXLEN + 1];
    int ListLen;

    void SLInit(SLType SL) {
        SL.ListLen = 0;
    }

    int SLLength(SLType SL) {
        return SL.ListLen;
    }

    int SLInsert(SLType SL, int n, DATA data) {
        int i;
        if (SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入结点！");
            return 0;
        }
        if (n < 1 || n > SL.ListLen - 1) {
            System.out.println("插入元素号错误，不能插入元素！");
            return 0;
        }
        for (i = SL.ListLen; i >= n; i--) {
            SL.ListDate[i + 1] = SL.ListDate[i];
        }
        SL.ListDate[n] = data;
        SL.ListLen++;
        return 1;
    }

    int SLAdd(SLType SL, DATA data) {
        if (SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能再添加结点了！");
            return 0;
        }
        SL.ListDate[++SL.ListLen] = data;
        return 1;
    }

    int SLDelete(SLType SL, int n) {
        int i;
        if (n < 1 || n > SL.ListLen - 1) {
            System.out.println("删除元素号错误，不能删除结点！");
            return 0;
        }

        for (i = n; i < SL.ListLen; i++) {
            SL.ListDate[i] = SL.ListDate[i + 1];
        }
        SL.ListLen--;
        return 1;
    }

    DATA SLFindByNum(SLType SL, int n) {
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.println("结点序号错误，不能返回节点！");
            return null;
        }
        return SL.ListDate[n];
    }

    int SLFindByCont(SLType SL, String key) {
        int i;
        for (i = 1; i <= SL.ListLen; i++) {
            if (SL.ListDate[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        return 0;
    }

    int SLAll(SLType SL) {
        int i;
        for (i = 1; i <= SL.ListLen; i++) {
            System.out.printf("(%s,%s,%d)\n", SL.ListDate[i].key, SL.ListDate[i].name, SL.ListDate[i].age);
        }
        return 0;
    }
}