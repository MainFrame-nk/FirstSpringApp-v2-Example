package ru.connectx.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.connectx.demo.model.Role;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class RoleDTO {
    private String role;

    public static RoleDTO toRoleDto(Role role) {
        return RoleDTO.builder()
                .role(role.getRole())
                .build();
    }
}
