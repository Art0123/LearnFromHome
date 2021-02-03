package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.entity.User;
import com.art0123.LearnFromHome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No such user as " + username);
        }

        return user.map(MyUserDetails::new).get();
    }
}
