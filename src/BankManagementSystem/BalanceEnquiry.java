package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnummber;
    BalanceEnquiry(String pinnumber){

        this.pinnummber = pinnumber;
        JButton back;
        setLayout(null);
        //for image -------------------------------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //for back button
        back = new JButton("Back");
        back.setBounds(355,520,150,30);                  // location of deposit button
        image.add(back);                                                    // adding deposit  button
        back.addActionListener(this);                                       //when user fit the login button-->it will take action

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs =conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            }
            catch(Exception e){
                System.out.println(e);
            }

            JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170,300,400,30);
            image.add(text);

        //color the frame  -------------------------------------------------------------------------------------
        getContentPane().setBackground(Color.WHITE);            // color class using to background of frame white

        // creation of frame ----------------------------------------------------------------------
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);                 // for removeming above the frame (like ex. close)
        setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnummber).setVisible(true);
    }
}
