package IMetier;

import Entities.Departement;
import Entities.Professeur;

import java.util.List;

public interface IMetier {
    void ajouterProfesseur(Professeur prof);
    void supprimerProfesseur(int idProf);
    void modifierProfesseur(Professeur prof);
    List<Professeur> afficherListeProfesseurs();
    List<Professeur> rechercherProfesseur(String motCle);
    void affecterProfesseurADepartement(int idProf, int idDepart);

    void ajouterDepartement(Departement depart);
    void supprimerDepartement(int idDepart);
    void modifierDepartement(Departement depart);
    List<Departement> afficherListeDepartements();
    List<Professeur> afficherProfesseursParDepartement(int idDepart);

}
