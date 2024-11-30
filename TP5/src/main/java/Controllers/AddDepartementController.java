package Controllers;

import Entities.Departement;
import IMetier.IMetierImplementation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDepartementController {

    private IMetierImplementation im = new IMetierImplementation();
    @FXML
    private TextField nameField;
    private DepartementController departementController ;
    public void setDepartement(DepartementController departementController) {
        this.departementController = departementController;
    }

    @FXML
    private void handleAddDepartement() {
        String name = nameField.getText();

        Departement departement = new Departement();

        departement.setNom(name);

        im.ajouterDepartement(departement);

        if(departementController!=null){
            departementController.refreshDepartement();
        }
        handleCancel();

    }


    @FXML
    private void handleCancel() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }





}
