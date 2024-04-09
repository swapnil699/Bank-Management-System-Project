package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        // set the title ----------------------------------------------------------------
        setTitle("Automated Teller Machine");

        setLayout(null);                //default layout of board of center to change null.

        //for logo image icon-------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //for adjement of image icon
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);      // image convert to image icon
        JLabel label = new JLabel(i3);
        //for change logo icon location
        label.setBounds(70,10,100,100);
        add(label);

        //adding one welcome lable -------------------------------------------------------
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD, 38));         // set a font
        text.setBounds(200,40,400,40);                  // location
        add(text);                                                         // adding

        //for  card no label --------------------------------------------------------------
        JLabel cardno = new JLabel("Card No : ");
        cardno.setFont(new Font("Raleway",Font.BOLD, 28));         // set a font
        cardno.setBounds(120,150,150,30);                  // location
        add(cardno);                                                         // adding

        cardTextField = new JTextField();                                     // for text box
        cardTextField.setBounds(300,150,230,30);           // location
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));    //font & color
        add(cardTextField);                                                   //adding cardTextField

        //for  pin label ---------------------------------------------------------------
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD, 28));         // set a font
        pin.setBounds(120,220,250,30);                  // location
        add(pin);                                                         // adding

        pinTextField = new JPasswordField();                                 // for text box
        pinTextField.setBounds(300,220,230,30);           // location of pinTextField text
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));    //font & color
        add(pinTextField);                                                   //adding pinTextField box

        //for 'SIGN IN' button ----------------------------------------------------------
        login = new JButton("SIGN IN");                          //create a sing in button
        login.setBounds(300,300,100,30);                   //location of sign in button
        add(login);                                                           //adding sign in button
        login.addActionListener(this);                                       //when user fit the login button-->it will take action
        login.setBackground(Color.BLACK);                                     //setting a background with black
        login.setForeground(Color.WHITE);                                     //setting a fornt color with white

        //for 'clear' button ------------------------------------------------------------------------
        clear = new JButton("CLEAR");                                     //create a clear  button
        clear.setBounds(430,300,100,30);                    //location of clear  button
        add(clear);                                                           //adding clear  button
        clear.addActionListener(this);                                       //when user fit the login button-->it will take action
        clear.setBackground(Color.BLACK);                                     //setting a background with black
        clear.setForeground(Color.WHITE);                                     //setting a fornt color with white

        //for 'SIGN UP' button --------------------------------------------------------------------
        signup = new JButton("SIGN UP");                          //create a signup  button
        signup.setBounds(300,350,230,30);                   //location of signup button
        add(signup);                                                           //adding signup button
        signup.addActionListener(this);                                       //when user fit the login button-->it will take action
        signup.setBackground(Color.BLACK);                                     //setting a background with black
        signup.setForeground(Color.WHITE);                                     //setting a fornt color with white

        //color the frame  --------------------------------------------------------------------------
        getContentPane().setBackground(Color.WHITE);            // color class using to background of frame white

        // creation of frame ----------------------------------------------------------------------
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }



    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == clear){
            cardTextField.setText("");     //when user hits clear--> empty means it show empty
            pinTextField.setText("");      //when user hits clear--> empty means it show empty
            //setText() we will set the value
        }
        else if (ae.getSource() == login) {

        }
        else if (ae.getSource() == signup) {
            setVisible(false);             //when user hits the signup
            new SignupOne().setVisible(true);
        }
    }
}
