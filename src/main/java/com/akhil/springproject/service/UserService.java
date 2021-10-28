package com.akhil.springproject.service;

import com.akhil.springproject.dto.UserDTO;
import com.akhil.springproject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAll();
    User save(User user);
    UserDTO validate(String email, String password);
    Optional<User> findById(int theId);
}
