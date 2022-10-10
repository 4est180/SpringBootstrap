package my.task.SpringBootstrap.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import my.task.SpringBootstrap.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User findByUsername(String username);
}
