package com.joshuasantacruz.sportfinal.service;


import com.joshuasantacruz.sportfinal.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User>getAll();
User getUserById(Integer id);
User savedUser (User user);
User updateUser(Integer id, User user);
void deleteUser(Integer id);
}
