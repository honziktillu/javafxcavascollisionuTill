package sample;

import javafx.scene.paint.Paint;

public class Obdelnik {

    private double x;
    private double y;
    private double sirka;
    private double vyska;
    private Paint barva;
    private double rychlost;

    public Obdelnik(double x, double y, double sirka, double vyska, Paint barva, double rychlost) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.barva = barva;
        this.rychlost = rychlost;
    }

    public double getRychlost() {
        return rychlost;
    }

    public void setRychlost(double rychlost) {
        this.rychlost = rychlost;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSirka() {
        return sirka;
    }

    public void setSirka(double sirka) {
        this.sirka = sirka;
    }

    public double getVyska() {
        return vyska;
    }

    public void setVyska(double vyska) {
        this.vyska = vyska;
    }

    public Paint getBarva() {
        return barva;
    }

    public void setBarva(Paint barva) {
        this.barva = barva;
    }
}
