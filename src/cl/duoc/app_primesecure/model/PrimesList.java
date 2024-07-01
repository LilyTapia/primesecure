package cl.duoc.app_primesecure.model;

import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    // Método para verificar si un número es primo
    public boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;  // 2 es el único número primo par
        }
        if (numero % 2 == 0) {
            return false;  // descarta números pares
        }
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Sobrescribir método add
    @Override
    public synchronized boolean add(Integer numero) {
        if (isPrime(numero)) {
            return super.add(numero);
        } else {
            throw new IllegalArgumentException("Solo se permiten numeros primos");
        }
    }

    // Sobrescribir método remove
    @Override
    public synchronized boolean remove(Object numero) {
        if (numero instanceof Integer && isPrime((Integer) numero)) {
            return super.remove(numero);
        } else {
            throw new IllegalArgumentException("Solo se pueden remover numeros primos");
        }
    }

    // Método para obtener la cantidad de números primos en la lista
    public synchronized int getPrimesCount() {
        return this.size();
    }
}
