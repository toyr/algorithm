package com.toyr.algorithm.datastructure.linkedlist;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description
 * @create 2020-03-27 11:26 AM
 */
public class CLTypeTest {

    public static void main(String[] args) {
        CLType node, head = null;
        CLType CL = new CLType();
        String key, findkey;
        Scanner input = new Scanner(System.in);
        System.out.printf("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = input.next();
            if (nodeData.key.equals("0")) {
                break;
            } else {
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                head = CL.CLAddEnd(head, nodeData);
            }
        } while (true);
        CL.CLAllNode(head);

        System.out.println("\n演示插入结点，输入插入位置的关键字：");
        findkey = input.next();
        System.out.println("输入插入结点的数据（关键字 姓名 年龄）");
        DATA2 nodeData = new DATA2();
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        head = CL.CLInsertNode(head, findkey, nodeData);
        CL.CLAllNode(head);

        System.out.println("\n演示在链表中查找，输入查找关键字");
        key = input.next();
        node = CL.CLFindNode(head, key);
        if (node != null) {
            nodeData = node.nodeData;
            System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
        } else {
            System.out.printf("在链表中未找到关键字为%s的结点！", key);
        }

    }
}

class DATA2 {
    String key;
    String name;
    int age;

}

class CLType {
    DATA2 nodeData = new DATA2();
    CLType nextNode;

    CLType CLAddEnd(CLType head, DATA2 nodeData) {          // 追加结点
        CLType node, htemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return null;                                    // 分配内存失败
        } else {
            node.nodeData = nodeData;                       // 保存数据
            node.nextNode = null;                           // 设置结点引用为空，即为表尾
            if (head == null) {                             // 头引用
                head = node;
                return head;
            }
            htemp = head;
            while (htemp.nextNode != null) {                // 查找链表的末尾
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;
        }
    }

    CLType CAAddFirst(CLType head, DATA2 nodeData) {
        CLType node;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return null;                                    // 分配内存失败
        } else {
            node.nodeData = nodeData;                       // 保存数据
            node.nextNode = head;                           // 指向头引用所指结点
            head = node;                                    // 头引用执行新增结点
            return head;
        }
    }

    CLType CLFindNode(CLType head, String key) {            // 查找结点
        CLType htemp;
        htemp = head;
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }

    CLType CLInsertNode(CLType head, String findkey, DATA2 nodeData) {      // 插入结点
        CLType node, nodetemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return null;                                    // 分配内存失败
        }
        node.nodeData = nodeData;
        nodetemp = CLFindNode(head, findkey);
        if (nodetemp != null) {
            node.nextNode = nodetemp.nextNode;              // 新插入结点指向关键结点的下一个结点
            nodetemp.nextNode = node;                       // 设置关键结点指向新插入结点
        } else {
            System.out.println("未找到正确的插入位置！");
            free(node);                                     // 释放内存
        }
        return head;                                        // 返回头引用
    }

    int CLDeleteNode(CLType head, String key) {
        CLType node, htemp;
        htemp = head;
        node = head;
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;
//                free(htemp);
                return 1;
            } else {
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    int CLLength(CLType head) {
        CLType htemp;
        int Len = 0;
        htemp = head;
        while (htemp != null) {
            Len++;
            htemp = htemp.nextNode;
        }
        return Len;
    }

    void CLAllNode(CLType head) {
        CLType htemp;
        DATA2 nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：", CLLength(head));
        while (htemp != null) {
            nodeData = htemp.nodeData;
            System.out.printf("结点(%s,%s,%d)", nodeData.key, nodeData.name, nodeData.age);
            htemp = htemp.nextNode;
        }
    }

    void free(CLType node) {
        node = null;
    }
}
