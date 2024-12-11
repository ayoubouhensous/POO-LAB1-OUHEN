package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sommeur implements Runnable{

    private int[] tableau;
    private int debut;
    private int fin;
    private static int somme;


    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;

    }

    public static int getSomme() {
        return somme;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            synchronized (Sommeur.class) {
                somme += tableau[i];

            }
        }
    }
}
