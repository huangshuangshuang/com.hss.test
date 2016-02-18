package com.haowu.hss.matrix;

public class Matrix {
	private int[][] matrix;
	private int n;

	public Matrix(int n) {
		this.n = n;
		int m = 1;
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = m++;
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	private int[][] oddOperation(int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = 0;
			}
		}
		int number = 1;
		int column = (length - 1) / 2; // 列
		int row = 0;// 行
		matrix[row][column] = number;
		while (!(row == length - 1 && column == (length - 1) / 2)) {
			int col = column;
			column = column + 1;
			if (column >= length) {
				column = 0;
			}
			int r = row;
			row = row - 1;
			if (row < 0) {
				row = length - 1;
			}
			if (matrix[row][column] != 0) {
				column = col;
				row = r + 1;
			}
			matrix[row][column] = ++number;
		}
		return matrix;
	}

	private int[][] evenOperation(int length) {
		if (length % 4 == 0) {
			for (int i = 0; i < length / 2; i++) {
				for (int j = 0; j < length / 4; j++) {
					matrix[i][j] = matrix[length - 1 - i][j] + matrix[i][j];
					matrix[length - 1 - i][j] = matrix[i][j] - matrix[length - 1 - i][j];
					matrix[i][j] = matrix[i][j] - matrix[length - 1 - i][j];
				}
				for (int j = length - 1; j > length - length / 4 - 1; j--) {
					matrix[i][j] = matrix[length - 1 - i][j] + matrix[i][j];
					matrix[length - 1 - i][j] = matrix[i][j] - matrix[length - 1 - i][j];
					matrix[i][j] = matrix[i][j] - matrix[length - 1 - i][j];
				}
			}
			for (int i = 0; i < length / 2; i++) {
				for (int j = 0; j < length / 4; j++) {
					matrix[j][i] = matrix[j][length - 1 - i] + matrix[j][i];
					matrix[j][length - 1 - i] = matrix[j][i] - matrix[j][length - 1 - i];
					matrix[j][i] = matrix[j][i] - matrix[j][length - 1 - i];
				}
				for (int j = length - 1; j > length - length / 4 - 1; j--) {
					matrix[j][i] = matrix[j][length - 1 - i] + matrix[j][i];
					matrix[j][length - 1 - i] = matrix[j][i] - matrix[j][length - 1 - i];
					matrix[j][i] = matrix[j][i] - matrix[j][length - 1 - i];
				}
			}
		} else {
			// 初始化数组 A
			for (int i = 0; i < length / 2; i++) {
				for (int j = 0; j < length / 2; j++) {
					oddOperation(length / 2);
				}
			}
			// 初始化数组 B
			for (int i = length / 2; i < length; i++) {
				for (int j = length / 2; j < length; j++) {
					matrix[i][j] = matrix[i - length / 2][j - length / 2] + length * length / 4;
				}
			}
			// 初始化数组 C
			for (int i = 0; i < length / 2; i++) {
				for (int j = length / 2; j < matrix.length; j++) {
					matrix[i][j] = matrix[i + length / 2][j] + length * length / 4;
				}
			}
			// 初始化数组 D
			for (int i = length / 2; i < length; i++) {
				for (int  j= 0; j < length / 2; j++) {
					matrix[i][j] = matrix[i - length / 2][j + length / 2] + length * length / 4;
				}
			}

			for (int i = 0; i < length / 2; i++) {
				for (int j = length / 2; j < length; j++) {
					if (j > (3*length + 2) / 4) {
						matrix[i][j] = matrix[i + length / 2][j] + matrix[i + length / 2][j];
						matrix[i + length / 2][j] = matrix[i][j] - matrix[i + length / 2][j];
						matrix[i][j] = matrix[i][j] - matrix[i + length / 2][j];
					}
				}
			}
			for (int i = 0; i < length / 2; i++) {
				for (int j = 0; j < length / 2; j++) {
					if (i == (length - 2) / 4 && j == 0) {
						continue;
					}
					if (i == (length - 2) / 4 && j == (length - 2) / 4) {
						matrix[i][j] = matrix[i + length / 2][j] + matrix[i][j];
						matrix[i + length / 2][j] = matrix[i][j] - matrix[i + length / 2][j];
						matrix[i][j] = matrix[i][j] - matrix[i + length / 2][j];
					}
					if (j < (length - 2) / 4) {
						matrix[i][j] = matrix[i][j] + matrix[i + length / 2][j];
						matrix[i + length / 2][j] = matrix[i][j] - matrix[i + length / 2][j];
						matrix[i][j] = matrix[i][j] - matrix[i + length / 2][j];
					}
				}
			}
		}
		return matrix;
	}

	public int[][] operation() {
		int length = matrix.length;
		if (length < 3) {
			return matrix;
		}
		if ((length - 1) % 2 == 0) {
			matrix = oddOperation(length);
		} else {
			matrix = evenOperation(length);
		}
		return matrix;
	}

	public int[][] square() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i % 4 == 0 && Math.abs(i - j) % 4 == 0) // abs求绝对值
					for (int k = 0; k < 4; k++)
						matrix[i + k][j + k] = n * n - matrix[i + k][j + k] + 1;
				else if (i % 4 == 3 && (i + j) % 4 == 3)
					for (int k = 0; k < 4; k++)
						matrix[i - k][j + k] = n * n - matrix[i - k][j + k] + 1;
			}
		return matrix;
	}

}
