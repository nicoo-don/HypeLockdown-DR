package org.example;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Sprinter extends Nemico {
    private Image sprite;
    public Sprinter(double x, double y) {
        super("Sprinter", x, y, 4, 2.8, 12, 1, Color.ORANGE);
        sprite = new Image(getClass().getResource("/sprites/sprinter.png").toExternalForm());
    }

    public Image getSprite() {
        return sprite;
    }
}

