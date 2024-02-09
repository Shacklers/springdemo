package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    public List<Owner> listOwners(){
        return ownerRepository.findAll();
    }
    public Owner getOwner(long id){
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el owner"));
    }

    public Owner saveOwner(Owner o) {
        return ownerRepository.save(o);
    }
}
