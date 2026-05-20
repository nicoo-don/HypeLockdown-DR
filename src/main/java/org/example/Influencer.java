package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Influencer extends Nemico {
    private Image sprite;
    public Influencer(double x, double y) {
        super("Influencer", x, y, 40, 0.7, 80, 5, Color.HOTPINK);
        sprite = new Image(getClass().getResource("/images/Influencer.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
