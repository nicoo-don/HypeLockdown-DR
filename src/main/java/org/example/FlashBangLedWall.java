package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class FlashBangLedWall extends Torre {
    private Image sprite;
    public FlashBangLedWall(double x, double y) {
        super("Flash LED", x, y, 120, 2, 50, 80, "flash", Color.YELLOW);
        sprite = new Image(getClass().getResource("/images/FlashBang.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
