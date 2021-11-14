package com.estoqueCrud.estoqueCrud.Security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity findByUsername(String username);
}
