import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class View extends Pane {
    private Canvas canvas;
    private GraphicsContext gc;
    private Controller controller;
    private Pet pet;
    private Image petImage;

    public View(Controller controller, Pet pet) {
        this.controller = controller;
        this.pet = pet;

        this.canvas = new Canvas(800, 600);
        this.gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);

        try {
            String imagePath = getClass().getResource("/MyPet.jpg").toExternalForm();
            petImage = new Image(imagePath);
        } catch (Exception e) {
            System.out.println("Could not find the image! Check the name and resources folder.");
            petImage = null;
        }

        setupMouseEvents();
        startGameLoop();
    }

    private void setupMouseEvents() {
        canvas.setOnMouseMoved(e -> {
            controller.setTarget(e.getX(), e.getY());
        });

        canvas.setOnMouseExited(e -> {
            controller.stopMoving();
        });
    }

    private void startGameLoop() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.updateLocation();
                draw();
            }
        };
        timer.start();
    }

    private void draw() {
        gc.setFill(Color.ALICEBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (petImage != null && !petImage.isError()) {
            double imgW = petImage.getWidth();
            double imgH = petImage.getHeight();
            gc.drawImage(petImage, pet.x - (imgW / 2), pet.y - (imgH / 2));
        } else {
            gc.setFill(Color.BLUE);
            gc.fillOval(pet.x - 20, pet.y - 20, 40, 40);
            gc.setFill(Color.WHITE);
            gc.fillText("Pet", pet.x - 9, pet.y + 4);
        }
    }
}