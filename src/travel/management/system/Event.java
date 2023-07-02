package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Event extends JFrame {

    private String selectedMonth;
    public int mon;
      private int cityId;

     Event(String selectedMonth, int cityId) {
        this.selectedMonth = selectedMonth;
        this.cityId = cityId;

        Sehirler event = new Sehirler();
        event.setVisible(false);
        int id = event.getId();
        setBounds(400, 80, 600, 630);
        
        switch (selectedMonth) {
            case "January":
                mon = 0;
                break;
            case "February":
                mon = 1;
                break;
            case "March":
                mon = 2;
                break;
            case "April":
                mon = 3;
                break;
            case "May":
                mon = 4;
                break;
            case "June":
                mon = 5;
                break;
            case "July":
                mon = 6;
                break;
            case "August":
                mon = 7;
                break;
            case "September":
                mon = 8;
                break;
            case "October":
                mon = 9;
                break;
            case "November":
                mon = 10;
                break;
            case "December":
                mon = 11;
                break;
            default:
                // Handle the case when the selected month is not found
                mon = -1; // or any other default value you prefer
                break;
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            PreparedStatement statement = con.prepareStatement("SELECT MONTH(activites_date) AS event_month, activites_name, city_id FROM worldwander.activites WHERE MONTH(activites_date) = ? AND city_id = ?");
            statement.setInt(1, mon + 1);
            statement.setInt(2, id);

            ResultSet resultSet = statement.executeQuery();

            List<String> activitiesList = new ArrayList<>();
            while (resultSet.next()) {
                String activity_name = resultSet.getString("activites_name");
                activitiesList.add(activity_name);
            }

            resultSet.close();
            statement.close();
            con.close();

           // ...
if (activitiesList.isEmpty()) {
    JOptionPane.showMessageDialog(this, "No activities this month");
    createEventTabs(selectedMonth, new String[0]); // Pass an empty array to create an empty tabbed pane
    return;
}

String[] activities = activitiesList.toArray(new String[activitiesList.size()]);
createEventTabs(selectedMonth, activities);

setVisible(true);
// ...

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void createEventTabs(String selectedMonth, String[] activities) {
    JTabbedPane tabbedPane = new JTabbedPane();

    if (activities.length == 0) {
        JPanel noActivitiesPanel = createNoActivitiesPanel(selectedMonth);
        tabbedPane.addTab(selectedMonth, null, noActivitiesPanel);
    } else {
        for (int i = 0; i < activities.length; i++) {
            if (activities[i] != null) {
                JPanel panel = createPackage(selectedMonth, activities[i]);
                tabbedPane.addTab("Activity " + (i + 1), null, panel);
            }
        }
    }

    add(tabbedPane, BorderLayout.CENTER);
}

private JPanel createNoActivitiesPanel(String selectedMonth) {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.gray);

    JLabel label = new JLabel("No activities for " + selectedMonth);
    label.setForeground(Color.white);
    label.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    label.setBounds(50, 20, 500, 50);

    panel.add(label);
    return panel;
}


    public JPanel createPackage(String selectedMonth, String activity) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.gray);

        JButton back = new JButton("<");
        back.setBounds(5, 10, 40, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(e -> {
            setVisible(false);
            new Calender();
        });
        p1.add(back);

        JLabel lblName = new JLabel(selectedMonth);
        lblName.setForeground(Color.white);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 20, 500, 50);
        p1.add(lblName);

        JButton eventButton1 = new JButton(activity);
        eventButton1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        eventButton1.setBounds(50, 150, 500, 100);
        eventButton1.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(eventButton1);

        return p1;
    }
}
