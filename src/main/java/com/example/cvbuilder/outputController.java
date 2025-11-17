package com.example.cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    private Label Skills;

    public void setData(String fullName, String email, String phone, String address,
                        String ssc, String sscGroup, String sscGPA,
                        String hsc, String hscGroup, String hscGPA,
                        String hons, String honsDept, String honsCGPA,
                        String org1, String from1, String to1,
                        String org2, String from2, String to2,
                        String org3, String from3, String to3,
                        String skills) {

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
    }
}
