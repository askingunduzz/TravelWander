package travel.management.system;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class OrtakSehir extends JFrame {
    public static void main(String[] args) {
        new OrtakSehir().setVisible(true);
    }

    String sqlQuery = "SELECT 'Bursa' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Bursa'\n" +
            ")\n" +
            "UNION\n" +
            "SELECT 'Ankara' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Ankara'\n" +
            ")\n" +
            "UNION\n" +
            "SELECT 'Istanbul' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Istanbul'\n" +
            ")\n" +
            "UNION\n" +
            "SELECT 'Antalya' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Antalya'\n" +
            ")\n" +
            "UNION\n" +
            "SELECT 'Konya' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Konya'\n" +
            ")\n" +
            "UNION\n" +
            "SELECT 'Izmir' AS city_name\n" +
            "FROM foods\n" +
            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
            "    SELECT city_id FROM city WHERE city_name = 'Izmir'\n" +
            ");";
    String[] sehirler = new String[10];

    public void OrtakYemeklerPanel() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            java.sql.Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            int i = 0;
            while (resultSet.next() && i < sehirler.length) {
                String city = resultSet.getString("city_name");
                sehirler[i] = city;
                i++;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    OrtakSehir() {
        setBounds(440, 200, 400, 430);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.gray);

        JLabel titleLabel = new JLabel("Döner Kebabı (rotisserie-style kebab)");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0)); 
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); 
        buttonPanel.setBackground(Color.gray);

        OrtakYemeklerPanel();

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
        gbc.insets = new Insets(10, 10, 10, 10);
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
            new ortaklar();
        });
        mainPanel.add(backButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
