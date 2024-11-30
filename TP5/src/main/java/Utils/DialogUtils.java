package Utils;

import Entities.Departement;
import Entities.Professeur;
import IMetier.IMetierImplementation;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class DialogUtils {
    public static void openModal(String fxmlPath, String title, Consumer<Object> controllerInitializer) {
        try {
            FXMLLoader loader = new FXMLLoader(DialogUtils.class.getResource(fxmlPath));
            Parent root = loader.load();

            controllerInitializer.accept(loader.getController());

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void openDepartmentAssignmentDialog(
            Professeur professor,
            IMetierImplementation metierService,
            Runnable onSuccess) {

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Assign Department");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        VBox content = createDepartmentAssignmentContent(
                professor,
                metierService,
                dialogStage,
                onSuccess
        );

        Scene scene = new Scene(content, 350, 150);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    private static VBox createDepartmentAssignmentContent(
            Professeur professor,
            IMetierImplementation metierService,
            Stage dialogStage,
            Runnable onSuccess) {

        Label instructionLabel = new Label("Choose a department for the professor:");
        instructionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        ComboBox<Departement> departementComboBox = new ComboBox<>();
        departementComboBox.setPrefWidth(300);
        departementComboBox.getItems().addAll(metierService.afficherListeDepartements());

        Button confirmButton = new Button("Assign");
        confirmButton.setOnAction(event -> {
            Departement selectedDepartement = departementComboBox.getValue();
            if (selectedDepartement != null) {
                metierService.affecterProfesseurADepartement(
                        professor.getIdProf(),
                        selectedDepartement.getIdDepart()
                );
                onSuccess.run();
                dialogStage.close();
            }
        });

        VBox content = new VBox(10, instructionLabel, departementComboBox, confirmButton);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        return content;
    }
}