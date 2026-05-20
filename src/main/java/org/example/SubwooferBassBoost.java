package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SubwooferBassBoost extends Torre {
    private Image sprite;
    public SubwooferBassBoost(double x, double y) {
        super("Subwoofer", x, y, 110, 2, 30, 25, "subwoofer", Color.DODGERBLUE);
        sprite = new Image(getClass().getResource("/images/Subwoofer.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}

