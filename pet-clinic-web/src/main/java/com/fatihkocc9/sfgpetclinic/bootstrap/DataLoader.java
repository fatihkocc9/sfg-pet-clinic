package com.fatihkocc9.sfgpetclinic.bootstrap;

import com.fatihkocc9.sfgpetclinic.model.Owner;
import com.fatihkocc9.sfgpetclinic.model.PetType;
import com.fatihkocc9.sfgpetclinic.model.Vet;
import com.fatihkocc9.sfgpetclinic.service.OwnerService;
import com.fatihkocc9.sfgpetclinic.service.PetService;
import com.fatihkocc9.sfgpetclinic.service.PetTypeService;
import com.fatihkocc9.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  public DataLoader(
      OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setFirstName("Fatih");
    owner1.setLastName("Koc");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Ozge");
    owner2.setLastName("Tatar");

    ownerService.save(owner2);

    System.out.println("Loaded 2 owners");

    Vet vet1 = new Vet();
    vet1.setFirstName("Kevser");
    vet1.setLastName("Koc");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Nesenur");
    vet2.setLastName("Koc");

    vetService.save(vet2);

    System.out.println("Loaded 2 vets");

    PetType dog = new PetType();
    dog.setName("Dog");

    petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Dog");

    petTypeService.save(cat);
  }
}
