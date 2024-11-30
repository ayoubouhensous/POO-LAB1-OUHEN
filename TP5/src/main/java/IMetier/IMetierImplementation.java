package IMetier;

import ConnexionDB.SignletonConnexionDB;
import Entities.Departement;
import Entities.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IMetierImplementation implements IMetier{
    Connection connection= SignletonConnexionDB.getConnection();
    @Override
    public void ajouterProfesseur(Professeur prof) {

        try{
            String checkSql = "SELECT COUNT(*) FROM professeur WHERE cin = ?";
            PreparedStatement checkPs = connection.prepareStatement(checkSql);
            checkPs.setString(1, prof.getCin());
            ResultSet resultSet = checkPs.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) == 0) {

                String sql = "INSERT INTO professeur(nom, prenom, cin, adresse, telephone, email, date_recrutement, id_deprat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ;
                ps.setString(1, prof.getNom());
                ps.setString(2, prof.getPrenom());
                ps.setString(3, prof.getCin());
                ps.setString(4, prof.getAdresse());
                ps.setString(5, prof.getTelephone());
                ps.setString(6, prof.getEmail());
                ps.setDate(7, prof.getDateRecrutement() != null ? new Date(prof.getDateRecrutement().getTime()) : null);
                if (prof.getDepartement() != null) {
                    ps.setInt(8, prof.getDepartement().getIdDepart());
                    prof.getDepartement().ajouterProfesseur(prof);

                } else {
                    ps.setNull(8, java.sql.Types.INTEGER);
                }
                ps.executeUpdate();

            }




        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void supprimerProfesseur(int idProf) {
        try {
            String sql = "DELETE FROM professeur WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,idProf);
            ps.executeUpdate();


            ps.close();


        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void modifierProfesseur(Professeur prof) {

        try {
            String sql = "UPDATE Professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_deprat = ? WHERE id_prof = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,prof.getNom());
            ps.setString(2,prof.getPrenom());
            ps.setString(3,prof.getCin());
            ps.setString(4,prof.getAdresse());
            ps.setString(5,prof.getTelephone());
            ps.setString(6,prof.getEmail());
            ps.setDate(7,new Date(prof.getDateRecrutement().getTime()));
            if (prof.getDepartement() != null) {
                ps.setInt(8, prof.getDepartement().getIdDepart());
            } else {
                ps.setNull(8, java.sql.Types.INTEGER);
            }

            ps.setInt(9,prof.getIdProf());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le professeur a été mis à jour avec succès.");
            } else {
                System.out.println("Aucune ligne n'a été mise à jour.");
            }
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Professeur> afficherListeProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Professeur");
            while (rs.next()) {
                Professeur prof=new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                int idDepartement=rs.getInt("id_deprat");
                if(idDepartement!=0){
                    String deptQuery = "SELECT * FROM Departement WHERE id_deprat = ?";
                    PreparedStatement deptStmt = connection.prepareStatement(deptQuery);
                    deptStmt.setInt(1, idDepartement);
                    ResultSet rsDept = deptStmt.executeQuery();
                    if(rsDept.next()){
                        Departement departement=new Departement();
                        departement.setIdDepart(rsDept.getInt("id_deprat"));
                        departement.setNom(rsDept.getString("nom"));

                        prof.setDepartement(departement);
                    }
                    rsDept.close();
                    deptStmt.close();
                }
                professeurs.add(prof);
            }
            rs.close();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }




        return professeurs;
    }

    @Override
    public List<Professeur> rechercherProfesseur(String motCle) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Professeur WHERE nom LIKE ? OR prenom LIKE ? OR cin LIKE ? OR email LIKE ? OR adresse LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,motCle);
            ps.setString(2,motCle);
            ps.setString(3,motCle);
            ps.setString(4,motCle);
            ps.setString(5,motCle);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur prof=new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                int idDepartement=rs.getInt("id_deprat");
                if(idDepartement!=0){
                    String deptQuery = "SELECT * FROM Departement WHERE id_deprat = ?";
                    PreparedStatement deptStmt = connection.prepareStatement(deptQuery);
                    deptStmt.setInt(1, idDepartement);
                    ResultSet rsDept = deptStmt.executeQuery();
                    if(rsDept.next()){
                        Departement departement=new Departement();
                        departement.setIdDepart(rsDept.getInt("id_deprat"));
                        departement.setNom(rsDept.getString("nom"));
                        prof.setDepartement(departement);
                    }
                    rsDept.close();
                    deptStmt.close();
                }
                professeurs.add(prof);


            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return professeurs;
    }

    @Override
    public void affecterProfesseurADepartement(int idProf, int idDepart) {
            try {
                String updateProfesseurSql = "UPDATE Professeur SET id_deprat = ? WHERE id_prof = ?";
                PreparedStatement updateProfesseurStmt = connection.prepareStatement(updateProfesseurSql);
                updateProfesseurStmt.setInt(1, idDepart);
                updateProfesseurStmt.setInt(2, idProf);
                updateProfesseurStmt.executeUpdate();

                updateProfesseurStmt.close();

            }catch (SQLException e){
                e.printStackTrace();
            }


    }

    @Override
    public void ajouterDepartement(Departement depart) {
        try {

            String checkSql = "SELECT COUNT(*) FROM Departement WHERE id_deprat = ?";
            PreparedStatement checkPs = connection.prepareStatement(checkSql);
            checkPs.setInt(1, depart.getIdDepart());
            ResultSet rs = checkPs.executeQuery();

            if(rs.next() && rs.getInt(1)==0){
                String sql = "INSERT INTO Departement (id_deprat, nom) VALUES (?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1,depart.getIdDepart());
                ps.setString(2,depart.getNom());
                ps.executeUpdate();
            }



        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void supprimerDepartement(int idDepart) {

        try {


                String deleteDepartementSql = "DELETE FROM Departement WHERE id_deprat = ?";
                PreparedStatement deleteDepartementStmt = connection.prepareStatement(deleteDepartementSql);
                deleteDepartementStmt.setInt(1, idDepart);
                deleteDepartementStmt.executeUpdate();



                deleteDepartementStmt.close();



        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void modifierDepartement(Departement depart) {

        try {

            String sql = "UPDATE Departement SET nom = ? WHERE id_deprat = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, depart.getNom());
            ps.setInt(2, depart.getIdDepart());

            ps.executeUpdate();

            ps.close();

            }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Departement> afficherListeDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Departement";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Departement depart = new Departement();
                depart.setIdDepart(rs.getInt("id_deprat"));
                depart.setNom(rs.getString("nom"));

                departements.add(depart);
            }

            rs.close();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();

        }

        return departements;
    }

    @Override
    public List<Professeur> afficherProfesseursParDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Professeur WHERE id_deprat = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setIdProf(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));

                String sqlDepartement = "SELECT * FROM Departement WHERE id_deprat = ?";
                PreparedStatement psDepartement = connection.prepareStatement(sqlDepartement);
                psDepartement.setInt(1, idDepart);
                ResultSet rsDepartement = psDepartement.executeQuery();

                if (rsDepartement.next()) {
                    Departement departement = new Departement();
                    departement.setIdDepart(rsDepartement.getInt("id_deprat"));
                    departement.setNom(rsDepartement.getString("nom"));
                    prof.setDepartement(departement);
                }
                rsDepartement.close();
                psDepartement.close();


                professeurs.add(prof);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return professeurs;
    }
}
