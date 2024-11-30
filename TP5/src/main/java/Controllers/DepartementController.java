package Controllers;

import Entities.Departement;
import IMetier.IMetierImplementation;
import Utils.TableUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {

    private final IMetierImplementation metierService = new IMetierImplementation();

    private final ObservableList<Departement> departments= FXCollections.observableArrayList();

    @FXML private TableView<Departement> departmentsTable;

    @FXML private TableColumn<Departement, Integer> departmentIdColumn;

    @FXML private TableColumn<Departement, String> departmentNameColumn;

    @FXML private TableColumn<Departement, Void> actionColumn;

    @FXML private Button addDepartementtButton;


    private void initializeTableColumns() {
        departmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("idDepart"));
        departmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        actionColumn.setCellFactory(column -> TableUtils.createActionButtonCell(
                this::ModifyDepartment,
                this::deleteDepartment,
                this::showprofessor
        ));
    }
    private void loadDepartments() {
        departments.setAll(metierService.afficherListeDepartements());
        departmentsTable.setItems(departments);
    }
    private void setupEventHandlers() {
        addDepartementtButton.setOnAction(event -> addDepartement());
    }

    @FXML
    private void addDepartement() {
        Utils.DialogUtils.openModal(
                "/fxml/AddDepartement.fxml",
                "Add New Department",
                controller -> ((AddDepartementController) controller).setDepartement(this)
        );
    }

    @FXML
    public void ModifyDepartment(Departement departement) {
        Utils.DialogUtils.openModal(
                "/fxml/ModifyDepartement.fxml",
                "Modify Department",
                controller -> ((ModifyDepartementController) controller).setDepartement(departement, this)
        );
    }

    private void deleteDepartment(Departement departement) {
        metierService.supprimerDepartement(departement.getIdDepart());
        refreshDepartement();
    }

    private void showprofessor(Departement departement) {
        Utils.DialogUtils.openModal(
                "/fxml/ListProfessorDepartement.fxml",
                "Department Professors",
                controller -> ((ListProfessorController) controller).ListProfessor(departement)
        );
    }

    public void refreshDepartement() {
        departments.setAll(metierService.afficherListeDepartements());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        loadDepartments();
        setupEventHandlers();

    }

}
