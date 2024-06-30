package cl.duoc.app_primesecure.messaging_application;

import cl.duoc.app_primesecure.model.PrimesList;
import cl.duoc.app_primesecure.service.PrimeGenerator;

public class main {

    public static void main(String[] args) {
        PrimesList listaPrimos = new PrimesList();

        // Crear y arrancar hilos para generar números primos
        Thread hilo1 = new Thread(new PrimeGenerator(listaPrimos, 1, 5000));
        Thread hilo2 = new Thread(new PrimeGenerator(listaPrimos, 5001, 10000));

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total de numeros primos: " + listaPrimos.getPrimesCount());
    }
}
