package com.miu.edu.batch_processing.service;

import com.miu.edu.batch_processing.entity.RoleType;
import com.miu.edu.batch_processing.entity.UserClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private String userName;
    private String passWord;
    private List<GrantedAuthority> roleTypes;

    public UserDetailsImpl(UserClass user) {
        this.userName = user.getUser();
        this.passWord = user.getPass();
        this.roleTypes = user.getRoleTypes().stream()
                .map((RoleType role) -> "ROLE_" + role.toString())
                .map((String role) -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleTypes;

    }

    @Override
    public String getPassword() {
        return passWord;
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