import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    public static final String ROOT = "test/resources/matrix/";

    @Test
    void constructEmpty() {
        Matrix m = new Matrix(4,3);
        assertEquals(0.0, m.get(3, 2));
    }

    @Test
    void constructFromFile() {
        Matrix m = new Matrix(new File(ROOT + "3x4.txt"));
        assertEquals(3, m.nRows());
        assertEquals(4, m.nColumns());

        assertEquals(1, m.get(0, 0));
        assertEquals(4, m.get(0, 3));
        assertEquals(10, m.get(2, 1));
    }

    @Test
    void constructFromInvalidFile() {
        Matrix m = new Matrix(new File("asdfasdf.txt"));
        assertEquals(0, m.nRows());
    }

    @Test
    void equals() {
        Matrix a = new Matrix(new File(ROOT + "3x4.txt"));
        Matrix b = new Matrix(new File(ROOT + "3x4.txt"));
        assertEquals(a, b);
    }

    @Test
    void multiply() {
        Matrix a = new Matrix(new File(ROOT + "3x4.txt"));
        Matrix b = new Matrix(new File(ROOT + "4x2.txt"));
        Matrix c = new Matrix(new File(ROOT + "3x2.txt"));
        assertEquals(c, a.multiply(b));
    }









}