package com.estoqueCrud.estoqueCrud.banco;

import com.estoqueCrud.estoqueCrud.Security.UserEntity;
import com.estoqueCrud.estoqueCrud.Security.UserEnum;
import com.estoqueCrud.estoqueCrud.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PopulacaoInicialBanco implements CommandLineRunner {


    private UserRepository userRepository;

    private PasswordEncoder encoder;

    public PopulacaoInicialBanco(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        UserEntity user = new UserEntity();
        user.setName("Italo");
        user.setPassword(encoder.encode("123"));
        user.setRole(UserEnum.Admin.getName());


        UserEntity user2 = new UserEntity();
        user2.setName("Teste");
        user2.setPassword(encoder.encode("123"));
        user2.setRole(UserEnum.User.getName());


        userRepository.save(user);
        userRepository.save(user2);
    }
}
