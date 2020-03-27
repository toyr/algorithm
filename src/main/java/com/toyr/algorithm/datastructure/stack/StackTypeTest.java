package com.toyr.algorithm.datastructure.stack;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description
 * @create 2020-03-27 10:49 AM
 */
public class StackTypeTest {

    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        StackType stack = st.STInit();                  // 栈初始化
        Scanner input = new Scanner(System.in);
        System.out.println("入栈操作：");
        System.out.println("输入姓名、年龄进行入栈操作：");
        do {
            DATA3 data = new DATA3();
            data.name = input.next();


            if (data.name.equals("0")) {
                break;
            } else {
                data.age = input.nextInt();
                st.PushST(stack, data);
            }
        } while (true);

        String temp = "1";
        System.out.println("出栈操作：按任意非0键进行出栈操作");
        temp = input.next();
        while (!temp.equals("0")) {
            data1 = st.PopST(stack);
            System.out.printf("出栈的数据是（%s,%d）\n", data1.name, data1.age);
            temp = input.next();
        }
        System.out.println("测试结束");
        st.STClear(st);                     // 释放栈所占用的空间
    }
}

class DATA3 {
    String name;
    int age;
}

class StackType {
    static final int MAXLEN = 50;
    DATA3[] data = new DATA3[MAXLEN + 1];       // 数据元素
    int top;                                    // 栈顶

    StackType STInit() {
        StackType p;
        if ((p = new StackType()) != null) {    // 申请内存
            p.top = 0;                          // 设置栈顶为0
            return p;                           // 返回指定栈的引用
        }
        return null;
    }

    boolean STIsEmpty(StackType s) {            // 判断栈是否为空
        boolean t;
        t = s.top == 0;
        return t;
    }

    boolean STIsFull(StackType s) {              // 判断栈是否为满
        boolean t;
        t = s.top == MAXLEN;
        return t;
    }

    void STClear(StackType s) {                 // 清空栈
        s.top = 0;
    }

    void STFree(StackType s) {                  // 释放栈所占用空间
        if (s != null) {
            s = null;
        }
    }

    int PushST(StackType s, DATA3 data) {       // 入栈操作
        if (s.top + 1 > MAXLEN) {
            System.out.println("栈溢出");
            return 0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    DATA3 PopST(StackType s) {                  // 出栈操作
        if (s.top == 0) {
            System.out.println("栈为空");
            System.exit(0);
        }
        return s.data[s.top--];
    }

    DATA3 PeekST(StackType s) {
        if (s.top == 0) {
            System.out.println("栈为空");
            System.exit(0);
        }
        return s.data[s.top];
    }

}
