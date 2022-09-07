package ru.kata.Task_3_1_3.dao;

import ru.kata.Task_3_1_3.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User findByUsername(String username);
}