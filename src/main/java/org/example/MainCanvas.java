package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainCanvas extends JPanel implements Interactable{
    private final MainWindow controller;
    private long lastFrameTime;
    private List<Interactable> interactables = new ArrayList<>();



   public MainCanvas(MainWindow controller) {
            this.controller = controller;
            lastFrameTime = System.nanoTime();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ball ball = new Ball();
                controller.addInteractable(ball);  // Добавьте мяч через контроллер
                repaint();

            }
        });
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();

    }
    public int getLeft() {return 0;}
    public int getRight() {return getWidth() - 1;}
    public int getTop() {return 0;}
    public int getBottom() {return getHeight() - 1;}


    @Override
    public void update(MainCanvas canvas, float deltaTime) {}

    @Override
    public void render(MainCanvas canvas, Graphics g) {}
}
