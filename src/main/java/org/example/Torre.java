package org.example;

import javafx.scene.paint.Color;

public class Torre {
    private String nome;
    private double x;
    private double y;
    private double raggio;
    private int danno;
    private int costo;
    private int tempoRicarica;
    private int contatoreRicarica;
    private String tipo;
    private Color colore;

    public Torre(String nome, double x, double y, double raggio, int danno, int costo, int tempoRicarica, String tipo, Color colore) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.raggio = raggio;
        this.danno = danno;
        this.costo = costo;
        this.tempoRicarica = tempoRicarica;
        this.contatoreRicarica = 0;
        this.tipo = tipo;
        this.colore = colore;
    }

    public void aggiorna() {
        if (contatoreRicarica > 0) {
            contatoreRicarica--;
        }
    }

    public boolean pronta() {
        if (contatoreRicarica <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean puoColpire(Nemico nemico) {
        double distanzaX = x - nemico.getX();
        double distanzaY = y - nemico.getY();
        double distanza = Math.sqrt(distanzaX * distanzaX + distanzaY * distanzaY);

        if (distanza <= raggio) {
            return true;
        } else {
            return false;
        }
    }

    public void attacca(Nemico nemico) {
        if (!pronta()) {
            return;
        }

        if (!puoColpire(nemico)) {
            return;
        }

        // Alcuni effetti sono diversi in base al tipo di difesa.
        if (tipo.equals("subwoofer")) {
            if (!nemico.isImmuneSubwoofer()) {
                nemico.subisciDanno(danno);
            }
        } else if (tipo.equals("scanner")) {
            if (nemico instanceof BotSquad) {
                nemico.subisciDanno(danno + 3);
            } else {
                nemico.subisciDanno(danno);
            }
        } else if (tipo.equals("nebbia")) {
            nemico.rallenta();
            nemico.subisciDanno(1);
        } else if (tipo.equals("flash")) {
            nemico.stordisci();
            nemico.subisciDanno(danno);
        } else if (tipo.equals("ologramma")) {
            nemico.setY(nemico.getY() - 20);
            nemico.subisciDanno(1);
        } else if (tipo.equals("magnet")) {
            nemico.setX(nemico.getX() - 10);
            nemico.subisciDanno(danno);
        } else if (tipo.equals("drone")) {
            nemico.subisciDanno(danno);
        }

        contatoreRicarica = tempoRicarica;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getRaggio()
    {
        return raggio;
    }

    public void setRaggio(double raggio)
    {
        this.raggio = raggio;
    }

    public int getDanno()
    {
        return danno;
    }

    public void setDanno(int danno)
    {
        this.danno = danno;
    }

    public int getCosto()
    {
        return costo;
    }

    public void setCosto(int costo)
    {
        this.costo = costo;
    }

    public int getTempoRicarica()
    {
        return tempoRicarica;
    }

    public void setTempoRicarica(int tempoRicarica)
    {
        this.tempoRicarica = tempoRicarica;
    }

    public int getContatoreRicarica()
    {
        return contatoreRicarica;
    }

    public void setContatoreRicarica(int contatoreRicarica)
    {
        this.contatoreRicarica = contatoreRicarica;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public Color getColore()
    {
        return colore;
    }

    public void setColore(Color colore)
    {
        this.colore = colore;
    }
}

