package com.fatihkocc9.sfgpetclinic.controller;


import com.fatihkocc9.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners",ownerService.findAll());
        return "owners/ownersList";
    }

    @RequestMapping({"/find", "/find.html"})
    public String findOwners(){
        return "notimplemented";
    }

}
