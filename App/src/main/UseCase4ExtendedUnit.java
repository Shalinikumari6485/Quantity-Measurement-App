package main;

public class UseCase4ExtendedUnit {

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

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC4 - Extended Unit Support");
        System.out.println("==========================================\n");

        System.out.println("Input: Quantity(1.0, YARD) & Quantity(3.0, FEET)");
        System.out.println("Output: Equal (" +
                new QuantityLength(1.0, LengthUnit.YARD)
                        .equals(new QuantityLength(3.0, LengthUnit.FEET)) + ")");

        System.out.println("\nInput: Quantity(1.0, YARD) & Quantity(36.0, INCH)");
        System.out.println("Output: Equal (" +
                new QuantityLength(1.0, LengthUnit.YARD)
                        .equals(new QuantityLength(36.0, LengthUnit.INCH)) + ")");

        System.out.println("\nInput: Quantity(1.0, CM) & Quantity(0.393701, INCH)");
        System.out.println("Output: Equal (" +
                new QuantityLength(1.0, LengthUnit.CM)
                        .equals(new QuantityLength(0.393701, LengthUnit.INCH)) + ")");

        System.out.println("\nUC4 completed...");
    }
}

