package ru.connectx.demo.model;

import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.connectx.demo.dto.UserDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "users")
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    private String email;
    private Integer age;
    private String password;

//    public User() {
//        this.roles = new ArrayList<>();
//    }

    //@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

//    public String roleToString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Role role : roles) {
//            stringBuilder.append(role.toString()).append(" ");
//        }
//        return stringBuilder.toString();
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public List<String> getNameRoles() {
        return this.roles.stream().map(Role::getRole).map(x->x.substring(5)).collect(Collectors.toList());
    }

    public String getAllRolesWithOutBrackets (Set<Role> roles){
        return roles.stream().map(Role::getRole).map(x->x.substring(5)).collect(Collectors.joining(", "));
    }
    public UserDTO toUserDTO() {
        return UserDTO.toUserDTO(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
