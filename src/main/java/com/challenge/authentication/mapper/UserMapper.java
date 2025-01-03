package com.challenge.authentication.mapper;

import com.challenge.authentication.dto.UserDTO;
import com.challenge.authentication.entity.User;

/**
 * The UserMapper class is responsible for converting between User and UserDTO objects.
 * It provides two static methods to facilitate this mapping.
 */
public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
