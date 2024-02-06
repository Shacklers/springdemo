package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PetViewController {
    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/pets")
    public String listPets(Model model){
        List<Pet> pets = petService.petList();
        model.addAttribute("pets", pets);
        return "pets";
    }

    @GetMapping("/addPets")
    public String addPets(Model model){
        model.addAttribute("owners",ownerService.listOwners());
        return "add pets";
    }

    @PostMapping("/savePets")
    public String savePets(Pet p, @RequestParam Long idOwner){
        petService.savePet(p,idOwner);
        return "redirect:/pets";
    }

}
