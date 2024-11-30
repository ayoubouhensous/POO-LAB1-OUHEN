    package Controllers;

    import Entities.Departement;
    import Entities.Professeur;
    import IMetier.IMetierImplementation;
    import Utils.TableUtils;
    import javafx.beans.property.SimpleStringProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.layout.HBox;
    import javafx.util.Callback;

    import java.net.URL;
    import java.util.List;
    import java.util.ResourceBundle;

    public class SearchProfessorController implements Initializable {



        private final IMetierImplementation metierService =new IMetierImplementation();
        private final ObservableList<Professeur> professorList = FXCollections.observableArrayList();
        private ProfessorController professorController;

        @FXML
        private Label resultLabel;


        @FXML
        TableColumn<Professeur, Integer> idColumn;

        @FXML
        private TableView<Professeur> professorsTable;

        @FXML
        private TableColumn<Professeur, String> nameColumn;

        @FXML
        private TableColumn<Professeur, String> emailColumn;

        @FXML
        private TableColumn<Professeur, String> departmentColumn;

        @FXML
        private TableColumn<Professeur, Void> actionColumn;


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            initializeTableColumns();
        }

        private void initializeTableColumns() {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("idProf"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(
                    data.getValue().getDepartement() != null ?
                            data.getValue().getDepartement().getNom() :
                            "No Department"
            ));
            actionColumn.setCellFactory(column -> TableUtils.createProfessorActionCell(
                    this::handleModify,
                    this::handleDelete,
                    this::handleAssign
            ));
            professorsTable.setItems(professorList);
        }



        public void searchProfessors(String keyword, ProfessorController controller) {
            this.professorController = controller;
            resultLabel.setText("Search results for: " + keyword);
            loadSearchResults(keyword);
        }

        private void loadSearchResults(String keyword) {
            professorList.setAll(metierService.rechercherProfesseur(keyword));
        }

        private void handleModify(Professeur professor) {
            professorController.modifyProfessor(professor);
            refreshResults();
        }

        private void handleDelete(Professeur professor) {
            professorController.deleteProfessor(professor);
            refreshResults();
        }

        private void handleAssign(Professeur professor) {
            professorController.affecterProfessor(professor);
            refreshResults();
        }

        private void refreshResults() {
            professorList.clear();
            loadSearchResults(professorController.getCurrentKeyword());
        }

        }
