package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main_Class extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastcash, ministatement, balanceenquiry, exit;
    String pin;

    main_Class(String pin){

        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(230,300,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(170,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355,485,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==deposit){

            setVisible(false);
            new Deposit(pin);

        }else if(e.getSource()==withdraw){

            setVisible(false);
            new Withdrawal(pin);

        }else if(e.getSource()==fastcash){

            setVisible(false);
            new FastCash(pin);

        }else if(e.getSource()==ministatement){

            new Mini(pin);

        }else if(e.getSource()==balanceenquiry){

            setVisible(false);
            new BalanceEnquiry(pin);

        }else if(e.getSource()==exit){

            System.exit(0);

        }
    }
}