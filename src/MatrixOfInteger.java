import java.util.List;

public class MatrixOfInteger extends Matrix<Integer>{

    public MatrixOfInteger() {}

    public MatrixOfInteger(List<List<Integer>> input) {
        super(input);
    }

    @Override
    Matrix<Integer> multiply(Matrix<Integer> right) {
        MatrixOfInteger result = new MatrixOfInteger();

        for (int i = 0; i < numberOfRows(); i++) {
            for (int j = 0; j < right.numberOfColumns(); j++) {

                for

            }
        }


    }

    public elementMultiply


}
