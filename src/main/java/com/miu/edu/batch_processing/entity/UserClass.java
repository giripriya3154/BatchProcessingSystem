package com.miu.edu.batch_processing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String user;
    @Column(name="password")
    private String pass;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<RoleType> roleTypes;



    public UserClass(String user, String pass,Set<RoleType> roleTypes) {
        this.user = user;
        this.pass = pass;
        this.roleTypes=roleTypes;
    }
}
