public class Main {
    public static void main(String[] args) {

        Personne personne=new Personne("ouhen","ouhen","ayou@gmail.com","084562",22);

        Auteur auteur=new Auteur("ayoub","ouhen","ayoub@gmail.com","06123456789",22,88);

        Livre livre1=new Livre(58,auteur,"java");

        livre1.afficher();
    }
}