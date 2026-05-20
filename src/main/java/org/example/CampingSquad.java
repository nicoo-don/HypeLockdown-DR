package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class CampingSquad extends Nemico {
    private Image sprite;
    public CampingSquad(double x, double y) {
        super("Camping Squad", x, y, 16, 0.9, 25, 2, Color.DARKGREEN);
        sprite = new Image(getClass().getResource("/images/CampingSquad.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
