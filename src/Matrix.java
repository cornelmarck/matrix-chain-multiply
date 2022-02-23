import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private final double[][] data;

    public Matrix(int nRows, int nColumns) {
        data = new double[nRows][nColumns];
    }

    public Matrix(File input) {
        data = parse(readByLine(input));
    }

    private double[][] parse(List<String> lines) {
        int nRows = lines.size();
        int nColumns = (nRows == 0) ? 0 : lines.get(0).split(" ").length;
        double[][] data = new double[nRows][nColumns];

        for (int i = 0; i < nRows; i++) {
            String[] rawNumbers = lines.get(i).split(" ");
            for (int j = 0; j < nColumns; j++) {
                data[i][j] = Double.parseDouble(rawNumbers[j]);
            }
        }
        return data;
    }

    private List<String> readByLine(File input){
        List<String> lines = new ArrayList<>();

        try {
            Scanner lineReader = new Scanner(input);

            while (lineReader.hasNextLine()) {
                String currentLine = lineReader.nextLine();
                if (currentLine.equals(System.lineSeparator())) {
                    break;
                }
                lines.add(currentLine);
            }
            lineReader.close();
        }
        catch (IOException ignored) {}

        return lines;
    }

    public Matrix(List<String> rawLines) {
        data = parse(rawLines);
    }

    Matrix multiply(Matrix right) {
        if (!isMultiplyAllowed(right)) {
            String errorMessage = String.format("Incompatible matrix dimensions: %dx%d and %dx%d",
                    nRows(), nColumns(), right.nRows(), right.nColumns());
            throw new IllegalArgumentException(errorMessage);
        }
        Matrix result = new Matrix(nRows(), right.nColumns());
        for (int i = 0; i < nRows(); i++) {
            for (int j = 0; j < right.nColumns(); j++) {
                double scalarProduct = 0;
                for (int k = 0; k < nColumns(); k++) {
                    scalarProduct += get(i, k) * right.get(k, j);
                }
                result.set(i, j, scalarProduct);
            }
        }
        return result;
    }

    public boolean isMultiplyAllowed(Matrix right) {
        return nColumns() == right.nRows();
    }

    public int nRows() {
        return data.length;
    }

    public int nColumns() {
        if (data.length == 0) {
            return 0;
        }
        return data[0].length;
    }

    public double get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    public int getMultiplyTimeComplexity(Matrix right) {
        return nRows() * nColumns() * right.nColumns();
    }

    public Matrix getTranspose() {
        Matrix result = new Matrix(nColumns(), nRows());
        for (int i = 0; i < nRows(); i++) {
            for (int j = 0; j < nColumns(); j++) {
                result.set(j, i, get(i, j));
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        return Arrays.deepEquals(this.data, matrix.data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows(); i++) {
            for (int j = 0; j < nColumns(); j++) {
                sb.append(get(i, j));
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}