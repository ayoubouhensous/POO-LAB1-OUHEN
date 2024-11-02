public class Ingenieur extends Employe {

    private String Specialité;


    public Ingenieur(String Nom, String Prenom, String Email, String Telephone, double Salaire, String Specialité) {
        super(Nom, Prenom, Email, Telephone, Salaire);
        this.Specialité = Specialité;
    }

    @Override
    public double calculerSailre() {
        return super.getSalaire()+super.getSalaire() * 0.15;
    }

    @Override
    public String toString() {
        return "Ingenieur{ " +
                "nom : " + super.getNom() + " prenom : " + super.getPrenom() + " salaire : " + this.calculerSailre() +
                " Specialité : " + Specialité + '\'' +
                '}';
    }
}
