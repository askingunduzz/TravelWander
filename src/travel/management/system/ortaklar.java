package travel.management.system;
import java.sql.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.cj.xdevapi.Statement;

public class ortaklar extends JFrame {
  public static void main(String[] args) {
     	
	
    	
    	
        new ortaklar().setVisible(true);
    }

    ortaklar() {
        setBounds(300, 80, 600, 630);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.gray);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBackground(Color.gray);

        String ortakYemek = "Food That Are The Same in Cities: ";
        JButton button1 = new JButton(ortakYemek);
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button1.addActionListener(e -> {
            setVisible(false);
        
         new OrtakSehir();
 
        });
        buttonPanel.add(button1);

   
        String kelime[] = {"Foods That Start With 'A'"};
        JButton button3 = new JButton(kelime[0]);
        button3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button3.addActionListener(e -> {
            setVisible(false);
            new StartWithA();
   
        });
        buttonPanel.add(button3);
        
        String obj = "\n"
        		+ "SELECT 'Bursa' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Bursa'\n"
        		+ ")\n"
        		+ "UNION\n"
        		+ "SELECT 'Ankara' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Ankara'\n"
        		+ ")\n"
        		+ "UNION\n"
        		+ "SELECT 'Istanbul' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Istanbul'\n"
        		+ ")\n"
        		+ "UNION\n"
        		+ "SELECT 'Antalya' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Antalya'\n"
        		+ ")\n"
        		+ "UNION\n"
        		+ "SELECT 'Konya' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Konya'\n"
        		+ ")\n"
        		+ "UNION\n"
        		+ "SELECT 'Izmir' AS city_name\n"
        		+ "FROM foods\n"
        		+ "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n"
        		+ "    SELECT city_id FROM city WHERE city_name = 'Izmir'\n"
        		+ ");";
      
        
        
        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            setVisible(false);
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
}