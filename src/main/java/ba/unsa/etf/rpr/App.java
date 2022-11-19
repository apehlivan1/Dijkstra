package ba.unsa.etf.rpr;

/**
 * Klasa sadrzi main metodu koja parsira ulaz i vrsi njegovu validaciju
 * @author Almedina Pehlivan
 */
public class App
{
    /**
     * Metoda vrsi validaciju unesenog stringa
     * @param s string koji korisnik unosi
     */
    public static void validityTest(String s) {
        RuntimeException error = new RuntimeException("Neispravan unos!");
        if (s.isEmpty())
            throw error;
        s=s.trim();
        int lParentheses = 0, rParentheses = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) != '(') throw error;
            if (i == s.length()-1 && s.charAt(i) != ')') throw error;
            if (s.charAt(i) == '(') lParentheses++;
            else if (s.charAt(i) == ')') rParentheses++;
            else if (s.charAt(i) == ' ' && i != s.length()-1 && s.charAt(i+1) == ' ')
                throw error;
            /*else {
                String c = s.substring(i, s.indexOf(' ', i)-1);
                if (c!="+" || c!="-" || )
            }*/
        }
        if (lParentheses != rParentheses) throw error;
    }

    /**
     * Metoda parsira ulaz s konzole iz parametra args
     * @param args Uneseni izraz
     */
    public static void main( String[] args ) {
        String s = args[0];
        try {
            validityTest(s);
            System.out.println("Rezultat je: " + ExpressionEvaluator.evaluate(s));
        } catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }
}