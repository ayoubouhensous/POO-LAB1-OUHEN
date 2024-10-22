import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner Sc = new Scanner(System.in);

        System.out.println("Saisir le nombre des etudiant :");
        int NombreEtud = Sc.nextInt();

        float[] notes = new float[NombreEtud];

        for(int i = 0 ; i < NombreEtud ; i++){
            System.out.println("Saisir la note d etudiant N_"+(i+1));
            notes[i] = Sc.nextFloat();
        }


        Arrays.sort(notes);

        System.out.println("les notes des etudiants triées ");
        for(int i = 0 ; i < NombreEtud ; i++){
            System.out.print(notes[i] + " ") ;

        }

        float Somme=0;
        for(float i :notes){
            Somme+=i;
        }
        System.out.println() ;
        System.out.println("la note moyenne est : " + Somme/NombreEtud);

        System.out.println("la note Maximale est : " + notes[NombreEtud-1]);
        System.out.println("la note Minimale est : " + notes[0]);

        System.out.println("entrer la note a chercher :");
        float NoteChercher=Sc.nextFloat();
        int NombreEtudAyantNote=0;
        for(float i : notes){
            if(i==NoteChercher){
                NombreEtudAyantNote+=1;
            }
        }

        System.out.println("Le nombre de etudiant ayyant la note  : "+NoteChercher +" est " + NombreEtudAyantNote);


    }


}