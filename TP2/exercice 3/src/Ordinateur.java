public class Ordinateur {
    private String Nom;
    private String Marque;
    private double Prix;
    private String Description;
    private int Quantite;

    private Categorie Categorie;

    public Ordinateur(String Nom, String Marque, double Prix, String Description, int Quantite) {
        this.Nom = Nom;
        this.Marque = Marque;
        this.Prix = Prix;
        this.Description = Description;
        this.Quantite = Quantite;

    }

    public double getPrix() {
        return Prix;
    }

    public void getOrdinateur(){
        System.out.println("ordinateur : " + Nom + " de marque "+Marque+" et de prix "+Prix+" dh "+" avec un nombre de stock de : "+Quantite);
    }
}
