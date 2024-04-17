package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceequiry, exit;
    String pinnumber;

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        //for image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2  = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //for text label
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);              // for text image chya vr sati

        // for deposit button ----------------------------------------------------------------------------------
        deposit = new JButton("Deposit");                                 //create a deposit button
        deposit.setBounds(170,415,150,30);                  // location of deposit button
        image.add(deposit);                                                    // adding deposit  button
        deposit.addActionListener(this);                                       //when user fit the login button-->it will take action

        // for withdrawl button ----------------------------------------------------------------------------------
        withdrawl = new JButton("Cash Withdrawl");                             // create a withdrawl button
        withdrawl.setBounds(355,415,150,30);                     // location of withdrawl button
        image.add(withdrawl);                                                       // adding withdrawl button
        withdrawl.addActionListener(this);                                       // when user fit the login button-->it will take action

        // for fastcash button ----------------------------------------------------------------------------------
        fastcash = new JButton("Fast Cash");                                    //create a fastcash button
        fastcash.setBounds(170,450,150,30);                       //location of fastcash button
        image.add(fastcash);                                                        //adding fastcash button
        fastcash.addActionListener(this);                                        //when user fit the login button-->it will take action

        // for ministatement button ----------------------------------------------------------------------------------
        ministatement = new JButton("Mini Statement");                           // create a ministatement button
        ministatement.setBounds(355,450,150,30);                   // location of ministatement button
        image.add(ministatement);                                                    // adding ministatement button
        ministatement.addActionListener(this);                                    // when user fit the login button-->it will take action

        // for pinchange button ----------------------------------------------------------------------------------
        pinchange = new JButton("Pin Change");                                  // create a pinchange button
        pinchange.setBounds(170,485,150,30);                      // location of pinchange button
        image.add(pinchange);                                                       // adding pinchange button
        pinchange.addActionListener(this);                                       // when user fit the login button-->it will take action

        // for balanceequiry button ----------------------------------------------------------------------------------
        balanceequiry = new JButton("Balance Enquiry");                             //create a balanceequiry button
        balanceequiry.setBounds(355,485,150,30);                      //location of balanceequiry button
        image.add(balanceequiry);                                                       //adding balanceequiry button
        balanceequiry.addActionListener(this);                                       //when user fit the login button-->it will take action

        // for exit button ----------------------------------------------------------------------------------
        exit = new JButton("Exit");                                         //create a exit button
        exit.setBounds(355,520,150,30);                       //location of exit button
        image.add(exit);                                                        //adding exit button
        exit.addActionListener(this);                            //when user fit the exit button-->it will take action -> close windown

        //color the frame  -------------------------------------------------------------------------------------
        getContentPane().setBackground(Color.WHITE);            // color class using to background of frame white

        // creation of frame ----------------------------------------------------------------------
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);                 // for removeming above the frame (like ex. close)
        setVisible(true);
    }
    public static void main(String args[]){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceequiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }
}
