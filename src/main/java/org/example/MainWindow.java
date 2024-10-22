package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final List<Interactable> interactables;;
    private MainWindow() {
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bricks");
        interactables = new ArrayList<>();


        add(new MainCanvas(this));

        setVisible(true);


    }
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }
    private void update(MainCanvas canvas, float deltaTime) {
        for (Interactable interactable : interactables) interactable.update(canvas, deltaTime);
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (Interactable interactable : interactables) {
            interactable.render(canvas, g);
        }
    }
    public void addInteractable(Interactable interactable) {
        interactables.add(interactable); // Метод для добавления мяча в список
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
