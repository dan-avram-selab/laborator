package ro.mta.facc.selab.studapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.facc.selab.studapp.controller.StudentsController;
import ro.mta.facc.selab.studapp.model.Student;

import java.io.IOException;
import java.net.URL;


public class MainApp extends Application {
    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    public static void main(String[] args)
    {
        launch(args);
    }

    public void initializeStudents()
    {
        studentData.add(new Student("Avram", "Dan", "C214B", 10, 8, 8));
        studentData.add(new Student("Ion", "George", "C114A", 5, 7, 9));
        studentData.add(new Student("Gheorghe", "Vasile", "C224", 6, 9, 6));

    }

    public void start(Stage primaryStage) {
        initializeStudents();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("/view/StudentView.fxml"));
            loader.setController(new StudentsController(studentData));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
