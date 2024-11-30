package Controllers;

import Entities.Departement;
import Entities.Professeur;
import IMetier.IMetierImplementation;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyProfessorController {

    private final IMetierImplementation metierService=new IMetierImplementation() ;
    private Professeur professeur;
    private ProfessorController professorController;


    @FXML
    private TextField nameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField cinField;
    @FXML
    private TextField adressField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField numColumn;
    @FXML
    private ComboBox<Departement> departementComboBox;


    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadDepartement(){
        List<Departement> departements = metierService.afficherListeDepartements();
        departementComboBox.getItems().clear();
        departementComboBox.getItems().addAll(departements);
    }


    private void populateFields() {
        nameField.setText(professeur.getNom());
        lastnameField.setText(professeur.getPrenom());
        cinField.setText(professeur.getCin());
        adressField.setText(professeur.getAdresse());
        dateField.setValue(professeur.getDateRecrutement().toLocalDate());
        emailField.setText(professeur.getEmail());
        numColumn.setText(professeur.getTelephone());
        loadDepartement();
        departementComboBox.setValue(professeur.getDepartement());
    }

    public void setProfesseur(Professeur professeur, ProfessorController professorController) {
        this.professorController = professorController;
        this.professeur = professeur;
        populateFields();
    }

    private void updateProfessorData() {
        professeur.setNom(nameField.getText());
        professeur.setPrenom(lastnameField.getText());
        professeur.setCin(cinField.getText());
        professeur.setAdresse(adressField.getText());
        professeur.setEmail(emailField.getText());
        professeur.setTelephone(numColumn.getText());
        professeur.setDateRecrutement(Date.valueOf(dateField.getValue()));
        professeur.setDepartement(departementComboBox.getValue());
    }

    @FXML
    private void handleModifyProfessor() {
        updateProfessorData();
        metierService.modifierProfesseur(professeur);
        professorController.refreshProfessors();
        handleCancel();


    }

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }


}
