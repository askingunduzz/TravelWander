package travel.management.system;
//BİKAÇ BUTON AZALTILACAK!
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

public class DeleteCustomerDetails extends JFrame implements ActionListener {
    JButton delete, back;
    ButtonGroup gendergroup;
    JLabel labelusername, labelid, labelnumber, labelcountry, labelphone, labelemail, labelgender;
    String username;
    JTextField tfCountry, tfPhone, tfEmail, tfUsername, tfName;
    JRadioButton male, female;


  

       

       
/* 

        // Set the passed username value to the username text field
        tfUsername.setText(username);

      

        setVisible(true);
    }











*/

    DeleteCustomerDetails(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(300, 200, 850, 650);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setForeground(Color.BLACK);
        lblusername.setBounds(30, 30, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 30, 150, 20);
        labelusername.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelusername);

        tfUsername = new JTextField();
        tfUsername.setBounds(200, 30, 200, 20);
        tfUsername.setBackground(Color.white);
        add(tfUsername);

        JLabel lblgender = new JLabel("Gender:");
        lblgender.setForeground(Color.BLACK);
        lblgender.setBounds(30, 80, 150, 25);
        add(lblgender);

        lblgender = new JLabel();
        lblgender.setBounds(300, 80, 150, 20);
        lblgender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblgender);


        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(450, 30, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(600, 30, 150, 25);
        labelname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelname);

        tfName = new JTextField();
        tfName.setBounds(500, 30, 200, 20);
        tfName.setBackground(Color.white);
        add(tfName);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(30, 130, 150, 25);
        add(lblcountry);

        labelcountry = new JLabel();
        labelcountry.setBounds(200, 130, 150, 25);
        labelcountry.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelcountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 130, 200, 20);
        tfCountry.setBackground(Color.white);
        add(tfCountry);

        JLabel lbphone = new JLabel("Phone:");
        lbphone.setBounds(450, 80, 150, 25);
        add(lbphone);

        labelphone = new JLabel();
        labelphone.setBounds(600, 80, 150, 25);
        labelphone.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(500, 80, 200, 20);
        tfPhone.setBackground(Color.white);
        add(tfPhone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(450, 130, 150, 25);
        add(lblemail);

        labelemail = new JLabel();
        labelemail.setBounds(600, 130, 150, 25);
        labelemail.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelemail);

        tfEmail = new JTextField();
        tfEmail.setBounds(500, 130, 200, 20);
        tfEmail.setBackground(Color.white);
        add(tfEmail);


        labelgender = new JLabel();
        labelgender.setBounds(600, 180, 150, 25);
        labelgender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(labelgender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.PLAIN, 18));
        male.setBounds(200, 80, 100, 20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 18));
        female.setBounds(300, 80, 100, 20);
        female.setBackground(Color.white);
        add(female);


          // To select any one
          gendergroup = new ButtonGroup();
          gendergroup.add(male);
          gendergroup.add(female);

        delete = new JButton("Delete");
        delete.setBackground(Color.black);
        delete.setForeground(Color.black);
        delete.setBounds(400, 200, 100, 25);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.black);
        back.setBounds(200, 200, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/preview.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 265, 900, 360);
        add(image);


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = con.createStatement();
            String query = "select * from customer where username = '" + username + "' ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                labelemail.setText(rs.getString("email"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labelphone.setText(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new DeleteCustomerDetails("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            String username = tfUsername.getText();

                String name = tfName.getText();
                String number = tfPhone.getText();
                String email = tfEmail.getText();
                String country = tfCountry.getText();
                String gender = male.isSelected() ? "Male" : "Female";
                
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                Statement statement = con.createStatement(); // Create Statement object
                String selectQuery = "SELECT * FROM customer WHERE username = '" + username + "' AND name = '" + name + "' AND gender = '" + gender + "' AND number = '" + number + "' AND email = '" + email + "'";
                ResultSet rs = statement.executeQuery(selectQuery);
                if (rs.next()) {
                String deleteCustomerQuery = "DELETE FROM customer WHERE username = '" + username + "' AND name = '" + name+ "' AND gender = '" + gender + "' AND number = '" + number + "' AND email = '" + email + "'";
                
                statement.executeUpdate(deleteCustomerQuery);
              
                
                JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                setVisible(false);
                }
                else{JOptionPane.showMessageDialog(null, "No such customer!");}
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
}
