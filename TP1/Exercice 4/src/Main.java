import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String chaine;
        System.out.println("Saisir la chaine");
        chaine=sc.nextLine().toLowerCase();

        int[] nb_occurrences =new int[26];

        for(char c : chaine.toCharArray()){
            nb_occurrences[c-'a']++;
        }

        for(int i=0; i<nb_occurrences.length; i++){
            if(nb_occurrences[i]>0){
                char let=(char)('a'+i);
                System.out.println(nb_occurrences[i]+" fois la lettre "+ let);
            }
        }
    }
}