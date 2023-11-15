package ru.connectx.demo.model;

import javax.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import ru.connectx.demo.dto.RoleDTO;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Override
    public String toString() {
        return role.substring(5);
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Bean
    public Role roleWithOutPrefix(Role role) {
        return Role.builder()
                .role(role.getRole().substring(5))
                .build();
    }
    public RoleDTO toRoleDto() {
        return RoleDTO.toRoleDto(this);
    }
}
