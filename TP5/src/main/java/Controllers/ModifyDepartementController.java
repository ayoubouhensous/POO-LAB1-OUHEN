package Controllers;

import Entities.Departement;
import IMetier.IMetierImplementation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyDepartementController {
    IMetierImplementation im=new IMetierImplementation();
    DepartementController departementController;
    private Departement departement;
    @FXML
    private TextField nameField;


    @FXML
    private void handleModifyDepartement() {
        departement.setNom(nameField.getText());
        im.modifierDepartement(departement);
        departementController.refreshDepartement();
        handleCancel();
    }
    public void setDepartement(Departement departement,DepartementController departementController){
        this.departementController=departementController;
        this.departement=departement;
        nameField.setText(departement.getNom());
    }

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

}
