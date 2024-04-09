package BankManagementSystem;

import java.sql.*;
public class Conn {

    Connection c;                   //for connection of drive
    Statement s;                    //for statement use
    public Conn(){
        try{
            //step 1 : Register the drive
           //Class.forName(com.mysql.cj.jdbc.Driver); no need this line driver fetch path for libary
           //step 2 : create connention
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");      //bankmanagementsystem database names
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}