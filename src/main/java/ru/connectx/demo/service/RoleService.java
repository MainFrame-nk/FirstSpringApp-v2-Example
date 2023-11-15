package ru.connectx.demo.service;

import ru.connectx.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByName(String role);
    Role getRoleById(Long id);
}
