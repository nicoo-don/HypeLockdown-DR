package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BackdoorCooker extends Nemico {
    private Image sprite;
    public BackdoorCooker(double x, double y) {
        super("Backdoor Cooker", x, y, 6, 1.5, 20, 1, Color.PURPLE);
        sprite = new Image(getClass().getResource("/images/BackDoorCooker.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}