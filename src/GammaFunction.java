import java.util.Scanner;

public class GammaFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for x: ");
        double x = sc.nextDouble();
        if (x <= 0 && x == floor(x)) {
            System.out.println("Gamma function is not defined for non-positive integers.");
        } else {
            double result = gamma(x);
            System.out.printf("Gamma(%.2f) = %.6f\n", x, result);
        }
    }

    public static double gamma(double x) {
        double g = 7;
        double[] p = {
            0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6,
            1.5056327351493116e-7
        };

        if (x < 0.5) {
            return MyMath.PI() / (MyMath.mySin(MyMath.PI() * x) * gamma(1 - x));
        } else {
            x -= 1;
            double a = p[0];
            for (int i = 1; i < p.length; i++) {
                a += p[i] / (x + i);
            }
            double t = x + g + 0.5;
            return MyMath.mySqrt(2 * MyMath.PI()) * MyMath.myPow(t, x + 0.5) * MyMath.myExp(-t) * a;
        }
    }

    // Manual implementations below

    public static double PI() {
        return 3.14159265358979323846;
    }

    public static double mySin(double x) {
        // Taylor series for sin(x), x in radians
        double term = x;
        double sum = x;
        for (int i = 1; i < 15; i++) {
            term *= -x * x / ((2 * i) * (2 * i + 1));
            sum += term;
        }
        return sum;
    }

    public static double myExp(double x) {
        double sum = 1.0;
        double term = 1.0;
        for (int i = 1; i < 30; i++) {
            term *= x / i;
            sum += term;
        }
        return sum;
    }

    public static double myPow(double base, double exp) {
        // pow(a, b) = exp(b * ln(a))
        return myExp(exp * myLn(base));
    }

    public static double myLn(double x) {
        // Natural log using Newton's method
        if (x <= 0) return Double.NaN;
        double guess = 1.0;
        for (int i = 0; i < 20; i++) {
            guess = guess - (myExp(guess) - x) / myExp(guess);
        }
        return guess;
    }

    public static double mySqrt(double x) {
        if (x < 0) return Double.NaN;
        double guess = x / 2.0;
        for (int i = 0; i < 20; i++) {
            guess = (guess + x / guess) / 2.0;
        }
        return guess;
    }

    public static double floor(double x) {
        int xi = (int)x;
        return (x < xi) ? xi - 1 : xi;
    }
}
