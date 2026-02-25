package bank.management.system;

import javax.swing.*;

public class IconTest extends JFrame {

    IconTest(){

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("Icons/bank.png"));

        JLabel image = new JLabel(i1);
        image.setBounds(50,50,200,200);
        add(image);

        setLayout(null);
        setSize(400,400);
        setLocation(500,200);
        setVisible(true);
    }

    public static void main(String[] args) {

        new IconTest();

    }
}
