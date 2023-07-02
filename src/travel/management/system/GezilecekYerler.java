package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GezilecekYerler extends JFrame {
    private static final int NUM_PLACES = 5;
    private static final int IMAGE_WIDTH = 250;
    private static final int IMAGE_HEIGHT = 330;

    public GezilecekYerler() {
        Sehirler gez = new Sehirler();
        gez.setVisible(false);
        int id = gez.getId();

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.gray);
        setBounds(300, 100, 800, 600);

        List<String> gezilecekYer = new ArrayList<>();
        List<String> konum = new ArrayList<>();
        List<String> imagePaths = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worldwander.places_to_visit WHERE city_id = " + id + ";");

            int i = 0;
            while (resultSet.next() && i < NUM_PLACES) {
                String place_name = resultSet.getString("place_name");
                String place_address = resultSet.getString("place_address");
                String image_path = resultSet.getString("images");

                gezilecekYer.add(place_name);
                konum.add(place_address);
                imagePaths.add(image_path);
                i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTabbedPane tabbedPane = new JTabbedPane();

        for (int i = 0; i < gezilecekYer.size(); i++) {
            String[] packageInfo = new String[]{imagePaths.get(i), gezilecekYer.get(i), konum.get(i)};
            JPanel packagePanel = createPackage(packageInfo);
            tabbedPane.addTab(packageInfo[1], null, packagePanel);
        }

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JPanel createPackage(String[] packageInfo) {
        JPanel packagePanel = new JPanel();
        packagePanel.setLayout(null);
        packagePanel.setBackground(Color.gray);

        JButton back = new JButton("<");
        back.setBounds(5, 10, 40, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(e -> {
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        packagePanel.add(back);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/"+packageInfo[0]));
        Image scaledImage = icon.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(-50, 20, 450, 420);
        packagePanel.add(imageLabel);

        JLabel nameLabel = new JLabel(packageInfo[1]);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        nameLabel.setBounds(50, 10, 550, 53);
        packagePanel.add(nameLabel);

        JLabel addressLabel = new JLabel(packageInfo[2]);
        addressLabel.setForeground(Color.white);
        addressLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
        addressLabel.setBounds(50, 400, 850, 53);
        packagePanel.add(addressLabel);

        return packagePanel;
    }
}
