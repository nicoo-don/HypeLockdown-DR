package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class MacchinaNebbia extends Torre {
    private Image sprite;
    public MacchinaNebbia(double x, double y) {
        super("Nebbia", x, y, 130, 1, 35, 55, "nebbia", Color.LIGHTGRAY);
        sprite = new Image(getClass().getResource("/images/MacchinaNebbia.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
