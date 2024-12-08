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

```java




