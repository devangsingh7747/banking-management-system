package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;

    Login(){

        setTitle("Bank Management System");

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(350,10,100,100);
        add(image);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setFont(new Font("System",Font.BOLD,30));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("System",Font.BOLD,20));
        label2.setBounds(150,190,200,30);
        add(label2);

        textField2 = new JTextField();
        textField2.setBounds(325,190,230,30);
        add(textField2);

        label3 = new JLabel("PIN:");
        label3.setFont(new Font("System",Font.BOLD,20));
        label3.setBounds(150,250,200,30);
        add(label3);

        passwordField3 = new JPasswordField();
        passwordField3.setBounds(325,250,230,30);
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon bg = new ImageIcon(
                ClassLoader.getSystemResource("Icons/backbg.png"));
        Image bg2 = bg.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bg2));
        background.setBounds(0,0,850,480);
        add(background);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        try{

            if(e.getSource()==button1){

                Connn c = new Connn();

                String cardno = textField2.getText();
                String pin = passwordField3.getText();

                String q = "select * from login where cardnumber='"+cardno+"' and pin='"+pin+"'";

                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){

                    setVisible(false);
                    new main_Class(pin);

                }else{

                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");

                }

            }else if(e.getSource()==button2){

                textField2.setText("");
                passwordField3.setText("");

            }else if(e.getSource()==button3){
                new Signup();
                setVisible(false);
            }

        }catch(Exception E){

            E.printStackTrace();

        }

    }

    public static void main(String[] args){

        new Login();

    }
}