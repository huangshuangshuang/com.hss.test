package com.sogou.api.client;

import java.util.Scanner;

public class Test {
	private static Matrix matrix;

	public static void main(String[] args) {
		Test test = new Test();
		test.matrix();
	}

	public void matrix() {
		System.out.println("请输入矩阵的行数或列数");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		matrix = new Matrix(num);
		int[][] initMatrix = matrix.operation();
		for (int i = 0; i < initMatrix.length; i++) {
			 int sum=0;
			for (int j = 0; j < initMatrix.length; j++) {
				String string = "";
				if (initMatrix[i][j] < 10) {
					string = initMatrix[i][j] + "  ";
				} else {
					string = initMatrix[i][j] + " ";
				}
				System.out.print(string);
				sum+=initMatrix[i][j];
			}
			System.out.println("sum="+sum);
		}
	}
}
