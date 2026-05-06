package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase2FeetInchMeasurementTest {

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

    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }


    @Test
    void testEquality_SameValue_Feet() {
        assertTrue(new Feet(1.0).equals(new Feet(1.0)));
    }

    @Test
    void testEquality_DifferentValue_Feet() {
        assertFalse(new Feet(1.0).equals(new Feet(2.0)));
    }

    @Test
    void testEquality_NullComparison_Feet() {
        assertFalse(new Feet(1.0).equals(null));
    }

    @Test
    void testEquality_NonNumericInput_Feet() {
        assertFalse(new Feet(1.0).equals("Invalid"));
    }

    @Test
    void testEquality_SameReference_Feet() {
        Feet f = new Feet(1.0);
        assertTrue(f.equals(f));
    }


    @Test
    void testEquality_SameValue_Inches() {
        assertTrue(new Inches(1.0).equals(new Inches(1.0)));
    }

    @Test
    void testEquality_DifferentValue_Inches() {
        assertFalse(new Inches(1.0).equals(new Inches(2.0)));
    }

    @Test
    void testEquality_NullComparison_Inches() {
        assertFalse(new Inches(1.0).equals(null));
    }

    @Test
    void testEquality_NonNumericInput_Inches() {
        assertFalse(new Inches(1.0).equals("Invalid"));
    }

    @Test
    void testEquality_SameReference_Inches() {
        Inches i = new Inches(1.0);
        assertTrue(i.equals(i));
    }
}

