public class FenceEstimator {
    public static int calculateFencePanels(double length) {
        int panelSize = 8; // 8 ft per panel
        return (int) Math.ceil(length / panelSize);
    }
}