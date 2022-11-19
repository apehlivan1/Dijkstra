package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test klase App
 */
public class AppTest {
    /**
     * Nepravilan broj zagrada
     */
    @Test
    void test1() {
        assertThrows(RuntimeException.class, () -> App.validityTest("( 100 * 2 + 12 ) / 14 )"));
    }

    /**
     * Vise od jednog razmaka
     */
    @Test
    void test2() {
        assertThrows(RuntimeException.class, () -> App.validityTest("( 100 * ( 2 + 12 ) / 14 )"));
    }

    /**
     * Prazan string
     */
    @Test
    void test3() {
        assertThrows(RuntimeException.class, () -> App.validityTest(""));
    }
    @Test
    void test7(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 36 / ( + ( 15 -  8 ) ) )"));
    }

}

