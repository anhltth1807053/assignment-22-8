package com.demo.controller;


import com.demo.entity.Dogs;
import com.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    DogService dogService;

    @GetMapping("/admin/add")
    public String add(Model model){
        Dogs dogs = new Dogs();
        model.addAttribute("dogadd", dogs);
        return "/admin/add";
    }

    @PostMapping("/admin/add")
    public String saveDog(@ModelAttribute  Dogs dogs){
    dogService.saveDogs(dogs);
    return"/admin/list";
    }

    @GetMapping({"/admin/list","/"})
    public String getAllDog(Model model){
        List<Dogs> list = dogService.getAll();
        model.addAttribute("dogs", list);
        return"/admin/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model){
        Dogs dogs = dogService.getDogId(id);
        model.addAttribute("dogUpdate", dogs);
        return "/admin/update";
    }

    @PostMapping("/update/{id}")
    public String updateDog(@PathVariable("id") Integer id, @Valid Dogs dogs, BindingResult result, Model model){
        if (result.hasErrors()){
            dogs.setId(id);
            return "/admin/update";
        }
        dogService.updateDogs(dogs);
        model.addAttribute("dog", dogService.getAll());
        return "/admin/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDogForm(@PathVariable("id") Integer id, Model model){
        Dogs dogs = dogService.getDogId(id);
        model.addAttribute("dogDelete",dogs);
        return "/admin/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteDog(@PathVariable("id") Integer id, Model model){
        Dogs dogs =dogService.getDogId(id);
        dogs.setStatus(-1);
        dogService.updateDogs(dogs);
        return "/admin/list";
    }

}
