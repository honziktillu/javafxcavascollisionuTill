package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Canvas canvas;
    public GraphicsContext gc;
    public Obdelnik obdelnik;
    public Obdelnik obdelnik2;
    public ArrayList<String> vstup;
    public Pane main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        obdelnik = new Obdelnik(100, 100, 50, 50, Paint.valueOf("GREEN"), 10);
        obdelnik2 = new Obdelnik(500, 200, 50, 50, Paint.valueOf("RED"), 10);
        vstup = new ArrayList<>();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleBorders();
                move();
                gc.setFill(Paint.valueOf("GREY"));
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(obdelnik.getBarva());
                gc.fillRect(obdelnik.getX(), obdelnik.getY(), obdelnik.getSirka(), obdelnik.getVyska());
                gc.setFill(obdelnik2.getBarva());
                gc.fillRect(obdelnik2.getX(), obdelnik2.getY(), obdelnik2.getSirka(), obdelnik2.getVyska());
                gc.setFill(Paint.valueOf("BLACK"));
                gc.setFont(new Font(24));
                gc.fillText("x: " + obdelnik.getX(), 100, 100, 250);
                gc.fillText("y: " + obdelnik.getY(), 100, 130, 250);
                gc.fillText("Obdelnik2 hp: " + obdelnik2.getHp(), 100, 160, 250);
            }
        };
        animationTimer.start();

    }

    public boolean collision() {
        if
        (
            obdelnik.getX() < obdelnik2.getX() + obdelnik2.getSirka() &&
            obdelnik.getX() + obdelnik.getSirka() > obdelnik2.getX() &&
            obdelnik.getY() < obdelnik2.getY() + obdelnik2.getVyska() &&
            obdelnik.getY() + obdelnik.getVyska()  > obdelnik2.getY()
        ) {
            obdelnik2.reduceHp();
            obdelnik2.zmenitBarvu();
            return true;
        } else {
            return false;
        }
    }

    public void handleBorders() {
        if (obdelnik.getX() + obdelnik.getSirka() < 0) {
            obdelnik.setX(canvas.getWidth());
        }
        if (obdelnik.getX() > canvas.getWidth()) {
            obdelnik.setX(0 - obdelnik.getSirka());
        }
        if (obdelnik.getY() + obdelnik.getVyska() < 0) {
            obdelnik.setY(canvas.getHeight());
        }
        if (obdelnik.getY() > canvas.getHeight()) {
            obdelnik.setY(0 - obdelnik.getVyska());
        }

    }

    public void move() {
        if (vstup.contains("W")) {
            obdelnik.setY(obdelnik.getY() - obdelnik.getRychlost());
            if (collision()) {
                obdelnik.setY(obdelnik.getY() + obdelnik.getRychlost());
            }
        }
        if (vstup.contains("S")) {
            obdelnik.setY(obdelnik.getY() + obdelnik.getRychlost());
            if (collision()) {
                obdelnik.setY(obdelnik.getY() - obdelnik.getRychlost());
            }
        }
        if (vstup.contains("D")) {
            obdelnik.setX(obdelnik.getX() + obdelnik.getRychlost());
            if (collision()) {
                obdelnik.setX(obdelnik.getX() - obdelnik.getRychlost());
            }
        }
        if (vstup.contains("A")) {
            obdelnik.setX(obdelnik.getX() - obdelnik.getRychlost());
            if (collision()) {
                obdelnik.setX(obdelnik.getX() + obdelnik.getRychlost());
            }
        }
    }


    public void keyPressed(KeyEvent keyEvent) {
        String code = keyEvent.getCode().toString();
        if (!vstup.contains(code)) {
            vstup.add(code);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        String code = keyEvent.getCode().toString();
        vstup.remove(code);
    }

}


