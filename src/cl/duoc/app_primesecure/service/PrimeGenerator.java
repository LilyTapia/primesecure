package cl.duoc.app_primesecure.service;

import cl.duoc.app_primesecure.model.PrimesList;

public class PrimeGenerator implements Runnable {

    private PrimesList listaPrimos;
    private int inicio;
    private int fin;

    public PrimeGenerator(PrimesList listaPrimos, int inicio, int fin) {
        this.listaPrimos = listaPrimos;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            if (listaPrimos.isPrime(i)) {
                listaPrimos.add(i);
            }
        }
    }
}
