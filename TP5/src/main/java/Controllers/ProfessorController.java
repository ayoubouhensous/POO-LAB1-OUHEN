package Controllers;

import Entities.Departement;
import Entities.Professeur;
import IMetier.IMetierImplementation;
import Utils.DialogUtils;
import Utils.TableUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProfessorController implements Initializable {

    private final IMetierImplementation metierService = new IMetierImplementation();

    private final ObservableList<Professeur> professors = FXCollections.observableArrayList();

    private String currentKeyword; // Pour stocker le mot-clé courant

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    TableView<Professeur> professorsTable;
    @FXML
    TableColumn<Professeur, Integer> idColumn;
    @FXML
    TableColumn<Professeur, String> nameColumn;
    @FXML
    TableColumn<Professeur, String> emailColumn;
    @FXML
    TableColumn<Professeur, String> cinColumn;
    @FXML
    TableColumn<Professeur, String> numColumn;
    @FXML
    TableColumn<Professeur, String> departmentColumn;
    @FXML
    TableColumn<Professeur, Void> actionColumn;
    @FXML
    private Button addprofessortButton;




    private void initializeTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idProf"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
        numColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getDepartement() != null ?
                        data.getValue().getDepartement().getNom() :
                        "Aucun département"
        ));
        actionColumn.setCellFactory(column -> TableUtils.createProfessorActionCell(
                this::modifyProfessor,
                this::deleteProfessor,
                this::affecterProfessor
        ));
    }

    private void loadProfessors() {
        professors.clear();
        professors.setAll(metierService.afficherListeProfesseurs());
        professorsTable.setItems(professors);
    }

    private void setupEventHandlers() {
        addprofessortButton.setOnAction(event -> addProfessor());
        searchButton.setOnAction(event -> onSearchClicked());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        loadProfessors();
        setupEventHandlers();

    }

    @FXML
    private void addProfessor() {
        DialogUtils.openModal(
                "/fxml/AddProfessor.fxml",
                "Add New Professor",
                controller -> ((AddProfessorController) controller).setProfesseurController(this)
        );
    }

    public void modifyProfessor(Professeur professeur) {
        DialogUtils.openModal(
                "/fxml/ModifyProfessor.fxml",
                "Modify Professor",
                controller -> ((ModifyProfessorController) controller).setProfesseur(professeur, this)
        );
    }

    public void deleteProfessor(Professeur professeur) {
        metierService.supprimerProfesseur(professeur.getIdProf());
        refreshProfessors();
    }

    public void affecterProfessor(Professeur professeur) {
        DialogUtils.openDepartmentAssignmentDialog(
                professeur,
                metierService,
                this::refreshProfessors
        );
    }
    @FXML
    private void onSearchClicked() {
        String keyword = searchField.getText();
        if (keyword == null || keyword.isEmpty()) {
            return;
        }

        this.currentKeyword = keyword;
        DialogUtils.openModal(
                "/fxml/SearchProfessor.fxml",
                "Search Results",
                controller -> ((SearchProfessorController) controller).searchProfessors(keyword, this)
        );
    }

    public void refreshProfessors() {
        professors.setAll(metierService.afficherListeProfesseurs());
    }

    public String getCurrentKeyword() {
        return currentKeyword;
    }
}

