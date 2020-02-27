package com.gayan.rentcloud.authorizationserver.service;


import com.gayan.rentcloud.authorizationserver.model.AuthUserDetail;
import com.gayan.rentcloud.authorizationserver.model.User;
import com.gayan.rentcloud.authorizationserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Gayan Samuditha
 * @created 27/02/2020 - 1:26 AM
 */

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;


    }

}
