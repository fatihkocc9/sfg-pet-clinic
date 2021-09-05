package com.fatihkocc9.sfgpetclinic.bootstrap;

import com.fatihkocc9.sfgpetclinic.model.*;
import com.fatihkocc9.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;


  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }

  @Override
  public void run(String... args) throws Exception {

    int count = petTypeService.findAll().size();

    if(count == 0){
      loadData();
    }else{

    }


  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");

    petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Dog");

    petTypeService.save(cat);

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    Specialty savedRadiology = specialtyService.save(radiology);


    Specialty surgery = new Specialty();
    surgery.setDescription("Surgery");
    Specialty savedSurgery = specialtyService.save(surgery);

    Specialty dentistry = new Specialty();
    surgery.setDescription("Dentistry");
    Specialty savedDentistry = specialtyService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setFirstName("Fatih");
    owner1.setLastName("Koc");
    owner1.setAddress("Kazanci yokusu 4333/88 beyoğlu");
    owner1.setCity("İstanbul");

    Pet cat2 = new Pet();
    cat2.setPetType(cat);
    cat2.setOwner(owner1);
    cat2.setName("Pamuk");
    cat2.setBirthDate(LocalDate.ofYearDay(2017,210));
    owner1.getPets().add(cat2);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Ozge");
    owner2.setLastName("Tatar");
    owner2.setAddress("Şehit bir şey bir şey sokak 15/7 kadıköy/istanbul");
    owner2.setCity("İstanbul");


    Pet cat1 = new Pet();
    cat1.setPetType(cat);
    cat1.setOwner(owner2);
    cat1.setName("Leo");
    cat1.setBirthDate(LocalDate.ofYearDay(2018,210));
    owner2.getPets().add(cat1);
    ownerService.save(owner2);

    System.out.println("Loaded 2 owners");

    Vet vet1 = new Vet();
    vet1.setFirstName("Kevser");
    vet1.setLastName("Koc");
    vet1.getSpecialtySet().add(savedSurgery);
    vet1.getSpecialtySet().add(savedDentistry);

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Nesenur");
    vet2.setLastName("Koc");
    vet2.getSpecialtySet().add(savedRadiology);
    vet2.getSpecialtySet().add(savedSurgery);

    vetService.save(vet2);

    System.out.println("Loaded 2 vets");
  }
}
