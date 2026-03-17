package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUI extends JPanel {

    private ArrayList<Nodo> nodos;
    private ArrayList<Arista> aristas;

    private Nodo nodoSeleccionado = null;

    public GUI() {

        nodos = new ArrayList<>();
        aristas = new ArrayList<>();

        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.WHITE);

        // Click del mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Nodo nodo = obtenerNodo(e.getX(), e.getY());

                // Si NO dio click sobre nodo → crear nodo
                if (nodo == null) {

                    String valor = JOptionPane.showInputDialog(
                            GUI.this,
                            "Ingrese el valor del nodo:",
                            "Nuevo Nodo",
                            JOptionPane.PLAIN_MESSAGE
                    );

                    if (valor != null && !valor.trim().isEmpty()) {
                        nodos.add(new Nodo(e.getX(), e.getY(), valor));
                        repaint();
                    }

                } else {
                    // Selección para crear aristas
                    if (nodoSeleccionado == null) {
                        nodoSeleccionado = nodo;
                    } else {

                        aristas.add(new Arista(nodoSeleccionado, nodo));
                        nodoSeleccionado = null;

                        repaint();
                    }
                }
            }
        });

        // Botón matriz
        JButton btnMatriz = new JButton("Ver Matriz");
        btnMatriz.addActionListener(e -> mostrarMatriz());

        this.add(btnMatriz);
    }

    // Obtener nodo por posición
    private Nodo obtenerNodo(int x, int y) {

        for (Nodo n : nodos) {

            int dx = x - n.getX();
            int dy = y - n.getY();

            if (Math.sqrt(dx*dx + dy*dy) <= 15) {
                return n;
            }
        }
        return null;
    }

    // Dibujar grafo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Dibujar aristas
        g2.setStroke(new BasicStroke(2));

        for (Arista a : aristas) {

            g2.drawLine(
                    a.getOrigen().getX(),
                    a.getOrigen().getY(),
                    a.getDestino().getX(),
                    a.getDestino().getY()
            );
        }

        // Dibujar nodos
        for (Nodo n : nodos) {

            int x = n.getX();
            int y = n.getY();
            int r = 30;

            g2.setColor(Color.ORANGE);
            g2.fillOval(x - r/2, y - r/2, r, r);

            g2.setColor(Color.BLACK);
            g2.drawOval(x - r/2, y - r/2, r, r);

            // Texto centrado
            FontMetrics fm = g2.getFontMetrics();
            int ancho = fm.stringWidth(n.getValor());

            g2.drawString(
                    n.getValor(),
                    x - ancho/2,
                    y + 5
            );
        }
    }

    // Matriz de adyacencia
    private void mostrarMatriz() {

        int n = nodos.size();
        int[][] matriz = new int[n][n];

        for (Arista a : aristas) {

            int i = nodos.indexOf(a.getOrigen());
            int j = nodos.indexOf(a.getDestino());

            matriz[i][j] = 1;
            matriz[j][i] = 1; // no dirigido
        }

        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (Nodo nodo : nodos) {
            sb.append(nodo.getValor()).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {

            sb.append(nodos.get(i).getValor()).append(" ");

            for (int j = 0; j < n; j++) {
                sb.append(" ").append(matriz[i][j]);
            }
            sb.append("\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(area),
                "Matriz de Adyacencia",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
