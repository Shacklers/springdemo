package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Pet> petList(){
        return petRepository.findAll();
    }

    public Pet getPetById(Long id){
        return petRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la mascota"));
    }
    public void savePet(Pet p, Long idOwner){
        Owner owner = ownerRepository
                .findById(idOwner)
                .orElseThrow(() -> new RuntimeException());

        p.setOwner(owner);
        petRepository.save(p);

    }

    public void deletePet(Long id){
        Optional<Pet> optionalPet = petRepository.findById(id);
        if(optionalPet.isPresent()){
            Pet realPet = optionalPet.get();
            petRepository.delete(realPet);
        }
        else{
           throw  new RuntimeException("Mascota no encontrada");
        }
    }

    public void actualizarPet(Long id, Pet updatedPet){
        Optional<Pet> optionalPet = petRepository.findById(id);
        if(optionalPet.isPresent()){
            Pet realPet = optionalPet.get();
            realPet.setNombre(updatedPet.getNombre());
            realPet.setEdad(updatedPet.getEdad());
            realPet.setEspecie(updatedPet.getEspecie());
            realPet.setOwner(updatedPet.getOwner());

            petRepository.save(realPet);
        }
        else{
            throw  new RuntimeException("Mascota no encontrada al actualizar");
        }


    }

}
