package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static int USER_COUNT;

//    private static final String URL = "jdbc:mysql://localhost:3306/first_db";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<User> index() {
//        List<User> users = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM User";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                User user = new User();
//
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setAge(resultSet.getInt("age"));
//
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return jdbcTemplate.query("SELECT * FROM User", new UserMapper());
    }

    public User show(int id) {
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);

//        User user = null;
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM User WHERE id=?");
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//
//            user = new User();
//
//            user.setId(resultSet.getInt("id"));
//            user.setName(resultSet.getString("name"));
//            user.setEmail(resultSet.getString("email"));
//            user.setAge(resultSet.getInt("age"));
//        } catch (SQLException e) {
//            e.printStackTrace();;
//        }

        return jdbcTemplate.query("SELECT * FROM User WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class)) //вместо собственного rowmappera
                .stream().findAny().orElse(null);
    }

    public void save(User user) {
//        user.setId(++USER_COUNT);
//        users.add(user);

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("INSERT INTO User VALUES (1, ?, ?, ?)");
//
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setInt(2, user.getAge());
//            preparedStatement.setString(3, user.getEmail());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        jdbcTemplate.update("INSERT INTO User VALUES (1, ?, ?, ?)", user.getName(), user.getAge(), user.getEmail());
    }

    public void update(int id, User updatedUser) {
//        User userToBeUpdated = show(id);
//
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setAge(updatedUser.getAge());
//        userToBeUpdated.setEmail(updatedUser.getEmail());

//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET name=?, age=?, email=? WHERE id=?");
//
//            preparedStatement.setString(1, updatedUser.getName());
//            preparedStatement.setInt(2, updatedUser.getAge());
//            preparedStatement.setString(3, updatedUser.getEmail());
//            preparedStatement.setInt(4, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        jdbcTemplate.update("UPDATE User SET name=?, age=?, email=? WHERE id=?", updatedUser.getName(), updatedUser.getAge(),updatedUser.getEmail(), id);
    }

    public void delete(int id) {
//        users.removeIf(u -> u.getId() == id);

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("DELETE FROM User WHERE id=?");
//
//            preparedStatement.setInt(1, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        jdbcTemplate.update("DELTE FROM User WHERE id=?", id);
    }
}
