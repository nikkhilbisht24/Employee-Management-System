package employee.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame{

    Splash(){
        //All the images that we have to put in frame so that logic should be above setSize and all other functions.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));// getting the image.
        Image i2=i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);// scaling the image.
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); //bringing image to label.
        image.setBounds(0,0,1170,650);// setting label dimensions.
        add(image);


        setSize(1170,650);  // frame size.
        setLocation(100,50); // x is dist from left to right and y is dist from top to bottom.
        setLayout(null);  //  we have to adjust text and images according to ourselves that's why null.
        setVisible(true); // visibility is false so we made it true.

        try{
            Thread.sleep(5000); // sleep time to close the frame after 5 sec.
            setVisible(false); // closing the frame
            new Login(); // after closing the frame to open login frame
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
