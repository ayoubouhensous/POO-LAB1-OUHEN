package Utils;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

import java.util.function.Consumer;

public class TableUtils {

    public static <T> TableCell<T, Void> createActionButtonCell(
            Consumer<T> onModify,
            Consumer<T> onDelete,
            Consumer<T> onShowProfessor) {

        return new TableCell<>() {
            private final Button modifyButton = new Button("Modify");
            private final Button deleteButton = new Button("Delete");
            private final Button professorButton = new Button("Liste Professors");
            private final HBox buttonBox = new HBox(10, modifyButton, deleteButton, professorButton);

            {
                modifyButton.setOnAction(event -> onModify.accept(getCurrentItem()));
                deleteButton.setOnAction(event -> onDelete.accept(getCurrentItem()));
                professorButton.setOnAction(event -> onShowProfessor.accept(getCurrentItem()));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : buttonBox);
            }

            private T getCurrentItem() {
                return getTableView().getItems().get(getIndex());
            }
        };
    }

    public static <T> TableCell<T, Void> createProfessorActionCell(
            Consumer<T> onModify,
            Consumer<T> onDelete,
            Consumer<T> onAssign) {

        return new TableCell<>() {
            private final Button modifyButton = new Button("Modify");
            private final Button deleteButton = new Button("Delete");
            private final Button assignButton = new Button("Assign");
            private final HBox buttonBox = new HBox(10, modifyButton, deleteButton, assignButton);

            {
                modifyButton.setOnAction(event -> onModify.accept(getCurrentItem()));
                deleteButton.setOnAction(event -> onDelete.accept(getCurrentItem()));
                assignButton.setOnAction(event -> onAssign.accept(getCurrentItem()));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : buttonBox);
            }

            private T getCurrentItem() {
                return getTableView().getItems().get(getIndex());
            }
        };
    }

}
