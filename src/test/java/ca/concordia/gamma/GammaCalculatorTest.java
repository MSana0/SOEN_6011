package test.java.ca.concordia.gamma;

import static org.junit.Assert.*;
import org.junit.Test;

public class GammaCalculatorTest {
    @Test
    public void testGammaPositiveInteger() {
        assertEquals(24.0, GammaFunction.gamma(5), 0.0001);
    }

    @Test
    public void testGammaHalf() {
        assertEquals(Math.sqrt(Math.PI), GammaFunction.gamma(0.5), 0.0001);
    }

    @Test
    public void testGammaUndefined() {
        assertTrue(Double.isNaN(GammaFunction.gamma(0)));
    }
}
