package Entities;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private int idDepart;
    private String nom;

    private List<Professeur> professeurs=new ArrayList<>();

    public Departement(int idDepart, String nom) {
        this.idDepart = idDepart;
        this.nom = nom;
    }

    public Departement() {
        this.professeurs=new ArrayList<Professeur>();
    }


    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }


    public void ajouterProfesseur(Professeur professeur) {
            professeurs.add(professeur);

    }

    @Override
    public String toString() {
        return this.nom;
    }
}
