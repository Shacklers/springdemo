package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Pet> petList(){
        return petRepository.findAll();
    }

    public void savePet(Pet p, Long idOwner){
        Owner owner = ownerRepository
                .findById(idOwner)
                .orElseThrow(() -> new RuntimeException());

        p.setOwner(owner);
        petRepository.save(p);

    }

}
