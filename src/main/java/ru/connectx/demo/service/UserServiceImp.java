package ru.connectx.demo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.connectx.demo.config.WebSecurityConfig;
import ru.connectx.demo.dto.UserDTO;
import ru.connectx.demo.exceptions.UserNotFoundException;
import ru.connectx.demo.model.User;
import ru.connectx.demo.repositories.RoleRepository;
import ru.connectx.demo.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder = WebSecurityConfig.bCryptPasswordEncoder();

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

//    @Transactional
//    @Override
//    public void save(User user) {
//        user.setPassword(WebSecurityConfig.bCryptPasswordEncoder().encode(user.getPassword()));
//        userRepository.save(user);
//    }

    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        String encoderPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = User.builder()
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .password(encoderPassword)
                .roles(userDTO.getRoles().stream().map(x -> roleRepository.findByRole(x.getRole())).collect(Collectors.toSet()))
                .build();
        userRepository.save(user);
        return userDTO;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getById(Long id) {
        return UserDTO.toUserDTO(userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User with id: " + id + " not found!")));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(User::toUserDTO).sorted(Comparator.comparing(UserDTO::getId)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователя: " + userDTO.getEmail() + " не найдено"));
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        if (!passwordEncoder.matches(passwordEncoder.encode(userDTO.getPassword()), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        user.setRoles(userDTO.getRoles().stream().map(x -> roleRepository.findByRole(x.getRole())).collect(Collectors.toSet()));
        userRepository.save(user);
        return userDTO;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("User '%s' not found!", username));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
//                mapRoleAuthority(user.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRoleAuthority (Collection<Role> roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
//    }

}
