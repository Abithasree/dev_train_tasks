package db;

import java.sql.*;

public class MySQLConnectionExample {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sample_db";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT * FROM users";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    String city = resultSet.getString("city");

                    // Create a User object and populate it with retrieved data
                    User user = new User(id, name, age, email, city);

                    // Print the user information using DTO (User) object
                    System.out.println("User Information:");
                    System.out.println(user); // This will implicitly call user.toString()
                    System.out.println("--------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
