package travel.management.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class newPage extends JFrame {
    private JButton nextPageButton;
    private JButton backButton;

    public static void main(String[] args) {
        new newPage().setVisible(true);
    }

    private void initializeBackButton() {
    backButton = new JButton("Back");
    backButton.setBounds(500, 10, 80, 30);
    add(backButton);
}


    public newPage() {

        initializeBackButton();
        
        setBounds(300, 80, 600, 630);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.gray);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        String[] queryTitles = {
                "Query 1: Famous People in Istanbul",
                "Query 2: Average Age and Closest Famous Person to the Average Age",
                "Query 3: Total Age by Job",
                "Query 4: Oldest Famous Person",
                "Query 5: Youngest Famous Person",
                "Query 6: Foods with Multiple City Associations",
                "Query 7: Cities with Döner Kebabı",
                "Query 8: Food-Menü Combinations",
                "Query 9: Total Number of Foods",
                "Query 10: Cities with Upper Case Names and Images",
                "Query 11: Famous People who are Singers or Actors",
                "Query 12: Places to Visit with Uncommon Foods",
                "Query 13: Singers and Their Cities",
                "Query 14: All Food Names",
                "Query 15: Total People by Job and Age Range"
        };

        String[] queries = {
                "SELECT people_name\n" +
                        "FROM worldwander.famous_people\n" +
                        "WHERE city_id = SOME (SELECT city_id FROM city WHERE city_name = 'Istanbul')" +
                        "LIMIT 2;",
                "SELECT avg_age.averageAge, t.people_name, t.people_age\n" +
                        "FROM (\n" +
                        "    SELECT AVG(people_age) AS averageAge\n" +
                        "    FROM worldwander.famous_people\n" +
                        "    WHERE people_age IS NOT NULL\n" +
                        ") AS avg_age,\n" +
                        "(\n" +
                        "    SELECT people_name, people_age\n" +
                        "    FROM worldwander.famous_people\n" +
                        "    WHERE people_age IS NOT NULL\n" +
                        "    ORDER BY ABS(people_age - (SELECT AVG(people_age) FROM worldwander.famous_people WHERE people_age IS NOT NULL)) ASC\n" +
                        "    LIMIT 1\n" +
                        ") AS t;",
                "SELECT DISTINCT people_job, SUM(DISTINCT people_age) AS total_age\n" +
                        "FROM famous_people\n" +
                        "GROUP BY people_job\n" +
                        "LIMIT 3;",
                "SELECT people_age, people_name\n" +
                        "FROM worldwander.famous_people\n" +
                        "WHERE people_age = (SELECT MAX(people_age) FROM worldwander.famous_people);",
                "SELECT people_age, people_name\n" +
                        "FROM worldwander.famous_people\n" +
                        "WHERE people_age = (SELECT MIN(people_age) FROM worldwander.famous_people);",
                "SELECT worldwander.foods.food_name, COUNT(worldwander.city.city_id) AS Count\n" +
                        "FROM worldwander.city\n" +
                        "INNER JOIN worldwander.foods ON worldwander.city.city_id = worldwander.foods.city_id\n" +
                        "WHERE worldwander.foods.city_id <= 5\n" +
                        "GROUP BY worldwander.foods.food_name \n" +
                        "HAVING COUNT(worldwander.foods.food_name) >= 2\n" +
                        "LIMIT 4;",
                "SELECT worldwander.foods.food_name, GROUP_CONCAT(city_id) AS city_id_list\n" +
                        "FROM worldwander.foods\n" +
                        "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)'\n" +
                        "GROUP BY food_name LIMIT 3;",
                "SELECT f.food_name, GROUP_CONCAT(DISTINCT p.place_name ORDER BY p.city_id) AS menu\n" +
                        "FROM worldwander.foods AS f\n" +
                        "JOIN worldwander.places_to_visit AS p ON f.city_id = p.city_id\n" +
                        "GROUP BY f.food_name limit 3;",
                "SELECT COUNT(*) AS total_count\n" +
                        "FROM worldwander.foods;",
                "SELECT city_id, UPPER(city_name) AS city_name, images\n" +
                        "FROM worldwander.city limit 3;",
                "SELECT *\n" +
                        "FROM worldwander.famous_people\n" +
                        "WHERE people_job IN ('Singer', 'Actor') limit 3;",
                "SELECT p.place_name, f.food_name\n" +
                        "FROM worldwander.places_to_visit p\n" +
                        "LEFT JOIN (\n" +
                        "    SELECT f1.city_id, f1.food_name\n" +
                        "    FROM worldwander.foods f1\n" +
                        "    LEFT JOIN (\n" +
                        "        SELECT city_id, MIN(food_name) AS min_food_name\n" +
                        "        FROM worldwander.foods\n" +
                        "        GROUP BY city_id\n" +
                        "    ) f2 ON f1.city_id = f2.city_id AND f1.food_name = f2.min_food_name\n" +
                        "    WHERE f2.city_id IS NULL\n" +
                        ") f ON p.city_id = f.city_id limit 3;",
                "SELECT fp.people_name, c.city_name\n" +
                        "FROM worldwander.famous_people fp\n" +
                        "JOIN city c ON fp.city_id = c.city_id\n" +
                        "WHERE fp.people_job = 'singer' limit 3;",
                "SELECT ALL food_name from worldwander.foods limit 3;",
                "SELECT people_job, COUNT(DISTINCT people_name) AS total_people\n" +
                        "FROM worldwander.famous_people\n" +
                        "WHERE people_age BETWEEN 30 AND 50\n" +
                        "GROUP BY people_job;"
        };

        for (int i = 0; i < queryTitles.length; i++) {
            textArea.append(queryTitles[i] + "\n\n");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queries[i]);

                if (i == 8 || i == 13) {
                    while (rs.next()) {
                        textArea.append(rs.getString(1) + "\n");
                    }
                } else if (i == 9) {
                    while (rs.next()) {
                        textArea.append(rs.getString(1) + " - " + rs.getString(2) + "\n");
                    }
                } else {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    for (int j = 1; j <= columnCount; j++) {
                        textArea.append(rsmd.getColumnLabel(j) + "\t");
                    }
                    textArea.append("\n");

                    while (rs.next()) {
                        for (int j = 1; j <= columnCount; j++) {
                            textArea.append(rs.getString(j) + "\t");
                        }
                        textArea.append("\n");
                    }
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            textArea.append("\n------------------------\n\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);


        nextPageButton = new JButton("Next Page");
     
       mainPanel.add(nextPageButton,  BorderLayout.AFTER_LAST_LINE);

        add(mainPanel);
        setVisible(true);

   
        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             new PageViewer();

            
                setVisible(false);
            }

      
         }     );
         backButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       
        new StartPage("a").setVisible(true);
            setVisible(false);
   
    }
});

         
    
    }
}