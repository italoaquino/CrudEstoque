package com.estoqueCrud.estoqueCrud.Controller;

import com.estoqueCrud.estoqueCrud.Entities.Person;
import com.estoqueCrud.estoqueCrud.Repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public String person(Model model){
        model.addAttribute("listPersons", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/persons/new")
    public String NewPerson(@ModelAttribute("person") Person person){
        return "form";
    }

   @GetMapping("/persons/{id}")
   public String Edit(@PathVariable("id") long id, Model model){
       Optional<Person> person = personRepository.findById(id);
       if(person.isEmpty()){
           throw new IllegalArgumentException("Person Empty!");
       }
       model.addAttribute("person", person.get());
       return "form";
   }

   @GetMapping("/persons/delete/{id}")
    public String Delete(@PathVariable("id") long id, Model model){
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty()){
            throw new IllegalArgumentException("Person is empty!");
        }
       personRepository.delete(person.get());
        return "redirect:/persons";
    }

    @PostMapping("/person/save")
    public String savePessoa(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/form";
        }

        personRepository.save(person);
        return "redirect:/persons";
    }
}

