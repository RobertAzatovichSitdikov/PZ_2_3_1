package ru.alishev.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.dao.UserDAO;
import ru.alishev.springcourse.models.User;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(@Valid User updatedUser) {
        userDAO.update(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
