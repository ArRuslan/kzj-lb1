package ua.nure.kz;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.LogManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    static {
        try (InputStream is = Demo.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*@Test
    public void testApp() {
        assertTrue( true );
    }*/

    @Test
    public void testAdd() {
        int expected = 4;
        int actual = Calc.add(1, 3);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        int expected = -1;
        int actual = Calc.subtract(34, 35);

        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        int expected = 68;
        int actual = Calc.multiply(34, 2);

        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        int expected = 33;
        int actual = Calc.divide(100, 3);

        assertEquals(expected, actual);
    }
}
