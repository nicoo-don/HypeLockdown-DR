package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private final Gioco gioco = new Gioco();

    // Stato schermata: 0 = menu, 1 = istruzioni, 2 = gioco
    private int stato = 0;

    @Override
    public void start(Stage stage) {
        // Dove viene disegnato tutto il gioco
        Canvas canvas = new Canvas(900, 900);

        // Per disegnare sul canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(new Group(canvas));

        // CLICK DEL MOUSE
        // Serve per piazzare le torri
        canvas.setOnMouseClicked(e -> {
            if (stato == 2) {
                gioco.click(e.getX(), e.getY());
            }
        });

        // CONTROLLI TASTIERA
        scene.setOnKeyPressed(e -> {
            // MENU
            if (stato == 0) {
                // ENTER = avvia il gioco
                if (e.getCode() == KeyCode.ENTER) stato = 2;

                // I = apre istruzioni
                if (e.getCode() == KeyCode.I) stato = 1;
            }

            // ISTRUZIONI
            else if (stato == 1) {
                // ESC = torna al menu
                if (e.getCode() == KeyCode.ESCAPE) stato = 0;
            }

            // GIOCO
            else if (stato == 2) {
                // Tasti 1-7 per scegliere le torri
                if (e.getCode() == KeyCode.DIGIT1) gioco.scegliTorre(1);
                if (e.getCode() == KeyCode.DIGIT2) gioco.scegliTorre(2);
                if (e.getCode() == KeyCode.DIGIT3) gioco.scegliTorre(3);
                if (e.getCode() == KeyCode.DIGIT4) gioco.scegliTorre(4);
                if (e.getCode() == KeyCode.DIGIT5) gioco.scegliTorre(5);
                if (e.getCode() == KeyCode.DIGIT6) gioco.scegliTorre(6);
                if (e.getCode() == KeyCode.DIGIT7) gioco.scegliTorre(7);
            }
        });

        // Game loop del gioco
        // Aggiorna continuamente il gioco e ridisegna tutto
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Aggiorna il gioco solo se siamo nella schermata gameplay
                if (stato == 2) {
                    gioco.aggiorna();
                }

                // Disegna tutto
                disegna(gc);
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Hype Lockdown");
        stage.show();
    }

    // Disegno
    private void disegna(GraphicsContext gc) {
        // Sfondo nero
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 900, 900);

        // Menu
        if (stato == 0) {
            gc.setFill(Color.WHITE);

            gc.fillText("HYPE LOCKDOWN - Vault 700", 350, 270);

            gc.fillText("ENTER = Gioca", 390, 300);
            gc.fillText("I = Istruzioni", 395, 330);
        }
        // Istruzioni
        else if (stato == 1) {
            gc.setFill(Color.WHITE);

            gc.fillText("OBIETTIVO", 60, 60);
            gc.fillText("Proteggi il Vault 700 dalle ondate.", 60, 90);

            gc.fillText("COME GIOCARE", 60, 150);
            gc.fillText("1. Premi 1-7 per scegliere una torre", 60, 180);
            gc.fillText("2. Clicca per piazzarla sulla mappa", 60, 210);
            gc.fillText("3. Non puoi piazzare sulla strada", 60, 240);
            gc.fillText("4. Le torri attaccano da sole", 60, 270);
            gc.fillText("5. Uccidi nemici per guadagnare crediti", 60, 300);

            gc.fillText("TORRI", 60, 360);
            gc.fillText("- Subwoofer Bass-Boost: Danno Base, Emette onde d'urto a bassa frequenza che respingono fisicamente la folla. Cadenza alta.", 60, 390);
            gc.fillText("- Scanner Legit Check: Precisione, Un laser che scansiona i nemici. Se portano fake, vengono umiliati pubblicamente e fuggono.", 60, 420);
            gc.fillText("- Macchina Della Nebbia: Rallentamento, Crea una coltre di fumo densa che riduce la velocità dei nemici.", 60, 450);
            gc.fillText("- Flash-Bang LED Wall: Stordimento, Muro di schermi che emette flash accecanti, bloccando i nemici per 2 secondi.", 60, 480);
            gc.fillText("- Ologramma Limited: Esca, Proietta un pezzo raro fuori dal percorso; i nemici deviano per tentare di prenderlo.", 60, 510);
            gc.fillText("- HypeMagnet: Controllo, Attira a sé droni e nemici con accessori metallici per raggrupparli e colpirli ad area.", 60, 540);
            gc.fillText("- DroneSniper: Danno Singolo, Pattuglia un'area e colpisce con precisione chirurgica solo i nemici con più Clout.", 60, 570);

            gc.fillText("NEMICI", 60, 630);
            gc.fillText("Sprinter - Ragazzini agili in tuta acetata. Velocissimi, cercano di passare tra le difese senza essere visti.", 60, 660);
            gc.fillText("Bot-Squad - Droni programmati per il reselling. Immuni ai bassi, devono essere colpiti da Scanner o Laser.", 60, 690);
            gc.fillText("Camping Squad (Tank) - Gruppi con tende e sedie che creano un muro umano, proteggendo i nemici dietro di loro.", 60, 720);
            gc.fillText("Backdoor Cooker - Hacker che tentano di disattivare le tue torri a distanza. Vanno eliminati subito.", 60, 750);
            gc.fillText("Influencer (Boss) - Seguito da cameraman, ha una resistenza enorme (Clout). Se entra, sottrae metà dello stock.", 60, 780);
            gc.fillText("Early Link Glitcher: - Nemico instabile che si teletrasporta in avanti quando subisce colpi critici.", 60, 810);

            gc.fillText("ESC per tornare al menu", 60, 870);
        }

        // Gioco
        else if (stato == 2) {
            // Disegno della strada dei nemici
            gc.setFill(Color.DARKGRAY);
            gc.fillRect(0, 260, 900, 100);

            // Disegno del Vault da difendere
            gc.setFill(Color.GOLD);
            gc.fillRect(830, 220, 50, 180);

            // Torri
            for (int i = 0; i < gioco.getNumTorri(); i++) {
                Torre t = gioco.getTorri()[i];

                // Disegno della torre
                gc.setFill(t.getColore());
                gc.fillOval(t.getX(), t.getY(), 30, 30);

                // Nome della torre sotto il personaggio
                gc.setFill(Color.WHITE);
                gc.fillText(t.getNome(), t.getX() - 20, t.getY() + 45);
            }

            // Nemici
            for (int i = 0; i < gioco.getNumNemici(); i++) {
                Nemico n = gioco.getNemici()[i];

                // Disegno del nemico
                gc.setFill(n.getColore());
                gc.fillOval(n.getX(), n.getY(), 30, 30);

                // Nome del nemico sopra
                gc.setFill(Color.LIGHTGRAY);
                gc.fillText(n.getNome(), n.getX() - 20, n.getY() - 5);
                gc.fillText("HP: " + n.getVita(), n.getX() - 10, n.getY() + 45);
            }

            // Informazioni del giocatore
            gc.setFill(Color.WHITE);
            gc.fillText("Crediti: " + gioco.getCrediti(), 20, 20);
            gc.fillText("Hype: " + gioco.getHype(), 20, 40);
            gc.fillText("Wave: " + gioco.getOndata() + "/10", 20, 60);

            // Lista torri disponibili e costo
            gc.fillText("1 Subwoofer (30)", 20, 500);
            gc.fillText("2 Scanner (45)", 20, 520);
            gc.fillText("3 Nebbia (35)", 20, 540);
            gc.fillText("4 LED Wall (50)", 20, 560);
            gc.fillText("5 Ologramma (25)", 150, 500);
            gc.fillText("6 Magnet (40)", 150, 520);
            gc.fillText("7 Drone (70)", 150, 540);

            // Schermata game over
            if (gioco.isGameOver()) {
                gc.setFill(Color.RED);
                gc.fillText("BRAND CANCELED", 350, 200);
            }

            // Schermata vittoria
            if (gioco.isVittoria()) {
                gc.setFill(Color.LIME);
                gc.fillText("LOCKDOWN COMPLETATO", 300, 200);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}