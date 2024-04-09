package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    //gobal variables
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male,female,other, married, unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);                                      //default layout of board of center to change null.

        //for generating random value
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        //for form no label -----------------------------------------------
        JLabel formno = new JLabel("APPLICATION FORM NO. "  +  random);       //label of formno
        formno.setFont(new Font("Raleway",Font.BOLD, 38));              // set of font of formno
        formno.setBounds(140,20,600,40);                        // set a location of formno
        add(formno);                                                              // adding a formno in frame

        //for personal details  -------------------------------------------
        JLabel personDetails = new JLabel("Page 1 : personal Details" );     //label of personal details
        personDetails.setFont(new Font("Raleway",Font.BOLD, 22));      //set of font of personal details
        personDetails.setBounds(290,80,400,30);                 // set a location of personal details
        add(personDetails);                                                        // adding a personal details in frame

        //for name label ----------------------------------------
        JLabel name = new JLabel("Name: " );                        //label of name
        name.setFont(new Font("Raleway",Font.BOLD, 20));      //set of font of name
        name.setBounds(100,140,100,30);                 // set a location of name
        add(name);                                                        // adding a name in frame

        nameTextField = new JTextField();                           // box for name nameTextField
        nameTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        nameTextField.setBounds(300, 140, 400,30);          // set the location
        add(nameTextField);                                                    //adding in frame

        //for fname label ------------------------------------
        JLabel fname = new JLabel("Father's Name: " );                       //label of fname
        fname.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of fname
        fname.setBounds(100,190,200,30);                       // set a location of fname
        add(fname);                                                               // adding a fname in frame

        fnameTextField = new JTextField();                           // box for name nameTextField
        fnameTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        fnameTextField.setBounds(300, 190, 400,30);          // set the location
        add(fnameTextField);                                                    //adding in frame

        //for date of birth label -----------------------
        JLabel dob = new JLabel("Date of Birth: " );                       //label of dob
        dob.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of dob
        dob.setBounds(100,240,200,30);                       // set a location of dob
        add(dob);                                                               // adding a dob in frame


        dateChooser = new JDateChooser();                         //JDateChooser for date select
        dateChooser.setBounds(300,240,400,30);              // set the location of dateChooser
        dateChooser.setFont(new Font("Raleway",Font.BOLD, 20));      //set of font of dateChooser
        add(dateChooser);                                                      // adding in frame

        //for gender label ------------------------------
        JLabel gender = new JLabel("Date of Birth: " );                       //label of gender
        gender.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of gender
        gender.setBounds(100,290,200,30);                       // set a location of gender
        add(gender);                                                               // adding a gender in frame

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);                       // set a location of gender
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);                       // set a location of gender
        female.setBackground(Color.WHITE);
        add(female);

        //for select gender only option
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        //for email label -------------------------------
        JLabel email = new JLabel("Email Address: " );                       //label of email
        email.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of email
        email.setBounds(100,340,200,30);                       // set a location of email
        add(email);                                                               // adding email in frame

        emailTextField = new JTextField();                           // box for name nameTextField
        emailTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        emailTextField.setBounds(300, 340, 400,30);          // set the location
        add(emailTextField);                                                    //adding in frame

        //for marital label  --------------------------------------
        JLabel marital = new JLabel("Marital Status: " );                       //label of marital
        marital.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of marital
        marital.setBounds(100,390,200,30);                       // set a location of marital
        add(marital);                                                               // adding a marital in frame

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);                       // set a location of gender
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);                       // set a location of gender
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);                       // set a location of gender
        other.setBackground(Color.WHITE);
        add(other);

        //for select status of married only option
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        //for address label  ----------------------------------------
        JLabel address = new JLabel("Address: " );                             //label of address
        address.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of address
        address.setBounds(100,440,200,30);                       // set a location of address
        add(address);                                                               // adding  address in frame

        addressTextField = new JTextField();                           // box for name nameTextField
        addressTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        addressTextField.setBounds(300, 440, 400,30);          // set the location
        add(addressTextField);                                                    //adding in frame

        //for city label  -------------------------------------------
        JLabel city = new JLabel("City: " );                             //label of city
        city.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of city
        city.setBounds(100,490,200,30);                       // set a location of city
        add(city);                                                               // adding a city in frame

        cityTextField = new JTextField();                           // box for name nameTextField
        cityTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        cityTextField.setBounds(300, 490, 400,30);          // set the location
        add(cityTextField);                                                    //adding in frame

        //for state label  --------------------------------------------
        JLabel state = new JLabel("State: " );                             //label of state
        state.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of state
        state.setBounds(100,540,200,30);                       // set a location of state
        add(state);                                                               // adding a state in frame

        stateTextField = new JTextField();                           // box for name nameTextField
        stateTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        stateTextField.setBounds(300, 540, 400,30);          // set the location
        add(stateTextField);                                                    //adding in frame

        //for pincode label ---------------------------------------------
        JLabel pincode = new JLabel("Pin Code: " );                             //label of pincode
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));              //set of font of pincode
        pincode.setBounds(100,590,200,30);                       // set a location of pincode
        add(pincode);                                                               // adding a pincode in frame

        pinTextField = new JTextField();                           // box for name nameTextField
        pinTextField.setFont(new Font("Raleway",Font.BOLD, 14));   //set of font
        pinTextField.setBounds(300, 590, 400,30);          // set the location
        add(pinTextField);                                                    //adding in frame

        //for create a next button ------------------------------------
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this);                           // for taking action when user click on next

        // --------------------------------------------------------------------------------
        getContentPane().setBackground(Color.WHITE);                //background white for frame

        //creation of frame  -------------------------------------------------------------
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public static void main(String args[]){

        new SignupOne();
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;             //random is long we convert into long to string
        String name = nameTextField.getText();   //getText we will get the value
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marrital = null;
        if(married.isSelected()){
            marrital = "Married";
        } else if (unmarried.isSelected()) {
            marrital = "Unmarried";
        } else if (other.isSelected()) {
            marrital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
