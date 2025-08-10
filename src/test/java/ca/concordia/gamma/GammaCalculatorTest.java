package ca.concordia.gamma;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GammaCalculatorTest {
    @Test
    public void testGammaPositiveInteger() {
        double result = GammaFunction.gamma(5);
        System.out.println("Gamma(5) = " + result);
        assertEquals(24.0, result, 0.0001);
    }

    @Test
    public void testGammaNegativeNonInteger() {
    double result = GammaFunction.gamma(-2.5);
    System.out.println("Gamma(-2.5) = " + result);
    // Compare with expected value from a reliable source
    assertEquals(-0.9453087204829419, result, 0.0001);
    }

    @Test
    public void testGammaHalf() {
        double result = GammaFunction.gamma(0.5);
        System.out.println("Gamma(0.5) = " + result);
        assertEquals(Math.sqrt(Math.PI), result, 0.0001);
    }

    @Test
    public void testGammaLargeInput() {
    double result = GammaFunction.gamma(200);
    System.out.println("Gamma(200) = " + result);
    assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGammaUndefined() {
        double result = GammaFunction.gamma(0);
        System.out.println("Gamma(0) = " + result);
        assertTrue(Double.isNaN(result) || Double.isInfinite(result));
    }

    @Test
    public void testGammaSmallPositive() {
        double result = GammaFunction.gamma(0.1);
        System.out.println("Gamma(0.1) = " + result);
        assertEquals(9.513507698668731, result, 0.0001);
    }

    @Test
    public void testGammaNaN() {
    double result = GammaFunction.gamma(Double.NaN);
    assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGammaInfinity() {
    double result = GammaFunction.gamma(Double.POSITIVE_INFINITY);
    assertTrue(Double.isNaN(result));
    }
}
