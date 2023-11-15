package ru.connectx.demo.service;

import ru.connectx.demo.dto.UserDTO;
import ru.connectx.demo.model.User;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getById(Long id);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO, Long id);
    User findByEmail(String email);

}
