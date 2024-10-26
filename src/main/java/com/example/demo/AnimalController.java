package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    public String getAllAnimals(Model model){
    model.addAttribute("animalList", animalService.getAllAnimals());
    model.addAttribute("title", "All Animals");
    return "animal-list";
    }

    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        model.addAttribute("title", "Animal Details: " + animalId);
        return "animal-details";

    }

    @GetMapping("")
    public String getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "Animal") String species, Model model) {
        model.addAttribute("animalList", animalService.getAnimalsBySpecies(species));
        model.addAttribute("title", "Animals of Species: " + species);
        return "animal-list";
    }

    @PostMapping("/new")
    public String addAnimal(Animal animal) {
        animalService.addAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/search")
    public String getAnimalsbyName(@RequestParam("name") String name, Model model) {
        model.addAttribute("animalList", animalService.searchAnimalsByName(name));
        model.addAttribute("title", "Search Results for: " + name);
        return "animal-list";
    }

    @GetMapping("/habitat")
    public String findByHabitat(@RequestParam(name = "habitat") String habitat, Model model) {
        model.addAttribute("animalList", animalService.findByHabitat(habitat));
        model.addAttribute("title", "Animals in Habitat: " + habitat);
        return "animal-list";
    }
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model){
    model.addAttribute("animal", animalService.getAnimalById(animalId));
    return "animal-update";
    }


    @PostMapping("/update")
    public String updateAnimal(Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    //@GetMapping("/delete/{animalId}")
    @PostMapping("/delete/{animalId}")
    public String deleteAnimal(@PathVariable int animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/animals/all";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("title", "Create New Animal");
        return "animal-create";
    }


}
