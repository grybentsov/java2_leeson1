package ru.gb.jtwo.la.online.circles;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Color color = new Color((int) (Math.random() * 255));

    long lastFrameTime;
    private final MainCircles controller;

    Background(MainCircles controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = lastFrameTime + 120;
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onBackgroundRepainted(this, g, deltaTime);

        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint();
    }
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }


  /*  public void updateBackground(Background background, float deltaTime) {
        repaint();
    }

    public void renderBackground(Background background, Graphics g) {
        g.setColor(new Color((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)));
        g.fillRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
   */
/*
    public void updateBackground(Background background, float deltaTime) {
        repaint();
        }

    public void renderBackground(Background background, Graphics g) {
        g.setColor(color);
        g.fillRect(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
*/
}


