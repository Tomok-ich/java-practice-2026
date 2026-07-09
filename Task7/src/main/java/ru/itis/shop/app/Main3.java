package ru.itis.shop.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/shop_db", "postgres", "qwerty007")) {

            // insert into account(email, password) values('mail@gmail.com', 'qwerty007');

            String email = scanner.nextLine();
            String password = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement("insert into account(email, password) values(?, ?)")) {

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                int affectedRowsCount = preparedStatement.executeUpdate();

                if (affectedRowsCount != 1) {
                    throw new SQLException("Can't insert");
                }

                System.out.println("Добавлено");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
