import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le chemin du répertoire :");
        String chemin = scanner.nextLine();

        File repertoire = new File(chemin);
        if (!repertoire.exists() || !repertoire.isDirectory()) {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
            return;
        }
        listerRepertoire(repertoire, "");

    }
    public static void listerRepertoire(File dossier, String indentation) {
        File[] fichiers = dossier.listFiles();

        if(fichiers != null) {
            String type;
            for(File fichier : fichiers) {
                if(fichier.isDirectory()) {
                    type="<DIR>";
                }else {
                    type="<FILE>";
                }
                StringBuilder permissions = new StringBuilder();
                permissions.append(fichier.canRead() ? "r" : "-");
                permissions.append(fichier.canWrite() ? "w" : "-");
                permissions.append(fichier.isHidden() ? "h" : "-");
                System.out.println(indentation + fichier.getAbsolutePath() + " " + type + " " + permissions);
                if (fichier.isDirectory()) {
                    listerRepertoire(fichier, indentation + "    ");
                }




            }


        }





    }
    }