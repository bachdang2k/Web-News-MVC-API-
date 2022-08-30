package com.javadev.webnewsMVC.entity.user;

import com.javadev.webnewsMVC.entity.base.BaseEntity;
import com.javadev.webnewsMVC.entity.Comment;
import com.javadev.webnewsMVC.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", length = 25)
    private String firstName;

    @Column(name = "last_name", length = 25)
    private String lastName;

    @Column(unique = true, length = 45)
    private String gmail;

    @Column(name = "user_name")
    private String userName;

    @Size(max = 20, min = 6)
    @Column(name = "password")
    private String password;

    @Column
    private Integer status;

    @Size(min = 9, max = 13)
    @Column(unique = true)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public User(String firstName, String lastName, String gmail, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmail = gmail;
        this.phone = phone;
        this.password = password;
    }

}
