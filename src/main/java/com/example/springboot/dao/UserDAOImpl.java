package com.example.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import com.example.springboot.models.User;

import java.util.List;
@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> listOfUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User showUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public void saveNewUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(long id) {
        entityManager.remove(entityManager.contains(showUserById(id)) ? showUserById(id) :
                entityManager.merge(showUserById(id)));
    }
}
