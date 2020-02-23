package matrix;

public class MatrixRunner {

    public MatrixRunner() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String[] args) {

        Matrix one = new Matrix();
        Matrix two = new Matrix();
        MatrixFunctions funct = new MatrixFunctions(one, two);
        MatrixWindow window = new MatrixWindow(funct);

    }

}
