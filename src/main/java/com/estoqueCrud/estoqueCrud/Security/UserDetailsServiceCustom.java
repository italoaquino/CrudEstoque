package com.estoqueCrud.estoqueCrud.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("UserDetailsService")
public class UserDetailsServiceCustom implements UserDetailsService {


    private UserRepository userRepository;

    public UserDetailsServiceCustom(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuario = userRepository.findByUsername(username);
        if(username != null){
             SimpleGrantedAuthority authority= new SimpleGrantedAuthority(usuario.getRole());
             Set<GrantedAuthority> authorities = new HashSet<>();
             authorities.add(authority);
             User user = new User(usuario.getName(), usuario.getPassword(), authorities);
             return user;
        }
        return null;
    }
}
