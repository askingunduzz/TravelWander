package travel.management.system;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Food extends JFrame {
    public static void main(String[] args) {
        new Food().setVisible(true);
    }

    Food() {
        Sehirler food=new Sehirler();
        food.setVisible(false);
        int id=food.getId();
        String[] fooods = new String[3];
        String[] imagess = new String[3];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = ((java.sql.Connection) con).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worldwander.foods where city_id ="+id+";");

            int i= 0;
            while (resultSet.next()) {
                String food_name = resultSet.getString("food_name");
                int city_id = resultSet.getInt("city_id");
                String images = resultSet.getString("images");
                fooods[i] = food_name;
                imagess[i]=images;
                i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        setBounds(400, 80, 650, 630);

        // yemek isimler çekilecek
        String[] images = {imagess[0],imagess[1],imagess[2]};
     
        String[] food1 = new String[]{images[0], fooods[0]};
        String[] food2 = new String[]{images[1], fooods[1]};
        String[] food3 = new String[]{images[2], fooods[2]};


        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(food1);
        tabbedPane.addTab(food1[1], null, p1);

        JPanel p2 = createPackage(food2);
        tabbedPane.addTab(food2[1], null, p2);

        JPanel p3 = createPackage(food3);
        tabbedPane.addTab(food3[1], null, p3);

        add(tabbedPane, BorderLayout.CENTER);

    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.gray);

        JButton back = new JButton("<");
        back.setBounds(5, 10, 40, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(e -> {
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[0]));
        Image i3 = i1.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(50, 50, 550, 420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setForeground(Color.white);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 5, 550, 100);
        p1.add(lblName);


        return p1;
    }
}