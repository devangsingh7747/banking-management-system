package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;

    String formno;

    Signup3(String formno) {
        this.formno = formno;

        setTitle("APPLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("System", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Type:");
        l2.setFont(new Font("System", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 180, 250, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 150, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JLabel l3 = new JLabel("Card Number:");
        l3.setFont(new Font("System", Font.BOLD, 18));
        l3.setBounds(100, 300, 200, 30);
        add(l3);

        JLabel l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setBounds(330, 300, 250, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setBounds(330, 330, 250, 20);
        add(l5);

        JLabel l6 = new JLabel("PIN:");
        l6.setFont(new Font("System", Font.BOLD, 18));
        l6.setBounds(100, 370, 200, 30);
        add(l6);

        JLabel l7 = new JLabel("XXXX");
        l7.setBounds(330, 370, 200, 30);
        add(l7);

        JLabel l8 = new JLabel("(4-digit Password)");
        l8.setBounds(330, 400, 200, 20);
        add(l8);

        JLabel l9 = new JLabel("Services Required:");
        l9.setFont(new Font("System", Font.BOLD, 18));
        l9.setBounds(100, 450, 200, 30);
        add(l9);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct");
        c7.setBounds(100, 650, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(250, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 700, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String accountType = "";

        if (r1.isSelected()) accountType = "Saving Account";
        else if (r2.isSelected()) accountType = "Fixed Deposit Account";
        else if (r3.isSelected()) accountType = "Current Account";
        else if (r4.isSelected()) accountType = "Recurring Deposit Account";

        Random random = new Random();
        String card = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

        String facility = "";

        if (c1.isSelected()) facility += " ATM Card";
        if (c2.isSelected()) facility += " Internet Banking";
        if (c3.isSelected()) facility += " Mobile Banking";
        if (c4.isSelected()) facility += " Email Alerts";
        if (c5.isSelected()) facility += " Cheque Book";
        if (c6.isSelected()) facility += " E-Statement";

        if(accountType.equals("")) {
            JOptionPane.showMessageDialog(null, "Account Type is Required");
            return;
        }
        
        if (!c7.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please Select the Declaration");
            return;
        }

        try {

            Connn c = new Connn();

            String q1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+card+"','"+pin+"','"+facility+"')";
            String q2 = "insert into login values('"+formno+"','"+card+"','"+pin+"')";

            c.statement.executeUpdate(q1);
            c.statement.executeUpdate(q2);

            JOptionPane.showMessageDialog(null, "Account Created Successfully");

            setVisible(false);
            new Login();

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Signup3("");
    }
}