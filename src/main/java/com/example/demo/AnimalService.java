package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all animals
     *
     * @return the list of all animals
     */
    public List<Animal> getAllAnimals(){

        return animalRepository.findAll();
    }
    /**
     * Gets a unique animal
     *
     * @param animalId the unique animal ID
     * @return a unique animal object
     */
    public Animal getAnimalById(int animalId) {

        return animalRepository.findById(animalId).orElse(null);
    }

    public List<Animal> findByHabitat(String habitat){

        return animalRepository.findByHabitat(habitat);
    }
    /**
     * Add a new animal to the database
     *
     * @param animal the new animal to add
     */
    public void addAnimal(Animal animal) {

        animalRepository.save(animal);
    }
    /**
     * Update and existing animal
     *
     * @param animal the new animal details
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setDescription(animal.getDescription());
        existing.setHabitat(animal.getHabitat());
        existing.setSpecies(animal.getSpecies());
        existing.setScientificName(animal.getScientificName());

        animalRepository.save(existing);
    }
    /**
     * Delete a unique animal
     *
     * @param animalId the unique animal ID
     */
    public void deleteAnimal(int animalId) {

        animalRepository.deleteById(animalId);
    }
    /**
     * Gets all the animals whose species matches the search term
     *
     * @param species the search key
     * @return the list of matching animals
     */
    public List<Animal> getAnimalsBySpecies(String species) {

        return animalRepository.findBySpecies(species);
    }
    /**
     * Gets all the animals whose name matches the search term
     *
     * @param name the search key
     * @return the list of matching animals
     */
    public List<Animal> searchAnimalsByName(String name) {

        return animalRepository.findByNameContaining(name);
    }
}
