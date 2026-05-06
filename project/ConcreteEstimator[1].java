public class ConcreteEstimator {
    public static double calculateConcrete(double length, double width, double depth) {
        double cubicFeet = length * width * depth;
        return cubicFeet / 27.0; // cubic yards
    }
}