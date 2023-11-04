package com.ehcache.LibraryApp.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ehcache.LibraryApp.model.UserLoginEntity;

public class UserInfoUserDetails implements UserDetails{

    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(UserLoginEntity userEntity){
        userName=userEntity.getUserName();
        password=userEntity.getUserPassword();
         
        authorities =Arrays.stream(userEntity.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
   
       return authorities;
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
