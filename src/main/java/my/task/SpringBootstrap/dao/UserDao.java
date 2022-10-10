package my.task.SpringBootstrap.dao;

import my.task.SpringBootstrap.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User findByUsername(String username);
}