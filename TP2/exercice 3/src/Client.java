import java.util.ArrayList;
import java.util.List;

public class Client {
    private String Nom;
    private String Prenom;
    private String Email;
    private String Ville;
    private String Telephone;

    private List<Commande> Commandes;
    public Client(String nom, String prenom, String email, String ville, String telephone) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        Ville = ville;
        Telephone = telephone;
        Commandes = new ArrayList<Commande>();
    }

    public void ajouterCommande(Commande commande) {
        if (!Commandes.contains(commande)) {
            Commandes.add(commande);
        }else {
            System.out.println("Commande deja existe");
        }
    }
    public void supprimerCommande(Commande commande) {
        if(Commandes.contains(commande)) {
            Commandes.remove(commande);
        }
        else {
            System.out.println("Commande n'existe pas");
        }
    }

    public List<Commande> getCommandes() {
        return Commandes;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getVille() {
        return Ville;
    }

    public String getEmail() {
        return Email;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getNom() {
        return Nom;
    }
}
