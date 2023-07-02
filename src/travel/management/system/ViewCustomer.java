package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton view_button,back;
    JLabel labelUsername, labelName, labelCountry, labelPhone, labelEmail, labelGender;
    JTextField textFieldName;

    ViewCustomer() {
        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(300, 900, 700, 690);

        JLabel lblName = new JLabel("Enter Username:");
        lblName.setBounds(30, 30, 150, 25);
        add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(200, 30, 150, 25);
        add(textFieldName);

        view_button = new JButton("View");
        view_button.setBackground(Color.black);
        view_button.setForeground(Color.black);
        view_button.setBounds(380, 30, 80, 25);
        view_button.addActionListener(this);
        add(view_button);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 70, 150, 25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(200, 70, 150, 20);
        labelUsername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelUsername);

        JLabel lblName2 = new JLabel("Name:");
        lblName2.setBounds(400, 70, 150, 25);
        add(lblName2);

        labelName = new JLabel();
        labelName.setBounds(600, 70, 150, 25);
        labelName.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelName);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setBounds(30, 120, 150, 25);
        add(lblCountry);

        labelCountry = new JLabel();
        labelCountry.setBounds(200, 120, 150, 25);
        labelCountry.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelCountry);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(400, 120, 150, 25);
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(600, 120, 150, 25);
        labelPhone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 170, 150, 25);
        add(lblEmail);

        labelEmail = new JLabel();
        labelEmail.setBounds(200, 170, 150, 25);
        labelEmail.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelEmail);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(400, 170, 150, 25);
        add(lblGender);

        labelGender = new JLabel();
        labelGender.setBounds(600, 170, 150, 25);
        labelGender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelGender);

        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBackground(Color.black);
        back.setBounds(480, 27, 80, 30);
        back.addActionListener(this);
        add(back);

        
            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(10, 160, 700, 550);
            ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/view4.png"));
        
            Image scaledImage = image.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(scaledIcon);
            add(imageLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewCustomer();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_button) {
            String customeruserName = textFieldName.getText();
            if (customeruserName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer username.");
            } else {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                    Statement statement = con.createStatement();
                    String query = "SELECT * FROM customer WHERE username = '" + customeruserName + "'";
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        labelUsername.setText(rs.getString("username"));
                        labelName.setText(rs.getString("name"));
                        labelEmail.setText(rs.getString("email"));
                        labelGender.setText(rs.getString("gender"));
                        labelCountry.setText(rs.getString("country"));
                        labelPhone.setText(rs.getString("number"));
                    } else {
                        JOptionPane.showMessageDialog(this, "No such customer found.");
                    }
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }  
        }
        else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
}
