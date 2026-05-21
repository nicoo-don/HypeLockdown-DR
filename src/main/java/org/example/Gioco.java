package org.example;

public class Gioco {
    private final Torre[] torri = new Torre[40];
    private final Nemico[] nemici = new Nemico[80];
    private int numTorri = 0;
    private int numNemici = 0;
    private int crediti = 100;
    private int hype = 10;
    private int ondata = 0;
    private final int MAX_ONDATE = 10;
    private int timer = 0;
    private int torreScelta = 1;
    private boolean gameOver = false;
    private boolean vittoria = false;

    // Metodo che aggiorna il gioco
    public void aggiorna() {
        // Se il gioco è finito non aggiorna più nulla
        if (gameOver || vittoria) {
            return;
        }
        // Se non ci sono nemici parte il timer della nuova ondata
        if (numNemici == 0) {
            timer++;

            // Dopo un po' di tempo crea una nuova ondata
            if (timer >= 120 && ondata < MAX_ONDATE) {
                // Numero nemici dell'ondata
                int nem = 2 + ondata;

                // Limite massimo di nemici
                if (nem > 6) {
                    nem = 6;
                }

                // Creazione dei nemici
                for (int i = 0; i < nem; i++) {
                    // Controlla che ci sia spazio nell'array
                    if (numNemici < nemici.length) {
                        nemici[numNemici] = creaNemico(i);
                        numNemici++;
                    }
                }
                ondata++;
                timer = 0;
            }
        }

        // Movimento dei nemici
        for (int i = 0; i < numNemici; i++) {
            Nemico n = nemici[i];
            n.muovi();

            // Se arriva al Vault
            if (n.getX() > 830) {
                hype -= n.getDannoVault();
                rimuoviNemico(i);
                // Senza si rischia di saltare nemici
                i--;
            }
        }

        // Attacco delle torri
        for (int i = 0; i < numTorri; i++) {
            Torre t = torri[i];
            t.aggiorna();

            // Cerca un nemico da colpire
            for (int j = 0; j < numNemici; j++) {
                Nemico n = nemici[j];
                if (t.puoColpire(n)) {
                    t.attacca(n);
                    if (!n.isVivo()) {
                        crediti += n.getRicompensa();
                        rimuoviNemico(j);
                    }
                    break;
                }
            }
        }
        // Controllo game over
        if (hype <= 0) {
            gameOver = true;
        }

        // Controllo vittoria
        if (ondata > MAX_ONDATE && numNemici == 0) {
            vittoria = true;
        }
    }

    // Crea un nemico casuale
    private Nemico creaNemico(int i) {

        // Posizione iniziale del nemico
        double x = -50 - i * 60;

        // Ogni 5 ondate il primo nemico è un boss
        if (ondata > 0 && ondata % 5 == 0 && i == 0){
            return new Influencer(x, 300);
        }

        // Numero casuale per scegliere il nemico
        int r = (int)(Math.random() * 5);

        if (r == 0) {
            return new Sprinter(x, 300);
        } else if (r == 1) {
            return new BotSquad(x, 300);
        } else if (r == 2) {
            return new CampingSquad(x, 300);
        } else if (r == 3) {
            return new BackdoorCooker(x, 300);
        }
        return new Glitcher(x, 300);
    }

    // Rimuove un nemico dall'array
    private void rimuoviNemico(int indice) {
        // Sposta tutti gli elementi a sinistra per non lasciare buchi
        for (int i = indice; i < numNemici - 1; i++) {
            nemici[i] = nemici[i + 1];
        }
        numNemici--;
    }

    // Metodo chiamato quando il giocatore clicca
    public void click(double x, double y) {
        // Impedisce di piazzare torri sulla strada
        if (y > 260 && y < 360) {
            return;
        }

        Torre t = creaTorre(x, y);

        // Controlla se il giocatore ha abbastanza soldi
        if (crediti >= t.getCosto()) {
            // Non può superare il numero massimo di torri
            if (numTorri < torri.length) {
                torri[numTorri] = t;
                numTorri++;
            }
            crediti -= t.getCosto();
        }
    }

    // Crea la torre selezionata dal giocatore
    private Torre creaTorre(double x, double y) {
        if (torreScelta == 1) {
            return new SubwooferBassBoost(x, y);
        } else if (torreScelta == 2) {
            return new ScannerLegitCheck(x, y);
        } else if (torreScelta == 3) {
            return new MacchinaNebbia(x, y);
        } else if (torreScelta == 4) {
            return new FlashBangLedWall(x, y);
        } else if (torreScelta == 5) {
            return new OlogrammaLimited(x, y);
        } else if (torreScelta == 6) {
            return new HypeMagnet(x, y);
        } else if (torreScelta == 7) {
            return new DroneSniper(x, y);
        }
        return null;
    }

    public void scegliTorre(int n) {
        torreScelta = n;
    }

    public Torre[] getTorri() {
        return torri;
    }

    public Nemico[] getNemici() {
        return nemici;
    }

    public int getNumTorri() {
        return numTorri;
    }

    public int getNumNemici() {
        return numNemici;
    }

    public int getCrediti() {
        return crediti;
    }

    public int getHype() {
        return hype;
    }

    public int getOndata() {
        return ondata;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isVittoria() {
        return vittoria;
    }
}
