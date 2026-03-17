package org.example;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Editor de Grafos con Matriz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
