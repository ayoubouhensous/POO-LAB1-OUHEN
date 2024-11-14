import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {

    public static void main(String[] args) {
        ArrayList<Produit> produits = new ArrayList<Produit>();

        System.out.println("ajouter des produits");


        produits.add(new Produit(1L,"produits1",120));
        produits.add(new Produit(2L,"produits2",200));
        produits.add(new Produit(3L,"produits3",250));
        produits.add(new Produit(4L,"produits4",350));

        produits.forEach((p)->System.out.println(p.toString()));

        System.out.println("supprimer un produit par indice");

        produits.remove(0);

        produits.forEach((p)->System.out.println(p.toString()));

        System.out.println("modifier un produit par indice");

        produits.set(1, new Produit(5L,"produits1",120));

        produits.forEach((p)->System.out.println(p.toString()));

        Scanner scanner=new Scanner(System.in);
        String nom =scanner.nextLine();

        boolean found = false;
        for(Produit p:produits){
            if(p.getNom().equals(nom)){
                System.out.println("le produit existe");
                found = true;
            }
        }
        if(!found){
            System.out.println("produits n existe pas");
        }
    }

}
