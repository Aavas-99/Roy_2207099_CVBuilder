package com.example.cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    @FXML
    private TextField FullName;
    @FXML
    private TextField Email;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Address;

    @FXML
    private TextField SSCName, SSCGroup, SSCGPA;
    @FXML
    private TextField HSCName, HSCGroup, HSCGPA;
    @FXML
    private TextField HonsName, HonsDept, HonsCGPA;

    @FXML
    private TextField Org1, From1, To1;
    @FXML
    private TextField Org2, From2, To2;
    @FXML
    private TextField Org3, From3, To3;
    @FXML
    private TextField Skills;
    @FXML
    private TextField Projects;

    @FXML
    private void onBuildCV(ActionEvent event) throws IOException {
        if (FullName.getText().isEmpty() || Email.getText().isEmpty() || Phone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in Name, Email and Phone Number before building the CV.");
            alert.showAndWait();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("output.fxml"));
        Parent root = loader.load();

        outputController controller = loader.getController();
        controller.setData(
                FullName.getText(),
                Email.getText(),
                Phone.getText(),
                Address.getText(),

                SSCName.getText(), SSCGroup.getText(), SSCGPA.getText(),
                HSCName.getText(), HSCGroup.getText(), HSCGPA.getText(),
                HonsName.getText(), HonsDept.getText(), HonsCGPA.getText(),

                Org1.getText(), From1.getText(), To1.getText(),
                Org2.getText(), From2.getText(), To2.getText(),
                Org3.getText(), From3.getText(), To3.getText(),
                Skills.getText(),Projects.getText()
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 600, 700));
        stage.show();
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("CV Ready");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Your CV has been successfully generated!");
        successAlert.showAndWait();
    }
}
