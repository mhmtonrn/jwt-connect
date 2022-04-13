package com.softengine.jwttest;

import com.softengine.jwttest.entity.Privilege;
import com.softengine.jwttest.entity.Role;
import com.softengine.jwttest.entity.User;
import com.softengine.jwttest.repository.PrivilegeRepository;
import com.softengine.jwttest.repository.RoleRepository;
import com.softengine.jwttest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class JwtTestApplication {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUser() {
        List<User> users = List.of(User.builder().id(1).userName("user1")
                .password(passwordEncoder.encode("user1"))
                .accountNonExpired(Boolean.TRUE)
                .accountNonLocked(Boolean.TRUE)
                .credentialsNonExpired(Boolean.TRUE)
                .enabled(Boolean.TRUE).build(),
                User.builder().id(2).userName("user2")
                        .password(passwordEncoder.encode("user2"))
                        .accountNonExpired(Boolean.TRUE)
                        .accountNonLocked(Boolean.TRUE)
                        .credentialsNonExpired(Boolean.TRUE)
                        .enabled(Boolean.TRUE).build()
                );
        userRepository.saveAll(users);

        Role r1 = new Role();
        r1.setId(1);
        r1.setName("ADMIN");
        r1.setDesci("ADMIN");

        Role r2 = new Role();
        r2.setId(2);
        r2.setName("USER");
        r2.setDesci("USER");


        roleRepository.save(r1);
        roleRepository.save(r2);

        Privilege p1 = new Privilege();
        p1.setRoleId(1);
        p1.setUserId(1);
        privilegeRepository.save(p1);

        Privilege p2 = new Privilege();
        p2.setRoleId(2);
        p2.setUserId(2);
        privilegeRepository.save(p2);
        Privilege p3 = new Privilege();
        p3.setRoleId(2);
        p3.setUserId(1);
        privilegeRepository.save(p3);


    }

    public static void main(String[] args) {
        SpringApplication.run(JwtTestApplication.class, args);
    }

}
