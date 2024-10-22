import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String Verb,F_Verb,L_Verb;

        String[] tabl1={"je ","tu ","il ","nous ","vous ","ils "};

        String[] tabl2={"e","es","e","ons","ez","ent"};

        System.out.println("Saisir le verbe a conjuger");
        Verb = sc.nextLine().toLowerCase();

        F_Verb = Verb.substring(0,Verb.length()-2);
        L_Verb = Verb.substring(Verb.length()-2);

        if(L_Verb.equals("er") && !Verb.equals("aller")){
            for (int i = 0; i < tabl1.length; i++) {
                System.out.println(tabl1[i]+ F_Verb+tabl2[i]);
            }
        }
        else{
            System.out.println("Le verbe saisi n'est pas du premier groupea");
        }






    }
}