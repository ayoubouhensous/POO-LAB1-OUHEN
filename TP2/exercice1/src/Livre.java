public class Livre {
    private int esbn;
    private Auteur auteur;
    private String titre;

    public Livre(int esbn, Auteur auteur, String titre) {
        this.esbn = esbn;
        this.auteur = auteur;
        this.titre = titre;
    }

    public void afficher(){
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "Livre{" +" de titre='" + titre + '\'' +
                ", et d auteur=" + auteur.toString() +
                '}';
    }
}
