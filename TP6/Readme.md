# TP6: Gestion de Répertoires, Contacts, et Produits


Ce projet en Java permet de :

Lister le contenu d'un répertoire avec les informations de permissions et de type.
Gérer un annuaire de contacts, y compris l'ajout, la suppression, la modification et la recherche.
Gérer une liste de produits et de clients avec des fonctionnalités similaires (ajout, suppression, recherche, sauvegarde).


## Overview
This project focuses on the implementation of arrays and strings in Java. It consists of several exercises demonstrating how to manage student grades, conjugate French verbs, manipulate strings, and count letter occurrences. 

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: Lister un répertoire](#exercise-Lister-un-répertoire)
   - [Exercise 2: Gestion de contacts](#exercise-2-Gestion-de-contacts)
   - [Exercise 3: Gestion de clients et produits](#exercise-3-Gestion-de-clients-et-produits)
6. [Conclusion](#Conclusion)

### Introduction
This lab focuses on creating, manipulating, and managing entities in Java while exploring the relationships between them. These exercises strengthen your understanding of OOP and introduce concepts such as association, aggregation, and composition, which are essential for modeling complex systems.

 ## Technologies Used
- Java
- IntelliJ IDEA (IDE)
- JDK 17 or higher

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayoubouhensous/POO-LAB1-OUHEN
2. Open the project in IntelliJ IDEA.
3. Ensure that you have JDK 17 or higher installed.

   
## Usage
To run the exercises, simply execute the corresponding Java class files. Each class contains a main method to start the program.


## Exercises

### Exercise 1: Lister un répertoire
This exercise involves writing a Java program to explore a given directory and display its contents with details (type, permissions, etc.).

1. Input: Directory Path
The program starts by asking the user to enter the path of a directory.

2. Traversing and Displaying
Using the File class, the program lists the directory contents and displays their information:

Type: File or Directory.
Permissions: Readable, Writable, or Hidden.

```java
import java.io.File;

public class DirectoryLister {
    public static void main(String[] args) {
        System.out.println("Enter the directory path: ");
        String path = new java.util.Scanner(System.in).nextLine();

        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.printf("%s %s [%s]\n", 
                        file.isDirectory() ? "<DIR>" : "<FILE>",
                        file.getName(),
                        (file.canRead() ? "r" : "-") +
                        (file.canWrite() ? "w" : "-") +
                        (file.isHidden() ? "h" : "-")
                    );
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Invalid path or not a directory.");
        }
    }
}

```


### Exercise 2: Contact Management

This exercise focuses on managing a contact directory using files for persistence.

1. Menu of Options
The user can:

Add a contact.
Search for a contact.
Update a contact.
Delete a contact.
2. Adding and Updating
Contacts are stored in files named after their names, with their phone numbers as content.

```java
import java.io.*;
import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone number: ");
                    String number = scanner.nextLine();
                    try (FileWriter writer = new FileWriter("contacts/" + name + ".txt")) {
                        writer.write(number);
                        System.out.println("Contact added.");
                    } catch (IOException e) {
                        System.out.println("Error while adding contact.");
                    }
                    break;
                case 2:
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    File file = new File("contacts/" + name + ".txt");
                    if (file.exists()) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            System.out.println("Phone number: " + reader.readLine());
                        } catch (IOException e) {
                            System.out.println("Error while reading contact.");
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
```


### Exercise 3: Product Management

This exercise involves managing a list of products and clients and their details, with persistence using a file.

1. Menu of Options
The user can:

Add a product-client.
Search for a product,client.
Display all products,clients.
2. Persistence with File
The data is stored in a binary file using serialization.

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price;
    }
}

public class ProductManager {
    private static final String FILE_NAME = "products.dat";

    public static void main(String[] args) {
        List<Product> products = loadProducts();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Add a product");
            System.out.println("2. Search for a product");
            System.out.println("3. Display all products");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Product price: ");
                    double price = scanner.nextDouble();
                    products.add(new Product(name, price));
                    saveProducts(products);
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.print("Product name to search: ");
                    String searchName = scanner.nextLine();
                    products.stream()
                            .filter(p -> p.toString().contains(searchName))
                            .forEach(System.out::println);
                    break;
                case 3:
                    products.forEach(System.out::println);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private static List<Product> loadProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private static void saveProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error while saving products.");
        }
    }
}
```

```java
import java.util.List;
import java.util.Scanner;

public class ApplicationClients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierClientImpl metierClient = new MetierClientImpl(" clients.dat");

        int choix;
        do {
            System.out.println("Menu Clients:");
            System.out.println("1. Afficher la liste des clients.");
            System.out.println("2. Rechercher un client par son nom.");
            System.out.println("3. Ajouter un nouveau client.");
            System.out.println("4. Supprimer un client par nom.");
            System.out.println("5. Sauvegarder les clients.");
            System.out.println("6. Quitter.");
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    List<Client> clients = metierClient.getAll();
                    clients.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du client: ");
                    String nomClient = scanner.nextLine();
                    Client client = metierClient.findByNom(nomClient);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse: ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone: ");
                    String tel = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    metierClient.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("Client ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez le nom du client à supprimer: ");
                    String nomASupprimer = scanner.nextLine();
                    metierClient.delete(nomASupprimer);
                    System.out.println("Client(s) supprimé(s).");
                    break;
                case 5:
                    metierClient.saveAll();
                    System.out.println("Clients sauvegardés.");
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }
}
```

### Conclusion
Through these exercises, we explored file handling, data persistence, and basic user interaction in Java. These tasks demonstrate how Java can manage and manipulate data efficiently for practical applications.
















