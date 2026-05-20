package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class OlogrammaLimited extends Torre {
    private Image sprite;
    public OlogrammaLimited(double x, double y) {
        super("Ologramma", x, y, 115, 1, 25, 60, "ologramma", Color.VIOLET);
        sprite = new Image(getClass().getResource("/images/Ologramma.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
