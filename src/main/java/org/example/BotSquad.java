package org.example;

import javafx.scene.paint.Color;

public class BotSquad extends Nemico {
    public BotSquad(double x, double y) {
        super("Bot-Squad", x, y, 7, 1.7, 18, 1, Color.LIGHTBLUE);
        setImmuneSubwoofer(true);
    }
}
