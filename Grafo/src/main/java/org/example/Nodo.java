package org.example;

public class Nodo {

    int x, y;
    String valor;

    public Nodo(int x, int y, String valor) {
        this.x = x;
        this.y = y;
        this.valor = valor;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getValor() { return valor; }
}
