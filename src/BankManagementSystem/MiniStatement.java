package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        // for text label -----------------------------
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        // for bank label ------------------------------
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        // for card label --------------------------
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        // for balance label --------------------------
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
           Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number : " +rs.getString("cardnumber").substring(0,4) + " XXXX XXXX " + rs.getString("cardnumber").substring(12));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account Balance Rs." + bal);
        }catch (Exception e){
            System.out.println(e);
        }

        // --------------------------------------
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);                 // for removeming above the frame (like ex. close)
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
