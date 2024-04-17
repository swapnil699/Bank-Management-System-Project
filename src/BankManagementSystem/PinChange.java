package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JLabel text, pintext, repintext;
    JPasswordField pin, repin;
    JButton change,back;
    String pinnummber;
    PinChange(String pinnumber){
        this.pinnummber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        // for text lable
        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        // for pintext lable-----------------------------------------
        pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        // for pin box
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        // for repintext lable-------------------------------------------
        repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        // for pin box
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,22));
        repin.setBounds(330,360,180,25);
        image.add(repin);


        //for change button
        change = new JButton("CHANGE");                                 //create a deposit button
        change.setBounds(355,485,150,30);                  // location of deposit button
        image.add(change);                                                    // adding deposit  button
        change.addActionListener(this);                                       //when user fit the login button-->it will take action

        //for back button
        back = new JButton("BACK");                                 //create a deposit button
        back.setBounds(355,520,150,30);                  // location of deposit button
        image.add(back);                                                    // adding deposit  button
        back.addActionListener(this);                                       //when user fit the login button-->it will take action


        // --------------------------------------
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);                 // for removeming above the frame (like ex. close)
        setVisible(true);
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (! npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pinnummber + "'";
                String query2 = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pinnummber + "'";
                String query3 = "UPDATE signupthree SET pinnumber = '" + rpin + "' WHERE pinnumber = '" + pinnummber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnummber).setVisible(true);
        }
    }
}
