import java.io.File;
import java.io.IOException;

import
class MatrixTest {

    @org.junit.jupiter.api.Test
    void multiply() {
        StringBuilder sb = new StringBuilder();
    }

    @org.junit.jupiter.api.Test
    void MatrixFromFile() throws IOException {
        Matrix m = new Matrix(new File("test/resources/2x3.txt"));

        assertEquals(2, m.numberOfRows());
        assertEquals(3, m.numberOfColumns());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Matrix m = new Matrix(3, 2, 0.0);

        System.out.println(m);
    }
}