package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Canvas canvas;
    public GraphicsContext gc;
    public Obdelnik obdelnik;
    public Obdelnik obdelnik2;
    public ArrayList<String> vstup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        obdelnik = new Obdelnik(100, 100, 50, 50, Paint.valueOf("GREEN"), 1);
        obdelnik2 = new Obdelnik(500, 200, 50, 50, Paint.valueOf("RED"), 10);
        vstup = new ArrayList<>();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
                collision();
                gc.setFill(Paint.valueOf("WHITE"));
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(obdelnik.getBarva());
                gc.fillRect(obdelnik.getX(), obdelnik.getY(), obdelnik.getSirka(), obdelnik.getVyska());
                gc.setFill(obdelnik2.getBarva());
                gc.fillRect(obdelnik2.getX(), obdelnik2.getY(), obdelnik2.getSirka(), obdelnik2.getVyska());
            }
        };
        animationTimer.start();

    }

    public void collision() {
        if
        (
           obdelnik.getX() < obdelnik2.getX() + obdelnik2.getSirka() &&
           obdelnik.getX() + obdelnik.getSirka() > obdelnik2.getX() &&
           obdelnik.getY() < obdelnik2.getY() + obdelnik2.getVyska() &&
           obdelnik.getY() + obdelnik.getVyska() > obdelnik2.getY()

        ) {
            System.out.println("Kolize");
        }
    }

    public void move() {
        if (vstup.contains("W")) {
            obdelnik.setY(obdelnik.getY() - obdelnik.getRychlost());
        }
        if (vstup.contains("S")) {
            obdelnik.setY(obdelnik.getY() + obdelnik.getRychlost());
        }
        if (vstup.contains("D")) {
            obdelnik.setX(obdelnik.getX() + obdelnik.getRychlost());
        }
        if (vstup.contains("A")) {
            obdelnik.setX(obdelnik.getX() - obdelnik.getRychlost());
        }
    }


    public void keyPressed(KeyEvent keyEvent) {
        String code = keyEvent.getCode().toString();
        if (!vstup.contains(code)) {
            vstup.add(code);
            System.out.println(code);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        String code = keyEvent.getCode().toString();
        vstup.remove(code);
        System.out.println(code);
    }
}


