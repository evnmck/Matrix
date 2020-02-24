package matrix;

public class MatrixFunctions {

    /**
     * 
     *
     */
    public MatrixFunctions() {

    }


    /**
     * 
     * @param matrix
     * @return the numbers entered for the matrix as a string
     */
    public String asEntered(Matrix matrix) {
        double[] entered = matrix.toArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < entered.length; i++) {
            str.append(" " + entered[i]);
            if (i != entered.length - 1) {
                str.append(",");
            }
        }
        str.append("\n");
        return str.toString();

    }


    /**
     * 
     * @return a new matrix which is the sum of two others
     */
    public Matrix add(Matrix matrix, Matrix other) {
        Matrix sum = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum.setNumAt(i, j, matrix.getNum(i, j) + other.getNum(i, j));

            }
        }
        return sum;

    }


    /**
     * 
     * @param matrix
     * @param other
     * @return the difference between two matrices
     */
    public Matrix subtract(Matrix matrix, Matrix other) {
        Matrix sub = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sub.setNumAt(i, j, matrix.getNum(i, j) - other.getNum(i, j));

            }
        }
        return sub;

    }


    /**
     * 
     * @param matrix
     * @param other
     * @return the product between two matrices
     */
    public Matrix multiply(Matrix matrix, Matrix other) {
        Matrix product = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                product.setNumAt(i, j, multiplyHelp(i, j, matrix, other));
            }
        }

        return product;

    }


    /**
     * 
     * @param i
     * @param j
     * @param matrix
     * @param other
     * @return helper method to compute information for specified index and then
     *         returns to that index
     */
    private double multiplyHelp(int i, int j, Matrix matrix, Matrix other) {

        double[] row = matrix.getRow(i);
        double[] col = other.getColumn(j);
        double product = ((row[0] * col[0]) + (row[1] * col[1]) + (row[2]
            * col[2]));

        return product;
    }


    /**
     * 
     * @param matrix
     * @return a transposed matrix
     */
    public Matrix transpose(Matrix matrix) {
        Matrix trans = new Matrix();
        for (int i = 0; i < 3; i++) {
            trans.setColumn(i, matrix.getRow(i));
        }
        return trans;
    }


    /**
     * 
     * @param matrix
     * @return the diagonal of a matrix as a string
     */
    public String diagonal(Matrix matrix) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            str.append(" " + matrix.getDiagonal()[i] + " \n");
        }

        return str.toString();
    }


    /**
     * 
     * @param matrix
     * @param other
     * @return a matrix whose diagonal has been switched with another matrix
     */
    public Matrix switchDiagonal(Matrix matrix, Matrix other) {
        Matrix temp = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp.setNumAt(i, j, matrix.getNum(i, j));
            }
        }
        temp.setDiagonal(other.getDiagonal());
        return temp;

    }


    /**
     * 
     * @param matrix
     * @return the determinate of a matrix as a string
     */
    public String determinant(Matrix matrix) {
        double[][] det = new double[3][5];
        double determinant = 0;
        for (int i = 0; i < det.length; i++) {
            for (int j = 0; j < det.length; j++) {
                det[i][j] = matrix.getNum(i, j);
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 3; l < 5; l++) {
                det[k][l] = matrix.getNum(k, l - 3);
            }
        }
        determinant = detHelp(det, 1) + detHelp(det, 2) + detHelp(det, 3)
            - (detHelp(det, -1) + detHelp(det, -2) + detHelp(det, -3));
        StringBuilder str = new StringBuilder();
        str.append(" " + determinant + " \n");
        return str.toString();
    }


    /**
     * 
     * @param deter
     * @param row
     * @return helper method for determinant
     */
    private double detHelp(double[][] deter, int row) {
        int num = row;
        double[][] det = deter;
        double dMult = 0;
        switch (num) {
            case -1:
                dMult = det[0][4] * det[1][3] * det[2][2];
                break;
            case -2:
                dMult = det[0][3] * det[1][2] * det[2][1];
                break;
            case -3:
                dMult = det[0][2] * det[1][1] * det[2][0];
                break;
            case 3:
                dMult = det[0][2] * det[1][3] * det[2][4];
                break;
            case 2:
                dMult = det[0][1] * det[1][2] * det[2][3];
                break;
            case 1:
                dMult = det[0][0] * det[1][1] * det[2][2];
                break;
            default:
                throw new IndexOutOfBoundsException();
        }

        return dMult;
    }

}
