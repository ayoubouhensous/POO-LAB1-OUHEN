import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private String Nom;
    private String Description;

    private List<Ordinateur> Ordinateurs;

    public Categorie(String nom, String description) {
        Nom = nom;
        Description = description;
        Ordinateurs =new ArrayList<>();
    }


    public void AjouterOrdinateur(Ordinateur ordinateur) {

        if(!Ordinateurs.contains(ordinateur)){
            Ordinateurs.add(ordinateur);
        }
        else {
            System.out.println("ordinateur n existe pas");
        }


    }

    public void supprimerOrdinateur(Ordinateur ordinateur) {
        if(Ordinateurs.contains(ordinateur)){
            Ordinateurs.remove(ordinateur);
        }
        else{
            System.out.println("ordinateur n existe pas");
        }
    }

    public List<Ordinateur> RachercheParPrix(double prix){
        List<Ordinateur> Ordinateurs_Prix = new ArrayList<>();
        for(Ordinateur o : Ordinateurs) {
            if(o.getPrix() == prix) {
                Ordinateurs_Prix.add(o);
            }
        }
        return Ordinateurs_Prix;

    }

    public List<Ordinateur> getOrdinateurs() {
        return Ordinateurs;
    }
}
