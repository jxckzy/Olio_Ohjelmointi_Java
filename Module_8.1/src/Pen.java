public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    private Color color;
    private boolean capOn;

    /**
     * Constructs a Pen with the default color (RED) and cap ON.
     */
    public Pen() {
        this(Color.RED);
    }

    /**
     * Constructs a Pen with a selected color and cap ON.
     *
     * @param color initial color of the pen
     */
    public Pen(Color color) {
        this.color = color;
        this.capOn = true;
    }

    /**
     * Removes the cap from the pen.
     */
    public void capOff() {
        this.capOn = false;
    }

    /**
     * Puts the cap on the pen.
     */
    public void capOn() {
        this.capOn = true;
    }

    /**
     * Changes the pen's color only if the cap is currently ON.
     *
     * @param newColor the new color to switch to
     */
    public void changeColor(Color newColor) {
        if (this.capOn) {
            this.color = newColor;
        }
    }

    /**
     * Draws using the pen if the cap is OFF.
     *
     * @return "Drawing <color>" when cap is off, or "" when cap is on.
     */
    public String draw() {
        if (this.capOn) {
            return "";
        }
        return "Drawing " + this.color;
    }
}