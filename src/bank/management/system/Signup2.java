package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    JTextField textPan,textAadhar;
    JRadioButton seniorYes,seniorNo,accountYes,accountNo;
    JButton next;
    String formno;

    Signup2(String formno){

        this.formno=formno;

        setTitle("APPLICATION FORM - PAGE 2");

        JLabel label1=new JLabel("Page 2 : Additional Details");
        label1.setFont(new Font("System",Font.BOLD,25));
        label1.setBounds(250,40,400,40);
        add(label1);


        JLabel religion=new JLabel("Religion:");
        religion.setBounds(100,120,200,30);
        add(religion);

        String religionVal[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religionBox=new JComboBox(religionVal);
        religionBox.setBounds(300,120,400,30);
        add(religionBox);


        JLabel category=new JLabel("Category:");
        category.setBounds(100,170,200,30);
        add(category);

        String categoryVal[]={"General","OBC","SC","ST","Other"};
        categoryBox=new JComboBox(categoryVal);
        categoryBox.setBounds(300,170,400,30);
        add(categoryBox);


        JLabel income=new JLabel("Income:");
        income.setBounds(100,220,200,30);
        add(income);

        String incomeVal[]={"Null","<1,50,000","<2,50,000","<5,00,000","Up to 10,00,000","Above 10,00,000"};
        incomeBox=new JComboBox(incomeVal);
        incomeBox.setBounds(300,220,400,30);
        add(incomeBox);


        JLabel education=new JLabel("Education:");
        education.setBounds(100,270,200,30);
        add(education);

        String educationVal[]={"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        educationBox=new JComboBox(educationVal);
        educationBox.setBounds(300,270,400,30);
        add(educationBox);


        JLabel occupation=new JLabel("Occupation:");
        occupation.setBounds(100,320,200,30);
        add(occupation);

        String occupationVal[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupationBox=new JComboBox(occupationVal);
        occupationBox.setBounds(300,320,400,30);
        add(occupationBox);


        JLabel pan=new JLabel("PAN Number:");
        pan.setBounds(100,370,200,30);
        add(pan);

        textPan=new JTextField();
        textPan.setBounds(300,370,400,30);
        add(textPan);


        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setBounds(100,420,200,30);
        add(aadhar);

        textAadhar=new JTextField();
        textAadhar.setBounds(300,420,400,30);
        add(textAadhar);


        JLabel senior=new JLabel("Senior Citizen:");
        senior.setBounds(100,470,200,30);
        add(senior);

        seniorYes=new JRadioButton("Yes");
        seniorYes.setBounds(300,470,100,30);
        add(seniorYes);

        seniorNo=new JRadioButton("No");
        seniorNo.setBounds(450,470,100,30);
        add(seniorNo);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(seniorYes);
        bg1.add(seniorNo);


        JLabel account=new JLabel("Existing Account:");
        account.setBounds(100,520,200,30);
        add(account);

        accountYes=new JRadioButton("Yes");
        accountYes.setBounds(300,520,100,30);
        add(accountYes);

        accountNo=new JRadioButton("No");
        accountNo.setBounds(450,520,100,30);
        add(accountNo);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(accountYes);
        bg2.add(accountNo);


        next=new JButton("Next");
        next.setBounds(620,580,80,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850,700);
        setLocation(350,50);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent e){

        String religion=(String)religionBox.getSelectedItem();
        String category=(String)categoryBox.getSelectedItem();
        String income=(String)incomeBox.getSelectedItem();
        String education=(String)educationBox.getSelectedItem();
        String occupation=(String)occupationBox.getSelectedItem();

        String pan=textPan.getText();
        String aadhar=textAadhar.getText();

        String senior="";
        if(seniorYes.isSelected()) senior="Yes";
        else senior="No";

        String account="";
        if(accountYes.isSelected()) account="Yes";
        else account="No";


        try{

            if(pan.equals("") || aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Fill all fields");
                return;
            }

            Connn c=new Connn();

            String q="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+account+"')";

            c.statement.executeUpdate(q);

            setVisible(false);
            new Signup3(formno);
            
        }
        catch(Exception E){
            E.printStackTrace();
        }

    }


    public static void main(String[] args){

        new Signup2("");

    }

}