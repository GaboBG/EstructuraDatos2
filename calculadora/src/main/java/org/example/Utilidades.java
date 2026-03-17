package org.example;

import java.util.Scanner;

public class Utilidades {

    public static int leerEntero(Scanner sc) {

        while (true) {

            try {

                String entrada = sc.nextLine();
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(" Ingresar solo números");

            }

        }

    }
}
