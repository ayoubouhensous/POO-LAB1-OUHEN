import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DossierContact dossier = new DossierContact();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Annuaire ---");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro de téléphone d’un contact");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom du contact : ");
                    String nomRecherche = scanner.nextLine();
                    System.out.println("Numéro : " + dossier.rechercherContact(nomRecherche));
                    break;
                case 2:
                    System.out.print("Entrez le nom du contact : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le numéro du contact : ");
                    String nouveauNumero = scanner.nextLine();
                    dossier.ajouterContact(nouveauNom, nouveauNumero);
                    break;
                case 3:
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    dossier.supprimerContact(nomSuppression);
                    break;
                case 4:
                    System.out.print("Entrez le nom du contact : ");
                    String nomModification = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro : ");
                    String numeroModification = scanner.nextLine();
                    dossier.changerNumero(nomModification, numeroModification);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }

        }

    }


}
