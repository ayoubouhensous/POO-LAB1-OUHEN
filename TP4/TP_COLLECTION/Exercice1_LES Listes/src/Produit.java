public class Produit {
    private Long id;
    private String nom;
    private double prix;

    public Produit(Long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + '}';
    }

    public String getNom() {
        return nom;
    }
}
