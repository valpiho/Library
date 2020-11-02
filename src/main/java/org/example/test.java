package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
public class test {

        public static void main(String[] args) {

            String jdbcUrl = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
            String user = "root";
            String pass = "root";
            try {
                System.out.println("Connecting to database: " + jdbcUrl);
                Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
                System.out.println("Connection successful !!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
