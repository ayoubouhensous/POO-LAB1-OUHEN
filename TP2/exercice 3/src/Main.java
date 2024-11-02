import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ordinateur ordinateur1=new Ordinateur("pc1","hp",5000,"desciption1",20);
        Ordinateur ordinateur2=new Ordinateur("pc2","dell",10000,"desciption2",28);
        Ordinateur ordinateur3=new Ordinateur("pc3","acer",7000,"desciption3",32);

        Categorie categorie = new Categorie("categorie1","ordinateur des differents types");

        categorie.AjouterOrdinateur(ordinateur1);
        categorie.AjouterOrdinateur(ordinateur2);
        categorie.AjouterOrdinateur(ordinateur3);


        Client client1=new Client("ayoub","ouhen","ayoub@gmail.com","mohamadia","06262652");
        Client client2=new Client("ouhen","hicham","hicham@gmail.com","mohamadia","06123456");

        Commande commande1=new Commande(client1,new Date(2024, Calendar.DECEMBER,18),"En cours","Reference1");
        Commande commande2=new Commande(client2,new Date(2024, Calendar.JANUARY,1),"En cours","Reference2");
        Commande commande3=new Commande(client1,new Date(2024, Calendar.FEBRUARY,5),"En cours","Reference3");

        client1.ajouterCommande(commande1);
        client1.ajouterCommande(commande3);
        client2.ajouterCommande(commande2);

        LigneCommande ligneCommande1=new LigneCommande(2,commande1,ordinateur1);
        LigneCommande ligneCommande2=new LigneCommande(15,commande2,ordinateur2);
        LigneCommande ligneCommande3=new LigneCommande(5,commande3,ordinateur3);
        System.out.println("---");ligneCommande1.getLigneCommande();
        System.out.println("---");ligneCommande2.getLigneCommande();
        System.out.println("---");ligneCommande3.getLigneCommande();



    }
}