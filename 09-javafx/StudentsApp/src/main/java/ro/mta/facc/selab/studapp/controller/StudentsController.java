package ro.mta.facc.selab.studapp.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ro.mta.facc.selab.studapp.MainApp;
import ro.mta.facc.selab.studapp.model.Student;

import java.io.IOException;
import java.net.URL;


public class StudentsController {
    private ObservableList<Student> studentData;

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> numeColumn;
    @FXML
    private TableColumn<Student, String> prenumeColumn;
    @FXML
    private TableColumn<Student, Float> medieColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;

    @FXML
    private Label numeLabel;
    @FXML
    private Label prenumeLabel;
    @FXML
    private Label grupaLabel;
    @FXML
    private Label notaProgLabel;
    @FXML
    private Label notaPooLabel;
    @FXML
    private Label notaIpLabel;

    public StudentsController(ObservableList<Student> studentData) {
        this.studentData = studentData;
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        numeColumn.setCellValueFactory(cellData -> cellData.getValue().numeProperty());
        prenumeColumn.setCellValueFactory(cellData -> cellData.getValue().prenumeProperty());
        medieColumn.setCellValueFactory(cellData -> cellData.getValue().medieProperty().asObject());

        studentTable.setItems(studentData);

        studentTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                showStudentInfo(newValue);
            }
        });


    }

    private boolean showEditDialog(Student student) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/view/StudentEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            StudentEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStudent(student);

            System.out.println("test");
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void handleNew() {
        /* Va fi populat in apel */
        Student stud = new Student("tmp", "tmp", "tmp", 0, 0, 0);

        boolean okClicked = showEditDialog(stud);

        if (okClicked) {
            studentData.add(stud);
        }
    }

    @FXML
    private void handleEdit() {
        /* Va fi populat in apel */
        Student stud = studentTable.getSelectionModel().getSelectedItem();

        boolean okClicked = showEditDialog(stud);

        if (okClicked) {
            showStudentInfo(stud);
        }
    }

    @FXML
    private void handleDelete() {
        int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        studentTable.getItems().remove(selectedIndex);
    }

    private void showStudentInfo(Student stud) {
        if (stud != null) {
            numeLabel.setText(stud.getNume());
            prenumeLabel.setText(stud.getPrenume());
            grupaLabel.setText(stud.getGrupa());

            notaProgLabel.setText(Integer.toString(stud.getNota_prog()));
            notaIpLabel.setText(Integer.toString(stud.getNota_ip()));
            notaPooLabel.setText(Integer.toString(stud.getNota_poo()));
        } else {
            numeLabel.setText("");
            prenumeLabel.setText("");
            grupaLabel.setText("");

            notaProgLabel.setText("");
            notaIpLabel.setText("");
            notaPooLabel.setText("");
        }
    }

}
