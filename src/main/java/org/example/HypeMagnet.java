package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class HypeMagnet extends Torre {
    private Image sprite;
    public HypeMagnet(double x, double y) {
        super("Hype Magnet", x, y, 100, 2, 40, 35, "magnet", Color.RED);
        sprite = new Image(getClass().getResource("/images/Magnet.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
