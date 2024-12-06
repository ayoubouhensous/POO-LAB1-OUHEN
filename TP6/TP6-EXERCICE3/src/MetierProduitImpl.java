import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    List<Produit> produits=new ArrayList<>();
    private String fichier ;

    public MetierProduitImpl(String fichier) {
        this.fichier=fichier;
    }


    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        File file = new File(fichier);
        if (!file.exists()) {
            System.out.println("Le fichier n'existe pas encore. Une nouvelle liste sera créée.");
            return produits; // Retourne une liste vide
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            produits = (List<Produit>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        }
        return produits;
    }


    @Override
    public Produit findByNom(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(produits);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
