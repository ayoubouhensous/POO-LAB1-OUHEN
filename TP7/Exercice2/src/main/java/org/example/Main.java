package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int[] tableau = new int[20];

        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }
        int nombreDeThreads = 5;
        int tailleSegment = tableau.length / nombreDeThreads;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < nombreDeThreads; i++) {
            int debut = i * tailleSegment;
            int fin = (i == nombreDeThreads - 1) ? tableau.length : (i + 1) * tailleSegment;
            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            Thread thread = new Thread(sommeur);
            threads.add(thread);
        }
        for(Thread thread : threads) {
            thread.start();
            thread.join();
        }



        System.out.println(Sommeur.getSomme());


        }

}