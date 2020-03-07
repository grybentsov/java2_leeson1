package ru.gb.jtwo.la.online.circles;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);

        Background background = new Background(this);
        add (background);
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }
    public void onBackgroundRepainted(Background background, Graphics g, float deltaTime) {
        updateBackground(background, deltaTime);
        renderBackground(background, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public void updateBackground(Background background, float deltaTime) {
        repaint();
    }

    public void renderBackground(Background background, Graphics g) {
        g.setColor(new Color((int) (Math.random() * 255)));
        g.fillRect(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

  }
