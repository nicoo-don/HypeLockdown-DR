package org.example;

import javafx.scene.paint.Color;

public class Nemico {
    private String nome;
    private double x;
    private double y;
    private int vita;
    private int vitaMassima;
    private double velocita;
    private double velocitaBase;
    private int ricompensa;
    private int dannoVault;
    private boolean vivo;
    private boolean rallentato;
    private int tempoRallentamento;
    private boolean stordito;
    private int tempoStordimento;
    private boolean immuneSubwoofer;
    private boolean glitcher;
    private Color colore;

    public Nemico(String nome, double x, double y, int vita, double velocita, int ricompensa, int dannoVault, Color colore) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.vita = vita;
        this.vitaMassima = vita;
        this.velocita = velocita;
        this.velocitaBase = velocita;
        this.ricompensa = ricompensa;
        this.dannoVault = dannoVault;
        this.colore = colore;
        this.vivo = true;
        this.rallentato = false;
        this.tempoRallentamento = 0;
        this.stordito = false;
        this.tempoStordimento = 0;
        this.immuneSubwoofer = false;
        this.glitcher = false;
    }

    // Movimento del nemico
    public void muovi() {
        // Se è stordito non si muove
        if (stordito) {
            tempoStordimento--;

            if (tempoStordimento <= 0) {
                stordito = false;
            }
            return;
        }

        if (rallentato) {
            tempoRallentamento--;

            if (tempoRallentamento <= 0) {
                rallentato = false;
                velocita = velocitaBase;
            }
        }
        // avanzamento nel percorso
        x += velocita;
    }

    // Il nemico subisce danno
    public void subisciDanno(int danno) {
        vita -= danno;

        // Effetto speciale del glitcher: può scattare in avanti quando colpito
        if (glitcher && vita > 0) {
            if (Math.random() < 0.25) {
                x += 45;
            }
        }

        if (vita <= 0){
            vivo = false;
        }
    }

    public void rallenta() {
        rallentato = true;
        tempoRallentamento = 90;
        velocita = velocitaBase * 0.4;
    }

    public void stordisci() {
        stordito = true;
        tempoStordimento = 80;
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

    public int getVita()
    {
        return vita;
    }

    public void setVita(int vita)
    {
        this.vita = vita;
    }

    public int getVitaMassima()
    {
        return vitaMassima;
    }

    public void setVitaMassima(int vitaMassima)
    {
        this.vitaMassima = vitaMassima;
    }

    public double getVelocita()
    {
        return velocita;
    }

    public void setVelocita(double velocita)
    {
        this.velocita = velocita;
    }

    public double getVelocitaBase()
    {
        return velocitaBase;
    }

    public void setVelocitaBase(double velocitaBase)
    {
        this.velocitaBase = velocitaBase;
    }

    public int getRicompensa()
    {
        return ricompensa;
    }

    public void setRicompensa(int ricompensa)
    {
        this.ricompensa = ricompensa;
    }

    public int getDannoVault()
    {
        return dannoVault;
    }

    public void setDannoVault(int dannoVault)
    {
        this.dannoVault = dannoVault;
    }

    public boolean isVivo()
    {
        return vivo;
    }

    public void setVivo(boolean vivo)
    {
        this.vivo = vivo;
    }

    public boolean isRallentato()
    {
        return rallentato;
    }

    public void setRallentato(boolean rallentato)
    {
        this.rallentato = rallentato;
    }

    public int getTempoRallentamento()
    {
        return tempoRallentamento;
    }

    public void setTempoRallentamento(int tempoRallentamento)
    {
        this.tempoRallentamento = tempoRallentamento;
    }

    public boolean isStordito()
    {
        return stordito;
    }

    public void setStordito(boolean stordito)
    {
        this.stordito = stordito;
    }

    public int getTempoStordimento()
    {
        return tempoStordimento;
    }

    public void setTempoStordimento(int tempoStordimento)
    {
        this.tempoStordimento = tempoStordimento;
    }

    public boolean isImmuneSubwoofer()
    {
        return immuneSubwoofer;
    }

    public void setImmuneSubwoofer(boolean immuneSubwoofer)
    {
        this.immuneSubwoofer = immuneSubwoofer;
    }

    public boolean isGlitcher()
    {
        return glitcher;
    }

    public void setGlitcher(boolean glitcher)
    {
        this.glitcher = glitcher;
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

