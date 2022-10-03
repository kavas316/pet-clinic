package com.petclinic.service;

import com.petclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAllOwners();

    void saveOwner(Owner owner);

    void deleteOwner(int id);

    Owner getOwnerById(int id);


}
