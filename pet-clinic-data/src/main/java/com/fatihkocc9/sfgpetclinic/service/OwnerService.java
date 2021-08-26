package com.fatihkocc9.sfgpetclinic.service;

import com.fatihkocc9.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService <Owner, Long> {

    Owner findByLastName(String lastName);

}
