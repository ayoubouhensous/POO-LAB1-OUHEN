public class Produit {
    private Long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombrestock;

    public Produit(Long id, String nom, String marque, double prix, String description, int nombrestock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombrestock = nombrestock;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombrestock=" + nombrestock +
                '}';
    }
}
