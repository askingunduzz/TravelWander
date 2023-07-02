package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails , viewPersonalDetails , updatePersonalDetails , chechpackages , bookPackages , deletePersonalDetails, foods, famouspeople, back;
    JButton logout , calculator , about ,  Destinations , viewBookedHotels  , bookHotels , viewHotels ,viewPackages, Sehirler, funfacts;
    String username;
    public static String city_name;
    Dashboard(String username){
        this.username = username;

     
        setSize(1100, 750); 
        setLocationRelativeTo(null); 

      
        Sehirler dash=new Sehirler();
        dash.setVisible(false);
        int id=dash.getId();


        String[] sehir=new String[6];

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.gray);
      
        p1.setBounds(0,0,2550 , 95);
        add(p1);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = ((java.sql.Connection) con).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worldwander.city where city_id ="+id+";");


            while (resultSet.next()) {
                city_name = resultSet.getString("city_name");
                int city_id = resultSet.getInt("city_id");
                sehir[id] = city_name;

            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel heading = new JLabel(sehir[id]); 
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 60));
        heading.setBounds(60, 25, 500, 50);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.GRAY);
     
        p2.setBounds(0,65,300 , 1100);
        add(p2);

        back = new JButton("<");
        back.setBackground(Color.black);
        back.setForeground(Color.black);
        back.setBounds(10 ,  50 , 50 , 60);
        back.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        back.addActionListener(this);
        p2.add(back);

        chechpackages = new JButton("Places To Visit");
        chechpackages.setBounds(0,170,300,80);
        chechpackages.setBackground( new Color( 0,0,102));
        chechpackages.setForeground(Color.black);
        chechpackages.setFont(new Font( "Tohoma" , Font.PLAIN , 25) );
        chechpackages.setMargin( new Insets(0,0,0,0));
        chechpackages.addActionListener(this);
        p2.add(chechpackages);

        viewHotels = new JButton("Various Activities");
        viewHotels.setBounds(0,250,300,80);
        viewHotels.setBackground( new Color( 0,0,102));
        viewHotels.setForeground(Color.black);
        viewHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 25) );
        viewHotels.setMargin( new Insets(0,0,0,0));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        foods = new JButton("Foods");
        foods.setBounds(0,330,300,80);
        foods.setBackground( new Color( 0,0,102));
        foods.setForeground(Color.black);
        foods.setFont(new Font( "Tohoma" , Font.PLAIN , 25) );
        foods.setMargin( new Insets(0,0,0,0));
        foods.addActionListener(this);
        p2.add(foods);

        famouspeople = new JButton("Famous People");
        famouspeople.setBounds(0,410,300,80);
        famouspeople.setBackground( new Color( 0,0,102));
        famouspeople.setForeground(Color.black);
        famouspeople.setFont(new Font( "Tohoma" , Font.PLAIN , 25) );
        famouspeople.setMargin( new Insets(0,0,0,0));
        famouspeople.addActionListener(this);
        p2.add(famouspeople);

        funfacts = new JButton("Facts");
        funfacts.setBounds(0,490,300,80);
        funfacts.setBackground( new Color( 0,0,102));
        funfacts.setForeground(Color.black);
        funfacts.setFont(new Font( "Tohoma" , Font.PLAIN , 25) );
        funfacts.setMargin( new Insets(0,0,0,0));
        funfacts.addActionListener(this);
        p2.add(funfacts);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/iki.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(65, 95, 1100, 750);
        add(NewLabel);



        JButton allFoodsButton = new JButton("Click Here for More");
        allFoodsButton.setBounds(0, 600, 300, 40);
        allFoodsButton.addActionListener(e -> {
          
           
          
         //  new OrtakSehir();
            setVisible(false);
            new ortaklar().setVisible(true);
        });
        p2.add(allFoodsButton);

        setVisible(true);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==addPersonalDetails ){
            setVisible(false);
            new AddCustomer(username);
        }
        else if( ae.getSource() == chechpackages){
              setVisible(false);
            new GezilecekYerler();
            //  new CheckPackage().setVisible(true);
        }

        else if( ae.getSource() == back){
            setVisible(false);
            new StartPage(getName());
        }
        else if(ae.getSource()==foods){
            setVisible(false);
            new Food().setVisible(true);
        }
        else if(ae.getSource()==famouspeople){
            setVisible(false);
            new FamousPeople().setVisible(true);
        }
        else if(ae.getSource()==viewHotels){

            setVisible(false);
            new Calender().setVisible(true);
        }
        else if( ae.getSource() == funfacts){
            setVisible(false);
            new Facts().setVisible(true);
        }

        else if( ae.getSource() == deletePersonalDetails ){
            setVisible(false);
            new DeleteCustomerDetails(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}