package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class HelloController {
    @FXML
    private Button cancelButton;
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Label loginmessagelabel;
     @FXML
     private TextField usernameTextField;
     @FXML
     private PasswordField passwordPasswordField;
     @FXML
     private Button loginbutton;
     public  void loginButtonAction(ActionEvent e) throws Exception{

        if(usernameTextField.getText().isBlank()==false  &&  passwordPasswordField.getText().isBlank()==false){
           // loginmessagelabel.setText("Enter valid details");
            validatelogin();
        }
        else{
            loginmessagelabel.setText("Please enter the username & password");
        }
    }
    public void validatelogin() throws Exception{
         DatabaseConnection connectnow=new DatabaseConnection();
         Connection connectDB= connectnow.getConnection();
        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = '"+ usernameTextField.getText() + "' AND password = '"+ passwordPasswordField.getText() +"'";

        try{
             Statement statement= connectDB.createStatement();
             ResultSet queryResult=statement.executeQuery(verifyLogin);

             while (queryResult.next()){
                 if(queryResult.getInt(1)==1){
                     //loginmessagelabel.setText("Welcome");
                     FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
                     Stage window=(Stage)loginbutton.getScene().getWindow();
                     window.setScene(new Scene(fxmlLoader.load(),600 , 400));
                 }
                 else{
                        loginmessagelabel.setText("Invalid credentials");
                 }
             }
         }
         catch (Exception e){
                e.printStackTrace();
         }

//

    }



}