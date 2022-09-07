package ru.kata.Task_3_1_3.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.Task_3_1_3.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User findByUsername(String username);
}
