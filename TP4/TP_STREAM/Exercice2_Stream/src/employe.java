public class employe {

    private String nom;
    private String departement;
    private double salary;

    public employe(String nom, String departement, double salary) {
        this.nom = nom;
        this.departement = departement;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return
                "nom='" + nom ;
    }
}
