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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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



        int id=insertIntoDatabase();

        if(id!=-1){
            outputController controller = loader.getController();
            controller.setData(
                    id,
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
                    Skills.getText(), Projects.getText()
            );
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to insert data into the database.");
            alert.showAndWait();
            return;
        }


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 600, 700));
        stage.show();
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("CV Ready");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Your CV has been successfully generated!");
        successAlert.showAndWait();
    }

    private int insertIntoDatabase() {
        String sql = "INSERT INTO users (Name, Email, Phone, Address, " +
                "SSC, SSCGroup, SSCGPA, HSC, HSCGroup, HSCGPA, " +
                "Hons, HonsDept, HonsCGPA, " +
                "Org1, From1, To1, Org2, From2, To2, Org3, From3, To3, Skills, Projects) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, FullName.getText());
            stmt.setString(2, Email.getText());
            stmt.setString(3, Phone.getText());
            stmt.setString(4, Address.getText());

            stmt.setString(5, SSCName.getText());
            stmt.setString(6, SSCGroup.getText());
            stmt.setString(7, SSCGPA.getText());

            stmt.setString(8, HSCName.getText());
            stmt.setString(9, HSCGroup.getText());
            stmt.setString(10, HSCGPA.getText());

            stmt.setString(11, HonsName.getText());
            stmt.setString(12, HonsDept.getText());
            stmt.setString(13, HonsCGPA.getText());

            stmt.setString(14, Org1.getText());
            stmt.setString(15, From1.getText());
            stmt.setString(16, To1.getText());

            stmt.setString(17, Org2.getText());
            stmt.setString(18, From2.getText());
            stmt.setString(19, To2.getText());

            stmt.setString(20, Org3.getText());
            stmt.setString(21, From3.getText());
            stmt.setString(22, To3.getText());

            stmt.setString(23, Skills.getText());
            stmt.setString(24, Projects.getText());
            stmt.executeUpdate();
            ResultSet rs= stmt.getGeneratedKeys();
            if(rs.next()){
                int id= rs.getInt(1);
                System.out.println("Generated User ID: " + id);
                return id;
            }

            System.out.println("✔ Data inserted into database");

        } catch (Exception e) {
            System.out.println("❌ Data insertion failed");
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
}

