package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField textField;
    JButton withdraw, back;
    String pin;

    Withdrawal(String pin){

        this.pin = pin;

        setTitle("Withdrawal");

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(150,50,400,30);
        add(label1);

        textField = new JTextField();
        textField.setBounds(150,100,300,30);
        add(textField);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(150,160,130,30);
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("BACK");
        back.setBounds(320,160,130,30);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==withdraw){

            String amount = textField.getText();

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Amount");
                return;
            }

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

        }else if(e.getSource()==back){

            setVisible(false);
            new main_Class(pin);
        }

    }
}