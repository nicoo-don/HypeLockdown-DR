package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Glitcher extends Nemico {
    private Image sprite;
    public Glitcher(double x, double y) {
        super("Early Link", x, y, 8, 1.6, 22, 1, Color.LIME);
        sprite = new Image(getClass().getResource("/images/Glitcher.png").toExternalForm());
        setGlitcher(true);
    }
    public Image getSprite(){
        return sprite;
    }
}
