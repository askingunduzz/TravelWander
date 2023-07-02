package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

public class main {

	public static void main(String[] args) {
	    String sqlQuery = "SELECT 'Bursa' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Bursa'\n" +
	            ")\n" +
	            "UNION\n" +
	            "SELECT 'Ankara' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Ankara'\n" +
	            ")\n" +
	            "UNION\n" +
	            "SELECT 'Istanbul' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Istanbul'\n" +
	            ")\n" +
	            "UNION\n" +
	            "SELECT 'Antalya' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Antalya'\n" +
	            ")\n" +
	            "UNION\n" +
	            "SELECT 'Konya' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Konya'\n" +
	            ")\n" +
	            "UNION\n" +
	            "SELECT 'Izmir' AS city_name\n" +
	            "FROM foods\n" +
	            "WHERE food_name = 'Döner Kebabı (rotisserie-style kebab)' AND city_id = (\n" +
	            "    SELECT city_id FROM city WHERE city_name = 'Izmir'\n" +
	            ");";
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldwander", "root", "24052003As");
	        java.sql.Statement statement = con.createStatement();


	        ResultSet resultSet = statement.executeQuery(sqlQuery);


	        while (resultSet.next()) {
	            String cityName = resultSet.getString("city_name");
	            System.out.println("Döner Kebabı (rotisserie-style kebab) şehri: " + cityName);
	        }
			


	        resultSet.close();
	        statement.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
