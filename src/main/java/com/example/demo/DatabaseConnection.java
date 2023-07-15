package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String dbname="pradeep";
        String dbuser="root";
        String dbpassword="pradeep@3238";
        String url="jdbc:mysql://localhost/" + dbname;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url, dbuser,dbpassword);
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return databaseLink;
    }
}