package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel lblusername, lblname; 
    JTextField tfusername, tfname; 

    JButton back, update;

    JTextField tfNumber, tfcountry, tfphone, tfemail, tfid, tfgender;

    JLabel lblid, lblnumber, lblcountry, lblphone, lblemail, lblgender;
    String username;
    JComboBox<String> comboid;

    UpdateCustomer(String username) {
        this.username = username;

        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(300, 200, 820, 450);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 22));
        text.setBounds(450, 0, 500, 30);
        add(text);

        lblusername = new JLabel("Enter Username:");
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblusername.setBounds(50, 20, 300, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 200, 20);
        add(tfusername);

        JLabel lblnewusername = new JLabel("New Username:");
        lblnewusername.setForeground(Color.BLACK);
        lblnewusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblnewusername.setBounds(50, 60, 300, 20);
        add(lblnewusername);

        JTextField tfnewusername = new JTextField();
        tfnewusername.setBounds(200, 60, 200, 20);
        add(tfnewusername);

        lblname = new JLabel("Name:");
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblname.setBounds(50, 100, 300, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 200, 20);
        add(tfname);

        lblgender = new JLabel("Gender:");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblgender.setBounds(50, 140, 300, 20);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(200, 140, 200, 20);
        tfgender.setBackground(Color.white);
        add(tfgender);

        lblcountry = new JLabel("Country:");
        lblcountry.setForeground(Color.BLACK);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcountry.setBounds(50, 180, 300, 20);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 180, 200, 20);
        tfcountry.setBackground(Color.white);
        add(tfcountry);

        lblphone = new JLabel("Phone:");
        lblphone.setForeground(Color.BLACK);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblphone.setBounds(50, 220, 300, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 220, 200, 20);
        tfphone.setBackground(Color.white);
        add(tfphone);

        lblemail = new JLabel("Email:");
        lblemail.setForeground(Color.BLACK);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblemail.setBounds(50, 260, 300, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 260, 200, 20);
        tfemail.setBackground(Color.white);
        add(tfemail);

        update = new JButton("Update");
        update.setForeground(Color.black);
        update.setBackground(Color.black);
        update.setBounds(100, 370, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBackground(Color.black);
        back.setBounds(350, 370, 100, 30);
        back.addActionListener(this);
        add(back);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                tfusername.setText(rs.getString("username"));
                tfname.setText(rs.getString("name"));
                tfcountry.setText(rs.getString("country"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/u.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 450, 420);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String oldUsername = tfusername.getText();
            String newUsername = tfusername.getText();
            String name = tfname.getText();
            String number = tfphone.getText();
            String email = tfemail.getText();
            String country = tfcountry.getText();
            String gender = tfgender.getText();

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                Statement statement = con.createStatement(); // Create Statement object
                String checkUsernameQuery = "SELECT * FROM customer WHERE username = '" + oldUsername + "'";
                ResultSet rs = statement.executeQuery(checkUsernameQuery);
                
                if (rs.next()) {
                    String updateCustomerQuery = "UPDATE customer SET username = '" + newUsername + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', number = '" + number + "', email = '" + email + "' WHERE username = '" + oldUsername + "'";
                    statement.executeUpdate(updateCustomerQuery);
                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No such customer!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
