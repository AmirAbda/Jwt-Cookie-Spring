package com.amir.jwt_api__demo.utils;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.amir.jwt_api__demo.model.UserInfo;
import com.amir.jwt_api__demo.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Entering in loadUserByUsername");
        Optional<UserInfo> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            logger.debug("Username not found: " + username);
            throw new UsernameNotFoundException("Could not find user: " + username);
        }
        UserInfo user = userOptional.get();
        logger.info("User Authenticated Successfully: " + username);
        return new CustomUserDetails(user);
    }
}
