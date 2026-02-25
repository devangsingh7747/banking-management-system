package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin){

        this.pin = pin;

        setTitle("Fast Cash");

        JLabel label1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(180,50,300,30);
        add(label1);

        b1 = new JButton("100");
        b1.setBounds(100,120,100,40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("500");
        b2.setBounds(250,120,100,40);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("1000");
        b3.setBounds(400,120,100,40);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("2000");
        b4.setBounds(100,200,100,40);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("5000");
        b5.setBounds(250,200,100,40);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("10000");
        b6.setBounds(400,200,100,40);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(250,300,120,40);
        b7.addActionListener(this);
        add(b7);

        setLayout(null);
        setSize(600,400);
        setLocation(500,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b7){

            setVisible(false);
            new main_Class(pin);
            return;
        }

        String amount = ((JButton)e.getSource()).getText();

        try{

            Connn c = new Connn();

            String q = "insert into bank values('"+pin+"','"+new Date()+"','Withdrawal','"+amount+"')";
            c.statement.executeUpdate(q);

            JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn Successfully");

            setVisible(false);
            new main_Class(pin);

        }catch(Exception E){
            E.printStackTrace();
        }

    }
}