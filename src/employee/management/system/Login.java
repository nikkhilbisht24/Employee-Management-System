package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    //we have declared them globally bcz textfield contain username and pass which we have to match with database.
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;

    Login(){

        //for making any text visible on frame.
        JLabel username = new JLabel("Username: ");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password: ");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);// button background color
        login.setForeground(Color.WHITE); //text color
        login.addActionListener(this); //whenever a button is pressed we get to know in the override function.
        add(login);

        back = new JButton("BACK");

        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);// button background color
        back.setForeground(Color.WHITE); //text color
        back.addActionListener(this);
        add(back);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22=i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);


        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try {
                String username=tusername.getText(); // extracting the text from tusername.
                String password=tpassword.getText(); // extracting the password from tpassword.

                conn conn=new conn(); //creating object of connection class.

                //we have to create a query to check that the text which we have extracted from textfield matches with db or not.
                String query="select * from login where username='"+username+"' and password='"+password+"'";
                ResultSet resultSet=conn.statement.executeQuery(query);// running the query if data matches it get stores in resultSet.
                if(resultSet.next()){
                    //if data arrives in resultSet & get matches then we need to close the login frame & open new frame.
                    setVisible(false);
                    new main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            System.exit(0); // exiting the frame
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
