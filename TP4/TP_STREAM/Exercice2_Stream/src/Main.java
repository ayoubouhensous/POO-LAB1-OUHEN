import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<employe> employes=new ArrayList<>();

        employes.add(new employe("empl1","depar1",10000));
        employes.add(new employe("empl2","depar2",1100));
        employes.add(new employe("aempl3","depar3",3000));
        employes.add(new employe("empl4","depar4",4000));


        System.out.println("la somme totale des salaires");
        System.out.println(employes.stream()
                .mapToDouble(employe::getSalary)
                .sum());


        System.out.println("trier la liste des employés");
        System.out.println(employes.stream()
                .sorted(Comparator.comparing(employe::getNom))
                .collect(Collectors.toList()));

        System.out.println("minumum du salaire");
        Optional<employe> employe_min= employes.stream()
                .min(Comparator.comparing(employe::getSalary));

        employe_min.ifPresent(employe -> System.out.println("employe avec le salaire le plus bas"+employe));

        double salaire_eleve=1200;
        System.out.println("les employes ayant salaires plus eleve de "+salaire_eleve);

        System.out.println(employes.stream()
                .filter(employee -> employee.getSalary()>salaire_eleve)
                .collect(Collectors.toList()));

        System.out.println("le salsair le plis eleve de l entreprise");

        Optional<employe> employe_max=employes.stream()
                .reduce((e1,e2)->e1.getSalary()>e2.getSalary()?e1:e2);

        employe_max.ifPresent(employe -> System.out.println("l employe avec le salaire le plus eleve"+employe));

        System.out.println(employes.stream()
                .map(employe::getNom)
                .reduce("",(a,b)->a+b));


    }


}