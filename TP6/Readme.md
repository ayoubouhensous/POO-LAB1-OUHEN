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

The program begins by importing the File class from the java.io package, which allows manipulation of files and directories within the file system. It then declares a public class named DirectoryLister, which will contain the main method.

The main method, main, serves as the entry point for the program. Inside this method, the program displays a message prompting the user to enter a directory path. It uses a Scanner object to read user input from the console and stores this path in a variable called path.

After obtaining the path, the program creates a File object using this path, which allows it to represent the directory specified by the user. It then checks if this path corresponds to a valid directory by calling the isDirectory() method. If it is indeed a directory, the program uses the listFiles() method to obtain an array of File objects, each representing a file or subdirectory within the specified directory.

The program then checks if the array of files is not null, indicating that the directory is not empty and that the files have been successfully retrieved. It enters a for loop that iterates over each file or subdirectory in the array. For each file, it uses the isDirectory() method to determine whether it is a directory or a file and displays <DIR> or <FILE> accordingly.

The program also retrieves the name of each file or directory using the getName() method. Additionally, it checks the permissions of each file using the canRead(), canWrite(), and isHidden() methods, displaying "r" to indicate that the file is readable, "w" to indicate that it is writable, and "h" to indicate that it is hidden. The information is displayed in a formatted line summarizing these details.

After iterating through all the files, if the directory is empty, the program displays a message indicating that the directory is empty. If at any point the path provided by the user is not a valid directory, the program displays an error message indicating that the path is invalid or does not correspond to a directory.

In summary, this program provides a simple interface for the user to explore a directory on their file system, view its contents, and obtain information about each file and subdirectory, such as their names and permissions. It serves as a practical example of file handling and user interaction in Java.





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
The program begins by importing necessary classes: java.io.* for input and output operations, and java.util.Scanner for reading user input from the console. The main class, ContactManager, contains the main method, which serves as the entry point of the application.

Inside the main method, a Scanner object named scanner is created to facilitate user input. A boolean variable, running, is initialized to true, which will control the main loop of the program.

The program enters a while loop that continues executing as long as running is true. Within this loop, a menu is displayed to the user, offering options to add, search for, update, delete a contact, or exit the program. The user is prompted to enter their choice, which is read as an integer.

The program uses a switch statement to determine the action based on the user's choice.

#### Adding a Contact (Case 1):

If the user selects option 1, the program prompts for the contact's name and phone number.
A FileWriter is then created to write the phone number to a text file named after the contact (e.g., contacts/John.txt). The contacts directory must exist for the program to work correctly.
After writing the contact's number, a message is displayed indicating that the contact has been added. If an IOException occurs during this process (for example, if the directory does not exist), an error message is printed.
#### Searching for a Contact (Case 2):

When the user selects option 2, they are prompted to enter a name to search for.
A File object is created to represent the corresponding contact file. The program checks if the file exists using the exists() method.
If the file exists, a BufferedReader is used to read the phone number from the file, which is then displayed to the user. If an IOException occurs during reading, an error message is printed.
If the file does not exist, the program informs the user that the contact was not found.

#### Exiting the Program (Case 5):

If the user selects option 5, the variable running is set to false, which will cause the while loop to terminate and the program to exit.
Invalid Options:

If the user enters any option that does not correspond to the available choices, an error message stating "Invalid option" is displayed.
At the end of the while loop, the scanner is closed to release system resources associated with it.

Overall, this Java program provides a basic console-based contact management system where users can add and search for contacts. It demonstrates fundamental concepts of file handling, user input, and control structures in Java. However, the program currently lacks functionalities for updating and deleting contacts, as indicated by the available options in the menu. These features could be implemented in a similar manner by adding corresponding cases in the switch statement.




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
The code defines a simple product management application that allows users to add, search, and display products. It uses serialization to store the products in a file.

#### Imports:

The code imports necessary classes for file I/O (java.io.*), collections (java.util.ArrayList and java.util.List), and user input (java.util.Scanner).

#### Product Class:

The Product class implements Serializable, which allows instances of this class to be serialized (converted into a byte stream) and deserialized (reconstructed from a byte stream).
It has two private attributes: name (the product name) and price (the product price).
A constructor initializes these attributes, and the toString method provides a string representation of the product.

#### ProductManager Class:

The ProductManager class contains the main application logic.
It defines a constant FILE_NAME to specify the filename (products.dat) where products will be saved.

#### Main Method:

A list of Product objects (products) is initialized by loading previously saved products from the file using the loadProducts method.

A Scanner object is created to read user input.

The program enters a while loop, presenting a menu with four options: add a product, search for a product, display all products, and exit.

The user's choice is read and processed using a switch statement.

Adding a Product (Case 1):

If the user chooses to add a product, they are prompted for the product name and price.
A new Product instance is created and added to the list.
The saveProducts method is called to save the updated product list to the file.
Searching for a Product (Case 2):

If the user opts to search, they enter a product name to look for.
The program filters the product list to find matches and prints the results.
Displaying All Products (Case 3):

If the user wants to see all products, the program iterates through the product list and prints each product.
Exiting (Case 4):

The user can exit the program by setting running to false.

#### Load and Save Methods:

loadProducts: Attempts to read a list of products from the specified file using ObjectInputStream. If the file does not exist or an error occurs, it returns an empty list.
saveProducts: Serializes the list of products and writes it to the file using ObjectOutputStream. If an error occurs during saving, an error message is printed.

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
                    metierClient.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("Client ajouté.");
                    break;
                case 4:
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

The code defines a simple application for managing client information. It provides options for users to view, search, add, delete, and save client records.

#### Imports:

The code imports necessary classes for managing lists (java.util.List) and user input (java.util.Scanner).
#### ApplicationClients Class:

The ApplicationClients class contains the main method, which serves as the entry point for the application.

#### Main Method:

A Scanner object is created to read user input.
An instance of MetierClientImpl is created, which presumably manages client operations and uses "clients.dat" as the file for storing client data.
The application runs in a loop, displaying a menu of options for the user to choose from.
Menu Options:

The menu presents six options:
Display Client List: Retrieves and prints all clients by calling the getAll() method from MetierClientImpl.
Search for a Client by Name: Prompts the user for a client name, searches for the client using the findByNom() method, and displays the client details if found.
Add a New Client: Prompts the user for various client details (name, first name, address, phone, email), creates a new Client object, and adds it using the add() method.
Delete a Client by Name: Prompts the user for the name of the client to delete and calls the delete() method.
Save Clients: Calls the saveAll() method to save the client data to the file.
Exit: Exits the application with a farewell message.

#### Input Handling:

After reading a choice from the user, scanner.nextLine() is called to consume the newline character left by nextInt().

#### Switch Statement:

A switch statement processes the user's choice. Each case corresponds to one of the menu options, executing the appropriate method from MetierClientImpl based on the user's input.

#### Loop Control:

The loop continues until the user chooses option 6 (exit), at which point the scanner is closed to release resources.


### Conclusion
Through these exercises, we explored file handling, data persistence, and basic user interaction in Java. These tasks demonstrate how Java can manage and manipulate data efficiently for practical applications.
















