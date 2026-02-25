package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

    JTextField textName,textFname,textEmail,textAdd,textCity,textPin,textState;
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    JSpinner dateSpinner;

    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L)+1000L;
    String formno = ""+Math.abs(first4);

    Signup(){

        setTitle("APPLICATION FORM");

        JLabel label1 = new JLabel("APPLICATION FORM NO. "+formno);
        label1.setFont(new Font("System",Font.BOLD,30));
        label1.setBounds(140,20,600,40);
        add(label1);

        JLabel label2 = new JLabel("Personal Details");
        label2.setFont(new Font("System",Font.BOLD,22));
        label2.setBounds(290,80,400,30);
        add(label2);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(100,150,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setBounds(300,150,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father Name:");
        labelfName.setBounds(100,200,200,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setBounds(300,200,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setBounds(100,250,200,30);
        add(DOB);

        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setBounds(300,250,400,30);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy"));
        add(dateSpinner);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,300,200,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(300,300,100,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(450,300,100,30);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel email = new JLabel("Email:");
        email.setBounds(100,350,200,30);
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(300,350,400,30);
        add(textEmail);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100,400,200,30);
        add(marital);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,400,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(450,400,120,30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(600,400,100,30);
        add(m3);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(m1);
        bg2.add(m2);
        bg2.add(m3);

        JLabel address = new JLabel("Address:");
        address.setBounds(100,450,200,30);
        add(address);

        textAdd = new JTextField();
        textAdd.setBounds(300,450,400,30);
        add(textAdd);

        JLabel city = new JLabel("City:");
        city.setBounds(100,500,200,30);
        add(city);

        textCity = new JTextField();
        textCity.setBounds(300,500,400,30);
        add(textCity);

        JLabel pin = new JLabel("Pin Code:");
        pin.setBounds(100,550,200,30);
        add(pin);

        textPin = new JTextField();
        textPin.setBounds(300,550,400,30);
        add(textPin);

        JLabel state = new JLabel("State:");
        state.setBounds(100,600,200,30);
        add(state);

        textState = new JTextField();
        textState.setBounds(300,600,400,30);
        add(textState);

        next = new JButton("Next");
        next.setBounds(620,650,80,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(350,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        System.out.println("Next Button Clicked");

        String name = textName.getText();
        String fname = textFname.getText();

        Date selectedDate = (Date) dateSpinner.getValue();
        String dob = new SimpleDateFormat("dd-MM-yyyy").format(selectedDate);

        String gender="";
        if(r1.isSelected()) gender="Male";
        else if(r2.isSelected()) gender="Female";

        String email = textEmail.getText();

        String marital="";
        if(m1.isSelected()) marital="Married";
        else if(m2.isSelected()) marital="Unmarried";
        else if(m3.isSelected()) marital="Other";

        String address=textAdd.getText();
        String city=textCity.getText();
        String pin=textPin.getText();
        String state=textState.getText();

        try{

            Connn c = new Connn();

            String q="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";

            c.statement.executeUpdate(q);

            System.out.println("Signup1 Data Inserted");

            setVisible(false);
            new Signup2(formno);

        } catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){

        new Signup();

    }
}