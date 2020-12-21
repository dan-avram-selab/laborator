package ro.mta.facc.selab.studapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ro.mta.facc.selab.studapp.MainApp;
import ro.mta.facc.selab.studapp.model.Student;


import java.io.IOException;

public class StudentEditController {
    @FXML
    private TextField numeTextField;
    @FXML
    private TextField prenumeTextField;
    @FXML
    private TextField grupaTextField;
    @FXML
    private TextField notaProgTextField;
    @FXML
    private TextField notaPooTextField;
    @FXML
    private TextField notaIpTextField;

    private Stage dialogStage;
    private Student student;
    private boolean okClicked = false;

    @FXML
    private void initialize() {

    }



    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setStudent(Student student)
    {
        this.student = student;
        numeTextField.setText(student.getNume());
        prenumeTextField.setText(student.getPrenume());
        grupaTextField.setText(student.getGrupa());

        notaProgTextField.setText(Integer.toString(student.getNota_prog()));
        notaPooTextField.setText(Integer.toString(student.getNota_poo()));
        notaIpTextField.setText(Integer.toString(student.getNota_ip()));
    }

    /* True dacă s-a apăsat OK */
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void okHandle()
    {
        student.setNume(numeTextField.getText());
        student.setPrenume(prenumeTextField.getText());
        student.setGrupa(grupaTextField.getText());

        student.setNota_ip(Integer.parseInt(notaIpTextField.getText()));
        student.setNota_poo(Integer.parseInt(notaPooTextField.getText()));
        student.setNota_prog(Integer.parseInt(notaProgTextField.getText()));
        okClicked = true;

        dialogStage.close();

    }

    @FXML
    private void cancelHandle() {
        dialogStage.close();
    }
}
