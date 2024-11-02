public class Manager extends Employe{

    public String Service ;

    public Manager (String Nom, String Prenom, String Email, String Telephone, double Salaire,String Service) {
        super(Nom, Prenom, Email, Telephone, Salaire);
        this.Service = Service;
    }

    @Override
    public double calculerSailre() {
        return super.getSalaire()+super.getSalaire()*0.2;
    }


    @Override
    public String toString() {
        return "Manager{ " +
                " nom : " + super.getNom() + " prenom : " + super.getPrenom() + " salaire : " + this.calculerSailre() +
                " service : " + Service + '\'' +
                '}';
    }
}
