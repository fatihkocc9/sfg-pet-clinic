package com.fatihkocc9.sfgpetclinic.service;

import com.fatihkocc9.sfgpetclinic.model.Owner;
import java.util.Set;


public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
