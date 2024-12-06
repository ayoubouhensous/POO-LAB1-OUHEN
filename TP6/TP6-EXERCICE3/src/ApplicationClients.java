import java.util.List;
import java.util.Scanner;

public class ApplicationClients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierClientImpl metierClient = new MetierClientImpl(" clients.dat");

        int choix;
        do {
            System.out.println("Menu Clients:");
            System.out.println("1. Afficher la liste des clients.");
            System.out.println("2. Rechercher un client par son nom.");
            System.out.println("3. Ajouter un nouveau client.");
            System.out.println("4. Supprimer un client par nom.");
            System.out.println("5. Sauvegarder les clients.");
            System.out.println("6. Quitter.");
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    List<Client> clients = metierClient.getAll();
                    clients.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du client: ");
                    String nomClient = scanner.nextLine();
                    Client client = metierClient.findByNom(nomClient);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse: ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone: ");
                    String tel = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    metierClient.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("Client ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez le nom du client à supprimer: ");
                    String nomASupprimer = scanner.nextLine();
                    metierClient.delete(nomASupprimer);
                    System.out.println("Client(s) supprimé(s).");
                    break;
                case 5:
                    metierClient.saveAll();
                    System.out.println("Clients sauvegardés.");
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }
}
