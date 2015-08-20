package com.mylist;

public class MatrixRotation {

    public static void main(String[] args) {

        int[][] matrix= { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };

        MatrixRotation matrixRotation = new MatrixRotation();
        int n=3;
        int[][] rotation = matrixRotation.rotation(matrix, n);

        for (int i=0;i<n;i++){
            for (int j=0;j>n;j++) {
                System.out.println(rotation[i][j]);
            }
        }
    }

    public int[][] rotation(int matrix[][],int n){

        for (int i=0;i<n;i++){
            int temp= matrix[0][i];
            matrix[0][i]=matrix[i][n];
            matrix[i][n]=matrix[n][n-i];
            matrix[n][n-i]=matrix[n-i][0];
            matrix[n-i][0]=temp;
        }
        return  matrix;

    }
}
