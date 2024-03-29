package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("owner",ownerService.listOwners());
        return "addPet";
    }

    @PostMapping("/savePets")
    public String savePets(Pet p, @RequestParam Long idOwner){
        petService.savePet(p,idOwner);

        return "redirect:/pets";
    }

    @GetMapping("/eliminarMascota/{id}")
    public String deletePete(@PathVariable Long id){
        petService.deletePet(id);
        return "redirect:/pets";
    }

    @GetMapping("/actualizarMascota/{id}")
    public String showFormUpdatePet(@PathVariable Long id, Model model){
        Pet pet = petService.getPetById(id);
        model.addAttribute("pets", pet); //debe ser igual el nombre al objeto enviado.
        model.addAttribute("owner", ownerService.listOwners());
        return "actualizarMascota";
    }

    @PostMapping("/actualizarMascota/{id}")
    public String updatePet(@PathVariable Long id, @ModelAttribute Pet updatedPet, @RequestParam Long idOwner){
        System.out.println("El id del post es:"+idOwner);
        updatedPet.setOwner(ownerService.getOwner(idOwner));

        petService.actualizarPet(id, updatedPet);
        return "redirect:/pets";
    }

}
