
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPage extends JFrame implements ActionListener {

    JButton addPersonalDetails , viewPersonalDetails , updatePersonalDetails , chechpackages , bookPackages , deletePersonalDetails, back;
    JButton logout , calculator , about , payment , Destinations , viewBookedHotels  , bookHotels , viewHotels ,viewPackages;
    String username;
    JLabel about2, about3, about4,about5, imageLabel;

    StartPage(String username){
        this.username = username;

       setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setLayout(null);

    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(Color.gray);
   
    p1.setBounds(0,0,2050 , 95);
    add(p1);

    JLabel heading = new JLabel("TravelWander");
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 45));
        
        heading.setBounds(20, 30, 500, 50);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
       
       p2.setBackground(Color.gray);
        p2.setBounds(0,45,300 , 900);
        add(p2);

        addPersonalDetails = new JButton("Add personal Details");
        addPersonalDetails.setBounds(0,100,300,50);
        addPersonalDetails.setBackground( new Color( 0,0,102));
        addPersonalDetails.setForeground(Color.black);
        addPersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        
        addPersonalDetails.setMargin( new Insets(0,0,0,0));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,160,300,50);
        updatePersonalDetails.setBackground( new Color( 0,0,102));
        updatePersonalDetails.setForeground(Color.black);
        updatePersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        

        updatePersonalDetails.setMargin( new Insets(0,0,0,0));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);   
        
        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,220,300,50);
        viewPersonalDetails.setBackground( new Color( 0,0,102));
        viewPersonalDetails.setForeground(Color.black);
        viewPersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        
        viewPersonalDetails.setMargin( new Insets(0,0,0,0));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

         deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,280,300,50);
        deletePersonalDetails.setBackground( new Color( 0,0,102));
        deletePersonalDetails.setForeground(Color.black);
        deletePersonalDetails.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        
        deletePersonalDetails.setMargin( new Insets(0,0,0,0));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        chechpackages = new JButton("Discover Cities");
        chechpackages.setBounds(0,340,300,50);
        chechpackages.setBackground( new Color( 0,0,102));
        chechpackages.setForeground(Color.black);
        chechpackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        chechpackages.setMargin( new Insets(0,0,0,0));
        chechpackages.addActionListener(this);
        p2.add(chechpackages);


        JButton button2 = new JButton("Other Info");
        button2.setBounds(0,650,300,50);
        button2.setBackground( new Color( 0,0,102));
        button2.setForeground(Color.black);
        button2.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button2.setMargin( new Insets(0,0,0,0));
        button2.addActionListener(e -> {
         setVisible(false);
          new newPage();
        });
        p2.add(button2);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/foto.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1250, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(250, 50, 1250, 750);
        add(NewLabel);

        JLabel showname = new JLabel("Journey beyond the beaten path with TravelWander! "+username+"");
        showname.setBounds(555 , 30 , 550 , 45);
        showname.setForeground(Color.black);
        showname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));

        p1.add(showname);

    


about2 = new JLabel("Located On: Asia");

about2.setBounds(20, 400, 600, 50);
about2.setForeground(Color.black);
about2.setFont(new Font("Tohoma", Font.PLAIN, 20));
p2.add(about2);

about3 = new JLabel("Language: Turkish");

about3.setBounds(20, 430, 600, 50);
about3.setForeground(Color.black);
about3.setFont(new Font("Tohoma", Font.PLAIN, 20));
p2.add(about3);

about4 = new JLabel("Population: 84.78 mil");

about4.setBounds(20, 460, 600, 50);
about4.setForeground(Color.black);
about4.setFont(new Font("Tohoma", Font.PLAIN, 20));
p2.add(about4);



JPanel paragraphPanel = new JPanel();

paragraphPanel.setBackground(new Color(0, 0, 0, 0)); 


paragraphPanel.setBounds(20, 500, 350, 300); 
p2.add(paragraphPanel);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==addPersonalDetails ){
            new AddCustomer(username);
        }

        else if( ae.getSource() == viewPersonalDetails){
            new ViewCustomer().setVisible(true);
        }
        else if( ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username).setVisible(true);
        }
        else if( ae.getSource() == chechpackages){
            setVisible(false);
           new Sehirler();
        }

        else if( ae.getSource() == deletePersonalDetails ){
                new DeleteCustomerDetails(username);
        }
    }

    public static void main(String[] args) {
        new StartPage("");
    }
}

