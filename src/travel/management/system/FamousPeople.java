package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

// Famous people
public class FamousPeople extends JFrame{
    public static void main(String[] args) {
        new FamousPeople().setVisible(true);
    }

    FamousPeople() {
       
        Sehirler fampep=new Sehirler();
        fampep.setVisible(false);
        int id=fampep.getId();
        

        setBounds(400 , 60 , 600, 730);
     //   String[] images = {"aaa.jpg", "package2.jpg", "package3.jpg"};

        String[] famouspeople = new String[3];
        Date[] birth= new Date[3];
        int[] age= new int[3];
        String[] job = new String[3];
        String[] imagess = new String[3];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
            Statement statement = ((java.sql.Connection) con).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM worldwander.famous_people where city_id="+id+";");
            int i=0;
            while (resultSet.next()) {
                String people_name = resultSet.getString("people_name");
                 Date birth_date = resultSet.getDate("people_birthday");
                int aged = resultSet.getInt("people_age");
                String jobs = resultSet.getString("people_job");
                String images = resultSet.getString("images");

               famouspeople[i]=people_name;
               birth[i]=birth_date;
               age[i]=aged;
               job[i]=jobs;
               imagess[i]=images;
               i++;
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


//resimler çekilecek
//çektim ama resimler henüz mevcut olmadığı için bu class açılmıyor, doğru olduğunu düşünüyrom
String[] famous1 = new String[]{imagess[0],"",famouspeople[0], "Date of Birth:", String.valueOf(birth[0]), "Age:", String.valueOf(age[0]), "Job:",job[0]};
String[] famous2 = new String[]{imagess[1],"",famouspeople[1],"Date of Birth:", String.valueOf(birth[1]),"Age:", String.valueOf(age[1]), "Job:",job[1]};
String[] famous3 = new String[]{imagess[2],"",famouspeople[2],"Date of Birth:", String.valueOf(birth[2]),"Age:", String.valueOf(age[2]),"Job:",job[2]};

        // create Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(famous1);
        tabbedPane.addTab(famouspeople[0], null, p1);

        JPanel p2 = createPackage(famous2);
        tabbedPane.addTab(famouspeople[1], null, p2);

        JPanel p3 = createPackage(famous3);
        tabbedPane.addTab(famouspeople[2], null, p3);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.gray);

        JButton back = new JButton("<");
        back.setBounds(5, 10, 40, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(e -> {
            setVisible(false);
            new Dashboard("").setVisible(true);
        });
        p1.add(back);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i3 = i1.getImage().getScaledInstance(250, 330,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(-50,20,450,420);
        p1.add(l1);

        JLabel lblName = new JLabel(pack[1]);
        lblName.setForeground(Color.white);
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblName.setBounds(50, 10, 350, 53);
        p1.add(lblName);

        JLabel lbx = new JLabel(pack[2]);
        lbx.setForeground(Color.white);
        lbx.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lbx.setBounds(50, 400, 350, 53);
        p1.add(lbx);

        JLabel l3 = new JLabel(pack[3]);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l3.setBounds(50, 450, 230, 20);
        p1.add(l3);

        JLabel l4 = new JLabel(pack[4]);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l4.setBounds(350, 450, 230, 20);
        p1.add(l4);

        JLabel l5 = new JLabel(pack[5]);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l5.setBounds(50, 500, 230, 20);
        p1.add(l5);


        JLabel l6 = new JLabel(pack[6]);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l6.setBounds(350, 500, 230, 20);
        p1.add(l6);


        JLabel l7 = new JLabel(pack[7]);
        l7.setForeground(Color.white);
        l7.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l7.setBounds(50, 550, 230, 20);
        p1.add(l7);

        JLabel l8 = new JLabel(pack[8]);
        l8.setForeground(Color.white);
        l8.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
        l8.setBounds(350, 550, 230, 20);
        p1.add(l8);

        return p1;
    }
}