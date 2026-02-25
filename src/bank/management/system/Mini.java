package bank.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Mini extends JFrame {

    String pin;

    Mini(String pin){

        this.pin = pin;

        setTitle("Mini Statement");

        JLabel label1 = new JLabel("Mini Statement");
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(150,20,200,30);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(20,80,350,300);
        add(label2);

        try{

            Connn c = new Connn();

            ResultSet rs = c.statement.executeQuery(
                    "select * from bank where pin='"+pin+"'");

            String text = "<html>";

            while(rs.next()){

                text += rs.getString("date")+" &nbsp;&nbsp;&nbsp; "
                        +rs.getString("type")+" &nbsp;&nbsp;&nbsp; Rs "
                        +rs.getString("amount")+"<br>";
            }

            text += "</html>";

            label2.setText(text);

        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        setSize(400,400);
        setLocation(600,200);
        setVisible(true);
    }
}