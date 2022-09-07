package ru.kata.Task_3_1_3.dao;

import org.springframework.stereotype.Repository;
import ru.kata.Task_3_1_3.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class UserDaoHibernateImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }


    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles roles where u.name = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}
