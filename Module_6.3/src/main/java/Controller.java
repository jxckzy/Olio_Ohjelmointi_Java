public class Controller {
    private Pet pet;

    public Controller(Pet petModel) {
        this.pet = petModel;
    }

    public void setTarget(double x, double y) {
        this.pet.targetX = x;
        this.pet.targetY = y;
        this.pet.isMoving = true;
    }

    public void stopMoving() {
        this.pet.isMoving = false;
    }

    public void updateLocation() {
        if (!this.pet.isMoving) return;

        double dx = this.pet.targetX - this.pet.x;
        double dy = this.pet.targetY - this.pet.y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance <= this.pet.speed) {
            this.pet.x = this.pet.targetX;
            this.pet.y = this.pet.targetY;
            this.pet.isMoving = false;
        } else {
            this.pet.x += (dx / distance) * this.pet.speed;
            this.pet.y += (dy / distance) * this.pet.speed;
        }
    }
}