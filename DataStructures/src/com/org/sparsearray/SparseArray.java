package com.org.sparsearray;

/**
 * @author zz
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘数组
        //0：表示空 1：表示白棋 2：表示黑棋
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][8] = 1;
        chessArr1[8][5] = 2;

        System.out.println("原始棋盘：");
        //记录有效数据
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        //二维数组 转 稀疏数组

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        //稀疏数组 转 二维数组
        int [][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i <sparseArr[0][2]+1 ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("二维数组:");
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}
