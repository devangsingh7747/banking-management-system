package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton back;

    BalanceEnquiry(String pin){

        this.pin = pin;

        setTitle("Balance Enquiry");

        JLabel label1 = new JLabel("Your Current Balance is:");
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(120,50,300,30);
        add(label1);

        label2 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(180,100,200,30);
        add(label2);

        back = new JButton("BACK");
        back.setBounds(180,180,100,30);
        back.addActionListener(this);
        add(back);

        int balance = 0;

        try{

            Connn c = new Connn();

            ResultSet rs = c.statement.executeQuery(
                    "select * from bank where pin='"+pin+"'");

            while(rs.next()){

                if(rs.getString("type").equals("Deposit")){

                    balance += Integer.parseInt(rs.getString("amount"));

                }else{

                    balance -= Integer.parseInt(rs.getString("amount"));

                }
            }

            label2.setText("Rs "+balance);

        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        setSize(500,300);
        setLocation(500,250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        setVisible(false);
        new main_Class(pin);
    }
}