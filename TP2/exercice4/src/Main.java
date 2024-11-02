import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par id");
            System.out.println("6. Quitter ce programme");
            System.out.print("Entrez votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("La liste des produits est vide.");
                    } else {
                        for (Produit p : produits) {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Entrez le mot clé pour la recherche: ");
                    String motCle = scanner.nextLine();
                    List<Produit> produitsTrouves = metier.findByNom(motCle);
                    if (produitsTrouves.isEmpty()) {
                        System.out.println("Aucun produit trouvé.");
                    } else {
                        for (Produit p : produitsTrouves) {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID du produit: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock: ");
                    int nombreEnStock = scanner.nextInt();

                    Produit produit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    metier.add(produit);
                    System.out.println("Produit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit: ");
                    id = scanner.nextLong();
                    Produit produitTrouve = metier.findById(id);
                    if (produitTrouve != null) {
                        System.out.println(produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer: ");
                    id = scanner.nextLong();
                    metier.delete(id);
                    System.out.println("Produit supprimé avec succès.");
                    break;

                case 6:
                    System.out.println("Quitter le programme...");
                    scanner.close();
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

            if (choix == 6) {
                break;
            }

            System.out.println("\nRetour au menu principal...\n");
        }
    }

}
