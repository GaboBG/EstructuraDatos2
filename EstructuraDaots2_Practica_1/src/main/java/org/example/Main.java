package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(esPositivo(5));   // true
        System.out.println(esPositivo(-3));  // false
    }

    public static boolean esPositivo(int n) {
        if (n == 0) {
            return false; // el 0 no es positivo
        }
        if (n > 0) {
            return true;
        }
        return esPositivo(n + 1);
    }
    }
