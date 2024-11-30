package example;

import Entities.Departement;
import Entities.Professeur;
import IMetier.IMetierImplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IMetierImplementation metier = new IMetierImplementation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter Professeur");
            System.out.println("2. Modifier Professeur");
            System.out.println("3. Supprimer Professeur");
            System.out.println("4. Afficher Liste des Professeurs");
            System.out.println("5. Rechercher Professeur");
            System.out.println("6. Ajouter Département");
            System.out.println("7. Modifier Département");
            System.out.println("8. Supprimer Département");
            System.out.println("9. Afficher Liste des Départements");
            System.out.println("10. Afficher Professeurs par Département");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterProfesseur(scanner, metier);
                    break;
                case 2:
                    modifierProfesseur(scanner, metier);
                    break;
                case 3:
                    supprimerProfesseur(scanner, metier);
                    break;
                case 4:
                    afficherListeProfesseurs(metier);
                    break;
                case 5:
                    rechercherProfesseur(scanner, metier);
                    break;
                case 6:
                    ajouterDepartement(scanner, metier);
                    break;
                case 7:
                    modifierDepartement(scanner, metier);
                    break;
                case 8:
                    supprimerDepartement(scanner, metier);
                    break;
                case 9:
                    afficherListeDepartements(metier);
                    break;
                case 10:
                    afficherProfesseursParDepartement(scanner, metier);
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }

    private static void ajouterProfesseur(Scanner scanner, IMetierImplementation metier) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Téléphone: ");
        String telephone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Date de recrutement (yyyy-MM-dd): ");
        String dateRecrutement = scanner.nextLine();
        System.out.print("ID Département: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();
        Departement dep=new Departement();
        dep.setIdDepart(idDepart);
        Professeur prof = new Professeur();
        prof.setNom(nom);
        prof.setPrenom(prenom);
        prof.setCin(cin);
        prof.setAdresse(adresse);
        prof.setTelephone(telephone);
        prof.setEmail(email);
        prof.setDateRecrutement(java.sql.Date.valueOf(dateRecrutement));
        prof.setDepartement(dep);
        metier.ajouterProfesseur(prof);
    }

    private static void modifierProfesseur(Scanner scanner, IMetierImplementation metier) {
        System.out.print("ID Professeur à modifier: ");
        int idProf = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Téléphone: ");
        String telephone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Date de recrutement (yyyy-MM-dd): ");
        String dateRecrutement = scanner.nextLine();
        System.out.print("ID Département: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Departement dep=new Departement();
        dep.setIdDepart(idDepart);
        Professeur prof = new Professeur();
        prof.setIdProf(idProf);
        prof.setNom(nom);
        prof.setPrenom(prenom);
        prof.setCin(cin);
        prof.setAdresse(adresse);
        prof.setTelephone(telephone);
        prof.setEmail(email);
        prof.setDateRecrutement(java.sql.Date.valueOf(dateRecrutement));
        prof.setDepartement(dep);
        metier.modifierProfesseur(prof);
    }

    private static void supprimerProfesseur(Scanner scanner, IMetierImplementation metier) {
        System.out.print("ID Professeur à supprimer: ");
        int idProf = scanner.nextInt();
        scanner.nextLine();
        metier.supprimerProfesseur(idProf);
    }

    private static void afficherListeProfesseurs(IMetierImplementation metier) {
        List<Professeur> professeurs = metier.afficherListeProfesseurs();
        for (Professeur prof : professeurs) {
            System.out.println(prof);
        }
    }

    private static void rechercherProfesseur(Scanner scanner, IMetierImplementation metier) {
        System.out.print("Mot-clé de recherche: ");
        String motCle = scanner.nextLine();
        List<Professeur> professeurs = metier.rechercherProfesseur(motCle);
        for (Professeur prof : professeurs) {
            System.out.println(prof);
        }
    }

    private static void ajouterDepartement(Scanner scanner, IMetierImplementation metier) {
        System.out.print("Nom du Département: ");
        String nom = scanner.nextLine();
        Departement depart = new Departement();
        depart.setNom(nom);
        metier.ajouterDepartement(depart);
    }

    private static void modifierDepartement(Scanner scanner, IMetierImplementation metier) {
        System.out.print("ID Département à modifier: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom du Département: ");
        String nom = scanner.nextLine();
        Departement depart = new Departement(idDepart, nom);
        metier.modifierDepartement(depart);
    }

    private static void supprimerDepartement(Scanner scanner, IMetierImplementation metier) {
        System.out.print("ID Département à supprimer: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();
        metier.supprimerDepartement(idDepart);
    }

    private static void afficherListeDepartements(IMetierImplementation metier) {
        List<Departement> departements = metier.afficherListeDepartements();
        for (Departement depart : departements) {
            System.out.println(depart);
        }
    }

    private static void afficherProfesseursParDepartement(Scanner scanner, IMetierImplementation metier) {
        System.out.print("ID Département: ");
        int idDepart = scanner.nextInt();
        scanner.nextLine();
        List<Professeur> professeurs = metier.afficherProfesseursParDepartement(idDepart);
        for (Professeur prof : professeurs) {
            System.out.println(prof);
        }
    }
}