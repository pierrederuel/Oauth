package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User Create (User user) {
        try {
            user = userRepository.insert(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> GetAll () {
        return userRepository.findAll();
    }

    public User GetOne (String id) {
        return userRepository.findOne(id);
    }

    public Object Update (User model, String id) {
        try {
            User currentUser = userRepository.findOne(id);
            currentUser.setPassword(model.getPassword());
            currentUser.setAge(model.getAge());
            currentUser.setAddress(model.getAddress());
            currentUser.setLastname(model.getLastname());
            currentUser.setFirstname(model.getFirstname());
            currentUser.setEmail(model.getEmail());
            userRepository.save(currentUser);
            return currentUser;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public boolean Delete (String id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
