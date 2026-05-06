package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase4ExtendedUnitTest {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.393701 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }
    }


    @Test
    void testEquality_YardToYard_SameValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(1, LengthUnit.YARD)));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(3, LengthUnit.FEET)));
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new QuantityLength(3, LengthUnit.FEET)
                .equals(new QuantityLength(1, LengthUnit.YARD)));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(36, LengthUnit.INCH)));
    }

    @Test
    void testEquality_CMToInch_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.CM)
                .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
    }

    @Test
    void testEquality_CMToFeet_NonEquivalent() {
        assertFalse(new QuantityLength(1, LengthUnit.CM)
                .equals(new QuantityLength(1, LengthUnit.FEET)));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength a = new QuantityLength(1, LengthUnit.YARD);
        QuantityLength b = new QuantityLength(3, LengthUnit.FEET);
        QuantityLength c = new QuantityLength(36, LengthUnit.INCH);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        });
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength q = new QuantityLength(1, LengthUnit.YARD);
        assertTrue(q.equals(q));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength q = new QuantityLength(1, LengthUnit.YARD);
        assertFalse(q.equals(null));
    }
}

