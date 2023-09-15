package ru.alishev.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.dao.UserDAO;
import ru.alishev.springcourse.models.User;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> index() {
        return userDAO.index();
    }

    public User show(int id) {
        return userDAO.show(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(@Valid User updatedUser) {
        userDAO.update(updatedUser);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }
}
