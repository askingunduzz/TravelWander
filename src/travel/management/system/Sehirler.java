package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sehirler extends JFrame implements Runnable {

    public static int id;
    JLabel[] label = new JLabel[6];
    JLabel caption;
    int deger;

    Thread t1;

    public int getId() {
        return id;
    }
 
    public static void setId(int value) {
        id = value;
    }
    
    Sehirler() {

        deger=1;
    


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300, 100, 800, 600);

        ImageIcon[] image = new ImageIcon[6];
        Image[] jimage = new Image[6];
        ImageIcon[] kimage = new ImageIcon[6];

        caption = new JLabel();
        caption.setBounds(50, 60, 1000, 90);
        caption.setFont(new Font("Thoma", Font.PLAIN, 100));
        caption.setForeground(Color.white);
        add(caption);


    
        for (int i = 0; i <= 5; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/sehir" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }
       
        for (int i = 0; i < label.length; i++) {
            final int index = i;
            label[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch (index) {
                        case 0:
                              id=0;
                              setVisible(false);
                            new Dashboard(getName());
                            break;
                        case 1:
                           id=1;
                          setVisible(false);
                              new Dashboard(getName());
 
                            break;
                        case 2:
                            id=2;
                            new Dashboard(getName());
                            setVisible(false);
                            break;
                        case 3:
                           id=3;
                            new Dashboard(getName());
                            setVisible(false);
                            break;
                        case 4:
                          id=4;
                            new Dashboard(getName());
                            setVisible(false);
                            break;
                        case 5:
                        id=5;
                            new Dashboard(getName());
                         
                            setVisible(false);
                            break;
                        case 6:
                        id=6;
                        setVisible(false);
                            new Dashboard(getName());
                      
                     
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }
   
    

    public static void main(String[] args) {
        new Sehirler();
    }
    @Override
    public void run() {
        String[] text = new String[6];
   
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = ((java.sql.Connection) con).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worldwander.city;");

            int i= 0;
            while (resultSet.next()) {
                String city_name = resultSet.getString("city_name");
                int city_id = resultSet.getInt("city_id");
                text[city_id] = city_name;
                i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            int index = 0;
            while (true) {
               label[index].setVisible(true);
                caption.setText(text[index]);
                Thread.sleep(4000); //4000
                label[index].setVisible(false);
                
                index = (index + 1) % label.length; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}