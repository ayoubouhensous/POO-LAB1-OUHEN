import java.util.ArrayList;
import java.util.List;

public class LigneCommande {

    private int Quantite;
    private Commande Commande;
    private Ordinateur ordinateur;
    public LigneCommande(int Quantite, Commande Commande,Ordinateur ordinateur) {
        this.Quantite = Quantite;
        this.Commande = Commande;
        this.ordinateur = ordinateur;
    }

    public void getLigneCommande(){
        Commande.getCommande();ordinateur.getOrdinateur();
        System.out.println("Quantite: " + Quantite);
    }

}
