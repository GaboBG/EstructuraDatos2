package org.Tema01;
/// Se define la clase Node como genérica, de modo que pueda almacenar cualquier valor


// Nodo de árbol binario
public class Node<T> {

    // Dato el cual se guarda en nodo
    T data;

    // Se hace ha referencia de hijos tanto izquierdo como derecho
    Node<T> left, right;

    // Constructor
    Node(T data) {
        this.data = data;
    }
}
