package com.softengine.jwttest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLE_TBL")
public class Role {
    @Id
    private int id;
    private String name;
    private String desci;

    @OneToMany(mappedBy = "role",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Collection<Privilege> privileges;

}
