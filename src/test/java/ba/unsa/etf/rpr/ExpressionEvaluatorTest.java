package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Klasa testira klasu ExpressionEvaluator
 */
public class ExpressionEvaluatorTest {

    /**
     * Testiranje operatora +, -, /, *, sqrt
     */
    @Test
    void test1() {
        assertEquals(101D, ExpressionEvaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }
    @Test
    void test2() {
        assertEquals(2.769230769230769, ExpressionEvaluator.evaluate("( 36 / ( 6 + ( 15 - 8 ) ) )"));
    }
    @Test
    void test3() {
        assertEquals(61.5, ExpressionEvaluator.evaluate("( 78.5 - ( 5 + sqrt ( 144 ) ) )"));
    }
    @Test
    void test4() {
        assertEquals(8D, ExpressionEvaluator.evaluate("( 1 + sqrt ( 49 ) )"));
    }

    /**
     * Testiranje izuzetaka
     */
    @Test
    void test5(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 & 5 + 8 % ( 4 ^ 6 ) )"));
    }
    @Test
    void test6(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 36 / ( + ( 15 - 8 ) ) )"));
    }
    @Test
    void test7(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 36 / ( 14 + ( 15 8 ) ) )"));
    }
    @Test
    void test8(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 49s / 6 )"));
    }
    @Test
    void test9(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( / 6 )"));
    }

}
