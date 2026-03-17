package org.example;

import java.util.Scanner;

public class Menu {

    private Cajero cajero;
    private Scanner sc;

    public Menu(Cajero cajero, Scanner sc) {
        this.cajero = cajero;
        this.sc = sc;
    }

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n=== CAJERO AUTOMATICO ===");
            System.out.println("0. Mantenimiento");
            System.out.println("1. Retirar dinero");
            System.out.println("2. Salir");

            opcion = Utilidades.leerEntero(sc);

            switch (opcion) {

                case 0 -> mantenimiento();

                case 1 -> retirar();

                case 2 -> System.out.println("Salir del sistema...");

                default -> System.out.println(" Opción inválida");

            }

        } while (opcion != 2);
    }

    private void mantenimiento() {

        int opcion;

        do {

            System.out.println("\n--- MANTENIMIENTO ---");
            System.out.println("1. Agregar billetes");
            System.out.println("2. Ver billetes");
            System.out.println("3. Salir");

            opcion = Utilidades.leerEntero(sc);

            switch (opcion) {

                case 1 -> cajero.agregarBilletes(sc);

                case 2 -> cajero.verBilletes();

            }

        } while (opcion != 3);
    }

    private void retirar() {

        System.out.print("Ingrese el monto a retirar: ");
        int monto = Utilidades.leerEntero(sc);

        cajero.retirar(monto);
    }
}