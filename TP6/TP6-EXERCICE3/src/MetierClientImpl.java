import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client>{
    private List<Client> clients=new ArrayList<>();
    private String fichier ;

    public MetierClientImpl(String fichier) {
        this.fichier = fichier; // Charge les clients existants à partir du fichier
    }

    @Override
    public Client add(Client client) {
        clients.add(client);
        return client;
    }


    @Override
    public List<Client> getAll() {
        File file = new File(fichier);
        // Vérifier si le fichier existe, sinon le créer
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Si le fichier existe, lire les clients
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                clients = (List<Client>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clients;
    }




    @Override
    public Client findByNom(String nom) {
        for (Client c : clients) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(clients);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
