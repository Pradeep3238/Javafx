package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MainController {
    @FXML
    private TextField studenttextfield;
    @FXML
    private Button answerbutton;
    @FXML
    private Label answerlabel;
    @FXML
    private Button exitbutton;
    @FXML
    private TextField hallcount;
    @FXML
    private Label warnlabel;

    public void exitButtonOnAction(ActionEvent er){
        Stage stage=(Stage)exitbutton.getScene().getWindow();
        stage.close();
    }

    public void answerbuttonOnAction(ActionEvent e) throws Exception {
        String ns = studenttextfield.getText();
        String nh= hallcount.getText();
        if (ns.isBlank() || nh.isBlank()) {
            warnlabel.setText("Please enter the required values");
        }
        else{
            try {
                int nos = Integer.parseInt(ns);
                int noh = Integer.parseInt(nh);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pradeep", "root", "pradeep@3238");
                Statement stm = con.createStatement();
                String sql = "INSERT INTO sdetails VALUES('" + nos + "','" + noh + "')";
                stm.executeUpdate(sql);
                int answr = nos / noh;
                answerlabel.setText(String.valueOf(answr) + " students per hall.");
            }
            catch (NumberFormatException er){
                warnlabel.setText("Enter a valid number");
            }
            }
    }
}
