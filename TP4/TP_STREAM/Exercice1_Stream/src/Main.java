import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<String> mots = new ArrayList<String>();
         mots.add("ayoeub");
         mots.add("niir");
         mots.add("yahya");
         mots.add("zakaria");


         System.out.println(mots.stream()
                 .filter((s -> s.contains("a")))
                 .collect(Collectors.toList()));
         System.out.println(mots.stream()
                 .filter((s->s.length()>3))
                 .map(mot ->new StringBuilder(mot).reverse().toString())
                 .collect(Collectors.toList()));

         System.out.println(mots.stream()
                 .filter(s->s.contains("e"))
                 .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                 .collect(Collectors.toList())
);

         System.out.println(mots.stream()
                 .map(String::toUpperCase)
                 .collect(Collectors.toList()));

         System.out.println(mots.stream()
                 .map(String::length)
                 .collect(Collectors.toList()));

        System.out.println( mots.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .map(String::valueOf)
                .reduce(String::concat)
                .orElse("")
        );

        System.out.println(
                IntStream.range(0, mots.size())
                        .mapToObj(i -> mots.get(i)+'-'+i)
                        .collect(Collectors.toList())
        );
    }


}