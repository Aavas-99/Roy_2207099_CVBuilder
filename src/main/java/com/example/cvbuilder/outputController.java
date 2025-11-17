package com.example.cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class outputController {

    @FXML private Label FullName, Email, Phone, Address;
    @FXML private Label lblSSC, lblSSCGroup, lblSSCGPA;
    @FXML private Label lblHSC, lblHSCGroup, lblHSCGPA;
    @FXML private Label lblHons, lblHonsDept, lblHonsCGPA;
    @FXML private Label lblOrg1, lblFrom1, lblTo1;
    @FXML private Label lblOrg2, lblFrom2, lblTo2;
    @FXML private Label lblOrg3, lblFrom3, lblTo3;

    @FXML private Label lblSkills;

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

        lblSSC.setText(ssc);
        lblSSCGroup.setText(sscGroup);
        lblSSCGPA.setText(sscGPA);

        lblHSC.setText(hsc);
        lblHSCGroup.setText(hscGroup);
        lblHSCGPA.setText(hscGPA);

        lblHons.setText(hons);
        lblHonsDept.setText(honsDept);
        lblHonsCGPA.setText(honsCGPA);

        lblOrg1.setText(org1);
        lblFrom1.setText(from1);
        lblTo1.setText(to1);

        lblOrg2.setText(org2);
        lblFrom2.setText(from2);
        lblTo2.setText(to2);

        lblOrg3.setText(org3);
        lblFrom3.setText(from3);
        lblTo3.setText(to3);

        lblSkills.setText(skills);
    }
}
