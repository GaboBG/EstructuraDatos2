package org.Tema01;


// persona implementa clase Comparable. Se ordena por edad dentrol árbol
public class Persona implements Comparable<Persona> {

   // nombre de persona
    String nombre;

    // se define edad de persona. Se utiliza para ordenar
    int edad;

    // constructor de la clase Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override // Se sobreescribe el método comparaTo para comparar las edades.
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad); // Orden por edad
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
