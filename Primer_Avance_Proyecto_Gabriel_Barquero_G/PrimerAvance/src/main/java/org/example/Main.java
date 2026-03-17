package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import org.example.view.LibroView;


import org.example.view.LibroView;
import org.example.view.UsuarioView;
import org.example.view.PrestamoView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    public Main() {
        setTitle("Sistema de Biblioteca - Menú Principal");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initMenu();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú principal
        JMenu menu = new JMenu("Módulos");

        // Opción Libros
        JMenuItem menuLibros = new JMenuItem(new AbstractAction("Libros") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    LibroView lv = new LibroView();
                    lv.setVisible(true);
                });
            }
        });

        // Opción Usuarios
        JMenuItem menuUsuarios = new JMenuItem(new AbstractAction("Usuarios") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    UsuarioView uv = new UsuarioView();
                    uv.setVisible(true);
                });
            }
        });

        // Opción Préstamos
        JMenuItem menuPrestamos = new JMenuItem(new AbstractAction("Préstamos") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    PrestamoView pv = new PrestamoView();
                    pv.setVisible(true);
                });
            }
        });

        menu.add(menuLibros);
        menu.add(menuUsuarios);
        menu.add(menuPrestamos);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mp = new Main();
            mp.setVisible(true);
        });
    }
}