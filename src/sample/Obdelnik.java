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
    private int hp = 100;
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
        barvy.add("BLACK");
    }

    public void zmenitBarvu() {
        if (hp == 100) {
            barva = Paint.valueOf(barvy.get(1));
        }
        if (hp < 100 && hp > 10) {
            barva = Paint.valueOf(barvy.get(2));
        }
        if (hp <= 10) {
            barva = Paint.valueOf(barvy.get(0));
        }
        if (hp == 0) {
            barva = Paint.valueOf(barvy.get(3));
        }
    }

    public void reduceHp() {
        if (hp > 0) {
            hp--;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSoucasnaBarva() {
        return soucasnaBarva;
    }

    public void setSoucasnaBarva(int soucasnaBarva) {
        this.soucasnaBarva = soucasnaBarva;
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
