import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String,Double> qde=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        qde.put("Ayoub", 18.5);
        qde.put("Youness", 15.0);
        qde.put("zakaria", 12.5);
        qde.put("Omar", 19.0);

        qde.forEach((nom, note) -> System.out.println(nom + " : " + note));


        System.out.println("augmenter la note d un etudiant");

        augmenterNote(qde, "Ayoub", 1.5);
        qde.forEach((nom, note) -> System.out.println(nom + " : " + note));


        System.out.println("supprimer la note d un etudiant");
        qde.remove("zakaria");
        qde.forEach((nom, note) -> System.out.println(nom + " : " + note));


        System.out.println("Taille du map : " + qde.size());


        System.out.println("afficher min,max,moy");
        afficherStatistiques(qde);


        System.out.println("Vérifier s’il y a une note égale à 20");

        if(qde.containsValue(20.0)){
            System.out.println("la note 20 existe");
        }
        else{
            System.out.println("20 n existe pas");
        }


    }
    public static void augmenterNote(Map<String, Double> notes, String nom, double augmentation) {
        if (notes.containsKey(nom)) {
            notes.put(nom, notes.get(nom) + augmentation);
            System.out.println("La note de " + nom + " a été augmentée de " + augmentation);
        } else {
            System.out.println("Étudiant " + nom + " non trouvé.");
        }
    }
    public static void afficherStatistiques(Map<String, Double> notes) {
        if (notes.isEmpty()) {
            System.out.println("La liste des notes est vide.");
            return;
        }

        double somme = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (double note : notes.values()) {
            somme += note;
            if (note > max) max = note;
            if (note < min) min = note;
        }

        double moyenne = somme / notes.size();
        System.out.println("Note moyenne : " + moyenne);
        System.out.println("Note maximale : " + max);
        System.out.println("Note minimale : " + min);
    }


    }