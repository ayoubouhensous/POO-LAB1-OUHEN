package Controllers;

import Entities.Professeur;
import IMetier.IMetierImplementation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AddProfessorController implements Initializable {
    private final IMetierImplementation metierService=new IMetierImplementation() ;

    private ProfessorController professorController;


    @FXML
    private TextField nameField;

    @FXML
    private TextField LastnameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cinField;

    @FXML
    private TextField adressField;
    @FXML
    private TextField numColumn;

    @FXML
    private DatePicker dateField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setProfesseurController(ProfessorController professorController) {
        this.professorController = professorController;
    }
    @FXML
    private void handleAddProfessor() {
        Professeur professor = createProfessorFromFields();
        metierService.ajouterProfesseur(professor);

        if (professorController != null) {
            professorController.refreshProfessors();
        }
        handleCancel();
    }

    private Professeur createProfessorFromFields() {
        Professeur professor = new Professeur();
        professor.setNom(nameField.getText());
        professor.setPrenom(LastnameField.getText());
        professor.setEmail(emailField.getText());
        professor.setCin(cinField.getText());
        professor.setAdresse(adressField.getText());
        professor.setTelephone(numColumn.getText());
        professor.setDateRecrutement(
                dateField.getValue() != null ?
                        Date.valueOf(dateField.getValue()) :
                        null
        );
        return professor;
    }

    @FXML
    private void handleCancel() {
        ((Stage) nameField.getScene().getWindow()).close();
    }
}
