import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chaine;
        chaine="";
        int choix;
        do {
            menu();
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Saisir la chaine ");
                    chaine = sc.nextLine();
                    if (chaine.isEmpty()) {
                        System.out.println("Il faut saisir une chaîne !");
                    }
                    break;
                case 2:
                    afficherChaine(chaine);
                    break;
                case 3:
                    inverserChaine(chaine);
                    break;
                case 4:
                    compterMots(chaine);
                    break;
                case 0:
                    System.out.println("Sortie du programme");
                    break;
                default: System.out.println("choix invalid!");
            }
            if (choix != 0) {
                System.out.println("Frappez une touche pour revenir au menu.");
                sc.nextLine();
            }
        }while (choix != 0);
    }
    public static void menu(){
        System.out.println("Menu");
        System.out.println("1. Saisir la chaine");
        System.out.println("2. affihcer la chaine");
        System.out.println("3. inverser la chaine");
        System.out.println("4. Nombre des mots");
        System.out.println("0. Quitter");
        System.out.println("Entrer votre choix :");
    }
    public static void afficherChaine(String chaine) {
        if (chaine.isEmpty()) {
            System.out.println("Vous n'avez saisi aucune chaîne.");
        } else {
            System.out.println("La chaîne saisie est : " + chaine);
        }
    }

    public static void inverserChaine(String chaine) {
        if (chaine.isEmpty()) {
            System.out.println("Vous n'avez saisi aucune chaîne.");
        } else {
            String inversée = new StringBuilder(chaine).reverse().toString();
            System.out.println("L'inverse de la chaîne est : " + inversée);
        }
    }

    public static void compterMots(String chaine) {
        if (chaine.isEmpty()) {
            System.out.println("Vous n'avez saisi aucune chaîne.");
        } else {
            String[] mots = chaine.trim().split("\\s+");
            System.out.println("Le nombre de mots dans la chaîne est : " + mots.length);
        }
    }
}