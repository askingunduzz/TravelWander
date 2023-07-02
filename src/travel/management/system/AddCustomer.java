package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    ButtonGroup gendergroup;
    JRadioButton male, female;
    JLabel lblUsername, lblName, gender;
    JTextField tfCountry, tfPhone, tfEmail, tfUsername, tfName;

    JButton back, add, addAgeButton, dropAgeButton;

    boolean ageColumnAdded = false;

    AddCustomer(String username) {
        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(300, 200, 890, 470);

        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(50, 20, 300, 20);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(200, 20, 200, 20);
        tfUsername.setBackground(Color.white);
        add(tfUsername);

        lblName = new JLabel("Name:");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(50, 60, 300, 20);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 60, 200, 20);
        tfName.setBackground(Color.white);
        add(tfName);

        // Gender
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender.setBounds(50, 90, 300, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.PLAIN, 18));
        male.setBounds(200, 90, 100, 20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 18));
        female.setBounds(300, 90, 100, 20);
        female.setBackground(Color.white);
        add(female);

        // To select any one
        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setForeground(Color.BLACK);
        lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCountry.setBounds(50, 120, 300, 20);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 120, 200, 20);
        tfCountry.setBackground(Color.white);
        add(tfCountry);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setForeground(Color.BLACK);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPhone.setBounds(50, 165, 300, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 165, 200, 20);
        tfPhone.setBackground(Color.white);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(50, 210, 300, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 210, 200, 20);
        tfEmail.setBackground(Color.white);
        add(tfEmail);

        add = new JButton("Add");
        add.setForeground(Color.black);
        add.setBackground(Color.black);
        add.setBounds(100, 270, 100, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBackground(Color.black);
        back.setBounds(350, 267, 100, 30);
        back.addActionListener(this);
        add(back);

        addAgeButton = new JButton("Add Age");
        addAgeButton.setForeground(Color.black);
        addAgeButton.setBackground(Color.black);
        addAgeButton.setBounds(100, 310, 100, 30);
        addAgeButton.addActionListener(this);
        add(addAgeButton);

        dropAgeButton = new JButton("Drop Age");
        dropAgeButton.setForeground(Color.black);
        dropAgeButton.setBackground(Color.black);
        dropAgeButton.setBounds(250, 310, 100, 30);
        dropAgeButton.addActionListener(this);
        add(dropAgeButton);

        // Set the passed username value to the username text field
        tfUsername.setText(username);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/addcustomer.png"));
        Image image = imageIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(450, 10, 450, 420);
        add(imageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = tfUsername.getText();
            String name = tfName.getText();
            String number = tfPhone.getText();
            String email = tfEmail.getText();
            String country = tfCountry.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            
                   

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                Statement statement = con.createStatement();
                String query = "insert into customer values('" + username + "',  '" + name + "',  '" + gender + "',  '" + country + "',  '" + number + "'  , '" + email + "'  )";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
               // setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
            
        else if (ae.getSource() == addAgeButton) {
            if (!ageColumnAdded) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                    Statement statement = con.createStatement();
                    String query = "ALTER TABLE worldwander.customer ADD age INT";
                    statement.executeUpdate(query);
                    ageColumnAdded = true;
                    JOptionPane.showMessageDialog(null, "Added 'age' column to the customer table");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can't do that!");
            }
        } else if (ae.getSource() == dropAgeButton) {
            if (ageColumnAdded) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                    Statement statement = con.createStatement();
                    String query = "ALTER TABLE worldwander.customer DROP COLUMN age;";
                    statement.executeUpdate(query);
                    ageColumnAdded = false;
                    JOptionPane.showMessageDialog(null, "Dropped 'age' column from the customer table");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can't do that!");
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
