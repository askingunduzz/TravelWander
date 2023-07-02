package travel.management.system;


import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.*;

public class StartWithA extends JFrame {
    public static void main(String[] args) {
        new StartWithA().setVisible(true);
    }

//FOODS THAT START WITH A


        String[] sehirler = new String[10];
       
public void StartWithA() {

    System.out.println("aa");
    try {
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
       
        java.sql.Statement statement = con.createStatement();
    
        ResultSet resultSet = statement.executeQuery("SELECT food_name FROM worldwander.foods WHERE food_name LIKE 'A%';");
      
        
        int i = 0;
      
        while (resultSet.next() && i < sehirler.length) {
            
            String city = resultSet.getString("food_name");
       
            sehirler[i] = city;
         
            i++;
        }

       

        con.close();


    } catch (SQLException e) {
        e.printStackTrace();
    }
}

StartWithA() {
    setBounds(440, 200, 400, 430);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(Color.gray);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout()); 
    buttonPanel.setBackground(Color.gray);

    StartWithA(); 


    JButton button1 = new JButton(sehirler[0]);
    JButton button2 = new JButton(sehirler[1]);
    JButton button3 = new JButton(sehirler[2]);

   
    Font buttonFont = new Font("Tahoma", Font.PLAIN, 20);
    Dimension buttonSize = new Dimension(250, 150);
    
  
    button1.setFont(buttonFont);
    button2.setFont(buttonFont);
    button3.setFont(buttonFont);
    button1.setPreferredSize(buttonSize);
    button2.setPreferredSize(buttonSize);
    button3.setPreferredSize(buttonSize);
    
 
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(10, 10, 10, 10); // Add padding
    buttonPanel.add(button1, gbc);
    gbc.gridy = 1;
    buttonPanel.add(button2, gbc);
    gbc.gridy = 2;
    gbc.gridx = 0;
    buttonPanel.add(button3, gbc);

    mainPanel.add(buttonPanel, BorderLayout.CENTER);

    JButton backButton = new JButton("<");
    backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
    backButton.addActionListener(e -> {
        setVisible(false);
        // new Dashboard("").setVisible(true);
        new ortaklar();
    });
    mainPanel.add(backButton, BorderLayout.SOUTH);

    add(mainPanel);
    setVisible(true);
}

}