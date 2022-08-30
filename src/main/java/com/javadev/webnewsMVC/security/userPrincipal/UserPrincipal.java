package com.javadev.webnewsMVC.security.userPrincipal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadev.webnewsMVC.entity.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class UserPrincipal implements UserDetails {

    private Long id;
    private String firstName;
    private String lastName;
    private String gmail;

    private String phone;
    private String userName;
    @JsonIgnore
    private String password;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;

    public UserPrincipal() {}

    public UserPrincipal(Long id, String firstName, String lastName, String gmail, String phone, String userName, String password, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmail = gmail;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.roles = roles;
    }

    public static UserPrincipal build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getGmail(),
                user.getPhone(),
                user.getUserName(),
                user.getPassword(),
                user.getAvatar(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
