package ca.concordia.gamma;

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
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        if (x <= 0 && x == floor(x)) {
            return Double.NaN;
        }
        if (x > 170) {
            return Double.POSITIVE_INFINITY;
        }
        // Special cases for accuracy
        if (Math.abs(x - floor(x)) < 1e-10 && x > 0) {
            return factorial(x - 1); // Gamma(n) = (n-1)!
        }
        if (Math.abs(x - 0.5) < 1e-10) {
            return mySqrt(PI());
        }
        // Reflection formula for negative non-integers
        if (x < 0.5) {
            return PI() / (mySin(PI() * x) * gamma(1 - x));
        }
        // Lanczos approximation for positive x
        x -= 1;
        double g = 7;
        double[] p = {
            0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6,
            1.5056327351493116e-7
        };
        double a = p[0];
        for (int i = 1; i < p.length; i++) {
            a += p[i] / (x + i);
        }
        double t = x + g + 0.5;
        return mySqrt(2 * PI()) * myPow(t, x + 0.5) * myExp(-t) * a;
    }

    public static double factorial(double n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double PI() {
        return 3.141592653589793;
    }

    public static double mySin(double x) {
        double term = x;
        double sum = x;
        for (int i = 1; i < 30; i++) {
            term *= -x * x / ((2 * i) * (2 * i + 1));
            sum += term;
        }
        return sum;
    }

    public static double myExp(double x) {
        double sum = 1.0;
        double term = 1.0;
        for (int i = 1; i < 50; i++) {
            term *= x / i;
            sum += term;
        }
        return sum;
    }

    public static double myPow(double base, double exp) {
        return myExp(exp * myLn(base));
    }

    public static double myLn(double x) {
        // Use a simple approximation for ln(x) for x > 0
        if (x <= 0) return Double.NaN;
        double y = (x - 1) / (x + 1);
        double y2 = y * y;
        double sum = 0.0;
        for (int n = 1; n < 100; n += 2) {
            sum += (1.0 / n) * Math.pow(y, n);
        }
        return 2 * sum;
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
        return (double)((int)x - (x < 0 && x != (int)x ? 1 : 0));
    }
}
