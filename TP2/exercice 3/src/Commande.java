import java.sql.Ref;
import java.util.Date;

public class Commande {

    public String Reference;
    private Client client;

    private Date date;

    private String Etat_Commande;

    public Commande(Client client, Date date, String Etat_Commande, String Reference) {
        this.Reference = Reference;
        this.client = client;
        this.date = date;
        this.Etat_Commande = Etat_Commande;
    }

    public void getCommande(){
        System.out.println("Commande: {Reference :  " + Reference+", Date: "+ date+", Etat_Commande: "+ Etat_Commande);
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public String getEtat_Commande() {
        return Etat_Commande;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEtat_Commande(String etat_Commande) {
        Etat_Commande = etat_Commande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "client= " + client.getNom() +
                ", date= " + date +
                ", Etat_Commande ='" + Etat_Commande + '\'' +
                '}';
    }
}
