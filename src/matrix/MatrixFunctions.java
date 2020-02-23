package matrix;

public class MatrixFunctions {
    private Matrix one;
    private Matrix two;


    public MatrixFunctions(Matrix m1, Matrix m2) {
        one = m1;
        two = m2;

    }


    public Matrix getOne() {
        return one;
    }


    public Matrix getTwo() {
        return two;
    }


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


    public Matrix add() {
        Matrix sum = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum.setNumAt(i, j, one.getNum(i, j) + two.getNum(i, j));

            }
        }
        return sum;

    }


    public Matrix subtract() {
        Matrix sub = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sub.setNumAt(i, j, one.getNum(i, j) - two.getNum(i, j));

            }
        }
        return sub;

    }


    public Matrix multiply() {
        Matrix product = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                product.setNumAt(i, j, multiplyHelp(i, j));
            }
        }

        return product;

    }


    private double multiplyHelp(int i, int j) {

        double[] row = one.getRow(i);
        double[] col = two.getColumn(j);
        double product = ((row[0] * col[0]) + (row[1] * col[1]) + (row[2]
            * col[2]));

        return product;
    }


    public Matrix transpose(Matrix matrix) {
        Matrix trans = new Matrix();
        for (int i = 0; i < 3; i++) {
            trans.setColumn(i, matrix.getRow(i));
        }
        return trans;
    }


    public String diagonal(Matrix matrix) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            str.append(" " + matrix.getDiagonal()[i] + " \n");
        }

        return str.toString();
    }


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
