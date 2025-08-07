public class GammaFunc {
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
}