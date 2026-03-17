package org.example;

public class Cronometro implements Runnable {

    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;
    private boolean corriendo = true;

    @Override
    public void run() {
        try {
            while (corriendo) {

                // Imprime en la misma línea usando \r
                System.out.print(String.format("\r%02d:%02d:%02d", horas, minutos, segundos));

                Thread.sleep(1000); // Espera 1 segundo

                incrementarTiempo();
            }
        } catch (InterruptedException e) {
            System.out.println("\nCronómetro interrumpido.");
        }
    }

    private void incrementarTiempo() {
        segundos++;

        if (segundos == 60) {
            segundos = 0;
            minutos++;

            if (minutos == 60) {
                minutos = 0;
                horas++;
            }
        }
    }

    public void detener() {
        corriendo = false;
    }

    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        Thread hilo = new Thread(cronometro);
        hilo.start();
    }
}