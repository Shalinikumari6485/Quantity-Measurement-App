package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase1FeetMeasurementTest {

    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    @Test
    void testEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        Feet f1 = new Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        Feet f1 = new Feet(1.0);

        assertFalse(f1.equals("Not a Feet Object"));
    }

    @Test
    void testEquality_SameReference() {
        Feet f1 = new Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}

