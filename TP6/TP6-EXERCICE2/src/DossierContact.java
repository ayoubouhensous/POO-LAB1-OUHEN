import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DossierContact {

    private final Map<String, String> contacts = new HashMap<>();
    private final String directoryPath = "contacts";

    public DossierContact(){
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String number = reader.readLine();
                    contacts.put(file.getName(), number);
                } catch (Exception e) {
                    System.out.println("Erreur lors du chargement du contact : " + file.getName());
                }
            }
        }
        }

    public void ajouterContact(String nom, String phone) {
        if(contacts.containsValue(phone)) {
            System.out.println("existe");
        }else {
            contacts.put(nom, phone);
            sauvegarderContact(nom, phone);
        }
    }

    public void supprimerContact(String nom) {
        if (contacts.remove(nom) != null) {
            File file = new File(directoryPath + "/" + nom);
            if (file.delete()) {
                System.out.println("Contact supprimé avec succès.");
            } else {
                System.out.println("Erreur lors de la suppression du fichier.");
            }
        }
        else {
            System.out.println("Contact introuvable.");
        }
    }
    public String rechercherContact(String nom) {
        return contacts.get(nom);
    }
    // Sauvegarder un contact dans un fichier
    private void sauvegarderContact(String nom, String numero) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + "/" + nom));
            writer.write(numero);
            writer.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde du contact : " + nom);
        }
    }

    public void changerNumero(String nom, String nouveauNumero) {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
            sauvegarderContact(nom, nouveauNumero);
        } else {
            System.out.println("Contact introuvable.");
        }
    }










}
