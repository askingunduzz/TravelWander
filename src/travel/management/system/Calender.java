package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Calender extends JFrame {
    private String selectedMonth;
    private int cityId; 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calender::new);
    }

    Calender() {
        setBounds(300, 80, 600, 630);

        String[] months = new String[]{
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.gray);

        for (String month : months) {
            JButton button = new JButton(month);
            button.setFont(new Font("Tahoma", Font.PLAIN, 20));
            button.addActionListener(e -> {
                selectedMonth = button.getText(); // Store the selected month

                // Check if activities exist for the selected month
                boolean hasActivities = checkActivities(selectedMonth, cityId);

                if (hasActivities) {
                    setVisible(false);
                    new Event(selectedMonth, cityId);
                } else {
                    JOptionPane.showMessageDialog(this, "No activities this month");
                }
            });
            panel.add(button);
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.gray);

        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        bottomPanel.add(backButton, BorderLayout.EAST);

        add(panel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private boolean checkActivities(String selectedMonth, int cityId) {
        boolean hasActivities = false;
        int mon = getMonthIndex(selectedMonth);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) AS activity_count FROM worldwander.activites WHERE MONTH(activites_date) = ? AND city_id = ?");
            statement.setInt(1, mon + 1);
            statement.setInt(2, cityId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int activityCount = resultSet.getInt("activity_count");
                hasActivities = activityCount > 0;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasActivities;
    }

    private int getMonthIndex(String month) {
        String[] months = new String[]{
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month)) {
                return i;
            }
        }

        return -1;
    }
}
