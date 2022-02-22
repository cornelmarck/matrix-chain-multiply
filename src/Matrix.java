import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private final List<List<Double>> data;

    public Matrix(int numberOfRows, int numberOfColumns, double initialValue) throws IllegalArgumentException {
        data = new ArrayList<>();

        for (int i = 0; i < numberOfRows; i++) {
            List<Double> newRow = new ArrayList<>();
            for (int j = 0; j < numberOfColumns; j++) {
                newRow.add(initialValue);
            }
            data.add(newRow);
        }
    }

    public Matrix(File input) throws IOException, IllegalArgumentException {
        Scanner s = new Scanner(input);

        data = new ArrayList<>();
        while (s.hasNextLine()) {
            List<Double> newRow = new ArrayList<>();
            while (s.hasNextDouble()) {
                newRow.add(s.nextDouble());
            }
            data.add(newRow);
        }
    }



    private void importFromFile(File input) throws IOException {

    }

    public double get(int row, int col) {
        return data.get(row).get(col);
    }

    public void set(int row, int col, double value) {
        data.get(row).set(col, value);
    }

    public int numberOfRows() {
        return data.size();
    }

    public int numberOfColumns() {
        if (data.isEmpty()) {
            return 0;
        }
        return data.get(0).size();
    }

    Matrix multiply(Matrix right) {
        Matrix result = new Matrix(numberOfRows(), right.numberOfColumns(), 0.0);

        for (int i = 0; i < numberOfRows(); i++) {
            for (int j = 0; j < right.numberOfColumns(); j++) {
                double scalarProduct = 0;

                for (int k = 0; k < numberOfColumns(); k++) {
                    scalarProduct += get(i, k) * right.get(k, j);
                }

                result.set(i, j, scalarProduct);
            }
        }
        return result;
    }

    public String toString() {
        if (numberOfRows() < 1 || numberOfColumns() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRows(); i++) {
            for (int j = 0; j < numberOfColumns() - 1; j++) {
                sb.append(data.get(i).get(j));
                sb.append(" ");
            }
            sb.append(data.get(i).get(numberOfColumns() - 1));
            sb.append("\n");
        }
        return sb.toString();
    }

}