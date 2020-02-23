package matrix;

import java.util.Scanner;

public class Matrix {
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    private int size;
    private double[][] matrix;
    private Scanner scan;


    public Matrix() {
        size = 9;
        matrix = new double[ROWS][COLUMNS];

    }


    public void setMatrix(Scanner scanner) {

        this.scan = scanner;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("Enter " + i + j + ": ");
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.print("\n");
        // scan.close();

    }


    public double[][] getMatrix() {
        return matrix;
    }


    public int getSize() {
        return size;
    }


    public double getNumAt(int index) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < ROWS; k++) {
            for (int l = 0; l < COLUMNS; l++) {
                if (i + j == index) {
                    return matrix[k][l];
                }

                j++;
            }
            if (j % 3 != 0) {
                i++;
            }
        }
        return -1;
    }


    public double getNum(int i, int j) {
        return matrix[i][j];
    }


    public void setNumAt(int row, int column, double num) {
        matrix[row][column] = num;

    }


    public void setNumAt(int placement, double num) {
        int[] index = getIndices(placement);
        matrix[index[0]][index[1]] = num;
    }


    private int[] getIndices(int index) {
        int[] indices = new int[2];
        int i = 0;
        int j = 0;
        for (int k = 0; k < ROWS; k++) {
            for (int l = 0; l < COLUMNS; l++) {
                if (i + j == index) {

                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }

                j++;
            }
            if (j % 3 != 0) {
                i++;
            }
        }
        indices[0] = -1;
        indices[1] = -1;
        return indices;
    }


    public double getIndex(int num) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < ROWS; k++) {
            for (int l = 0; l < COLUMNS; l++) {
                if (matrix[k][l] == num) {
                    return i + j;
                }

                j++;
            }
            if (j % 3 != 0) {
                i++;
            }
        }
        return -1;
    }


    public double[] getRow(int num) {
        double row[] = new double[COLUMNS];
        int rowNum = num;
        if (rowNum == 0) {
            for (int i = 0; i < COLUMNS; i++) {
                row[i] = matrix[0][i];
            }
        }
        else if (rowNum == 1) {
            for (int i = 0; i < COLUMNS; i++) {
                row[i] = matrix[1][i];
            }
        }
        else if (rowNum == 2) {
            for (int i = 0; i < COLUMNS; i++) {
                row[i] = matrix[2][i];
            }
        }
        else {
            throw new IndexOutOfBoundsException("Number not within row range");
        }
        return row;
    }


    public void setRow(int row, double[] num) {
        matrix[row][0] = num[0];
        matrix[row][1] = num[1];
        matrix[row][2] = num[2];
    }


    public double[] getColumn(int num) {
        double column[] = new double[ROWS];
        int colNum = num;
        if (colNum == 0) {
            for (int i = 0; i < ROWS; i++) {
                column[i] = matrix[i][0];
            }
        }
        else if (colNum == 1) {
            for (int i = 0; i < ROWS; i++) {
                column[i] = matrix[i][1];
            }
        }
        else if (colNum == 2) {
            for (int i = 0; i < ROWS; i++) {
                column[i] = matrix[i][2];
            }
        }
        else {
            throw new IndexOutOfBoundsException("Number not within row range");
        }
        return column;
    }


    public void setColumn(int column, double[] num) {
        matrix[0][column] = num[0];
        matrix[1][column] = num[1];
        matrix[2][column] = num[2];
    }


    public void setDiagonal(double[] other) {
        double[] diagonal = other;
        for (int i = 0; i < ROWS; i++) {
            matrix[i][i] = diagonal[i];

        }
    }


    public double[] getDiagonal() {
        double[] diagonal = new double[3];
        for (int i = 0; i < ROWS; i++) {
            diagonal[i] = matrix[i][i];

        }
        return diagonal;

    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {

            str.append(" " + getNumAt(i) + " ");
            if ((i + 1) % 3 == 0) {
                str.append("\n");
            }

        }
        return str.toString();

    }


    public double[] toArray() {
        double[] test = new double[size];
        for (int i = 0; i < size; i++) {
            test[i] = this.getNumAt(i);

        }
        return test;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Matrix other = (Matrix)obj;
            return (this.toString().equals(other.toString()));

        }
        return false;

    }

}
