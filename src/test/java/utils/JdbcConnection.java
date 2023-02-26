package utils;

import java.sql.*;

import static utils.PropertiesReader.getProperty;

public class JdbcConnection {

    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    getProperty("dbUrl") + ":" + getProperty("dbPort") + "/" + getProperty("dbName"),
                    getProperty("dbUser"),
                    getProperty("dbPassword"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return User.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .email(resultSet.getString("email"))
                    .phone(resultSet.getString("phone"))
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Long saveUser(User user) {
        try {
            PreparedStatement prepareStatement = connection
                    .prepareStatement("INSERT INTO users (name, surname, email, phone) VALUES(?, ?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getSurname());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getPhone());
            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void updateUser(Long id, User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE users SET name=?, surname=?, email=?, phone=? WHERE id=?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser(Long id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getUsersCount() {
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Count(*) FROM users");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
