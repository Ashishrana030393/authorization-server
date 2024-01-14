package com.django.user.service;

import com.django.user.dao.UserRepository;
import com.django.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityUserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public SecurityUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("invalid username/password");
        }
        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;
    }
}
