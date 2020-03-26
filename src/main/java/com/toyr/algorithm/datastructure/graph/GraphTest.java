package com.toyr.algorithm.datastructure.graph;

import java.util.Scanner;

/**
 * @author unisk1123
 * @Description
 * @create 2020-03-26 7:01 PM
 */
public class GraphTest {

    static Scanner input = new Scanner(System.in);

    /**
     * 创建领接矩阵图
     *
     * @param GM
     */
    static void CreateGraph(GraphMatrix GM) {
        int i, j, k;
        int weight;                                             //权
        char EstartV, EendV;                                    //边的起始顶点
        System.out.println("输入图中各顶点信息");
        for (i = 0; i < GM.VertexNum; i++) {//输入顶点
            System.out.printf("第%d个顶点:", i + 1);
            GM.Vertex[i] = (input.next().toCharArray())[0];// 保存到各顶点数组元素中
        }
        System.out.println("输入构成各边的顶点及权值：");
        for (k = 0; k < GM.EdgeNum; k++) {
            System.out.printf("第%d条边：", k + 1);
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weight = input.nextInt();
            for (i = 0; EstartV != GM.Vertex[i]; i++) ; // 在已有顶点中查找开始点
            for (j = 0; EendV != GM.Vertex[j]; j++) ; // 在已有顶点中查找终始点
            GM.EdegeWeight[i][j] = weight;// 对应位置保存权值，表示有一条边
            if (GM.GType == 0) {
                GM.EdegeWeight[j][i] = weight; // 在对角位置保存权值
            }
        }
    }

    static void ClearGraph(GraphMatrix GM) {
        int i, j;
        for (i = 0; i < GM.VertexNum; i++) {    // 清空矩阵
            for (j = 0; j < GM.VertexNum; j++) {
                GM.EdegeWeight[i][j] = GraphMatrix.MaxValue; // 设置矩阵中各元素的值为MaxValue；
            }
        }
    }

    static void OutGraph(GraphMatrix GM) { // 输出邻接矩阵

        int i, j;
        for (j = 0; j < GM.VertexNum; j++) {
            System.out.printf("\t%c", GM.Vertex[j]); // 在第1行输出顶点信息
        }
        System.out.println();
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c", GM.Vertex[i]);
            for (j = 0; j < GM.VertexNum; j++) {
                if (GM.EdegeWeight[i][j] == GraphMatrix.MaxValue) { // 若权值为最大值
                    System.out.printf("\tZ"); // 以Z表示无穷大
                } else {
                    System.out.printf("\t%d", GM.EdegeWeight[i][j]);
                }
            }
            System.out.println();
        }
    }

    static void DeepTraOne(GraphMatrix GM, int n) { // 从第n个节点开始，深度遍历图
        int i;
        GM.isTrav[n] = 1;
        System.out.printf("->%c", GM.Vertex[n]);

        //添加处理节点的操作
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.EdegeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0) {
                DeepTraOne(GM, i);      // 递归进行遍历
            }
        }
    }

    static void DeepTraGraph(GraphMatrix GM) { // 深度优先遍历
        int i;
        for (i = 0; i < GM.VertexNum; i++) {    // 清除各顶点遍历标志
            GM.isTrav[i] = 0;
        }
        System.out.println("深度优先遍历结点：");
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0) {    // 若该点未遍历
                DeepTraOne(GM, i);      // 调用函数遍历
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphMatrix GM = new GraphMatrix();
        System.out.println("输入生成图的类型：");
        GM.GType = input.nextInt(); // 图的种类
        System.out.printf("输入图的顶点数量：");
        GM.VertexNum = input.nextInt(); // 输入图顶点数
        System.out.printf("输入图的边数量:");
        GM.EdgeNum = input.nextInt(); // 输入图边数
        ClearGraph(GM);    // 输入图边数
        CreateGraph(GM); // 生成邻接矩阵结果的图
        System.out.println("该图的邻接矩阵数据如下：");
        OutGraph(GM);   // 输出邻接矩阵
        DeepTraGraph(GM);// 深度优先搜索遍历图
    }

}

class GraphMatrix {
    //图的最大定点数
    static final int MaxNum = 20;
    //最大值（可设为一个最大整数）
    static final int MaxValue = 65535;
    //保存顶点信息（序号或字母）
    char[] Vertex = new char[MaxNum];
    // 图的类型（0：无向图，1：有向图）
    int GType;
    // 顶点的数量
    int VertexNum;
    // 边的数量
    int EdgeNum;
    // 保存边的权
    int[][] EdegeWeight = new int[MaxNum][MaxNum];
    // 遍历标志
    int[] isTrav = new int[MaxNum];
}