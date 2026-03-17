package org.example;

import javax.swing.*;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


    public class Main extends JFrame implements Runnable {

        private JLabel etiqueta;
        private Thread hilo;
        private int contador = 0;
        private String nombre;

        public Main(String nombre, int x, int y) {
            this.nombre = nombre;

            setTitle("Ventana " + nombre);
            setSize(300, 150);
            setLocation(x, y);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            etiqueta = new JLabel("Iniciando...", SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 18));
            add(etiqueta);

            setVisible(true);


            hilo = new Thread(this);
            hilo.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    contador++;
                    etiqueta.setText(nombre + " -> Proceso: " + contador);
                    System.out.println(nombre + " ejecutando: " + contador);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args) {
            new Main("Hilo 1", 100, 100);
            new Main("Hilo 2", 450, 100);
        }
    }
