import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();

        groupeA.add("ayoub");
        groupeA.add("yahya");
        groupeA.add("noussair");
        groupeA.add("zakaria");

        groupeB.add("ayoub");
        groupeB.add("salah");
        groupeB.add("jawad");


        HashSet<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB);
        System.out.println("Intersection des deux groupes : " + intersection);

        HashSet<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Union des deux groupes : " + union);





    }
}