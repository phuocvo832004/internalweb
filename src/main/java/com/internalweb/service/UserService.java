package com.internalweb.service;
import java.util.List;

import com.internalweb.model.User;

public interface UserService {
    User findByUsername(String username);
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void deleteById(Long id);
    List<User> findAllByRole(String role);
    List<User> searchStaff(String query);
}

