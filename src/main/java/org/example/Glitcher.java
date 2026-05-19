package org.example;

import javafx.scene.paint.Color;

public class Glitcher extends Nemico {
    public Glitcher(double x, double y) {
        super("Early Link", x, y, 8, 1.6, 22, 1, Color.LIME);
        setGlitcher(true);
    }
}
