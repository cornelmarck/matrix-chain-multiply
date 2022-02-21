import java.util.ArrayList;
import java.util.List;

abstract public class Matrix<T extends Number> {
    private List<List<T>> matrix;

    public Matrix() {
        matrix = new ArrayList<>();
    }

    public Matrix(int numberOfRows, int numberOfColumns) {
        matrix = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            matrix.add(new ArrayList<>(numberOfColumns));
        }
    }

    public Matrix(List<List<T>> rows) {
        matrix = new ArrayList<>();
        for (List<T> row : rows) {
            matrix.add(new ArrayList<>(row));
        }
    }

    public T get(int row, int col) {
        return matrix.get(row).get(col);
    }

    public void set(int row, int col, T value) {
        matrix.get(row).set(col, value);
    }

    Matrix<T> (Matrix<T> right) {
        
    }

    abstract T multiply(T other);

    public int numberOfRows() {
        return matrix.size();
    }

    public int numberOfColumns() {
        if (matrix.isEmpty()) {
            return 0;
        }
        return matrix.get(0).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRows(); i++) {
            for (int j = 0; j < numberOfColumns() - 1; i++) {
                sb.append(matrix.get(i).get(j));
                sb.append(" ");
            }
            sb.append(matrix.get(i).get(numberOfColumns() - 1));
            sb.append("\n");
        }
        return sb.toString();
    }
}


