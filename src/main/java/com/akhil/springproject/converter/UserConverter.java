package com.akhil.springproject.converter;

import com.akhil.springproject.dto.UserDTO;
import com.akhil.springproject.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDTO entityToDto(User theUser){
        ModelMapper mapper = new ModelMapper();
        UserDTO map = mapper.map(theUser,UserDTO.class);
        return map;
    }

    public User dtoToEntity(UserDTO theUserDTO){
        ModelMapper mapper = new ModelMapper();
        User map = mapper.map(theUserDTO, User.class);
        return map;
    }

    public List<UserDTO> entityToDto(List<User> users)
    {
        return users.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public List<User> dtoToEntity(List<UserDTO> userDtos)
    {
        return userDtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }

}
