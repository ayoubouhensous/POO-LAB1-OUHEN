public abstract class Employe {
    
    private String Nom;
    private String Prenom;
    private String Email;
    private String Telephone;
    private double Salaire;

    public Employe (String nom, String prenom, String email, String telephone, double salaire) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.Email = email;
        this.Telephone = telephone;
        this.Salaire = salaire;
    }
    public Employe(){};

    public  abstract double calculerSailre();

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public double getSalaire() {
        return Salaire;
    }
}
