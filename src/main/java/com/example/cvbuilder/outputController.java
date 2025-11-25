package com.example.cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class outputController {

    @FXML
    private Label FullName, Email, Phone, Address;
    @FXML
    private Label SSC, SSCGroup, SSCGPA;
    @FXML
    private Label HSC, HSCGroup, HSCGPA;
    @FXML
    private Label Hons, HonsDept, HonsCGPA;
    @FXML
    private Label Org1, From1, To1;
    @FXML
    private Label Org2, From2, To2;
    @FXML
    private Label Org3, From3, To3;
    @FXML
    private Label Skills, projects;
    private int userId;


    public void setData(int id,String fullName, String email, String phone, String address,
                        String ssc, String sscGroup, String sscGPA,
                        String hsc, String hscGroup, String hscGPA,
                        String hons, String honsDept, String honsCGPA,
                        String org1, String from1, String to1,
                        String org2, String from2, String to2,
                        String org3, String from3, String to3,
                        String skills, String Projects) {
        this.userId = id;
        FullName.setText(fullName);
        Email.setText(email);
        Phone.setText(phone);
        Address.setText(address);
        SSC.setText(ssc);
        SSCGroup.setText(sscGroup);
        SSCGPA.setText(sscGPA);
        HSC.setText(hsc);
        HSCGroup.setText(hscGroup);
        HSCGPA.setText(hscGPA);
        Hons.setText(hons);
        HonsDept.setText(honsDept);
        HonsCGPA.setText(honsCGPA);
        Org1.setText(org1);
        From1.setText(from1);
        To1.setText(to1);
        Org2.setText(org2);
        From2.setText(from2);
        To2.setText(to2);
        Org3.setText(org3);
        From3.setText(from3);
        To3.setText(to3);
        Skills.setText(skills);
        projects.setText(Projects);
    }
    @FXML
    public void onDeleteClicked(ActionEvent actionEvent) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✔ User deleted successfully!");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deleted");
                alert.setHeaderText(null);
                alert.setContentText("This CV entry has been deleted.");
                alert.showAndWait();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("❌ Delete failed");
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditClicked(ActionEvent actionEvent) {

    }
}
