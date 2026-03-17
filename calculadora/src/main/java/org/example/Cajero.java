package org.example;

import java.util.Scanner;

public class Cajero {

    int b20000;
    int b10000;
    int b5000;
    int b2000;
    int b1000;

    public void agregarBilletes(Scanner sc) {

        System.out.print("Cantidad ₡20000: ");
        b20000 += Utilidades.leerEntero(sc);

        System.out.print("Cantidad ₡10000: ");
        b10000 += Utilidades.leerEntero(sc);

        System.out.print("Cantidad ₡5000: ");
        b5000 += Utilidades.leerEntero(sc);

        System.out.print("Cantidad ₡2000: ");
        b2000 += Utilidades.leerEntero(sc);

        System.out.print("Cantidad ₡1000: ");
        b1000 += Utilidades.leerEntero(sc);

    }

    public void verBilletes() {

        System.out.println("Cantidad de ₡20000: " + b20000);
        System.out.println("Cantidad de ₡10000: " + b10000);
        System.out.println("Cantidad de ₡5000: " + b5000);
        System.out.println("Cantidad de ₡2000: " + b2000);
        System.out.println("Cantidad de ₡1000: " + b1000);
    }

    public void retirar(int monto) {

        if (monto <= 0 || monto % 1000 != 0) {
            System.out.println(" Monto inválido");
            return;
        }

        int r = monto;

        int c20000 = Math.min(r / 20000, b20000);
        r -= c20000 * 20000;

        int c10000 = Math.min(r / 10000, b10000);
        r -= c10000 * 10000;

        int c5000 = Math.min(r / 5000, b5000);
        r -= c5000 * 5000;

        int c2000 = Math.min(r / 2000, b2000);
        r -= c2000 * 2000;

        int c1000 = Math.min(r / 1000, b1000);
        r -= c1000 * 1000;

        if (r != 0) {
            System.out.println(" Imposible dispensar la cantidad solicitada ");
            return;
        }

        b20000 -= c20000;
        b10000 -= c10000;
        b5000 -= c5000;
        b2000 -= c2000;
        b1000 -= c1000;

        if (c20000 > 0)
            System.out.println("Cantidad de ₡20000: " + c20000);

        if (c10000 > 0)
            System.out.println("Cantidad de ₡10000: " + c10000);

        if (c5000 > 0)
            System.out.println("Cantidad de ₡5000: " + c5000);

        if (c2000 > 0)
            System.out.println("Cantidad de ₡2000: " + c2000);

        if (c1000 > 0)
            System.out.println("Cantidad de ₡1000: " + c1000);

        System.out.println("-------------------------");
        System.out.println("Total: ₡" + monto);
    }
}