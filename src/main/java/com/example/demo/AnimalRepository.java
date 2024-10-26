package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
    List<Animal> findByNameContaining(String name);
    List<Animal> findBySpecies(String species);

    @Query("SELECT a FROM Animal a WHERE a.habitat = ?1")
    List<Animal> findByHabitat(String habitat);
}
