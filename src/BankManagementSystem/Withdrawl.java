package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;
    Withdrawl(String pinnumber){

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
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);              // for text image chya vr sati

        // for deposit button ----------------------------------------------------------------------------------
        withdrawl = new JButton("Withdraw");                                 //create a deposit button
        withdrawl.setBounds(355,485,150,30);                  // location of deposit button
        image.add(withdrawl);                                                    // adding deposit  button
        withdrawl.addActionListener(this);                                       //when user fit the login button-->it will take action

        // for back button ----------------------------------------------------------------------------------
        back = new JButton("Back");                                 //create a back button
        back.setBounds(355,520,150,30);                  // location of back button
        image.add(back);                                                    // adding back  button
        back.addActionListener(this);                                       //when user fit the login button-->it will take action

        // for amount box
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);


        //color the frame  -------------------------------------------------------------------------------------
        getContentPane().setBackground(Color.WHITE);            // color class using to background of frame white

        // creation of frame ----------------------------------------------------------------------
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public  static void main(String args[]){
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdrawl){
            String number  = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "' , '" + date + "', 'Withdrawl', '" + number + "' )";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Withdraw successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
}
