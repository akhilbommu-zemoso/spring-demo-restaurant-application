package com.akhil.springproject.service;

import com.akhil.springproject.converter.UserConverter;
import com.akhil.springproject.dao.UserRepository;
import com.akhil.springproject.dto.UserDTO;
import com.akhil.springproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements com.akhil.springproject.service.UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }


    @Override
    public List<UserDTO> findAll() {
        return userConverter.entityToDto(userRepository.findAll());
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDTO validate(String email, String password){
        List<User> users= userRepository.findAll();
        for (User user:users) {
            if(user.getFirstName()!=null && user.getEmail().equals(email)&&user.getPassword().equals(password)) {
                return userConverter.entityToDto(user);
            }
        }
        return null;
    }

    @Override
    public Optional<User> findById(int theId) {
        return userRepository.findById(theId);
    }
}
