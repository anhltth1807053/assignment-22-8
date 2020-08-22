package com.demo.controller;


import com.demo.entity.Dogs;
import com.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    DogService dogService;

    @GetMapping({"dog"})
    public String dog(Model model){
        model.addAttribute("name", "Hello");
        return "dog";
    }

    @GetMapping("/add-dog")
    public String openAddDog(Model model){
        Dogs dogs = new Dogs();
        model.addAttribute("dog", dogs);
        return "add";
    }

    @PostMapping("/add-dog")
    public String addDog(@ModelAttribute  Dogs dogs){
    dogService.saveDog(dogs);
    return"redirect:/list";
    }

    @GetMapping({"/list","/"})
    public String getAllDog(Model model){
        List<Dogs> list = dogService.getAll();
        model.addAttribute("dogs", list);
        return"list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model){
        Optional<Dogs> dogs = Optional.ofNullable(dogService.getDogById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id)));
        model.addAttribute("dogs",dogs);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateDog(@PathVariable("id") Integer id, @Valid Dogs dogs, BindingResult result, Model model){
        if (result.hasErrors()){
            dogs.setId(id);
            return "update";
        }
        dogService.saveDog(dogs);
        model.addAttribute("dog", dogService.getAll());
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDog(@PathVariable("id") Integer id, Model model){
        Optional<Dogs> dogs = Optional.ofNullable(dogService.getDogById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id)));
        dogService.deleteById(id);
        model.addAttribute("dog",dogs);
        return "delete";
    }

}
