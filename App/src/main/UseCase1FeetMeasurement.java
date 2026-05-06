package main;

public class UseCase1FeetMeasurement {

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

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC1 - Feet Measurement Equality");
        System.out.println("==========================================\n");

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        boolean result = f1.equals(f2);

        System.out.println("Comparing 1.0 ft and 1.0 ft");
        System.out.println("Are Equal: " + result);

        System.out.println("\nUC1 equality check completed...");
    }
}
