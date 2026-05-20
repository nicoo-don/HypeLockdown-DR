package org.example;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BotSquad extends Nemico {
    private Image sprite;
    public BotSquad(double x, double y) {
        super("Bot-Squad", x, y, 7, 1.7, 18, 1, Color.LIGHTBLUE);
        sprite = new Image(getClass().getResource("/images/BotSquad.png").toExternalForm());
        setImmuneSubwoofer(true);
    }
    public Image getSprite(){
        return sprite;
    }
}
