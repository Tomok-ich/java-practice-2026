package ru.itis.shop.user.infrastructure.persistence;

import ru.itis.shop.user.domain.User;
import ru.itis.shop.user.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {

    private static final String DB_URL =
            "jdbc:postgresql://localhost:5432/java_2026";

    private static final String DB_USER =
            "postgres";

    private static final String DB_PASSWORD =
            "d@ta_160";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("select * from users")) {
                    while (resultSet.next()) {
                        User user = new User(
                                resultSet.getString("id"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("profile_description"),
                                resultSet.getString("name")
                        );
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> findById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException();
    }
}
