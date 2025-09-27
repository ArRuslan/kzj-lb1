package ua.nure.kz;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class Demo {

    static {
        try (InputStream is = Demo.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static final Logger LOGGER = Logger.getLogger(Calc.class.getCanonicalName());

    public static void main(String[] args) {
        System.out.printf("1 + 2 = %d\n", Calc.add(1, 2));
 
        System.out.printf("35 - 34 = %d\n", Calc.subtract(35, 34));

        System.out.printf("40 * 5 = %d\n", Calc.multiply(40, 5));

        System.out.printf("45 / 15 = %d\n", Calc.divide(45, 15));
    }
}
