import java.io.Serializable;

public class Produit implements Serializable {

    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombre_stock;

    public Produit(String nom, String marque, double prix, String description, int nombreEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombre_stock = nombreEnStock;
    }


    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getNombre_stock() {
        return nombre_stock;
    }
}
