package by.bsu.nummeth.main;

/**
 * Created by jenia on 17.02.16.
 */
public class SimpleIteration {
    public static double fun(double x) {
        return 0.5 * (Math.exp(x) + 1);
    }
    public static void main(String[] args) {
        double x = 0.6;
        double eps = 0.00001;
        while (eps < Math.abs(x - fun(x))) {
            x = fun(x);
        }
        System.out.println(x);
    }
}