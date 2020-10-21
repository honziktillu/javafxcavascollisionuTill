package sample;

import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Obdelnik {

    private double x;
    private double y;
    private double sirka;
    private double vyska;
    private Paint barva;
    private double rychlost;
    private ArrayList<String> barvy = new ArrayList<>();
    private int soucasnaBarva = 0;

    public Obdelnik(double x, double y, double sirka, double vyska, Paint barva, double rychlost) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.barva = barva;
        this.rychlost = rychlost;
        barvy.add("RED");
        barvy.add("GREEN");
        barvy.add("BLUE");
    }

    public void zmenitBarvu() {
        barva = Paint.valueOf(barvy.get(soucasnaBarva));
        if (soucasnaBarva == 2) {
            soucasnaBarva = 0;
        } else {
            soucasnaBarva++;
        }
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
