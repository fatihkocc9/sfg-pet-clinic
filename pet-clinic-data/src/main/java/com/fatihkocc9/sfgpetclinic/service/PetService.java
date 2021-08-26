package com.fatihkocc9.sfgpetclinic.service;

import com.fatihkocc9.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
