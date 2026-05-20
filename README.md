# Hype Lockdown – Vault 700

## C. Definizione della struttura dell’applicazione

Il gioco progettato dal gruppo si intitola **Hype Lockdown – Vault 700** ed è un videogioco Tower Defense ambientato in un mondo streetwear e hype culture. Il giocatore deve difendere il “Vault 700”, un deposito contenente scarpe, accessori e oggetti limitati, da orde di resellers, droni automatici, influencer e gruppi organizzati che cercano di rubare lo stock esclusivo.

L’obiettivo del gioco è sopravvivere a tutte le ondate di nemici proteggendo il Vault tramite il posizionamento strategico di torri con abilità differenti.

---

# Interfaccia del gioco

L’interfaccia del gioco è stata progettata per essere intuitiva, semplice da utilizzare e facilmente leggibile durante il gameplay.

Il gioco è suddiviso in tre schermate principali.

## Menu iniziale

Nel menu iniziale vengono mostrati:

* il titolo del gioco;
* il comando ENTER per iniziare;
* il comando I per visualizzare le istruzioni.

Questa schermata introduce il giocatore all’ambientazione urban del progetto.

## Schermata istruzioni

La schermata delle istruzioni contiene:

* l’obiettivo del gioco;
* la spiegazione dei controlli;
* la descrizione delle torri;
* la descrizione dei nemici;
* le condizioni di vittoria e sconfitta.

Il giocatore può tornare al menu tramite il tasto ESC.

## Gameplay

Durante la partita vengono mostrati:

* la mappa di gioco;
* la strada percorsa dai nemici;
* il Vault da difendere;
* le torri piazzate;
* i nemici in movimento;
* i crediti disponibili;
* il valore hype residuo;
* il numero dell’ondata corrente;
* eventuali schermate di vittoria o game over.

---

# Controlli del gioco

Il gioco utilizza tastiera e mouse.

## Tastiera

* ENTER → avvia il gioco;
* I → apre la schermata istruzioni;
* ESC → ritorna al menu;
* Tasti 1-7 → selezionano le diverse torri.

## Mouse

* Click sinistro → posiziona una torre sulla mappa.

---

# Elementi grafici utilizzati

Per la realizzazione grafica del progetto vengono utilizzati:

* sprite dei nemici;
* sprite delle torri;
* immagini del Vault;
* sfondi personalizzati;
* effetti grafici;
* colori differenti per identificare torri e nemici.

Le immagini del progetto vengono salvate nella cartella:

src/main/resources/images

Alcuni esempi:

* sprinter.png
* scanner.png
* vault.png
* background.png
* influencer.png

Il rendering grafico viene gestito tramite JavaFX utilizzando:

* Canvas;
* GraphicsContext;
* classi Image e ImageView.

---

# Componenti principali del progetto

## Interfacce grafiche

Le interfacce implementate nel progetto sono:

* menu iniziale;
* schermata istruzioni;
* schermata gameplay;
* schermata vittoria;
* schermata game over.

La gestione delle schermate avviene tramite una variabile di stato che identifica la schermata attiva.

## Routine di gioco

### Aggiornamento del gioco

Il metodo aggiorna() gestisce:

* movimento dei nemici;
* attacco delle torri;
* spawn delle ondate;
* controllo della vittoria;
* controllo del game over;
* gestione dei crediti.

### Rendering grafico

Il metodo disegna(GraphicsContext gc) si occupa di:

* disegnare sfondo e mappa;
* disegnare nemici e torri;
* mostrare HUD e statistiche;
* mostrare schermate finali.

### Spawn dei nemici

Il metodo creaNemico() genera nemici casuali e introduce un boss ogni 5 ondate.

### Posizionamento delle torri

Il metodo click(double x, double y) permette al giocatore di piazzare torri evitando le aree occupate dalla strada.

---

# Eventi possibili nel gioco

Durante la partita possono verificarsi diversi eventi:

* arrivo di una nuova ondata;
* eliminazione di un nemico;
* guadagno di crediti;
* attacco automatico delle torri;
* perdita di hype quando un nemico raggiunge il Vault;
* comparsa del boss;
* vittoria finale;
* game over.

---

# Struttura logica del codice

Il progetto è sviluppato in Java utilizzando la programmazione orientata agli oggetti.

## Classi principali

* App → gestione finestra, rendering e input;
* Gioco → gestione della logica principale;
* Torre → classe astratta per le torri;
* Nemico → classe astratta per i nemici.

## Classi derivate delle torri

* SubwooferBassBoost
* ScannerLegitCheck
* MacchinaNebbia
* FlashBangLedWall
* OlogrammaLimited
* HypeMagnet
* DroneSniper

## Classi derivate dei nemici

* Sprinter
* BotSquad
* CampingSquad
* BackdoorCooker
* Glitcher
* Influencer

---

# Concetti di programmazione utilizzati

Nel progetto vengono utilizzati diversi concetti della programmazione ad oggetti.

## Ereditarietà

Le classi dei nemici e delle torri derivano da classi astratte comuni.

## Polimorfismo

Le torri possono attaccare differenti tipi di nemici tramite metodi condivisi.

## Incapsulamento

Gli attributi vengono mantenuti privati e gestiti tramite getter e setter.

---

# Struttura delle cartelle

src
└─ main
├─ java
│   └─ org.example
│        ├─ App.java
│        ├─ Gioco.java
│        ├─ Torre.java
│        ├─ Nemico.java
│        └─ ...
│
└─ resources
└─ images

---

# Suddivisione dei ruoli del gruppo

## Nicolas Don

Si occupa principalmente della programmazione della logica di gioco e dello sviluppo delle funzionalità principali del progetto. Ha lavorato alla gestione delle ondate, al sistema delle torri, alla creazione delle classi Java e alla gestione degli eventi di gioco.  Si occupa inoltre della preparazione della presentazione finale e dell’esposizione orale del progetto.

##  Marco Roibu

Si occupa della progettazione dell’interfaccia grafica, dell’organizzazione della struttura del progetto e del testing del gioco. Ha contribuito alla progettazione dell’ambientazione, alla definizione delle caratteristiche dei nemici e delle torri, oltre al controllo dei bug e al miglioramento dell’esperienza utente. Inoltre si occupa dell’implementazione grafica tramite JavaFX e dell’integrazione delle immagini nel progetto.

