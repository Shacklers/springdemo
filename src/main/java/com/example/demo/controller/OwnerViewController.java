package com.example.demo.controller;


import com.example.demo.model.Owner;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OwnerViewController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners")
    public String listOwners(Model model){
        List<Owner> owners = ownerService.listOwners();
        model.addAttribute("owner", owners);
        return "owner";
    }

    @GetMapping("/addOwners")
    public void showFormAddOwner(Model model){
        model.addAttribute("", new Owner());
    }

    @PostMapping("/saveOwner")
    public String saveOwner(Owner o){
        ownerService.saveOwner(o);
        return "redirect:/owners";

    }

}
