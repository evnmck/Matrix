package matrix;

import java.util.Scanner;
// import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MatrixWindow {
    private JFrame window;
    private JTextArea text;
    private MatrixFunctions fun;
    private Matrix one;
    private Matrix two;
    private String first;
    private String second;
    private Matrix sum;
    private Matrix sub;
    private Matrix product;
    private Matrix trans;
    private Matrix trans2;
    private String diagonal;
    private String diagonal2;
    private String determinant;
    private String determinant2;
    private Scanner scan;
    private Matrix oneDSwitch;
    private Matrix twoDSwitch;


    /**
     * creates a new window where matrices will be displayed
     * 
     * @param funct
     *            a matrix to be manipulated
     */
    public MatrixWindow(MatrixFunctions funct) {

        fun = funct;
        one = fun.getOne();
        two = fun.getTwo();
        text = new JTextArea();
        createMatrix();

        window = new JFrame("Matrix Operations");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 600);
        window.setLocation(500, 100);

        // JButton choose = new JButton("Choose");
        // choose.setBounds(100, 10, 90, 30);
        // window.add(choose);

        addMatrix();
        window.add(text);

        JScrollPane scrollPane = new JScrollPane(text,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        window.add(scrollPane);

        window.setVisible(true);

    }


    /**
     * creates two new matrices and then manipulates them and stores the new
     * values is separate variables
     */
    private void createMatrix() {
        scan = new Scanner(System.in);
        one.setMatrix(scan);
        two.setMatrix(scan);
        scan.close();

        first = fun.asEntered(one);
        second = fun.asEntered(two);
        sum = fun.add();
        sub = fun.subtract();
        product = fun.multiply();
        trans = fun.transpose(one);
        trans2 = fun.transpose(two);
        diagonal = fun.diagonal(one);
        diagonal2 = fun.diagonal(two);
        determinant = fun.determinant(one);
        determinant2 = fun.determinant(two);
        oneDSwitch = fun.switchDiagonal(one, two);
        twoDSwitch = fun.switchDiagonal(two, one);

    }


    /**
     * adds the matrices and subsequent parts to the window
     */
    private void addMatrix() {

        String test = one.toString();
        String test2 = two.toString();
        String test3 = sum.toString();
        String test1 = sub.toString();
        String test4 = product.toString();
        String test5 = trans.toString();
        String test6 = trans2.toString();
        String test7 = oneDSwitch.toString();
        String test8 = twoDSwitch.toString();

        text.append(" First Data Entered\n");
        text.append(first);
        text.append("\n Second Data Entered\n");
        text.append(second);
        text.append("\n Matrix One\n");
        text.append(test);
        text.append("\n Matrix Two\n");
        text.append(test2);
        text.append("\n Matrix Sum\n");
        text.append(test3);
        text.append("\n Matrix Difference\n");
        text.append(test1);
        text.append("\n Matrix Product\n");
        text.append(test4);
        text.append("\n Matrix One Transposed\n");
        text.append(test5);
        text.append("\n Matrix Two Transposed\n");
        text.append(test6);
        text.append("\n Diagonal of Matrix One\n");
        text.append(diagonal);
        text.append("\n Diagonal of Matrix Two\n");
        text.append(diagonal2);
        text.append("\n Matrix One with Diagonal Two\n");
        text.append(test7);
        text.append("\n Matrix Two with Diagonal One\n");
        text.append(test8);
        text.append("\n Determinant of Matrix One\n");
        text.append(determinant);
        text.append("\n Determinant of Matrix Two\n");
        text.append(determinant2);

    }

}
