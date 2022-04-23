package com.softengine.jwttest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_TBL")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Privilege> privileges;
}
