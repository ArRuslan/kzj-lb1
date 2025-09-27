package ua.nure.kz;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Calc {
    private static final Logger LOGGER = Logger.getLogger(Calc.class.getCanonicalName());

    public static int add(int a, int b) {
        LOGGER.log(Level.INFO, "add");
        LOGGER.log(Level.FINEST, "a={0}, b={1}", new Object[]{a, b});
        return a + b;
    }

    public static int subtract(int a, int b) {
        LOGGER.log(Level.CONFIG, "subtract");
        LOGGER.log(Level.FINEST, "a={0}, b={1}", new Object[]{a, b});
        return a - b;
    }

    public static int multiply(int a, int b) {
        LOGGER.log(Level.CONFIG, "multiply");
        LOGGER.log(Level.FINEST, "a={0}, b={1}", new Object[]{a, b});
        return a * b;
    }

    public static int divide(int a, int b) {
        LOGGER.log(Level.CONFIG, "divide");
        LOGGER.log(Level.FINEST, "a={0}, b={1}", new Object[]{a, b});
        return a / b;
    }
}
