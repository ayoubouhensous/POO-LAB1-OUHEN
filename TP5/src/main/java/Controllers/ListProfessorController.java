package Controllers;

import Entities.Departement;
import Entities.Professeur;
import IMetier.IMetierImplementation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListProfessorController implements Initializable {
    private final IMetierImplementation metierService= new IMetierImplementation();
    private final ObservableList<Professeur> professorList = FXCollections.observableArrayList();

    @FXML
    private TableView<Professeur> professorsTable;
    @FXML
    TableColumn<Professeur, Integer> idColumn;
    @FXML
    private TableColumn<Professeur, String> nameColumn;
    @FXML
    private TableColumn<Professeur, String> emailColumn;
    @FXML
    private TableColumn<Professeur,String> cinColumn;
    @FXML
    private TableColumn<Professeur,String> numColumn;
    @FXML
    private Label resultLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeColumns();
    }

    private void initializeColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idProf"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
        numColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        professorsTable.setItems(professorList);
    }

    public void ListProfessor(Departement departement){
        resultLabel.setText("Liste des professeurs du département : " + departement.getNom());
        professorList.setAll(metierService.afficherProfesseursParDepartement(departement.getIdDepart()));

    }

}
