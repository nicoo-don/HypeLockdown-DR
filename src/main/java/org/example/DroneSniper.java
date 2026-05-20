package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DroneSniper extends Torre {
    private Image sprite;
    public DroneSniper(double x, double y) {
        super("Drone Sniper", x, y, 180, 7, 70, 100, "drone", Color.WHITE);
        sprite = new Image(getClass().getResource("/images/Drone.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
