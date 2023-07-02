package travel.management.system;


import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Facts extends JFrame {
    public static void main(String[] args) {
        new Facts().setVisible(true);
    }
//FUN FACTS
    Facts() {
        setBounds(300, 80, 600, 630);
        Sehirler fact=new Sehirler();
        fact.setVisible(false);
        int id=fact.getId();
        String[] funfact1 = new String[3];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = ((java.sql.Connection) con).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worldwander.facts where city_id ="+id+";");

            int i= 0;
            while (resultSet.next()) {
                String food_name = resultSet.getString("fact_description");
                int city_id = resultSet.getInt("city_id");
                funfact1[i] = food_name;
                i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(funfact1);
        tabbedPane.addTab("FACTS ", null, p1);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {

       
            JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.gray);

        JButton back = new JButton("<");
        back.setBounds(5, 5, 40, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(e -> {
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        p1.add(back);

    JLabel lblName = new JLabel();
    lblName.setForeground(Color.white);
    lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    lblName.setBounds(50, 20, 500, 50);
    p1.add(lblName);

    JLabel lb2 = new JLabel("<html><div style='text-align: center; padding: 10px; background-color: #ffffff;'>"
            + pack[0] + "</div></html>");
    lb2.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
    lb2.setBounds(50, 45, 500, 200);
    p1.add(lb2);

    JLabel lb3 = new JLabel("<html><div style='text-align: center; padding: 10px; background-color: #ffffff;'>"
            + pack[1] + "</div></html>");
    lb3.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
    lb3.setBounds(50, 200, 500, 200);
    p1.add(lb3);

    JLabel lb4 = new JLabel("<html><div style='text-align: center; padding: 10px; background-color: #ffffff;'>"
            + pack[2] + "</div></html>");
    lb4.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
    lb4.setBounds(50, 350, 500, 200);
    p1.add(lb4);
            return p1;
}
    

    }