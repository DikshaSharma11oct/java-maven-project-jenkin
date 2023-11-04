package com.ehcache.LibraryApp.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ehcache.LibraryApp.config.UserInfoUserDetails;
import com.ehcache.LibraryApp.model.UserLoginEntity;
import com.ehcache.LibraryApp.repository.UserRepository;

@Component
public class UserInfoUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //cant return directly user to UserDetails so use UserInfoUserDetails that 
        //contains the user name and password and authority field
        Optional<UserLoginEntity> user =userRepository.findByuserName(username);
        return  user.map(UserInfoUserDetails::new).
            orElseThrow(()-> new UsernameNotFoundException("userNotFound" +username));
 
    }
    
}
