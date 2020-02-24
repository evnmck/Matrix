package matrix;

import java.util.Scanner;

/**
 * 
 * @author mckso
 *
 */
public class Matrix {
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    public static final int size = 9;
    private double[][] matrix;
    private Scanner scan;


    /**
     * creates a new blank matrix out of arrays with size 9
     */
    public Matrix() {

        matrix = new double[ROWS][COLUMNS];

    }


    /**
     * sets the values of the matrix
     * 
     * @param scanner
     */
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


    /**
     * 
     * @return the values for the matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }


    /**
     * 
     * @return the size of the matrix
     */
    public int getSize() {
        return size;
    }


    /**
     * 
     * @param index
     * @return the number at a specific index 0-8
     */
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


    /**
     * 
     * @param i
     * @param j
     * @return returns the matrix at a given index 00,01,...,22
     */
    public double getNum(int i, int j) {
        return matrix[i][j];
    }


    /**
     * sets a number at a specific index given by row and column number
     * 
     * @param row
     * @param column
     * @param num
     */
    public void setNumAt(int row, int column, double num) {
        matrix[row][column] = num;

    }


    /**
     * sets the number at a specific index 0-8
     * 
     * @param placement
     * @param num
     */
    public void setNumAt(int placement, double num) {
        int[] index = getIndices(placement);
        matrix[index[0]][index[1]] = num;
    }


    /**
     * 
     * @param index
     * @return the specific index of an entry as 00,01,...,22
     */
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


    /**
     * 
     * @param num
     * @return the index of an entry as an integer 0-8
     */
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


    /**
     * 
     * @param num
     * @return the specified row
     */
    public double[] getRow(int num) {
        double row[] = new double[COLUMNS];
        int rowNum = num;
        switch (rowNum) {
            case 0:
                for (int i = 0; i < ROWS; i++) {
                    row[i] = matrix[0][i];
                }
                break;
            case 1:
                for (int i = 0; i < ROWS; i++) {
                    row[i] = matrix[1][i];
                }
                break;
            case 2:
                for (int i = 0; i < ROWS; i++) {
                    row[i] = matrix[2][i];
                }
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        /**
         * if (rowNum == 0) {
         * for (int i = 0; i < COLUMNS; i++) {
         * row[i] = matrix[0][i];
         * }
         * }
         * else if (rowNum == 1) {
         * for (int i = 0; i < COLUMNS; i++) {
         * row[i] = matrix[1][i];
         * }
         * }
         * else if (rowNum == 2) {
         * for (int i = 0; i < COLUMNS; i++) {
         * row[i] = matrix[2][i];
         * }
         * }
         * else {
         * throw new IndexOutOfBoundsException("Number not within row range");
         * }
         */
        return row;
    }


    /**
     * sets the specified row
     * 
     * @param row
     * @param num
     */
    public void setRow(int row, double[] num) {
        matrix[row][0] = num[0];
        matrix[row][1] = num[1];
        matrix[row][2] = num[2];
    }


    /**
     * returns the values of a particular column
     * 
     * @param num
     * @return
     */
    public double[] getColumn(int num) {
        double column[] = new double[ROWS];
        int colNum = num;
        switch (colNum) {
            case 0:
                for (int i = 0; i < ROWS; i++) {
                    column[i] = matrix[i][0];
                }
                break;
            case 1:
                for (int i = 0; i < ROWS; i++) {
                    column[i] = matrix[i][1];
                }
                break;
            case 2:
                for (int i = 0; i < ROWS; i++) {
                    column[i] = matrix[i][2];
                }
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        /**
         * if (colNum == 0) {
         * for (int i = 0; i < ROWS; i++) {
         * column[i] = matrix[i][0];
         * }
         * }
         * else if (colNum == 1) {
         * for (int i = 0; i < ROWS; i++) {
         * column[i] = matrix[i][1];
         * }
         * }
         * else if (colNum == 2) {
         * for (int i = 0; i < ROWS; i++) {
         * column[i] = matrix[i][2];
         * }
         * }
         * else {
         * throw new IndexOutOfBoundsException("Number not within row range");
         * }
         */

        return column;
    }


    /**
     * sets the values in a particular column
     * 
     * @param column
     * @param num
     */
    public void setColumn(int column, double[] num) {
        matrix[0][column] = num[0];
        matrix[1][column] = num[1];
        matrix[2][column] = num[2];
    }


    /**
     * sets the diagonal of the matrix
     * 
     * @param other
     */
    public void setDiagonal(double[] other) {
        double[] diagonal = other;
        for (int i = 0; i < ROWS; i++) {
            matrix[i][i] = diagonal[i];

        }
    }


    /**
     * 
     * @return the diagonal of the matrix
     */
    public double[] getDiagonal() {
        double[] diagonal = new double[3];
        for (int i = 0; i < ROWS; i++) {
            diagonal[i] = matrix[i][i];

        }
        return diagonal;

    }


    /**
     * returns the matrix as a string
     */
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


    /**
     * 
     * @return the matrix as a single dimensional array
     */
    public double[] toArray() {
        double[] test = new double[size];
        for (int i = 0; i < size; i++) {
            test[i] = this.getNumAt(i);

        }
        return test;
    }


    /**
     * checks for equality between matrices
     */
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
