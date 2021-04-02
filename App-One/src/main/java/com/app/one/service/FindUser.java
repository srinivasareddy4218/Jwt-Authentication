package com.app.one.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
    it will call MSS-User-Auth application to validate the user which provided in the token
    -by Rajeev
 */
@Service
public class FindUser implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8090/validateUser/" + username, UserDetails.class);
    }
}
