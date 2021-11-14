package com.estoqueCrud.estoqueCrud.Repositories;

import com.estoqueCrud.estoqueCrud.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
