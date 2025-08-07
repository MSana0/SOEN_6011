public class MyMath {
    public static double PI() {
        return 3.14159265358979323846;
    }

    public static double mySin(double x) {
        double pi = PI();
        x = x % (2 * pi);
        if (x > pi) x -= 2 * pi;
        if (x < -pi) x += 2 * pi;
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
        return myExp(exp * myLn(base));
    }

    public static double myLn(double x) {
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