package ba.unsa.etf.rpr;

import org.jetbrains.annotations.NotNull;
import java.util.Stack;

/**
 * Klasa implementira Dijkstra algoritam
 */
public class ExpressionEvaluator {
    /**
     * @param s Izraz unesen sa tastature
     * @return Rezultat unesenog izraza
     * @throws RuntimeException Neispravan unos
     */
    public static Double evaluate(@NotNull String s) throws RuntimeException {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (String c: s.split(" ")) {
            if (c.equals("(")) {}
            else if(c.equals("+"))
                ops.push(c);
            else if(c.equals("-"))
                ops.push(c);
            else if(c.equals("*"))
                ops.push(c);
            else if(c.equals("/"))
                ops.push(c);
            else if(c.equals("sqrt"))
                ops.push(c);
            else if(c.equals(")")) {
                double val = vals.pop();
                String op = ops.pop();
                if (op.equals("+"))
                    val = vals.pop() + val;
                else if(op.equals("-"))
                    val = vals.pop() - val;
                else if(op.equals("*"))
                    val = vals.pop() * val;
                else if(op.equals("/"))
                    val = vals.pop() / val;
                else if(op.equals("sqrt"))
                    val = Math.sqrt(val);
                vals.push(val);
            }
            else
                try {
                    vals.push(Double.parseDouble(c));
                } catch (Exception e) {
                    throw new RuntimeException("Neispravan unos!");
                }
        }
        if (ops.size() != 0 || vals.size() != 1)
            throw new RuntimeException("Neispravan unos!");
        return vals.pop();
        }
}
