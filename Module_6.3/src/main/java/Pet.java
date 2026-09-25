public class Pet {
    double x, y;
    double targetX, targetY;
    double speed;
    boolean isMoving;

    public Pet(double startX, double startY, double speed) {
        this.x = startX;
        this.y = startY;
        this.targetX = startX;
        this.targetY = startY;
        this.speed = speed;
        this.isMoving = false;
    }
}