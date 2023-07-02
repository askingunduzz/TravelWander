package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageViewer extends JFrame {

    private JButton previousPageButton;

    public static void main(String[] args) {
        new PageViewer().setVisible(true);
    }

    public PageViewer() {
        setBounds(300, 80, 600, 630);
        setTitle("Famous People Coming to Activities");

        String[] activitesname = new String[30];
        String[] peoplename = new String[30];
        String query = "SELECT a.activites_name, fp.people_name " +
                "FROM worldwander.activites a " +
                "LEFT JOIN worldwander.famous_people fp ON a.city_id = fp.city_id "+
                "LIMIT 30";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                String activityName = resultSet.getString("activites_name");
                String peopleName = resultSet.getString("people_name");

                activitesname[i] = activityName;
                peoplename[i] = peopleName;
                i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder paragraphText = new StringBuilder();
        for (int i = 0; i < activitesname.length; i++) {
            paragraphText.append(activitesname[i]).append(" -- ").append(peoplename[i]).append(" \n");
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.gray);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        
        previousPageButton = new JButton("Previous Page");
        mainPanel.add(previousPageButton, BorderLayout.PAGE_END);

        add(mainPanel);
        setVisible(true);

        
        textArea.setText(paragraphText.toString());

    
        previousPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        
                new newPage();

              
                dispose();
            }
        });
    }
}
