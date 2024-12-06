import java.util.List;
import java.util.Scanner;

public class ApplicationProduits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metierProduit = new MetierProduitImpl("produits.dat");

        int choix;
        do {
            System.out.println("Menu Produits:");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son nom.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par nom.");
            System.out.println("5. Sauvegarder les produits.");
            System.out.println("6. Quitter.");
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    List<Produit> produits = metierProduit.getAll();
                    produits.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du produit: ");
                    String nomProduit = scanner.nextLine();
                    Produit produit = metierProduit.findByNom(nomProduit);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque: ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Nombre en stock: ");
                    int stock = scanner.nextInt();
                    metierProduit.add(new Produit(nom, marque, prix, description, stock));
                    System.out.println("Produit ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez le nom du produit à supprimer: ");
                    String nomASupprimer = scanner.nextLine();
                    metierProduit.delete(nomASupprimer);
                    System.out.println("Produit(s) supprimé(s).");
                    break;
                case 5:
                    metierProduit.saveAll();
                    System.out.println("Produits sauvegardés.");
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
