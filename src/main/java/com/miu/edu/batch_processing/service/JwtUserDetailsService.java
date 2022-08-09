package com.miu.edu.batch_processing.service;

import com.miu.edu.batch_processing.entity.UserClass;
import com.miu.edu.batch_processing.repository.UserClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserClassRepository userClassRepository;



    @Override
    public UserDetails loadUserByUsername(String principal) throws UsernameNotFoundException {
        UserClass user = userClassRepository.findUserByUserName(principal).get();
        if (user.getUser().equals(principal)) {
            return new UserDetailsImpl(user);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + principal);
        }
    }

}