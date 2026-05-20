package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ScannerLegitCheck extends Torre {
    private Image sprite;
    public ScannerLegitCheck(double x, double y) {
        super("Scanner", x, y, 140, 4, 45, 45, "scanner", Color.CYAN);
        sprite = new Image(getClass().getResource("/images/Scanner.png").toExternalForm());
    }
    public Image getSprite(){
        return sprite;
    }
}
